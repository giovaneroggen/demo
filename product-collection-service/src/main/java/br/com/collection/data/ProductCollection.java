package br.com.collection.data;

import br.com.collection.enummeration.ProductCollectionTypeEnum;
import br.com.entity.BaseStoreEntity;
import lombok.Data;

import java.util.List;
import java.util.Optional;

/**
 * Created by giovane.silva on 26/09/2017.
 */
@Data
public class ProductCollection extends BaseStoreEntity{

    private String name;
    private String slug;
    private List<Long> productIdList;
    private Optional<List<ProductCollection>> productCollectionList;
    private ProductCollectionTypeEnum productCollectionType;
}
