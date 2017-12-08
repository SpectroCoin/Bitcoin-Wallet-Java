package lt.spectrofinance.spectrocoin.walletclient.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by UAB Spectro Finance
 * developed by MindaugasR on 2017-12-07.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OutputInfo {

	private Integer outputNo;

	private String withdrawAccount;

	private BigDecimal receiveAmount;

	private String refId;
}
