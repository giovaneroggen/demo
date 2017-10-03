package br.com.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by giovane.silva on 15/09/2017.
 */
@SpringBootApplication(scanBasePackageClasses = {DeliveryApplication.class})
public class DeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeliveryApplication.class, args);
    }
}
