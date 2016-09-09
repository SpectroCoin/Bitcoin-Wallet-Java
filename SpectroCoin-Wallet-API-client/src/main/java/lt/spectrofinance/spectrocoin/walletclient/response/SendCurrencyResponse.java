package lt.spectrofinance.spectrocoin.walletclient.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lt.spectrofinance.spectrocoin.walletclient.constants.SendCurrencyStatus;

import java.math.BigDecimal;

/**
 * Created by UAB Spectro Finance
 * developed by NerijusT on 2016-05-02.
 */
@Data
public class SendCurrencyResponse {

	@JsonProperty("paymentId")
	private Long paymentId;

	@JsonProperty("withdrawAmount")
	private BigDecimal withdrawAmount;

	@JsonProperty("receiveAmount")
	private BigDecimal receiveAmount;

	@JsonProperty("currency")
	private String currency;

	@JsonProperty("status")
	private SendCurrencyStatus status;

}