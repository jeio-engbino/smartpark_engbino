package org.smartparking.service.impl;

import com.github.pagehelper.util.StringUtil;
import org.smartparking.dto.VehicleDto;
import org.smartparking.mapper.ParkingLotMapper;
import org.smartparking.mapper.VehicleMapper;
import org.smartparking.model.ParkingLot;
import org.smartparking.model.Vehicle;
import org.smartparking.service.VehicleService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Resource
    VehicleMapper vehicleMapper;

    @Resource
    ParkingLotMapper parkingLotMapper;

    @Override
    public void addVehicle(VehicleDto vehicleDto) {
        Vehicle existingVehicle = vehicleMapper.getVehicleByPlate(vehicleDto.getPlateId());
        Assert.isNull(existingVehicle, "Vehicle already exists!");
        vehicleMapper.insertVehicle(vehicleDto);
    }

    @Override
    public void checkInOutVehicle(VehicleDto vehicleDto) {
        String parkingLotId;
        boolean checkInFlag = true;

        Vehicle checkExist = vehicleMapper.getVehicleByPlate(vehicleDto.getPlateId());
        Assert.notNull(checkExist, "Vehicle information does not exists, please perform registration to proceed!");

        if (Integer.valueOf(0).equals(vehicleDto.getOperateType())) {
            parkingLotId = vehicleMapper.getLotIdByVehicle(vehicleDto);
            Assert.isTrue(StringUtil.isEmpty(parkingLotId), String.format("Check-in failed. The vehicle is already in the parking lot %s!", parkingLotId));

            ParkingLot lotInfo = parkingLotMapper.getCapacityCount(vehicleDto.getLotId());
            Assert.notNull(lotInfo, "Parking lot doesn't exist. Please check the Lot ID.");

            boolean isFull = lotInfo.getCapacity().equals(lotInfo.getOccupied());
            Assert.isTrue(!isFull, "Parking lot is full.");

            parkingLotId = vehicleDto.getLotId();
        } else {
            parkingLotId = vehicleMapper.getLotIdByVehicle(vehicleDto);
            Assert.isTrue(StringUtil.isNotEmpty(parkingLotId), "Check-out failed, no check-in information found!");

            vehicleDto.setLotId(parkingLotId);
            parkingLotId = "";
            checkInFlag = false;
        }

        int updateSuccess = vehicleMapper.updateVehicle(vehicleDto.getPlateId(), parkingLotId);
        if (updateSuccess > 0) {
            ParkingLot parkingLot = parkingLotMapper.getLotInfoById(vehicleDto.getLotId());
            int occupiedCount = checkInFlag ? parkingLot.getOccupied() + 1 : parkingLot.getOccupied() - 1;
            parkingLotMapper.updateOccupiedCount(vehicleDto.getLotId(), occupiedCount);
        }
    }

    @Override
    public List<Vehicle> getParkedVehicleList(VehicleDto vehicleDto) {
        return vehicleMapper.queryParkedVehicleList(vehicleDto);
    }
}
