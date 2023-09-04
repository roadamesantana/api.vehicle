package com.santana.api.vehicle.controller;

import com.santana.api.vehicle.exception.HeaderException;
import com.santana.api.vehicle.service.IVehicleService;
import com.santana.api.vehicle.util.HeaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = {"/vehicles"})
public class VehicleController {

    @Autowired
    private IVehicleService vehicleService;

    @Autowired
    private HeaderUtil headerUtil;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity getVehicles(HttpServletRequest request) throws HeaderException {
        Integer loggedUserId = -1;

        try {
            loggedUserId = Integer.valueOf(headerUtil.getHeaderField("user_id", request));
        } catch (HeaderException exception) {
            throw exception;
        }

        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getVehicles(loggedUserId));
    }
}
