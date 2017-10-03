package br.com.collection.data.repository;

import br.com.collection.data.ProductCollection;
import br.com.entity.BaseStoreId;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by giovane.silva on 26/09/2017.
 */
@RepositoryRestResource(path = "/products/collections")
public interface ProductCollectionRepository extends PagingAndSortingRepository<ProductCollection, BaseStoreId> {
}
