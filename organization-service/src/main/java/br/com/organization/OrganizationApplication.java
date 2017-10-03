package br.com.organization;

import br.com.runnable.DemoAbstractApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by giovane.silva on 15/09/2017.
 */
@SpringBootApplication(scanBasePackageClasses = {OrganizationApplication.class})
public class OrganizationApplication extends DemoAbstractApplication{

    public static void main(String[] args) {
        SpringApplication.run(OrganizationApplication.class, args);
    }
}
