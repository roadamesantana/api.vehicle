package com.santana.api.vehicle.repository;

import com.santana.api.vehicle.model.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {
    List<Vehicle> findVehicleByUserIdUserAndIsDeleted(Integer userId, String isDeleted);
}
