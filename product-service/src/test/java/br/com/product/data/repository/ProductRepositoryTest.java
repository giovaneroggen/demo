package br.com.product.data.repository;

import br.com.product.data.Product;
import br.com.product.data.Simple;
import br.com.tests.SpringApplicationTests;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Created by giovane.silva on 05/10/2017.
 */
public class ProductRepositoryTest extends SpringApplicationTests {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void test_save_simple_product() throws IOException {


        String s = new StringBuilder()
                .append(" { ")
                .append("    \"name\": \"TESTE\",")
                .append("    \"price\": 10.0,")
                .append("    \"productType\": \"simple\" ")
                .append(" }").toString();


        Product p = this.objectMapper.readValue(s, Product.class);

        this.objectMapper.writeValueAsString(p);


        this.productRepository.save(p);


        Product one = this.productRepository.findOne(p.getId());

        assertTrue(one instanceof Simple);
    }



}