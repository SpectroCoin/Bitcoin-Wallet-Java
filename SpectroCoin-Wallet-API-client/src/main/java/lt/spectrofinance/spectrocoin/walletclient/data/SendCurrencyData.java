package lt.spectrofinance.spectrocoin.walletclient.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lt.spectrofinance.spectrocoin.walletclient.constants.SendCurrencyStatus;

import java.math.BigDecimal;

/**
 * Created by UAB Spectro Finance
 * developed by MindaugasR on 2017-11-14.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendCurrencyData {

	private Long paymentId;

	private BigDecimal withdrawAmount;

	private String receiver;

	private String message;

	private BigDecimal receiveAmount;

	private String currency;

	private SendCurrencyStatus status;

	private ErrorInfo error;

}