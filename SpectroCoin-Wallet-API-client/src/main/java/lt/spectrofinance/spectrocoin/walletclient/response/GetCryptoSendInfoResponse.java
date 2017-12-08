package lt.spectrofinance.spectrocoin.walletclient.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import lt.spectrofinance.spectrocoin.walletclient.constants.SendCurrencyStatus;
import lt.spectrofinance.spectrocoin.walletclient.data.OutputInfo;

import java.math.BigDecimal;

/**
 * Created by UAB Spectro Finance
 * developed by MindaugasR on 2017-11-14.
 */
@Data
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetCryptoSendInfoResponse {

	private Long paymentId;

	private SendCurrencyStatus status;

	private String transactionHash;

	private BigDecimal withdrawAmount;

	private String receiver;

	private String message;

	private BigDecimal receiveAmount;

	private String currency;

	private String refId;

	private OutputInfo[] outputData;

}