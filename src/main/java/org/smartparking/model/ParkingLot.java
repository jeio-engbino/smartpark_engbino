package org.smartparking.model;

import lombok.Data;

@Data
public class ParkingLot extends BaseModel{

    /**
     * Lot ID
     */
    private String lotId;

    /**
     * Location
     */
    private String location;

    /**
     * Capacity (Total number of parking spaces)
     */
    private Integer capacity;

    /**
     * Capacity (Number of currently occupied spaces)
     */
    private Integer occupied;
}
