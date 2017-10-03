package br.com.product;

import br.com.product.exception.ElasticSearchExceptionHandler;
import br.com.product.interceptor.ElasticSearchInterceptor;
import br.com.runnable.DemoAbstractApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * Created by giovane.silva on 04/09/2017.
 */
@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = {"br.com.product.data.repository"})
public class ProductApplication extends DemoAbstractApplication{

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

    @Bean
    @ConditionalOnMissingBean
    public ElasticSearchExceptionHandler elasticSearchExceptionHandler(){
        return new ElasticSearchExceptionHandler();
    }

    @Bean
    @ConditionalOnMissingBean
    public ElasticSearchInterceptor elasticSearchInterceptor(){
        return new ElasticSearchInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.elasticSearchInterceptor());
    }
}
