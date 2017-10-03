package br.com.delivery.data;

import br.com.delivery.enummeration.DispatchLimitTypeEnum;
import br.com.entity.BaseStoreEntity;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

/**
 * Created by giovane.silva on 22/09/2017.
 */
@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "dispatchLimitType",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = DispatchSizeLimit.class, name = DispatchLimitTypeEnum.SIZE_VALUE),
        @JsonSubTypes.Type(value = DispatchWeightLimit.class, name = DispatchLimitTypeEnum.WEIGHT_VALUE),
        @JsonSubTypes.Type(value = DispatchQuantityLimit.class, name = DispatchLimitTypeEnum.QUANTITY_VALUE),
        @JsonSubTypes.Type(value = DispatchPriceLimit.class, name = DispatchLimitTypeEnum.PRICE_VALUE)
})
public abstract class DispatchLimit extends BaseStoreEntity{

    private String name;
    @NotNull
    private DispatchLimitTypeEnum dispatchLimitType;
}
