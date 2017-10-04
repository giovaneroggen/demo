package br.com.product.data.repository;

import br.com.product.data.ElasticSearchSpringApplicationTest;
import br.com.product.data.ProductConfiguration;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.mapping.DynamicIndexAndTypeContextHolder;

import java.util.OptionalDouble;
import java.util.OptionalLong;

import static org.junit.Assert.*;

/**
 * Created by giovane.silva on 03/10/2017.
 */

public class ProductConfigurationRepositoryTest extends ElasticSearchSpringApplicationTest{


    @Autowired
    private ProductConfigurationRepository productConfigurationRepository;

    @Test
    public void test_product_configuration_register(){
        this.setIndexAndType("1", "2");
        this.productConfigurationRepository.save(
            ProductConfiguration.builder()
                    .id(1L)
                    .name("teste 1")
                    .price(OptionalDouble.of(20.0))
                    .stock(OptionalLong.of(12L))
                    .build()
        );
    }

    private void setIndexAndType(String index, String type) {
        DynamicIndexAndTypeContextHolder.getInstance().setIndexAndType(index, type);
    }


}