package org.smartparking.dto;

import lombok.Builder;
import lombok.Data;
import org.smartparking.validation.AddGroup;
import org.smartparking.validation.CheckInGroup;
import org.smartparking.validation.CheckOutGroup;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
public class VehicleDto {

    /**
     * License Plate (Unique identifier, allowed only letters, numbers, and dashes)
     */
    @Size(max = 20, message = "License plate too long (20 characters max only)", groups = AddGroup.class)
    @NotBlank(message = "License plate cannot be empty!", groups = {AddGroup.class, CheckInGroup.class, CheckOutGroup.class})
    @Pattern(regexp = "^(\\w|(?<=\\w)-(?=\\w))+$", message = "Invalid license plate. Allowed characters are letters, numbers, and dashes only.", groups = AddGroup.class)
    private String plateId;

    /**
     * Owner Name (Letters and spaces only)
     */
    @Size(max = 50, message = "Owner name too long (50 characters max only)", groups = AddGroup.class)
    @NotBlank(message = "Owner name cannot be empty!", groups = AddGroup.class)
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "Invalid owner name!", groups = AddGroup.class)
    private String ownerName;

    /**
     * Type (Car, Motorcycle, Truck)
     */
    @NotNull(message = "Vehicle type cannot be empty!", groups = AddGroup.class)
    private String vehicleType;

    /**
     * Checking in a vehicle to a parking lot
     * Checking out a vehicle from a parking lot
     * 0:check in, 1:check out
     */
    private Integer operateType;

    /**
     * Lot ID (Unique identifier, 50 characters max)
     */
    @NotBlank(message = "Please select a parking lot!", groups = CheckInGroup.class)
    private String lotId;

}
