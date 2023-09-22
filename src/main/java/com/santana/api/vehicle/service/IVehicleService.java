package com.santana.api.vehicle.service;

import com.santana.api.vehicle.exception.HeaderException;
import com.santana.api.vehicle.domain.Vehicle;
import reactor.core.publisher.Flux;

public interface IVehicleService {
    Flux<Vehicle> getVehiclesByUsername(String userId) throws HeaderException;
}
