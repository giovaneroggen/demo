package br.com.product.data.processor;

import br.com.product.data.projection.KitEcommerceProjection;
import br.com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by giovane.silva on 05/10/2017.
 */
@Component
public class KitEcommerceProcessor implements ResourceProcessor<Resource<KitEcommerceProjection>> {

    @Autowired
    private ProductService productService;

    @Override
    public Resource<KitEcommerceProjection> process(Resource<KitEcommerceProjection> resource) {
        KitEcommerceProjection content = resource.getContent();
        content.setProducts(this.productService.findAllProductsByKitItemList(content.getKitItemList()));

        this.productService.processKit(content.getKitItemList(), (price, stock) -> {
            content.setPrice(price);
            content.setStock(stock);
        });

        return resource;
    }
}
