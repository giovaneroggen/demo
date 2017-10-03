package br.com.delivery.enummeration;

import br.com.entity.enummeration.GenericEnum;
import br.com.runnable.web.exception.GenericProcessException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Created by giovane.silva on 22/09/2017.
 */

@AllArgsConstructor
public enum DispatchLimitTypeEnum implements GenericEnum<String>{

    SIZE(DispatchLimitTypeEnum.SIZE_VALUE),
    WEIGHT(DispatchLimitTypeEnum.WEIGHT_VALUE),
    QUANTITY(DispatchLimitTypeEnum.QUANTITY_VALUE),
    PRICE(DispatchLimitTypeEnum.PRICE_VALUE);

    @Getter
    private final String value;
    public static final String SIZE_VALUE = "size";
    public static final String WEIGHT_VALUE = "weight";
    public static final String QUANTITY_VALUE = "quantity";
    public static final String PRICE_VALUE = "price";

    @Override
    @JsonValue
    public String jsonValue() {
        return this.value;
    }

    @JsonCreator
    public static DispatchLimitTypeEnum forValue(String value) {
        return GenericEnum.get(value, DispatchLimitTypeEnum.class, (key) -> {
            throw new GenericProcessException("INVALID DispatchLimitTypeEnum "+key, HttpStatus.BAD_REQUEST);
        });
    }

}
