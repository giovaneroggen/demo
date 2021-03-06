package br.com.delivery.data.repository;

import br.com.delivery.data.Dispatch;
import br.com.delivery.data.DispatchAvailability;
import br.com.entity.BaseStoreId;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by giovane.silva on 22/09/2017.
 */
@RepositoryRestResource(path = "/dispatches")
public interface DispatchRepository extends PagingAndSortingRepository<Dispatch, BaseStoreId> {
}
