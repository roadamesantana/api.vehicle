package com.santana.api.vehicle.service.impl;

import com.santana.api.vehicle.exception.HeaderException;
import com.santana.api.vehicle.domain.Vehicle;
import com.santana.api.vehicle.data.VehicleRepository;
import com.santana.api.vehicle.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class VehicleService implements IVehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Flux<Vehicle> getVehiclesByUsername(String username) throws HeaderException {
        return vehicleRepository.findByUsernameAndEnabledTrue(username);
    }
}
