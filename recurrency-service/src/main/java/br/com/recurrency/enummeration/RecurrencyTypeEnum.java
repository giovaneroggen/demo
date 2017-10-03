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
public enum RecurrencyTypeEnum implements GenericEnum<String> {

    WEEKLY(RecurrencyTypeEnum.WEEKLY_VALUE),
    MONTHLY(RecurrencyTypeEnum.MONTHLY_VALUE),
    YEARLY(RecurrencyTypeEnum.YEARLY_VALUE);

    @Getter
    private final String value;
    public static final String WEEKLY_VALUE = "weekly";
    public static final String MONTHLY_VALUE = "monthly";
    public static final String YEARLY_VALUE = "yearly";

    @Override
    @JsonValue
    public String jsonValue() {
        return this.value;
    }

    @JsonCreator
    public static RecurrencyTypeEnum forValue(String value) {
        return GenericEnum.get(value, RecurrencyTypeEnum.class, (key) -> {
            throw new GenericProcessException("INVALID RecurrencyTypeEnum " + key, HttpStatus.BAD_REQUEST);
        });
    }
}
