package lt.spectrofinance.spectrocoin.walletclient.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lt.spectrofinance.spectrocoin.walletclient.data.TransactionInfo;

/**
 * Created by UAB Spectro Finance
 * developed by NerijusT on 2016-05-02.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetAccountTransactionsResponse {

	@JsonProperty("history")
	private TransactionInfo[] history;

	@JsonProperty("totalCount")
	private Long totalCount;

}