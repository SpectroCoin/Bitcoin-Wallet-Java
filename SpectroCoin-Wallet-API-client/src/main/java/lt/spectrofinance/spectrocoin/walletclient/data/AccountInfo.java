package lt.spectrofinance.spectrocoin.walletclient.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by UAB Spectro Finance
 * developed by NerijusT on 2016-05-02.
 */

@Data
public class AccountInfo {

	@JsonProperty(value = "accountId")
	private Long accountId;

	@JsonProperty(value = "balance")
	private BigDecimal balance;

	@JsonProperty(value = "availableBalance")
	private BigDecimal availableBalance;

	@JsonProperty(value = "reservedAmount")
	private BigDecimal reservedAmount;

	@JsonProperty(value = "currencyName")
	private String currencyName;

	@JsonProperty(value = "currencyCode")
	private String currencyCode;

	@JsonProperty(value = "currencySymbol")
	private String currencySymbol;

}