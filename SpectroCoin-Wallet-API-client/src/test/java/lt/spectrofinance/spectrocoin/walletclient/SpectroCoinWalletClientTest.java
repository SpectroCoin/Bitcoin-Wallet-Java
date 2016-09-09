package lt.spectrofinance.spectrocoin.walletclient;

import lt.spectrofinance.spectrocoin.walletclient.data.AccountInfo;
import lt.spectrofinance.spectrocoin.walletclient.data.SendCurrency;
import lt.spectrofinance.spectrocoin.walletclient.exception.ValidationException;
import lt.spectrofinance.spectrocoin.walletclient.request.*;
import lt.spectrofinance.spectrocoin.walletclient.response.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by UAB Spectro Finance
 * developed by NerijusT on 2016-05-04.
 */
public class SpectroCoinWalletClientTest {

	private static SpectroCoinWalletClient client;

	@BeforeClass
	public static void setUp() throws Exception {
		// TODO: update credentials
		client = new SpectroCoinWalletClient("wallet_v0c2e9f4a10943a1ff4d05f9552e8a8d", "password", null, "1.0");
	}

	@Test
	public void testGetAccounts() throws Exception {
		GetAccountsResponse accounts = client.getAccounts();
		Assert.assertNotNull(accounts);

		System.out.println("accounts = " + accounts);
	}

	@Test
	public void testGetAccountInfo() throws Exception {
		GetAccountsResponse getAccountsResponse = client.getAccounts();
		Assert.assertNotNull(getAccountsResponse);
		AccountInfo[] accounts = getAccountsResponse.getAccounts();
		Long firstAccountId = accounts[0].getAccountId();

		GetAccountTransactionsRequest getAccountInfoRequest = new GetAccountTransactionsRequest();
		getAccountInfoRequest.setPage(1L);
		getAccountInfoRequest.setSize(2L);
		getAccountInfoRequest.setAccountId(firstAccountId);

		GetAccountTransactionsResponse accountInfo = client.getAccountTransactions(getAccountInfoRequest);
		Assert.assertNotNull(accountInfo);
		Assert.assertTrue(accountInfo.getHistory().length <= 2L);

		System.out.println("accountInfo = " + accountInfo);
	}

	@Test
	public void testCalculatePayAmount() throws Exception {
		CalculatePayAmountRequest calculateBuyCurrencyRequest = new CalculatePayAmountRequest();
		calculateBuyCurrencyRequest.setPayCurrency("EUR");
		calculateBuyCurrencyRequest.setReceiveCurrency("BTC");
		calculateBuyCurrencyRequest.setReceiveAmount(new BigDecimal("1"));

		CalculatePayAmountResponse calculateBuyResponse = client.calculatePayAmount(calculateBuyCurrencyRequest);
		Assert.assertNotNull(calculateBuyResponse);

		System.out.println("calculateBuyResponse = " + calculateBuyResponse);
	}

	@Test
	public void testCalculateReceiveAmount() throws Exception {
		CalculateReceiveAmountRequest calculatePayAmountRequest = new CalculateReceiveAmountRequest();
		calculatePayAmountRequest.setPayCurrency("BTC");
		calculatePayAmountRequest.setPayAmount(new BigDecimal("10.1"));
		calculatePayAmountRequest.setReceiveCurrency("EUR");

		CalculateReceiveAmountResponse calculateReceiveAmountResponse = client.calculateReceiveAmount(calculatePayAmountRequest);
		Assert.assertNotNull(calculateReceiveAmountResponse);

		System.out.println("calculateReceiveAmountResponse = " + calculateReceiveAmountResponse);
	}

	@Test
	public void testSendCurrency() throws Exception {
		SendCurrencyRequest sendCurrencyRequest = new SendCurrencyRequest();
		sendCurrencyRequest.setCurrency("DASH");

		SendCurrency sendCurrency = new SendCurrency();
		sendCurrency.setAmount(new BigDecimal("1.11"));
		sendCurrency.setReceiver("user@spectrocoin.com");//todo: need to set receiver

		ArrayList<SendCurrency> list = new ArrayList<>();
		list.add(sendCurrency);
		sendCurrencyRequest.setSendCurrencyList(list);
		SendCurrencyResponse sendCurrencyResponse = client.sendCurrency(sendCurrencyRequest);
		Assert.assertNotNull(sendCurrencyResponse);

		System.out.println("sendCurrencyResponse = " + sendCurrencyResponse);
	}

	@Test
	public void testBuyCurrency() throws Exception {
		BuyCurrencyRequest buyCurrencyRequest = new BuyCurrencyRequest();
		buyCurrencyRequest.setPayCurrency("EUR");
		buyCurrencyRequest.setReceiveAmount(new BigDecimal("0.00"));//todo: need to set amount
		buyCurrencyRequest.setReceiveCurrency("BTC");

		BuyCurrencyResponse buyCurrencyResponse = client.buyCurrency(buyCurrencyRequest);
		Assert.assertNotNull(buyCurrencyResponse);

		System.out.println("buyCurrencyResponse = " + buyCurrencyResponse);
	}

	@Test
	public void testSellCurrency() throws Exception {
		SellCurrencyRequest sellCurrencyRequest = new SellCurrencyRequest();
		sellCurrencyRequest.setPayAmount(new BigDecimal("0.00"));//todo: need to set amount
		sellCurrencyRequest.setPayCurrency("EUR");
		sellCurrencyRequest.setReceiveCurrency("USD");

		SellCurrencyResponse sellCurrencyResponse = client.sellCurrency(sellCurrencyRequest);
		Assert.assertNotNull(sellCurrencyResponse);

		System.out.println("sellCurrencyResponse = " + sellCurrencyResponse);
	}

	@Test
	public void testGetLastCryptoAddress() throws Exception {

		GetLastCryptoAddressRequest getLastCryptoAddressRequest = new GetLastCryptoAddressRequest();
		getLastCryptoAddressRequest.setCurrency("BTC");

		GetLastCryptoAddressResponse lastCryptoAddress = client.getLastCryptoAddress(getLastCryptoAddressRequest);
		Assert.assertNotNull(lastCryptoAddress);

		System.out.println(String.format("Last %s address = %s", lastCryptoAddress.getCurrency(), lastCryptoAddress.getCryptoAddress()));
	}

	@Test
	public void testGetNewCryptoAddress() throws Exception {

		GetNewCryptoAddressRequest getNewCryptoAddressRequest = new GetNewCryptoAddressRequest();
		getNewCryptoAddressRequest.setCurrency("DASH");

		GetNewCryptoAddressResponse lastCryptoAddress = client.getNewCryptoAddress(getNewCryptoAddressRequest);
		Assert.assertNotNull(lastCryptoAddress);

		System.out.println(String.format("Last %s address = %s", lastCryptoAddress.getCurrency(), lastCryptoAddress.getCryptoAddress()));
	}

	@Test(expected = ValidationException.class)
	public void testGetNewCryptoAddressFail() throws Exception {

		GetNewCryptoAddressRequest getNewCryptoAddressRequest = new GetNewCryptoAddressRequest();
		getNewCryptoAddressRequest.setCurrency("EUR");

		try {
			client.getNewCryptoAddress(getNewCryptoAddressRequest);
		} catch (ValidationException e) {
			System.out.println("e = " + e);
			throw e;
		}
	}
}