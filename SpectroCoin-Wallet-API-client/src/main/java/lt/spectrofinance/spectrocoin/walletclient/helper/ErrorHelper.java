package lt.spectrofinance.spectrocoin.walletclient.helper;

import lt.spectrofinance.spectrocoin.walletclient.data.ErrorInfo;

/**
 * Created by UAB Spectro Finance
 * developed by NerijusT on 2016-05-05.
 */
public class ErrorHelper {

	public static final ErrorInfo VALIDATION_ERROR = new ErrorInfo(1L, "Invalid validation");
	public static final ErrorInfo UNSUPPORTED_MEDIA_TYPE = new ErrorInfo(97L, "Unsupported media type");
	public static final ErrorInfo UNEXPECTED_ERROR = new ErrorInfo(100L, "Unexpected error");
	public static final ErrorInfo MORE_THAN_ZERO = new ErrorInfo(1002L, "amount should be more than zero");
	public static final ErrorInfo FORBIDDEN = new ErrorInfo(1003L, "Forbidden");
	public static final ErrorInfo UNAUTHORIZED = new ErrorInfo(1004L, "Unauthorized");
	public static final ErrorInfo UNKNOWN_VALUE = new ErrorInfo(1005L, "Unknown value");
	public static final ErrorInfo AMOUNT_MORE_THAN  = new ErrorInfo(1008L, "Amount should be more than ");
	public static final ErrorInfo CLIENT_NOT_FOUND  = new ErrorInfo(2001L, "Specified client not found");
	public static final ErrorInfo APPLICATION_DISABLED = new ErrorInfo(2002L, "Application for this user is disabled");
	public static final ErrorInfo REFRESH_TOKEN_EXPIRED = new ErrorInfo(2003L, "Refresh token expired");
	public static final ErrorInfo BALANCE_NOT_ENOUGH = new ErrorInfo(3001L, "Balance not enough to send");
	public static final ErrorInfo INVALID_EMAIL_OR_ADDRESS = new ErrorInfo(3002L, "Invalid email or address");
	public static final ErrorInfo INVALID_EMAIL_ADDRESS = new ErrorInfo(3003L, "Invalid email address");
	public static final ErrorInfo SAME_SENDER_RECEIVER = new ErrorInfo(3005L, "Sender and receiver should be different");
	public static final ErrorInfo TO_SMALL_AMOUNT = new ErrorInfo(3006L, "Amount too small to send");
	public static final ErrorInfo DESTINATION_COUNT_REACHED = new ErrorInfo(3016L, "Destination count reached. Max allowed destinations: {count}");
	public static final ErrorInfo DATA_HAVE_EMPTY_FIELDS = new ErrorInfo(3017L, "Data have empty fields");
	public static final ErrorInfo INCORRECT_RECEIVER = new ErrorInfo(3020L, "Incorrect receiver.");
	public static final ErrorInfo DESTINATION_COUNT_REACHED_FIAT = new ErrorInfo(3021L, "Destination count reached. Max allowed fiat destinations: {count}");
	public static final ErrorInfo SEND_CURRENCY_FAILED = new ErrorInfo(3027L, "Send currency failed");
	public static final ErrorInfo FAILED_TO_GET_CRYPTO_PAYMENT = new ErrorInfo(3030L, "Failed to get crypto payment");
	public static final ErrorInfo BAD_PAYMENT_ID = new ErrorInfo(3031L, "Bad payment id");
	public static final ErrorInfo WITHDRAW_ALREADY_USED_REFID = new ErrorInfo(3032L, "You have already sent money with this refId");
	public static final ErrorInfo USER_NOT_VERIFIED = new ErrorInfo(5003L, "User not verified");
	public static final ErrorInfo ACCOUNT_NOT_FOUND = new ErrorInfo(6001L, "Member account not found for this user.");
	public static final ErrorInfo EXCEEDS_USER_PAY_LIMIT = new ErrorInfo(7006L, "Exceeds user pay limit!");
	public static final ErrorInfo EXCEEDS_USER_RECEIVE_LIMIT = new ErrorInfo(7007L, "Exceeds user receive limit!");
	public static final ErrorInfo UNSUPPORTED_CURRENCY_EXCHANGE = new ErrorInfo(7008L, "Unsupported currency exchange");
	public static final ErrorInfo TO_SMALL_PAY_AMOUNT = new ErrorInfo(7009L, "Pay amount can't be smaller than");
	public static final ErrorInfo TO_SMALL_RECEIVE_AMOUNT = new ErrorInfo(7010L, "Receive amount can't be smaller than");
	public static final ErrorInfo ADDRESS_GENERATION_LIMIT_REACHED = new ErrorInfo(13023L, "New crypto address generation limit reached");

}
