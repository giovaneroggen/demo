package br.com.runnable.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


/**
 * Created by giovane.silva on 04/10/2017.
 */

@Configuration
@ConditionalOnClass(name = {
        "org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter",
        "org.springframework.data.rest.core.event.ValidatingRepositoryEventListener",
        "org.springframework.validation.beanvalidation.LocalValidatorFactoryBean",
        "org.springframework.validation.Validator"
})
public class CustomRepositoryRestConfiguration extends RepositoryRestConfigurerAdapter {

    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }

    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
        validatingListener.addValidator("afterCreate", validator());
        validatingListener.addValidator("beforeCreate", validator());
        validatingListener.addValidator("afterSave", validator());
        validatingListener.addValidator("beforeSave", validator());
    }
}
