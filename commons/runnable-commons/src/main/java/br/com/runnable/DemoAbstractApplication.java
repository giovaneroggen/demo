package br.com.runnable;

import br.com.runnable.web.exception.handler.ExceptionResponseHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by giovane.silva on 04/09/2017.
 */
@Configuration
public abstract class DemoAbstractApplication extends WebMvcConfigurerAdapter {

    @Bean
    @ConditionalOnMissingBean
    public ExceptionResponseHandler exceptionHandler(){
        return new ExceptionResponseHandler();
    }

}
