package br.com.feign.response.basket;

import br.com.feign.request.basket.BasketRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * Created by giovane.silva on 04/09/2017.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BasketResponse {

    private List<ProductResponse> productList;

    public static BasketResponse fromRequestMock(BasketRequest request) {
        return BasketResponse
                .builder()
                .productList(
                        request.getProductList().stream().map(p ->
                                ProductResponse.builder()
                                        .id(p.getId())
                                        .quantity(p.getQuantity())
                                        .name("PRODUCT "+ p.getId())
                                        .price(ThreadLocalRandom.current().nextDouble(0.1, 100))
                                        .build()
                        ).collect(Collectors.toList())
                ).build();
    }
}
