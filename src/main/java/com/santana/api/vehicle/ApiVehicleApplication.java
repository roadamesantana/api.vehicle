package com.santana.api.vehicle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.santana.api.vehicle"})
public class ApiVehicleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiVehicleApplication.class, args);
	}

}
