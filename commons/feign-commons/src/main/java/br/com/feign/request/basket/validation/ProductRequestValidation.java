package br.com.feign.request.basket.validation;

import br.com.feign.request.basket.ProductRequest;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/*
 * Created by giovane.silva on 04/09/2017.
 */
public class ProductRequestValidation implements ConstraintValidator<ValidProductRequest, ProductRequest> {

    @Override
    public void initialize(ValidProductRequest constraintAnnotation) {

    }

    @Override
    public boolean isValid(ProductRequest value, ConstraintValidatorContext context) {
        String property = null;
        if(value.getId() == null){
            property = "id";
        }
        if(property != null){
            context
                    .buildConstraintViolationWithTemplate( "${errro.oiasjdioajsdjas}" )
                    .addPropertyNode(property).addConstraintViolation();
            return false;
        }
        return true;
    }
}
