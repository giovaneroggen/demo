package br.com.product.data;

import br.com.product.enummeration.ProductTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.repository.support.DynamicIndex;

import java.util.Optional;

/**
 * Created by giovane.silva on 15/09/2017.
 */
@Data
@DynamicIndex
@Document(indexName = "product", type = "product", createIndex = false)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "productType",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Kit.class, name = ProductTypeEnum.KIT_VALUE),
        @JsonSubTypes.Type(value = Simple.class, name = ProductTypeEnum.SIMPLE_VALUE)
})
public abstract class Product{

    @Id
    private String id;
    private ProductTypeEnum productType;
    private String name;
    private String description;
    private String imagePath;
    private String brand;
    private String provider;
    private Double price;

}
