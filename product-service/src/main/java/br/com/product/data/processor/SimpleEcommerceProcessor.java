package br.com.product.data.processor;

import br.com.product.data.projection.SimpleEcommerceProjection;
import br.com.product.service.ProductConfigurationService;
import br.com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.BiConsumer;

/**
 * Created by giovane.silva on 05/10/2017.
 */
@Component
public class SimpleEcommerceProcessor implements ResourceProcessor<Resource<SimpleEcommerceProjection>> {

    @Autowired
    private ProductService productService;

    @Override
    public Resource<SimpleEcommerceProjection> process(Resource<SimpleEcommerceProjection> resource) {

        SimpleEcommerceProjection content = resource.getContent();

        this.productService
                .processSimple(content.getId(), content.getPrice(),
                               Optional.empty(), (price, stock) -> {
                                    content.setPrice(price);
                                    content.setStock(stock);
                               });
        return resource;
    }
}
