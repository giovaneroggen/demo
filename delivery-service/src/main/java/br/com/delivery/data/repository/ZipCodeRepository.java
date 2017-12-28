package br.com.delivery.data.repository;

import br.com.delivery.data.ZipCode;
import br.com.entity.BaseOrganizationId;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by giovane.silva on 22/09/2017.
 */
@RepositoryRestResource(path = "/zipcodes")
public interface ZipCodeRepository extends PagingAndSortingRepository<ZipCode, BaseOrganizationId> {
}
