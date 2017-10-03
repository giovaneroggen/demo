package br.com.collection.enummeration;

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
public enum ProductCollectionTypeEnum implements GenericEnum<String> {

    SHELF(ProductCollectionTypeEnum.SHELF_VALUE);

    @Getter
    private final String value;
    public static final String SHELF_VALUE = "shelf";

    @Override
    @JsonValue
    public String jsonValue() {
        return this.value;
    }

    @JsonCreator
    public static ProductCollectionTypeEnum forValue(String value) {
        return GenericEnum.get(value, ProductCollectionTypeEnum.class, (key) -> {
            throw new GenericProcessException("INVALID ProductCollectionTypeEnum " + key, HttpStatus.BAD_REQUEST);
        });
    }
}
