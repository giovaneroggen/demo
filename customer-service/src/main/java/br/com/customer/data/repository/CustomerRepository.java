package br.com.customer.data.repository;

import br.com.customer.data.Customer;
import br.com.entity.BaseOrganizationId;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by giovane.silva on 26/09/2017.
 */
@RepositoryRestResource(path = "/customers")
public interface CustomerRepository extends PagingAndSortingRepository<Customer, BaseOrganizationId> {
}
