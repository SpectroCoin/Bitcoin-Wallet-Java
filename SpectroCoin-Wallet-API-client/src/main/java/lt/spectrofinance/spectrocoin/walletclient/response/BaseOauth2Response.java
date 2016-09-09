package lt.spectrofinance.spectrocoin.walletclient.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by UAB Spectro Finance
 * developed by NerijusT on 2016-05-03.
 */
@Data
public class BaseOauth2Response {

	@JsonProperty(value = "access_token")
	private String accessToken;

	@JsonProperty(value = "expires_in")
	private Long expiresIn;

	@JsonProperty(value = "refresh_token")
	private String refreshToken;

	@JsonProperty(value = "scope")
	private String scope;

	@JsonProperty(value = "token_type")
	private String tokenType;

}