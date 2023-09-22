package com.santana.api.vehicle.controller;

import com.santana.api.vehicle.domain.Vehicle;
import com.santana.api.vehicle.exception.HeaderException;
import com.santana.api.vehicle.service.IVehicleService;
import com.santana.api.vehicle.util.HeaderUtil;
import com.santana.api.vehicle.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = {"/vehicle"})
public class VehicleController {

    @Autowired
    private IVehicleService vehicleService;

    @Autowired
    private HeaderUtil headerUtil;

    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping(produces = "application/json")
    public Flux<Vehicle> getVehicles(HttpServletRequest request) throws HeaderException {
        final String loggedUserId = jwtUtil.getUsernameFromToken(headerUtil.getHeaderField("x-token", request));

        return vehicleService.getVehiclesByUsername(loggedUserId);
    }
}
