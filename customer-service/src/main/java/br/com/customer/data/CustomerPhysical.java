package br.com.customer.data;

import org.hibernate.validator.constraints.br.CPF;

/**
 * Created by giovane.silva on 26/09/2017.
 */
public class CustomerPhysical extends Customer {

    @CPF
    private String cpf;
}
