package br.com.recurrency.enummeration;

import br.com.entity.enummeration.GenericEnum;
import br.com.runnable.web.exception.GenericProcessException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Created by giovane.silva on 03/10/2017.
 */
@AllArgsConstructor
public enum RecurrencyStatusEnum implements GenericEnum<String> {

    RUNNING(RecurrencyStatusEnum.RUNNING_VALUE),
    PAUSED(RecurrencyStatusEnum.PAUSED_VALUE),
    CANCELED(RecurrencyStatusEnum.CANCELED_VALUE);

    @Getter
    private final String value;
    public static final String RUNNING_VALUE = "running";
    public static final String PAUSED_VALUE = "paused";
    public static final String CANCELED_VALUE = "canceled";

    @Override
    @JsonValue
    public String jsonValue() {
        return this.value;
    }

    @JsonCreator
    public static RecurrencyStatusEnum forValue(String value) {
        return GenericEnum.get(value, RecurrencyStatusEnum.class, (key) -> {
            throw new GenericProcessException("INVALID RecurrencyStatusEnum " + key, HttpStatus.BAD_REQUEST);
        });
    }
}
