package br.com.customer.data;

import br.com.entity.BaseOrganizationEntity;
import lombok.Data;

/**
 * Created by giovane.silva on 26/09/2017.
 */
@Data
public class Address extends BaseOrganizationEntity{

    public String name;
    public String country;
    public String state;
    public String neighborhood;
    public String street;
    public Integer number;
    public String complement;
}
