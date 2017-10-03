package br.com.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Created by giovane.silva on 26/09/2017.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseStoreId extends BaseOrganizationId implements Serializable {

    protected Long storeId;
}
