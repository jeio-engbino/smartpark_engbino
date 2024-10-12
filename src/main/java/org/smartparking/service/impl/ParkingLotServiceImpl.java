package org.smartparking.service.impl;

import org.smartparking.dto.ParkingLotDto;
import org.smartparking.mapper.ParkingLotMapper;
import org.smartparking.model.ParkingLot;
import org.smartparking.service.ParkingLotService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {

    @Resource
    ParkingLotMapper parkingLotMapper;

    @Override
    public void addParkingLot(ParkingLotDto parkingLotDto) {
        int lotIdUsageCount = parkingLotMapper.checkLotId(parkingLotDto.getLotId());
        Assert.isTrue(0 == lotIdUsageCount, "Lot ID already exists.");

        parkingLotMapper.insertParkingLot(parkingLotDto);
    }

    @Override
    public List<ParkingLot> getParkingLotList(ParkingLotDto parkingLotDto) {
        return parkingLotMapper.queryParkingLotList(parkingLotDto);
    }
}
