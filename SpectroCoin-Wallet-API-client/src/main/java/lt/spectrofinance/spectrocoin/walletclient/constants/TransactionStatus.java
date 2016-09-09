package lt.spectrofinance.spectrocoin.walletclient.constants;

/**
 * Created by UAB Spectro Finance
 * developed by NerijusT on 2016-05-04.
 */
public enum TransactionStatus {

	/**
	 * waiting for action
	 */
	PENDING(),
	/**
	 * transaction completed
	 */
	PROCESSED(),
	/**
	 * transaction incomplete for some reason
	 */
	FAILED ();

}