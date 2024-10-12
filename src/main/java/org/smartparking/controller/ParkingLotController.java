package org.smartparking.controller;

import org.smartparking.dto.ParkingLotDto;
import org.smartparking.service.ParkingLotService;
import org.smartparking.validation.AddGroup;
import org.smartparking.validation.QueryGroup;
import org.smartparking.vo.ResponseVo;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/parkingLot")
public class ParkingLotController {

    @Resource
    ParkingLotService parkingLotService;

    /**
     * Register a parking lot.
     * @param parkingLotDto
     */
    @PostMapping(value = "/v1/addParkingLot")
    public ResponseEntity<Object> addParkingLot(@RequestBody @Validated(AddGroup.class) ParkingLotDto parkingLotDto) {
        parkingLotService.addParkingLot(parkingLotDto);
        return ResponseVo.success();
    }

    /**
     * View current occupancy and availability of a parking lot.
     * @param parkingLotDto
     */
    @GetMapping(value = "/v1/getParkingLotList")
    public ResponseEntity<Object> getParkingLotList(@RequestBody @Validated(QueryGroup.class) ParkingLotDto parkingLotDto) {
        return ResponseVo.success(parkingLotService.getParkingLotList(parkingLotDto));
    }
}
