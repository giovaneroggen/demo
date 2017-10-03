package br.com.organization.data.repository;

import br.com.organization.data.Organization;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by giovane.silva on 22/09/2017.
 */
@RepositoryRestResource(path = "/organizations")
public interface OrganizationRepository extends PagingAndSortingRepository<Organization, String>{
}
