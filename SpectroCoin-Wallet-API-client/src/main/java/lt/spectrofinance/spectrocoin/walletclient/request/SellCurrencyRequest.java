package lt.spectrofinance.spectrocoin.walletclient.request;

import lombok.Data;

import javax.ws.rs.FormParam;
import java.math.BigDecimal;

/**
 * Created by UAB Spectro Finance
 * developed by NerijusT on 2016-05-04.
 */
@Data
public class SellCurrencyRequest {

	@FormParam("payAmount")
	private BigDecimal payAmount;

	@FormParam("receiveCurrency")
	private String receiveCurrency;

	@FormParam("payCurrency")
	private String payCurrency;

}