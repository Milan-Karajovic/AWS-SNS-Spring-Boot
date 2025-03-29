package rs.karajovic.milan.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * @author Milan Karajovic <milan.karajovic.rs@gmail.com>
 *
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class SnsResponse {
    private Integer statusCode;
    private String message;
    private String publishedMessageId;
    
    @Override
    public String toString() {
        return "SnsResponse{statusCode=" + statusCode + 
               ", message='" + message + '\'' + 
               ", publishedMessageId='" + publishedMessageId + "'}";
    }

}
