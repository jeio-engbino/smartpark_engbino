package org.smartparking.service;

import org.smartparking.dto.ParkingLotDto;
import org.smartparking.model.ParkingLot;

import java.util.List;

public interface ParkingLotService {
    void addParkingLot(ParkingLotDto parkingLotDto);

    List<ParkingLot> getParkingLotList(ParkingLotDto parkingLotDto);
}
