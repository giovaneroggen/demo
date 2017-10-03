package br.com.feign.client;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by giovane.silva on 04/09/2017.
 */
@FeignClient("checkout-service")
public interface CheckoutClient {
}
