package br.com.basket.data;

import br.com.entity.BaseOrganizationEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by giovane.silva on 03/10/2017.
 */
@Data
@Document
public class Product extends BaseOrganizationEntity{

    private Long productId;
    private Long quantity;

    private Double unitPrice;
    private Double unitPricePromotion;

}
