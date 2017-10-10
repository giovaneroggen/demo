package br.com.product.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

/**
 * Created by giovane.silva on 27/09/2017.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Kit extends Product{

    @NotEmpty
    private List<KitItem> kitItemList;

}
