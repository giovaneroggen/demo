package br.com.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * Created by giovane.silva on 26/09/2017.
 */
@Data
public class BaseOrganizationEntity {

    @Id
    private BaseOrganizationId id;
}
