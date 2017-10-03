package br.com.recurrency.data;

import br.com.runnable.web.exception.GenericProcessException;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Created by giovane.silva on 03/10/2017.
 */
@Data
public class RecurrencyHistory {

    @DBRef
    public Recurrency recurrency;
    public Optional<GenericProcessException> errorOcurred;
    public LocalDateTime dateCreated;

}
