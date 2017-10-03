package br.com.feign.request.basket.validation;

import javax.validation.Constraint;
import java.lang.annotation.*;

/**
 * Created by giovane.silva on 04/09/2017.
 */
@Constraint(validatedBy = ProductRequestValidation.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidProductRequest {
}
