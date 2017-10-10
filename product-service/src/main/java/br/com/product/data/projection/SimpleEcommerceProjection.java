package br.com.product.data.projection;

import br.com.product.data.Simple;
import org.springframework.data.rest.core.config.Projection;

/**
 * Created by giovane.silva on 05/10/2017.
 */
@Projection(name = "ecommerce", types = {Simple.class})
public interface SimpleEcommerceProjection extends ProductEcommerceProjection {
}
