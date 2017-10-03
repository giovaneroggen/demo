package br.com.feign.request.basket;

import br.com.feign.request.basket.validation.ValidProductRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * Created by giovane.silva on 04/09/2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ValidProductRequest
public class ProductRequest {

    @NotNull
    private Long id;
    @NotNull
    private Long quantity;
}
