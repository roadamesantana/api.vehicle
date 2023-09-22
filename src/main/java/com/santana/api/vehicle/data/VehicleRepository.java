package com.santana.api.vehicle.data;

import com.santana.api.vehicle.domain.Vehicle;
import com.santana.api.vehicle.dto.VehicleDto;
import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VehicleRepository extends ReactiveCrudRepository<Vehicle, String> {

    Flux<Vehicle> findByUsernameAndEnabledTrue(String userId);

    Mono<Vehicle> findByIdVehicleAndUsernameAndEnabledTrue(ObjectId idVehicle, String username);

    Mono<Vehicle> findByVinNumberAndUsernameAndEnabledTrue(String vinNumber, String username);

}
