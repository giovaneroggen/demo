package br.com.product.data.repository;

import br.com.product.data.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by giovane.silva on 15/09/2017.
 */
@RepositoryRestResource(path = "/products")
public interface ProductRepository extends ElasticsearchRepository<Product, Long> {
}
