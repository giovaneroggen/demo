package br.com.product.exception;

import br.com.runnable.web.exception.handler.ExceptionResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.mapping.exception.IndexNotFoundException;
import org.springframework.data.elasticsearch.core.mapping.exception.TypeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by giovane.silva on 02/10/2017.
 */
@ControllerAdvice
public class ElasticSearchExceptionHandler {

    @Autowired
    private ObjectMapper mapper;

    @ResponseBody
    @ExceptionHandler(value = IndexNotFoundException.class)
    public String defaultErrorHandler(HttpServletResponse response, IndexNotFoundException e) throws IOException {
        return this.writeElasticSearchExceptionResponse(response, "organization_is_required");
    }

    @ResponseBody
    @ExceptionHandler(value = TypeNotFoundException.class)
    public String defaultErrorHandler(HttpServletResponse response, TypeNotFoundException e) throws IOException {
        return this.writeElasticSearchExceptionResponse(response, "store_is_required");
    }

    private String writeElasticSearchExceptionResponse(HttpServletResponse response, String message) throws IOException {
        try{
            HttpStatus status = HttpStatus.BAD_REQUEST;
            response.setStatus(status.value());
            return mapper.writeValueAsString(new ExceptionResponse(status.getReasonPhrase(), status.value(), message, null));
        } catch (JsonProcessingException ex) {
            throw new IOException("message writing exception json value", ex);
        }
    }
}
