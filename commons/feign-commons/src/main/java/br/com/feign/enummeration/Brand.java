package br.com.feign.enummeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by giovane.silva on 04/09/2017.
 */
@AllArgsConstructor
public enum Brand {

    GRUPO_PAO_DE_ACUCAR("pa"), EXTRA_DELIVERY("ex");

    private final String value;

    @JsonValue
    public String toValue() {
        return this.value;
    }

    @JsonCreator
    public static Brand forValue(String value) {
        return get(value);
    }

    private static Brand get(String value) {
        List<Brand> collect = EnumSet.allOf((Brand.class))
                .stream().filter(origem -> origem.value.equals(value))
                .collect(Collectors.toList());
        if(collect.isEmpty()){
            throw new RuntimeException("Invalid brand documentType");
        }
        return collect.get(0);
    }

}
