package org.smartparking.controller;

import org.smartparking.dto.VehicleDto;
import org.smartparking.service.VehicleService;
import org.smartparking.validation.AddGroup;
import org.smartparking.validation.CheckInGroup;
import org.smartparking.validation.CheckOutGroup;
import org.smartparking.validation.QueryGroup;
import org.smartparking.vo.ResponseVo;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Resource
    VehicleService vehicleService;

    /**
     * Register a vehicle.
     * @param vehicleDto
     */
    @PostMapping(value = "/v1/addVehicle")
    public ResponseEntity<Object> addVehicle(@RequestBody @Validated(AddGroup.class) VehicleDto vehicleDto) {
        vehicleService.addVehicle(vehicleDto);
        return ResponseVo.success();
    }

    /**
     * Check-in a vehicle to a parking lot.
     * @param vehicleDto
     */
    @PostMapping(value = "/v1/checkInVehicle")
    public ResponseEntity<Object> checkInVehicle(@RequestBody @Validated(CheckInGroup.class) VehicleDto vehicleDto) {
        vehicleDto.setOperateType(0);
        vehicleService.checkInOutVehicle(vehicleDto);
        return ResponseVo.success();
    }

    /**
     * Check-in a vehicle from a parking lot.
     * @param vehicleDto
     */
    @PostMapping(value = "/v1/checkOutVehicle")
    public ResponseEntity<Object> checkOutVehicle(@RequestBody @Validated(CheckOutGroup.class) VehicleDto vehicleDto) {
        vehicleDto.setOperateType(1);
        vehicleService.checkInOutVehicle(vehicleDto);
        return ResponseVo.success();
    }

    /**
     * View all vehicles currently parked in a lot.
     * @param vehicleDto
     */
    @GetMapping(value = "/v1/getParkedVehicleList")
    public ResponseEntity<Object> getParkedVehicleList(@RequestBody @Validated(QueryGroup.class) VehicleDto vehicleDto) {
        return ResponseVo.success(vehicleService.getParkedVehicleList(vehicleDto));
    }
}
