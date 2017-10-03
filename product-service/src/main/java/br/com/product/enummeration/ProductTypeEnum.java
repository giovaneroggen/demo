package br.com.product.enummeration;

import br.com.entity.enummeration.GenericEnum;
import br.com.runnable.web.exception.GenericProcessException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Created by giovane.silva on 27/09/2017.
 */
@AllArgsConstructor
public enum ProductTypeEnum implements GenericEnum<String> {

    SIMPLE(ProductTypeEnum.SIMPLE_VALUE),
    KIT(ProductTypeEnum.KIT_VALUE);

    @Getter
    private final String value;
    public static final String SIMPLE_VALUE = "simple";
    public static final String KIT_VALUE = "kit";

    @Override
    @JsonValue
    public String jsonValue() {
        return this.value;
    }

    @JsonCreator
    public static ProductTypeEnum forValue(String value) {
        return GenericEnum.get(value, ProductTypeEnum.class, (key) -> {
            throw new GenericProcessException("INVALID ProductTypeEnum " + key, HttpStatus.BAD_REQUEST);
        });
    }
}
