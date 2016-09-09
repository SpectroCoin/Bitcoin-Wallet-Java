package lt.spectrofinance.spectrocoin.walletclient.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lt.spectrofinance.spectrocoin.walletclient.constants.TransactionStatus;
import lt.spectrofinance.spectrocoin.walletclient.helper.DateTimeJSONDeserializer;
import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * Created by UAB Spectro Finance
 * developed by NerijusT on 2016-05-02.
 */
@Data
public class TransactionInfo {

	@JsonProperty("transactionId")
	private String transactionId;

	@JsonProperty("status")
	private TransactionStatus status;

	@JsonProperty("amount")
	private BigDecimal amount;

	@JsonProperty("description")
	@JsonDeserialize()
	private String description;

	@JsonDeserialize(using = DateTimeJSONDeserializer.class)
	@JsonProperty("date")
	private DateTime date;

}