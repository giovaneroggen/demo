package br.com.delivery.data;

import lombok.Data;

/**
 * Created by giovane.silva on 22/09/2017.
 */
@Data
public class DispatchSizeLimit extends DispatchLimit {

    private Double length;
    private Double width;
    private Double height;

}
