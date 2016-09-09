package lt.spectrofinance.spectrocoin.walletclient.helper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.io.IOException;

/**
 * Created by UAB Spectro Finance
 * developed by NerijusT on 2016-05-02.
 */
public class DateTimeJSONDeserializer extends JsonDeserializer<DateTime> {

	@Override
	public DateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
		return new DateTime(jsonParser.getValueAsString()).toDateTime(DateTimeZone.UTC);
	}
}