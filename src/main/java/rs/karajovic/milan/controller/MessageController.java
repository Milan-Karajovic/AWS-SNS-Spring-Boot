package rs.karajovic.milan.controller;

import rs.karajovic.milan.model.Message;
import rs.karajovic.milan.model.SnsResponse;
import rs.karajovic.milan.service.MessagePublisher;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * 
 * @author Milan Karajovic <milan.karajovic.rs@gmail.com>
 *
 */

@RestController
public class MessageController {

    private final MessagePublisher messagePublisher;

    public MessageController(MessagePublisher messagePublisher) {
        this.messagePublisher = messagePublisher;
    }

    @PostMapping(value = "/publish")
    @ResponseStatus(HttpStatus.CREATED)
    public SnsResponse publishMessage(@RequestBody Message message) {
        return messagePublisher.publish(message);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    private String handleException(RuntimeException e) {
        return e.getMessage();
    }
}
