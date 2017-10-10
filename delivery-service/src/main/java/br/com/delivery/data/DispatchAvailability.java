package br.com.delivery.data;

import br.com.entity.BaseStoreEntity;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by giovane.silva on 22/09/2017.
 */
@Data
public class DispatchAvailability extends BaseStoreEntity{

    @NotNull
    private Time availabilityStartTime;
    @NotNull
    private Time availabilityEndTime;
    private Double price;
    private List<DispatchLimit> dispatchLimit;
    private Boolean active;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
