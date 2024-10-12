package org.smartparking.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.smartparking.dto.VehicleDto;
import org.smartparking.model.Vehicle;

import java.util.List;

@Mapper
public interface VehicleMapper {

    Vehicle getVehicleByPlate(@Param("plateId") String plateId);

    void insertVehicle(VehicleDto vehicleDto);

    String getLotIdByVehicle(VehicleDto vehicleDto);

    int updateVehicle(@Param("plateId") String plateId, @Param("parkingLotId") String parkingLotId);

    List<Vehicle> queryParkedVehicleList(VehicleDto vehicleDto);
}
