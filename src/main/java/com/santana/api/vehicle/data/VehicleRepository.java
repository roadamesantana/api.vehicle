package com.santana.api.vehicle.data;

import com.santana.api.vehicle.domain.Vehicle;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface VehicleRepository extends ReactiveCrudRepository<Vehicle, String> {
    Flux<Vehicle> findByUsernameAndEnabledTrue(String userId);

}
