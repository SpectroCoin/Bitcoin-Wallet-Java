package lt.spectrofinance.spectrocoin.walletclient;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import lt.spectrofinance.spectrocoin.walletclient.data.ErrorInfo;
import lt.spectrofinance.spectrocoin.walletclient.exception.ValidationException;
import lt.spectrofinance.spectrocoin.walletclient.helper.ErrorHelper;
import lt.spectrofinance.spectrocoin.walletclient.helper.ParamHelper;
import lt.spectrofinance.spectrocoin.walletclient.request.Oauth2Request;
import lt.spectrofinance.spectrocoin.walletclient.request.RefreshOauth2TokenRequest;
import lt.spectrofinance.spectrocoin.walletclient.response.Oauth2Response;
import lt.spectrofinance.spectrocoin.walletclient.response.RefreshOauth2Response;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.client.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by UAB Spectro Finance
 * developed by NerijusT on 2016-05-04.
 */
public class BaseClient {

	private final String CHARSET_NAME = "UTF-8";
	public final String DEFAULT_SCOPES = "send_currency currency_exchange user_account";

	public final String OAUTH_URL = "https://spectrocoin.com/api/r/oauth2";
	public final String WALLET_URL = "https://spectrocoin.com/api/r/wallet";

	//OAuth2 api paths
	public static String AUTH = "/auth";
	public static String REFRESH = "/refresh";
	//wallet api paths
	protected static String ACCOUNT_INFO = "/account/{accountId}";
	protected static String EXCHANGE_CALCULATE_BUY = "/exchange/calculate/buy";
	protected static String EXCHANGE_CALCULATE_SELL = "/exchange/calculate/sell";
	protected static String EXCHANGE_BUY = "/exchange/buy";
	protected static String EXCHANGE_SELL = "/exchange/sell";
	protected static String SEND_CURRENCY = "/send/{currency}";
	protected static String ACCOUNTS = "/accounts";
	protected static String LAST_CRYPTO_ADDRESS = "/deposit/{currency}/last";
	protected static String NEW_CRYPTO_ADDRESS = "/deposit/{currency}/fresh";

	//information
	private String clientId;
	private String clientSecret;
	private String scopes;
	private String version;

	private String accessToken;
	private String refreshToken;

	public BaseClient(String clientId, String clientSecret, String scopes, String version) {
		AUTH = OAUTH_URL + AUTH;
		REFRESH = OAUTH_URL + REFRESH;

		ACCOUNTS = WALLET_URL + ACCOUNTS;
		SEND_CURRENCY = WALLET_URL + SEND_CURRENCY;
		EXCHANGE_SELL = WALLET_URL + EXCHANGE_SELL;
		EXCHANGE_BUY = WALLET_URL + EXCHANGE_BUY;
		EXCHANGE_CALCULATE_SELL = WALLET_URL + EXCHANGE_CALCULATE_SELL;
		EXCHANGE_CALCULATE_BUY = WALLET_URL + EXCHANGE_CALCULATE_BUY;
		ACCOUNT_INFO = WALLET_URL + ACCOUNT_INFO;

		LAST_CRYPTO_ADDRESS = WALLET_URL + LAST_CRYPTO_ADDRESS;
		NEW_CRYPTO_ADDRESS = WALLET_URL + NEW_CRYPTO_ADDRESS;

		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.scopes = scopes;
		this.version = version;
	}

	protected <Req, Resp> Resp process(Req request, String url, String httpMethod, Class<Resp> respClass) throws ValidationException {

		if(accessToken == null){
			authenticate();
		}

		Client client = getClient();

		WebTarget target = client.target(url);
		if(httpMethod.compareTo(HttpMethod.GET) == 0 && request != null){
			HashMap<String, String> queryParameters = ParamHelper.get(request);
			for (String key : queryParameters.keySet()) {
				target = target.queryParam(key, queryParameters.get(key));
			}
		}

		Invocation.Builder builder = target.request()
				.header("Connection", "close")
				.header(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken)
				.acceptEncoding(CHARSET_NAME)
				.accept(MediaType.APPLICATION_JSON_TYPE);

		Future<Response> submit = null;
		if(httpMethod.compareTo(HttpMethod.GET) == 0){
			submit = builder.buildGet().submit();
		} else if(httpMethod.compareTo(HttpMethod.POST) == 0){
			submit = builder.buildPost((Entity.entity(request, MediaType.APPLICATION_JSON_TYPE))).submit();
		} else {
			throw new RuntimeException("Wrong http method");
		}

		try {
			Response response = submit.get();
			if(response.getStatusInfo().getStatusCode() == Response.Status.OK.getStatusCode()){
				return response.readEntity(respClass);
			} else if(response.getStatusInfo().getStatusCode() == 203) {
				ErrorInfo[] validationMessage = response.readEntity(ErrorInfo[].class);

				if(validationMessage != null){
					boolean throwable = true;

					//handle some errors
					for (ErrorInfo errorInfo : validationMessage) {
						if(errorInfo.getErrorCode().compareTo(ErrorHelper.UNAUTHORIZED.getErrorCode()) == 0){
							refreshToken();
							this.process(request, url, httpMethod, respClass);
							throwable = false;
						} else if(errorInfo.getErrorCode().compareTo(ErrorHelper.REFRESH_TOKEN_EXPIRED.getErrorCode()) == 0){
							authenticate();
							this.process(request, url, httpMethod, respClass);
							throwable = false;
						}
					}
					//if not handled - throw exception
					if(throwable){
						throw new ValidationException(validationMessage);
					}
				}
			} else {
				throw new RuntimeException(response.readEntity(String.class));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		return null;
	}

	private Client getClient() {
		Client client = ClientBuilder.newClient();
		client.register(new JacksonJaxbJsonProvider().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false));
		client.register(new ParamHelper());

		return client;
	}

	private void authenticate() throws ValidationException {
		Client client = getClient();

		WebTarget target = client.target(AUTH);
		Invocation.Builder builder = target.request()
				.header("Connection", "close")
				.acceptEncoding(CHARSET_NAME)
				.accept(MediaType.APPLICATION_JSON_TYPE);

		Oauth2Request request = new Oauth2Request();
		request.setClientId(clientId);
		request.setClientSecret(clientSecret);
		request.setVersion(version);
		request.setScope(this.scopes != null && this.scopes.length() > 0 ? this.scopes : DEFAULT_SCOPES);

		Future<Response> submit = builder.buildPost((Entity.entity(request, MediaType.APPLICATION_JSON_TYPE))).submit();
		try {
			Response response = submit.get();
			if(response.getStatusInfo().getStatusCode() == Response.Status.OK.getStatusCode()){
				Oauth2Response oauth2Response = response.readEntity(Oauth2Response.class);
				accessToken = oauth2Response.getAccessToken();
				refreshToken = oauth2Response.getRefreshToken();
			} else if(response.getStatusInfo().getStatusCode() == 203) {
				ErrorInfo[] validationMessage = response.readEntity(ErrorInfo[].class);
				throw new ValidationException(validationMessage);
			} else {
				throw new RuntimeException(response.readEntity(String.class));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}

	private void refreshToken() throws ValidationException {

		if(refreshToken == null){
			authenticate();
			return;
		}

		Client client = getClient();

		WebTarget target = client.target(REFRESH);
		Invocation.Builder builder = target.request()
				.header("Connection", "close")
				.acceptEncoding(CHARSET_NAME)
				.accept(MediaType.APPLICATION_JSON_TYPE);

		RefreshOauth2TokenRequest request = new RefreshOauth2TokenRequest();
		request.setClientId(clientId);
		request.setClientSecret(clientSecret);
		request.setVersion(version);
		request.setRefreshToken(refreshToken);

		Future<Response> submit = builder.buildPost((Entity.entity(request, MediaType.APPLICATION_JSON_TYPE))).submit();
		try {
			Response response = submit.get();
			if(response.getStatusInfo().getStatusCode() == Response.Status.OK.getStatusCode()){
				RefreshOauth2Response oauth2Response = response.readEntity(RefreshOauth2Response.class);
				accessToken = oauth2Response.getAccessToken();
				refreshToken = oauth2Response.getRefreshToken();
			} else if(response.getStatusInfo().getStatusCode() == 203) {
				ErrorInfo[] validationMessage = response.readEntity(ErrorInfo[].class);
				if(validationMessage != null){
					boolean throwable = true;

					//handle some errors
					for (ErrorInfo errorInfo : validationMessage) {
						if(errorInfo.getErrorCode().compareTo(ErrorHelper.REFRESH_TOKEN_EXPIRED.getErrorCode()) == 0){
							authenticate();
							throwable = false;
						}
					}
					//if not handled - throw exception
					if(throwable){
						throw new ValidationException(validationMessage);
					}
				}
			} else {
				throw new RuntimeException(response.readEntity(String.class));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
