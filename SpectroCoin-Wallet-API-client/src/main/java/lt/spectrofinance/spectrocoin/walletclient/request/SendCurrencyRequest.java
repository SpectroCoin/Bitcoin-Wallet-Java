package lt.spectrofinance.spectrocoin.walletclient.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lt.spectrofinance.spectrocoin.walletclient.data.SendCurrency;

import java.util.ArrayList;

/**
 * Created by UAB Spectro Finance
 * developed by NerijusT on 2016-05-04.
 */
@Data
public class SendCurrencyRequest {

	@JsonIgnore
	private String currency;

	private ArrayList<SendCurrency> sendCurrencyList;

}