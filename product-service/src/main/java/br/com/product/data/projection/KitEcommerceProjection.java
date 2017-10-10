package br.com.product.data.projection;

import br.com.product.data.Kit;
import br.com.product.data.KitItem;
import br.com.product.data.Product;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

/**
 * Created by giovane.silva on 05/10/2017.
 */
@Projection(name = "ecommerce", types = {Kit.class})
public interface KitEcommerceProjection extends ProductEcommerceProjection {

    List<KitItem> getKitItemList();

    List<Product> getProducts();
    void setProducts(List<Product> products);

}
