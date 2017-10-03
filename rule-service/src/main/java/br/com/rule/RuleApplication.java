package br.com.rule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by giovane.silva on 15/09/2017.
 */
@SpringBootApplication(scanBasePackageClasses = {RuleApplication.class})
public class RuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RuleApplication.class, args);
    }
}
