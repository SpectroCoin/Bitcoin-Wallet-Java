package lt.spectrofinance.spectrocoin.walletclient.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * Created by UAB Spectro Finance
 * developed by NerijusT on 2016-09-07.
 */
@Data
public class CurrencyRequest {

	@JsonIgnore
	private String currency;

}