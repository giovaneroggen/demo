package br.com.product.config;

import br.com.product.data.Kit;
import br.com.product.data.Simple;
import br.com.product.data.projection.KitEcommerceProjection;
import br.com.product.data.projection.SimpleEcommerceProjection;
import br.com.runnable.config.CustomRepositoryRestConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

/**
 * Created by giovane.silva on 05/10/2017.
 */
@Configuration
public class ProductCustomRepositoryRestConfiguration extends CustomRepositoryRestConfiguration {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.getProjectionConfiguration()
                .addProjection(SimpleEcommerceProjection.class, "simple", Simple.class)
                .addProjection(KitEcommerceProjection.class, "kit", Kit.class);
    }
}
