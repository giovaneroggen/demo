package br.com.basket.data;

import br.com.entity.BaseOrganizationEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by giovane.silva on 03/10/2017.
 */
@Data
@Document
public class Basket extends BaseOrganizationEntity {

    public List<String> coupons;
    public Double total;
    public Double subtotal;

    public Long customerId;
    public Long addressId;
    public Long dispatchAvailabilityId;

    @DBRef
    private List<Product> productList;
}
