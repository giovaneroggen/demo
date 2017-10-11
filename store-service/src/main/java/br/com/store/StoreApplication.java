package br.com.store;

import br.com.runnable.DemoAbstractApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by giovane.silva on 15/09/2017.
 */
@SpringBootApplication(scanBasePackageClasses = {StoreApplication.class})
@EnableMongoRepositories(basePackages = {"br.com.store.data.repository"})
public class StoreApplication extends DemoAbstractApplication{

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }
}
