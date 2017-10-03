package br.com.basket.data;

import br.com.entity.BaseOrganizationEntity;
import lombok.Data;

/**
 * Created by giovane.silva on 03/10/2017.
 */
@Data
public class Product extends BaseOrganizationEntity{

    private Long productId;
    private Long quantity;

    private Double unitPrice;
    private Double unitPricePromotion;

}
