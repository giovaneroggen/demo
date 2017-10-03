package br.com.delivery.data;

import br.com.entity.BaseOrganizationEntity;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by giovane.silva on 26/09/2017.
 */
@Data
public class ZipCode extends BaseOrganizationEntity{

    @NotNull
    private String city;
    private String district;
    @NotNull
    private String state;
    private String street;
    private String type;
    private String cep;
    private Boolean locale;
}
