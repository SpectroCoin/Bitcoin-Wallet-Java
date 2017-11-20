package lt.spectrofinance.spectrocoin.walletclient.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lt.spectrofinance.spectrocoin.walletclient.data.SendCurrencyData;

/**
 * Created by UAB Spectro Finance
 * developed by NerijusT on 2016-05-02.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendCurrencyResponse extends SendCurrencyData {

	private SendCurrencyData[] sendCurrencyData;

}