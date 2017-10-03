package br.com.delivery.data;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by giovane.silva on 22/09/2017.
 */
@Data
public class Delivery extends Dispatch {

    @NotNull
    private Double defaultPrice;
    private ZipCode zipCodeInitialRange;
    private ZipCode zipCodeFinalRange;

}
