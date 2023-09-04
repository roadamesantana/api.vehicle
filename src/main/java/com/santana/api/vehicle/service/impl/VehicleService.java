package com.santana.api.vehicle.service.impl;

import com.santana.api.vehicle.exception.HeaderException;
import com.santana.api.vehicle.model.Vehicle;
import com.santana.api.vehicle.repository.VehicleRepository;
import com.santana.api.vehicle.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService implements IVehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> getVehicles(Integer userId) throws HeaderException {
        return vehicleRepository.findVehicleByUserIdUserAndIsDeleted(userId, "F");
    }
}
