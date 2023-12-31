package com.santana.api.vehicle.service.impl;

import com.santana.api.vehicle.dto.VehicleDto;
import com.santana.api.vehicle.dto.impl.VehicleDtoImpl;
import com.santana.api.vehicle.exception.HeaderException;
import com.santana.api.vehicle.domain.Vehicle;
import com.santana.api.vehicle.data.VehicleRepository;
import com.santana.api.vehicle.exception.VehicleException;
import com.santana.api.vehicle.service.IVehicleService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class VehicleService implements IVehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Flux<VehicleDto> getVehiclesByUsername(String username) throws HeaderException {
        return vehicleRepository
                .findByUsernameAndEnabledTrue(username)
                .map(v -> new VehicleDtoImpl(v));
    }

    @Override
    public Mono<VehicleDto> getVehicleById(String username, String idVehicle) throws HeaderException {
        return vehicleRepository
                .findByIdVehicleAndUsernameAndEnabledTrue(new ObjectId(idVehicle), username)
                .map(v -> new VehicleDtoImpl(v));
    }

    @Override
    public Mono<VehicleDto> getVehicleByVinNumber(String username, String vinNumber) {
        return vehicleRepository
                .findByVinNumberAndUsernameAndEnabledTrue(vinNumber, username)
                .map(v -> new VehicleDtoImpl(v));
    }

    @Override
    public Mono<VehicleDto> newVehicle(String username, Vehicle vehicle) {
        if (null != vehicle.getIdVehicle()) {
            throw new VehicleException("Invalid Vehicle: ID should be empty to create a new Vehicle");
        }

        vehicle.setUsername(username);
        vehicle.setEnabled(true);
        vehicle.setCreatedAt(new Date());

        Mono<Vehicle> save = vehicleRepository.save(vehicle);

        return Mono.just(new VehicleDtoImpl(save.block()));
    }

}
