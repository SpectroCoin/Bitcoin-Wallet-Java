package lt.spectrofinance.spectrocoin.walletclient.request;

import lombok.Data;

import javax.ws.rs.QueryParam;
import java.math.BigDecimal;

/**
 * Created by UAB Spectro Finance
 * developed by NerijusT on 2016-05-04.
 */
@Data
public class CalculatePayAmountRequest {

	@QueryParam("receiveAmount")
	private BigDecimal receiveAmount;

	@QueryParam("receiveCurrency")
	private String receiveCurrency;

	@QueryParam("payCurrency")
	private String payCurrency;

}