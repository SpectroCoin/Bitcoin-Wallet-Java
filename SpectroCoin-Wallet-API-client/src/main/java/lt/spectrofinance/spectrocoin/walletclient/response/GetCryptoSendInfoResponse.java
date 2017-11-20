package lt.spectrofinance.spectrocoin.walletclient.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import lt.spectrofinance.spectrocoin.walletclient.constants.SendCurrencyStatus;

import java.math.BigDecimal;

/**
 * Created by UAB Spectro Finance
 * developed by MindaugasR on 2017-11-14.
 */
@Data
@ToString(callSuper = true)
public class GetCryptoSendInfoResponse {

	@JsonProperty("paymentId")
	private Long paymentId;

	@JsonProperty("status")
	private SendCurrencyStatus status;

	@JsonProperty("transactionHash")
	private String transactionHash;

	@JsonProperty("withdrawAmount")
	private BigDecimal withdrawAmount;

	@JsonProperty("receiver")
	private String receiver;

	@JsonProperty("message")
	private String message;

	@JsonProperty("receiveAmount")
	private BigDecimal receiveAmount;

	@JsonProperty("currency")
	private String currency;

}