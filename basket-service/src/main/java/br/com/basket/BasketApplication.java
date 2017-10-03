package br.com.basket;

import br.com.basket.messaging.queues.ProcessBasketQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * Created by giovane.silva on 01/09/2017.
 */
@EnableBinding({ProcessBasketQueue.class})
@SpringBootApplication(scanBasePackageClasses = {BasketApplication.class})
public class BasketApplication{

    public static void main(String[] args) {
        SpringApplication.run(BasketApplication.class, args);
    }
}
