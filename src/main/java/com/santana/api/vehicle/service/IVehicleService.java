package com.santana.api.vehicle.service;

import com.santana.api.vehicle.model.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<Vehicle> getVehicles(Integer userId);
}
