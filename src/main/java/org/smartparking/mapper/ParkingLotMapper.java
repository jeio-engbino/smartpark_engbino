package org.smartparking.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.smartparking.dto.ParkingLotDto;
import org.smartparking.model.ParkingLot;

import java.util.List;

@Mapper
public interface ParkingLotMapper {

    int checkLocation(@Param("location") String location);

    int checkLotId(@Param("lotId") String lotId);

    int insertParkingLot(ParkingLotDto parkingLotDto);

    ParkingLot getCapacityCount(@Param("lotId") String lotId);

    void updateOccupiedCount(@Param("lotId") String lotId, @Param("occupiedCount") int occupiedCount);

    ParkingLot getLotInfoById(@Param("lotId") String lotId);

    List<ParkingLot> queryParkingLotList(ParkingLotDto parkingLotDto);
}
