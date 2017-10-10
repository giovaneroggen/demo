package br.com.product.data;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by giovane.silva on 05/10/2017.
 */
@Data
public class KitItem {

    @NotEmpty
    private String productId;
    @Size(min = 1)
    private Long quantity;
}
