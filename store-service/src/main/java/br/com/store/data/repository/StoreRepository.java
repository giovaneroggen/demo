package br.com.store.data.repository;

import br.com.entity.BaseOrganizationId;
import br.com.store.data.Store;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by giovane.silva on 03/10/2017.
 */
@RepositoryRestResource(path = "/stores")
public interface StoreRepository extends PagingAndSortingRepository<Store, BaseOrganizationId>{
}
