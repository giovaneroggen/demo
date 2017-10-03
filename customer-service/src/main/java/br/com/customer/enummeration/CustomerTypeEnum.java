package br.com.customer.enummeration;

import br.com.entity.enummeration.GenericEnum;
import br.com.runnable.web.exception.GenericProcessException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Created by giovane.silva on 26/09/2017.
 */
@AllArgsConstructor
public enum CustomerTypeEnum implements GenericEnum<String> {

    PHYSICAL(CustomerTypeEnum.PHYSICAL_VALUE),
    LEGAL(CustomerTypeEnum.LEGAL_VALUE);

    @Getter
    private final String value;
    public static final String PHYSICAL_VALUE = "physical";
    public static final String LEGAL_VALUE = "legal";

    @Override
    @JsonValue
    public String jsonValue() {
        return this.value;
    }

    @JsonCreator
    public static CustomerTypeEnum forValue(String value) {
        return GenericEnum.get(value, CustomerTypeEnum.class, (key) -> {
            throw new GenericProcessException("INVALID CustomerTypeEnum " + key, HttpStatus.BAD_REQUEST);
        });
    }
}
