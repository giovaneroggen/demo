package br.com.feign.client;

import br.com.feign.request.basket.BasketRequest;
import br.com.feign.response.basket.BasketResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by giovane.silva on 04/09/2017.
 */
@FeignClient("basket-service")
public interface BasketClient {

    @PostMapping("/process")
    public BasketResponse processBasket(BasketRequest request);
}
