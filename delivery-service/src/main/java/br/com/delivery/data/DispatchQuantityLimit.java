package br.com.delivery.data;

import lombok.Data;

/**
 * Created by giovane.silva on 22/09/2017.
 */
@Data
public class DispatchQuantityLimit extends DispatchLimit {

    private Long productQuantity;

}
