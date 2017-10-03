package br.com.feign.request.basket;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by giovane.silva on 04/09/2017.
 */
@Data
public class BasketRequest{

    @Valid
    @NotNull
    @NotEmpty
    private List<ProductRequest> productList;
}
