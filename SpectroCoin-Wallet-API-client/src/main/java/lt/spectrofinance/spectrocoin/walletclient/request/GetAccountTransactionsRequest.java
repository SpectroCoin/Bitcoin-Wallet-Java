package lt.spectrofinance.spectrocoin.walletclient.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.ws.rs.QueryParam;

/**
 * Created by UAB Spectro Finance
 * developed by NerijusT on 2016-05-04.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetAccountTransactionsRequest {

	private Long accountId;

	@QueryParam("page")
	private Long page;

	@QueryParam("size")
	private Long size;

}