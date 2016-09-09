package lt.spectrofinance.spectrocoin.walletclient.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by UAB Spectro Finance
 * developed by NerijusT on 2016-05-02.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorInfo {

	@JsonProperty(value = "code")
	private Long errorCode;

	@JsonProperty(value = "message")
	private String message;

}