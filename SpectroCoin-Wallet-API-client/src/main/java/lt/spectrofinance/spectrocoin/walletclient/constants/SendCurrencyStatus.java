package lt.spectrofinance.spectrocoin.walletclient.constants;

/**
 * Created by UAB Spectro Finance
 * developed by NerijusT on 2016-05-04.
 */
public enum SendCurrencyStatus {

	/**
	 * initial status, should be processed in near future or manually
	 */
	NEW(),
	/**
	 * money from sender account is charged and reserved for receiver
	 */
	PENDING(),
	/**
	 * receiver got money
	 */
	PAID();

}