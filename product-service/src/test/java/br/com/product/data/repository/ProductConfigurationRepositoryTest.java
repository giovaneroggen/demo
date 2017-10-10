package br.com.product.data.repository;

import br.com.product.data.ElasticSearchSpringApplicationTest;
import br.com.product.data.Product;
import br.com.product.data.ProductConfiguration;
import br.com.product.data.Simple;
import br.com.product.enummeration.ProductTypeEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.mapping.DynamicIndexAndTypeContextHolder;


import static org.junit.Assert.*;

/**
 * Created by giovane.silva on 03/10/2017.
 */

public class ProductConfigurationRepositoryTest extends ElasticSearchSpringApplicationTest{


    @Autowired
    private ProductConfigurationRepository productConfigurationRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void test_product_configuration_register(){
        this.setIndexAndType("1", "2");

        Product product = new Simple();
        product.setProductType(ProductTypeEnum.SIMPLE);
        product.setName("LALAALA 1L");

        this.productRepository.save(product);

        ProductConfiguration configuration = ProductConfiguration.builder()
                .productId(product.getId())
                .name("teste 1")
                .price(20.0)
                .stock(12L)
                .build();

        this.productConfigurationRepository.save(configuration);


        ProductConfiguration one = this.productConfigurationRepository.findOne(configuration.getId());

        assertEquals(configuration.getId(), one.getId());
        assertEquals(configuration.getName(), one.getName());
        assertEquals(configuration.getPrice(), one.getPrice());
        assertEquals(configuration.getStock(), one.getStock());

        Product one1 = this.productRepository.findOne(product.getId());

        assertNotNull(one1.getProductType());
        assertEquals(product.getProductType(), one1.getProductType());
        assertEquals(product.getName(), one1.getName());
    }

    private void setIndexAndType(String index, String type) {
        DynamicIndexAndTypeContextHolder.getInstance().setIndexAndType(index, type);
    }
}