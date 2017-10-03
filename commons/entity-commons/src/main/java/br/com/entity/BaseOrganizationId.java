package br.com.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by giovane.silva on 26/09/2017.
 */
@Data
public class BaseOrganizationId implements Serializable {
    protected String id;
    protected String organizationId;
}
