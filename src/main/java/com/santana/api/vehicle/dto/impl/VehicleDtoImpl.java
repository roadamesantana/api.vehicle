package com.santana.api.vehicle.dto.impl;

import com.santana.api.vehicle.domain.Vehicle;
import com.santana.api.vehicle.dto.VehicleDto;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.bson.types.ObjectId;

@Getter
public class VehicleDtoImpl implements VehicleDto {

    private ObjectId idVehicle;

    private String vinNumber;

    private String plate;

    private String brand;

    private String model;

    private Integer year;

    private String color;

    public VehicleDtoImpl(Vehicle vehicle) {
        this.idVehicle = vehicle.getIdVehicle();
        this.vinNumber = vehicle.getVinNumber();
        this.plate = vehicle.getPlate();
        this.brand = vehicle.getBrand();
        this.model = vehicle.getModel();
        this.year = vehicle.getYear();
        this.color = vehicle.getColor();
    }

    @Override
    public String getIdVehicle() {
        return idVehicle.toHexString();
    }

}
