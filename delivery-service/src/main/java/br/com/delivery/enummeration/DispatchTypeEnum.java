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
public enum DispatchTypeEnum implements GenericEnum<String> {

    DELIVERY(DispatchTypeEnum.DELIVERY_VALUE),
    DRIVE_THRU(DispatchTypeEnum.DRIVE_THRU_VALUE);

    @Getter
    private final String value;
    public static final String DELIVERY_VALUE = "delivery";
    public static final String DRIVE_THRU_VALUE = "driveThru";

    @Override
    @JsonValue
    public String jsonValue() {
        return this.value;
    }

    @JsonCreator
    public static DispatchTypeEnum forValue(String value) {
        return GenericEnum.get(value, DispatchTypeEnum.class, (key) -> {
            throw new GenericProcessException("INVALID DispatchTypeEnum " + key, HttpStatus.BAD_REQUEST);
        });
    }

}
