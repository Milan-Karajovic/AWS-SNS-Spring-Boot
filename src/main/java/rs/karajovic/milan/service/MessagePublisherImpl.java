package rs.karajovic.milan.service;

import rs.karajovic.milan.config.AwsProperties;
import rs.karajovic.milan.model.Message;
import rs.karajovic.milan.model.RequestBuilder;
import rs.karajovic.milan.model.SnsResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.core.exception.SdkException;
import software.amazon.awssdk.core.exception.SdkServiceException;
import software.amazon.awssdk.http.SdkHttpResponse;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;
import software.amazon.awssdk.services.sns.model.SnsException;

/**
 * 
 * @author Milan Karajovic <milan.karajovic.rs@gmail.com>
 *
 */

@Service
@Slf4j
@AllArgsConstructor
public class MessagePublisherImpl implements MessagePublisher {

    private final SnsClient snsClient;
    private final AwsProperties awsProperties;

    @Override
    public SnsResponse publish(Message message) {
        SnsResponse response = null;

        try {
            PublishRequest request = RequestBuilder.build(awsProperties.getTopicArn(), message);
            log.info("Request: {}", request);

            PublishResponse publishResponse = snsClient.publish(request);
            log.info("Publish response: {}", publishResponse);

            SdkHttpResponse httpResponse = publishResponse.sdkHttpResponse();
            response = new SnsResponse(
                    httpResponse.statusCode(),
                    httpResponse.statusText().orElse(null),
                    publishResponse.messageId());
            log.info("Response details: {}", response);
        } catch (SnsException e) {
            rethrow(e.statusCode(), e.getClass().getSimpleName() + ": " + e.awsErrorDetails());
        } catch (SdkServiceException e) {
            rethrow(e.statusCode(), e.getClass().getSimpleName() + ": " + e.getMessage());
        } catch (SdkClientException e) {
            rethrow(null, e.getClass().getSimpleName() + ": " + e.getMessage());
        } catch (SdkException e) {
            rethrow(null, e.getClass().getSimpleName() + ": " + e.getMessage());
        }
        return response;
    }

    private void rethrow(Integer statusCode, String detailedMessage) {
        SnsResponse response = new SnsResponse(statusCode, detailedMessage, null);
        throw new RuntimeException(response.toString());
    }
}
