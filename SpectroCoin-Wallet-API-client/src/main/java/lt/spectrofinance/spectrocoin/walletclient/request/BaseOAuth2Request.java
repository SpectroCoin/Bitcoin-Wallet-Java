package lt.spectrofinance.spectrocoin.walletclient.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by UAB Spectro Finance
 * developed by NerijusT on 2016-05-03.
 */

@Data
public class BaseOAuth2Request {

	@JsonProperty(value = "client_id")
	private String clientId;

	@JsonProperty(value = "client_secret")
	private String clientSecret;

	@JsonProperty(value = "version")
	private String version;

}