package lt.spectrofinance.spectrocoin.walletclient.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by UAB Spectro Finance
 * developed by NerijusT on 2016-05-02.
 */
@Data
public class CalculateReceiveAmountResponse {

	@JsonProperty("receiveAmount")
	private BigDecimal receiveAmount;

	@JsonProperty("receiveCurrency")
	private String receiveCurrency;

}