package lt.spectrofinance.spectrocoin.walletclient.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by UAB Spectro Finance
 * developed by NerijusT on 2016-09-07.
 */
@Data
public class BaseCryptoAddressResponse {

	@JsonProperty("cryptoAddress")
	private String cryptoAddress;

	@JsonProperty("currency")
	private String currency;

	@JsonProperty("message")
	private String message;
}