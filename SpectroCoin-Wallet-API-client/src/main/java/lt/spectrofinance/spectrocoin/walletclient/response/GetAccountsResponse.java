package lt.spectrofinance.spectrocoin.walletclient.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lt.spectrofinance.spectrocoin.walletclient.data.AccountInfo;

/**
 * Created by UAB Spectro Finance
 * developed by NerijusT on 2016-05-02.
 */
@Data
public class GetAccountsResponse {

	@JsonProperty(value = "accounts")
	private AccountInfo[] accounts;

}