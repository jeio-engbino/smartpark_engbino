package org.smartparking.model;

import lombok.Data;

@Data
public class Vehicle extends BaseModel{

    /**
     * License Plate
     */
    private String plateId;

    /**
     * Owner Name
     */
    private String ownerName;

    /**
     * Type (Car, Motorcycle, Truck)
     */
    private String vehicleType;

    /**
     * Lot ID
     */
    private String lotId;

}
