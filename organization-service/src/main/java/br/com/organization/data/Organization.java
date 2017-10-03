package br.com.organization.data;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/**
 * Created by giovane.silva on 18/09/2017.
 */
@Data
public class Organization {

    @Id
    private String id;
    private String name;
    private LocalDateTime startDate;

}
