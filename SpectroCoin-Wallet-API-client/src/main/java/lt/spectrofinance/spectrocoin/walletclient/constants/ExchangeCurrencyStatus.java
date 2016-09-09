package lt.spectrofinance.spectrocoin.walletclient.constants;

/**
 * Created by UAB Spectro Finance
 * developed by NerijusT on 2016-05-04.
 */

public enum ExchangeCurrencyStatus{

	/**
	 * initial status
	 */
	NEW(),
	/**
	 * waiting for approval
	 */
	PENDING(),
	/**
	 * exchange completed
	 */
	PAID();

}