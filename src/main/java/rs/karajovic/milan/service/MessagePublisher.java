package rs.karajovic.milan.service;

import rs.karajovic.milan.model.Message;
import rs.karajovic.milan.model.SnsResponse;

/**
 * 
 * @author Milan Karajovic <milan.karajovic.rs@gmail.com>
 *
 */

public interface MessagePublisher {
    SnsResponse publish(Message message);
}
