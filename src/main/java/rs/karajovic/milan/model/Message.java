package rs.karajovic.milan.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Milan Karajovic <milan.karajovic.rs@gmail.com>
 *
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Message {
    private String country;
    private String region;
    private EventType eventType;
    private String city;
    private Double newTemperature;

}
