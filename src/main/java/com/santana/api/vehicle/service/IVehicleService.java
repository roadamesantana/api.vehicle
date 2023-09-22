package com.santana.api.vehicle.service;

import com.santana.api.vehicle.dto.VehicleDto;
import com.santana.api.vehicle.exception.HeaderException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IVehicleService {

    Flux<VehicleDto> getVehiclesByUsername(String username) throws HeaderException;

    Mono<VehicleDto> getVehicleById(String username, String id) throws HeaderException;

    Mono<VehicleDto> getVehicleByVinNumber(String username, String vinNumber);

}
