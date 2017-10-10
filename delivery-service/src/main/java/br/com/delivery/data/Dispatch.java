package br.com.delivery.data;

import br.com.delivery.enummeration.DispatchTypeEnum;
import br.com.entity.BaseStoreEntity;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by giovane.silva on 22/09/2017.
 */
@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "dispatchType",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = DriveThru.class, name = DispatchTypeEnum.DRIVE_THRU_VALUE),
        @JsonSubTypes.Type(value = Delivery.class, name = DispatchTypeEnum.DELIVERY_VALUE)
})
public abstract class Dispatch extends BaseStoreEntity{

    @NotEmpty
    private String name;
    @NotNull
    private DispatchTypeEnum dispatchType;
    private List<DispatchLimit> dispatchLimit;
    @NotEmpty
    private List<DispatchAvailability> dispatchAvailabilityList;
}
