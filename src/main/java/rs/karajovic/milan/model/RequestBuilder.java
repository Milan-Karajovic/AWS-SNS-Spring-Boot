package rs.karajovic.milan.model;

import software.amazon.awssdk.services.sns.model.MessageAttributeValue;
import software.amazon.awssdk.services.sns.model.PublishRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Milan Karajovic <milan.karajovic.rs@gmail.com>
 *
 */

public class RequestBuilder {
    public static final String COUNTRY = "Country";
    public static final String REGION = "Region";
    public static final String EVENT_TYPE = "EventType";
    public static final String CITY = "City";
    public static final String NEW_TEMPERATURE = "NewTemperature";
    public static final String DEFAULT_MESSAGE_BODY = "Please see attributes.";


    public static PublishRequest build(String topicArn, Message message) {
        Map<String, MessageAttributeValue> attributes = new HashMap<>();
        attributes.put(COUNTRY, buildAttribute(message.getCountry(), "String"));
        attributes.put(REGION, buildAttribute(message.getRegion(), "String"));
        attributes.put(EVENT_TYPE, buildAttribute(message.getEventType().toString(), "String"));
        attributes.put(CITY, buildAttribute(message.getCity(), "String"));
        attributes.put(NEW_TEMPERATURE, buildAttribute(message.getNewTemperature().toString(), "Number"));

        PublishRequest request = PublishRequest.builder()
                .topicArn(topicArn)
                .message(DEFAULT_MESSAGE_BODY)
                .messageAttributes(attributes)
                .build();

        return request;
    }

    private static MessageAttributeValue buildAttribute(String value, String dataType) {
        return MessageAttributeValue.builder()
                .dataType(dataType)
                .stringValue(value)
                .build();
    }
}
