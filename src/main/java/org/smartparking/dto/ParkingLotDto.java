package org.smartparking.dto;

import lombok.Builder;
import lombok.Data;
import org.smartparking.validation.AddGroup;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class ParkingLotDto {

    /**
     * Lot ID (Unique identifier, 50 characters max)
     */
    @Size(max = 50, message = "Lot ID too long (50 characters max).", groups = AddGroup.class)
    @NotBlank(message = "Lot ID cannot be empty.", groups = AddGroup.class)
    private String lotId;

    /**
     * Location
     */
    @Size(max = 100, message = "Location too long (100 characters max).", groups = AddGroup.class)
    @NotBlank(message = "Location cannot be empty!", groups = AddGroup.class)
    private String location;

    /**
     * Capacity (Total number of parking spaces)
     */
    @NotNull(message = "Capacity cannot be empty!", groups = AddGroup.class)
    private Integer capacity;

    /**
     * Capacity state of a parking lot
     * FALSE:avail, TRUE:full
     */
    private Boolean isFull;
}
