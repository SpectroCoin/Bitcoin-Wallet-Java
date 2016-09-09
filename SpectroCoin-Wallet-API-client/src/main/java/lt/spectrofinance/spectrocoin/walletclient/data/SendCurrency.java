package lt.spectrofinance.spectrocoin.walletclient.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by UAB Spectro Finance
 * developed by NerijusT on 2016-06-09.
 */
@Data
public class SendCurrency {

	@JsonProperty("amount")
	private BigDecimal amount;

	@JsonProperty("receiver")
	private String receiver;

}