package lt.spectrofinance.spectrocoin.walletclient.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * Created by UAB Spectro Finance
 * developed by MindaugasR on 2016-11-14.
 */
@Data
public class GetCryptoSendInfoRequest {

	@JsonIgnore
	private Integer paymentId;

}