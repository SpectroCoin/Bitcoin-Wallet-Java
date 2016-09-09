package lt.spectrofinance.spectrocoin.walletclient.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lt.spectrofinance.spectrocoin.walletclient.constants.ExchangeCurrencyStatus;

import java.math.BigDecimal;

/**
 * Created by UAB Spectro Finance
 * developed by NerijusT on 2016-05-02.
 */
@Data
public class ExchangeCurrencyResponse {

	@JsonProperty("exchangeId")
	private Long currencyExchangeId;

	@JsonProperty("status")
	private ExchangeCurrencyStatus status;

	@JsonProperty("payAmount")
	private BigDecimal payAmount;

	@JsonProperty("payCurrency")
	private String payCurrency;

	@JsonProperty("receiveCurrency")
	private String receiveCurrency;

	@JsonProperty("receiveAmount")
	private BigDecimal receiveAmount;

}