package br.com.product.data.projection;

import br.com.product.enummeration.ProductTypeEnum;

/**
 * Created by giovane.silva on 05/10/2017.
 */
public interface ProductEcommerceProjection {

    String getId();
    ProductTypeEnum getProductType();
    String getName();
    String getDescription();
    String getImagePath();
    String getBrand();
    String getProvider();
    Double getPrice();
    Boolean getStock();

    void setStock(Boolean stock);
    void setPrice(Double price);

}
