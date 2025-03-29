package rs.karajovic.milan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import rs.karajovic.milan.config.AppListener;

/**
 * 
 * @author Milan Karajovic <milan.karajovic.rs@gmail.com>
 *
 */

/**
 * *********************************
 * Example: AWS-SNS with Spring Boot
 * *********************************
 *
 */

@SpringBootApplication
public class SpringBootAwsSns {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringBootAwsSns.class);
        app.addListeners(new AppListener());
        app.run(args);
    }
}
