package lt.spectrofinance.spectrocoin.walletclient.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by UAB Spectro Finance
 * developed by NerijusT on 2016-05-03.
 */
@Data
public class RefreshOauth2TokenRequest extends BaseOAuth2Request {

	@JsonProperty(value = "refresh_token")
	private String refreshToken;

}