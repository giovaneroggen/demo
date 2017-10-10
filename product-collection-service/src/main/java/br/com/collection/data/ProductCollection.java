package br.com.collection.data;

import br.com.collection.enummeration.ProductCollectionTypeEnum;
import br.com.entity.BaseStoreEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

/**
 * Created by giovane.silva on 26/09/2017.
 */
@Data
public class ProductCollection extends BaseStoreEntity{

    private String name;
    private String slug;
    private List<Long> productIdList;
    @DBRef
    private List<ProductCollection> productCollectionList;
    private ProductCollectionTypeEnum productCollectionType;
}
