package br.com.recurrency.data;

import br.com.entity.BaseOrganizationEntity;
import br.com.recurrency.enummeration.RecurrencyStatusEnum;
import br.com.recurrency.enummeration.RecurrencyTypeEnum;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by giovane.silva on 03/10/2017.
 */
@Data
public class Recurrency extends BaseOrganizationEntity{

    @NotNull
    private Long basketId;
    @NotNull
    private RecurrencyTypeEnum recurrencyType;
    @NotNull
    private RecurrencyStatusEnum recurrencyStatus;

}
