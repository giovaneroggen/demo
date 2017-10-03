package br.com.basket.data.repository;

import br.com.basket.data.Basket;
import br.com.entity.BaseOrganizationId;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by giovane.silva on 03/10/2017.
 */
@RepositoryRestResource(path = "/baskets")
public interface BasketRepository extends PagingAndSortingRepository<Basket, BaseOrganizationId> {
}
