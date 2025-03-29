package rs.karajovic.milan.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Test;

import software.amazon.awssdk.services.sns.model.MessageAttributeValue;
import software.amazon.awssdk.services.sns.model.PublishRequest;

/**
 * 
 * @author Milan Karajovic <milan.karajovic.rs@gmail.com>
 *
 */

class RequestBuilderTest {

    private RequestBuilder requestBuilder = new RequestBuilder();

    @Test
    void buildMessage() {
        String expectedCountry = "Serbia";
        String expectedRegion = "Central Serbia";
        EventType expectedEventType = EventType.DROP;
        String expectedCity = "Krusevac";
        String expectednewTemperature = "14.7";
        Message message = new Message(
        		expectedCountry, expectedRegion, expectedEventType, expectedCity, Double.parseDouble(expectednewTemperature));

        PublishRequest publishRequest = requestBuilder.build("topicArn", message);

        assertThat(publishRequest.hasMessageAttributes()).isTrue();
        Map<String, MessageAttributeValue> actualAttributes = publishRequest.messageAttributes();
        assertThat(actualAttributes.get(RequestBuilder.COUNTRY).stringValue()).isEqualTo(expectedCountry);
        assertThat(actualAttributes.get(RequestBuilder.REGION).stringValue()).isEqualTo(expectedRegion);
        assertThat(actualAttributes.get(RequestBuilder.EVENT_TYPE).stringValue()).isEqualTo(expectedEventType.toString());
        assertThat(actualAttributes.get(RequestBuilder.CITY).stringValue()).isEqualTo(expectedCity);
        assertThat(actualAttributes.get(RequestBuilder.NEW_TEMPERATURE).stringValue()).isEqualTo(expectednewTemperature);
        assertThat(publishRequest.message()).isEqualTo(RequestBuilder.DEFAULT_MESSAGE_BODY);
        assertThat(publishRequest.topicArn()).isEqualTo("topicArn");
    }
}