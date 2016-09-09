package lt.spectrofinance.spectrocoin.walletclient.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lt.spectrofinance.spectrocoin.walletclient.data.ErrorInfo;

/**
 * Created by UAB Spectro Finance
 * developed by NerijusT on 2016-05-02.
 */

@Data
@AllArgsConstructor
public class ValidationException extends Exception {

	private ErrorInfo[] validationMessages;

}