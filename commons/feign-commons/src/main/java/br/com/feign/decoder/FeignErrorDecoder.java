package br.com.feign.decoder;

import br.com.runnable.web.exception.GenericProcessException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * Created by giovane.silva on 26/09/2017.
 */
@Slf4j
public class FeignErrorDecoder extends ErrorDecoder.Default{

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            return objectMapper.readValue(response.body().asInputStream(), GenericProcessException.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.decode(methodKey, response);
    }
}
