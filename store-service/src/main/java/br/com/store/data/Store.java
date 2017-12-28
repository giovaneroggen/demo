package br.com.store.data;

import br.com.entity.BaseOrganizationEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Created by giovane.silva on 03/10/2017.
 */
@Data
@Document
public class Store extends BaseOrganizationEntity{

    private String name;
    private LocalDateTime startDate;
}
