package br.com.customer.data;

import br.com.customer.enummeration.CustomerTypeEnum;
import br.com.entity.BaseOrganizationEntity;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by giovane.silva on 26/09/2017.
 */
@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "customerType",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CustomerPhysical.class, name = CustomerTypeEnum.PHYSICAL_VALUE),
        @JsonSubTypes.Type(value = CustomerLegal.class, name = CustomerTypeEnum.LEGAL_VALUE)
})
public abstract class Customer extends BaseOrganizationEntity{

    @NotNull
    private CustomerTypeEnum customerType;
    @DBRef
    private List<Address> addressList;
    @Email
    private String email;
    private String password;

}
