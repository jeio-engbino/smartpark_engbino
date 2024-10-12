package org.smartparking;

import org.junit.jupiter.api.Test;
import org.smartparking.controller.ParkingLotController;
import org.smartparking.controller.VehicleController;
import org.smartparking.dto.ParkingLotDto;
import org.smartparking.dto.VehicleDto;
import org.smartparking.model.ParkingLot;
import org.smartparking.model.Vehicle;
import org.smartparking.service.ParkingLotService;
import org.smartparking.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class SmartParkingApplicationTest {
    @Autowired
    private ParkingLotController parkingLotController;

    @Autowired
    private VehicleController vehicleController;

    @Test
    public void testParkingLotController() throws Exception {
        ParkingLotDto parkingLotDto = ParkingLotDto.builder().lotId("M-1234").location("Mall").capacity(5).build();
        int addCode = parkingLotController.addParkingLot(parkingLotDto).getStatusCodeValue();
        Assert.isTrue(addCode == HttpStatus.OK.value(), "Add parking lot test failed!");
    }

    @Test
    public void testVehicleController() throws Exception {
        VehicleDto vehicleDto = VehicleDto.builder().plateId("ABC-1234").ownerName("Kurosh").vehicleType("Car").build();
        int addCode  = vehicleController.addVehicle(vehicleDto).getStatusCodeValue();
        Assert.isTrue(addCode == HttpStatus.OK.value(), "Add vehicle test failed!");







//        int statusCode  = vehicleController.getParkedVehicleList(VehicleDto.builder().plateId("ABC-1234").ownerName("Kurosh").vehicleType("Car").build()).getStatusCode().value();
    }
}
