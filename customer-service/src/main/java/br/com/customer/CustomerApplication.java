package br.com.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by giovane.silva on 15/09/2017.
 */
@SpringBootApplication(scanBasePackageClasses = {CustomerApplication.class})
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

}
