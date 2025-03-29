package rs.karajovic.milan.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * 
 * @author Milan Karajovic <milan.karajovic.rs@gmail.com>
 *
 */

@Configuration
@ConfigurationProperties(prefix = "aws.sns")
public class AwsProperties {

	@Getter @Setter
    @NotNull
    private String region;

	@Getter @Setter
    @NotNull
    private String topicArn;


}
