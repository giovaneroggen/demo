package br.com.product.util;

import lombok.Data;

/**
 * Created by giovane.silva on 12/09/2017.
 */
@Data
public class Wrapper<T>{
    T value;
    private Wrapper(T value){
        this.value = value;
    }

    public static <T> Wrapper<T> instance(T value){
        return new Wrapper<>(value);
    }

    public static <T> Wrapper<T> instance(){
        return instance(null);
    }
}

