package br.com.runnable.web.exception.handler;

import br.com.runnable.web.exception.GenericProcessException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by giovane.silva on 26/09/2017.
 */
@ControllerAdvice
public class ExceptionResponseHandler {

    @Autowired
    private ObjectMapper mapper;

    @ResponseBody
    @ExceptionHandler(value = GenericProcessException.class)
    public String defaultErrorHandler(HttpServletResponse response, GenericProcessException e) throws IOException {
        try {
            HttpStatus status = e.getStatus();
            response.setStatus(status.value());
            return mapper.writeValueAsString(new ExceptionResponse(status.getReasonPhrase(), status.value(), e.getMessage(), e.getErrors()));
        } catch (JsonProcessingException ex) {
            throw new IOException("message writing exception json value", ex);
        }
    }
}
