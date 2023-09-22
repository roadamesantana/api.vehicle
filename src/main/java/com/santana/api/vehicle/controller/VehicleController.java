package com.santana.api.vehicle.controller;

import com.santana.api.vehicle.dto.VehicleDto;
import com.santana.api.vehicle.exception.HeaderException;
import com.santana.api.vehicle.service.IVehicleService;
import com.santana.api.vehicle.util.HeaderUtil;
import com.santana.api.vehicle.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = {"/vehicle"}, produces = "application/json")
public class VehicleController {

    @Autowired
    private IVehicleService vehicleService;

    @Autowired
    private HeaderUtil headerUtil;

    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping()
    public Flux<VehicleDto> getVehicles(HttpServletRequest request) throws HeaderException {
        final String username = jwtUtil.getUsernameFromToken(headerUtil.getHeaderField("x-token", request));

        return vehicleService.getVehiclesByUsername(username);
    }

    @GetMapping("/{id}")
    public Mono<VehicleDto> getVehicle(HttpServletRequest request, @PathVariable(name = "id", required = true) String id) throws HeaderException {
        final String username = jwtUtil.getUsernameFromToken(headerUtil.getHeaderField("x-token", request));

        return vehicleService.getVehicleById(username, id);
    }

    @GetMapping("/vin_number/{vin_number}")
    public Mono<VehicleDto> getVehicleByVinNumber(HttpServletRequest request, @PathVariable(name = "vin_number", required = true) String vinNumber) throws HeaderException {
        final String username = jwtUtil.getUsernameFromToken(headerUtil.getHeaderField("x-token", request));

        return vehicleService.getVehicleByVinNumber(username, vinNumber);
    }
}
