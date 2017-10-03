package br.com.entity.enummeration;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.EnumSet;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created by giovane.silva on 26/09/2017.
 */
public interface GenericEnum<T> {

    @JsonValue
    public T jsonValue();

    public static <R, E extends Enum<E> & GenericEnum<R>> E get(R value, Class<E> enumClass, Consumer<R> consumer) {
        EnumSet<E> enumSet = EnumSet.allOf(enumClass);
        List<E> collect = enumSet.stream()
                .filter(teste -> teste.jsonValue().equals(value))
                .collect(Collectors.toList());
        if(collect.isEmpty()){
            consumer.accept(value);
        }
        return collect.get(0);
    }
}