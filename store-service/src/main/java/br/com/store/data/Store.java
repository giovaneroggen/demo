package br.com.store.data;

import br.com.entity.BaseOrganizationEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/**
 * Created by giovane.silva on 03/10/2017.
 */
@Data
public class Store {

    @Id
    private String id;
    private String name;
    private LocalDateTime startDate;
}
