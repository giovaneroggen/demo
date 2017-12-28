package br.com.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by giovane.silva on 26/09/2017.
 */
@Data
public class BaseOrganizationId implements Serializable {
    @NotEmpty
    protected String id;
    @NotEmpty
    protected String organizationId;

    public BaseOrganizationId(String organizationId) {
        this.organizationId = organizationId;
        this.id = UUID.randomUUID().toString();
    }
}
