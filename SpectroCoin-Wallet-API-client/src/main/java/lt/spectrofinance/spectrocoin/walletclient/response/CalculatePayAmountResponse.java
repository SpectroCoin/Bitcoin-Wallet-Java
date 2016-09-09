package lt.spectrofinance.spectrocoin.walletclient.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by UAB Spectro Finance
 * developed by NerijusT on 2016-05-02.
 */
@Data
public class CalculatePayAmountResponse {

	@JsonProperty("payAmount")
	private BigDecimal payAmount;

	@JsonProperty("payCurrency")
	private String payCurrency;

}