package br.com.customer.data;

import org.hibernate.validator.constraints.br.CNPJ;

/**
 * Created by giovane.silva on 26/09/2017.
 */
public class CustomerLegal extends Customer {

    @CNPJ
    private String cnpj;
}
