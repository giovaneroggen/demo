package br.com.product.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

/**
 * Created by giovane.silva on 27/09/2017.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Kit extends Product{

    @NotEmpty
    @Field(type = FieldType.Nested)
    private List<Product> productList;

}
