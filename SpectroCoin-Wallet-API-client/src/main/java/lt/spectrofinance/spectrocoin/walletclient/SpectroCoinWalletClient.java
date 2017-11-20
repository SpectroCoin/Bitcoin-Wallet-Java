package lt.spectrofinance.spectrocoin.walletclient;

import lt.spectrofinance.spectrocoin.walletclient.exception.ValidationException;
import lt.spectrofinance.spectrocoin.walletclient.request.*;
import lt.spectrofinance.spectrocoin.walletclient.response.*;

import javax.ws.rs.HttpMethod;

/**
 * Created by UAB Spectro Finance
 * developed by NerijusT on 2016-05-02.
 */
public class SpectroCoinWalletClient extends BaseClient {

	/**
	 * SpectroCoin wallet client constructor
	 *
	 * @param clientId client id (Application name)
	 * @param clientSecret client secret
	 * @param scopes scopes witch you want to use
	 * @param version your wallet client version
	 *
	 * @see <a href="https://spectrocoin.com/en/walletAPI.html">SpectroCoin user wallet configuration</a> <br>
	 */
	public SpectroCoinWalletClient(String clientId, String clientSecret, String scopes, String version) {
		super(clientId, clientSecret, scopes, version);
	}

	/**
	 * <b>GET /wallet/accounts</b> <br><br>
	 *
	 * Method used to get user accounts information
	 * @return array of account information
	 * @throws ValidationException
	 */
	public GetAccountsResponse getAccounts() throws ValidationException {
		return this.process(null, ACCOUNTS, HttpMethod.GET, GetAccountsResponse.class);
	}

	/**
	 * <b>GET /wallet/account/{accountId}</b> <br><br>
	 * Method used to get paged transaction history of specified user account
	 * @param request <br>
	 * &#09 accountId - specified user account ID<br>
	 * &#09 page - which page you want to get<br>
	 * &#09 size - transactions count per page<br>
	 * @return transaction history array
	 * @throws ValidationException
	 */
	public GetAccountTransactionsResponse getAccountTransactions(GetAccountTransactionsRequest request) throws ValidationException {
		String url = ACCOUNT_INFO.replace("{accountId}", request.getAccountId().toString());
		return this.process(request, url, HttpMethod.GET, GetAccountTransactionsResponse.class);
	}

	/**
	 * <b>GET /wallet/exchange/calculate/buy</b> <br><br>
	 * Method used to calculate pay amount for currency exchange using receive amount for current moment
	 * @param request
	 * &#09 receiveAmount - amount you want to receive<br>
	 * &#09 receiveCurrency - currency you want to receive<br>
	 * &#09 payCurrency - currency you want to pay<br>
	 * @return calculated amount and currency you can pay if you want to get receive amount in receive currency
	 * @throws ValidationException
	 */
	public CalculatePayAmountResponse calculatePayAmount(CalculatePayAmountRequest request) throws ValidationException {
		return this.process(request, EXCHANGE_CALCULATE_BUY, HttpMethod.GET, CalculatePayAmountResponse.class);
	}

	/**
	 * <b>GET /wallet/exchange/calculate/sell</b> <br><br>
	 * Method used to calculate receive amount of currency exchange using pay amount for current moment.
	 * @param request
	 * &#09 payAmount - amount you want to pay<br>
	 * &#09 payCurrency - currency you want to pay<br>
	 * &#09 receiveCurrency - currency you want to receive<br>
	 * @return calculated amount and currency you will receive if you sell pay amount in pay currency
	 * @throws ValidationException
	 */
	public CalculateReceiveAmountResponse calculateReceiveAmount(CalculateReceiveAmountRequest request) throws ValidationException {
		return this.process(request, EXCHANGE_CALCULATE_SELL, HttpMethod.GET, CalculateReceiveAmountResponse.class);
	}

	/**
	 * <b>POST /wallet/send/{currency}</b> <br><br>
	 * Method to send currency to receiver (bitcoin address, email address).
	 * Additional fees may apply depending on send currency and receiver type.
	 * Receiver will receive provided amount and currency if sender has enough balance to cover possible additional fee.
	 * @param request
	 * &#09 amount - amount you want to send<br>
	 * &#09 currency - currency you want to send<br>
	 * &#09 receiver - receiver (bitcoin address, email address)<br>
	 * @return payment information about withdraw and receive amounts and payment status
	 * @throws ValidationException
	 */
	public SendCurrencyResponse sendCurrency(SendCurrencyRequest request) throws ValidationException {
		String url = SEND_CURRENCY.replace("{currency}", request.getCurrency());
		return this.process(request.getSendCurrencyList(), url, HttpMethod.POST, SendCurrencyResponse.class);
	}

	/**
	 * <b>POST /wallet/exchange/buy</b> <br><br>
	 * Method used to exchange receive currency amount to pay currency.
	 * @param request
	 * &#09 receiveAmount - amount you want to receive<br>
	 * &#09 receiveCurrency - currency you want to receive<br>
	 * &#09 payCurrency - currency you want to pay<br>
	 * @return exchange information about pay and receive amounts and exchange status
	 * @throws ValidationException
	 */
	public BuyCurrencyResponse buyCurrency(BuyCurrencyRequest request) throws ValidationException {
		return this.process(request, EXCHANGE_BUY, HttpMethod.POST, BuyCurrencyResponse.class);
	}

	/**
	 * <b>POST /wallet/exchange/sell</b> <br><br>
	 * Method used to exchange pay currency amount to receive currency
	 * @param request
	 * &#09 payAmount - amount you want to pay<br>
	 * &#09 payCurrency - currency you want to pay<br>
	 * &#09 receiveCurrency - currency you want to receive<br>
	 * @return exchange information about pay and receive amounts and exchange status
	 * @throws ValidationException
	 */
	public SellCurrencyResponse sellCurrency(SellCurrencyRequest request) throws ValidationException {
		return this.process(request, EXCHANGE_SELL, HttpMethod.POST, SellCurrencyResponse.class);
	}

	/**
	 * <b>GET /wallet/deposit/{cyrrency}/last</b> <br><br>
	 * Method used to get last crypto address
	 * @return last crypto address
	 * @throws ValidationException
	 */
	public GetLastCryptoAddressResponse getLastCryptoAddress(GetLastCryptoAddressRequest request) throws ValidationException {
		String url = LAST_CRYPTO_ADDRESS.replace("{currency}", request.getCurrency());
		return this.process(null, url, HttpMethod.GET, GetLastCryptoAddressResponse.class);
	}

	/**
	 * <b>GET /wallet/deposit/{currency}/fresh</b> <br><br>
	 * Method used to get new crypto address
	 * @return new crypto address
	 * @throws ValidationException
	 */
	public GetNewCryptoAddressResponse getNewCryptoAddress(GetNewCryptoAddressRequest request) throws ValidationException {
		String url = NEW_CRYPTO_ADDRESS.replace("{currency}", request.getCurrency());
		return this.process(null, url, HttpMethod.GET, GetNewCryptoAddressResponse.class);
	}

	/**
	 * <b>GET /wallet/send/status/{paymentId}</b> <br><br>
	 * Method used to get crypto payment info
	 * @return crypto payment info
	 * @throws ValidationException
	 */
	public GetCryptoSendInfoResponse getCryptoSendInfo(GetCryptoSendInfoRequest request) throws ValidationException {
		String url = CRYPTO_SEND_INFO.replace("{paymentId}", request.getPaymentId().toString());
		return this.process(null, url, HttpMethod.GET, GetCryptoSendInfoResponse.class);
	}
}