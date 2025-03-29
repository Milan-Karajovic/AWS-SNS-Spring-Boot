package rs.karajovic.milan.config;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * 
 * @author Milan Karajovic <milan.karajovic.rs@gmail.com>
 *
 */

public class AppListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
    	
    	// accessKeyId & for AWS user
        System.setProperty("aws.accessKeyId", "fill with accessKeyId & for AWS user");
        // secretAccessKey for AWS user
        System.setProperty("aws.secretAccessKey", "fill with secretAccessKey for AWS user");
    	
    }
}
