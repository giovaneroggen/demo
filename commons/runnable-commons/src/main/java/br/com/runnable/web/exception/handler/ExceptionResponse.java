package br.com.runnable.web.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

/**
 * Created by giovane.silva on 26/09/2017.
 */
@Data
@AllArgsConstructor
public class ExceptionResponse{
    private String status;
    private Integer code;
    private String message;
    private Map errors;
}