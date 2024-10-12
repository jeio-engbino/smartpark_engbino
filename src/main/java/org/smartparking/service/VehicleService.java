package org.smartparking.service;

import org.smartparking.dto.VehicleDto;
import org.smartparking.model.Vehicle;

import java.util.List;

public interface VehicleService {
    void addVehicle(VehicleDto vehicleDto);

    void checkInOutVehicle(VehicleDto vehicleDto);

    List<Vehicle> getParkedVehicleList(VehicleDto vehicleDto);
}
