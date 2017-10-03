package br.com.runnable.web.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by giovane.silva on 26/09/2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenericProcessException extends RuntimeException {

    private HttpStatus status;
    private Integer code;
    private String message;
    private Map<? extends Serializable,? extends Serializable> errors;

    public GenericProcessException(String message, HttpStatus status){
        super(message);
        this.message = message;
        this.status = status;
        this.code = status.value();
    }
}