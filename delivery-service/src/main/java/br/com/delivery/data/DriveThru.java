package br.com.delivery.data;

import lombok.Data;

import java.util.OptionalDouble;

/**
 * Created by giovane.silva on 22/09/2017.
 */
@Data
public class DriveThru extends Dispatch {

    private OptionalDouble defaultPrice;

}
