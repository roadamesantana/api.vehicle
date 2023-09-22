package com.santana.api.vehicle.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Vehicle {

    @Id
    @Field("_id")
    private ObjectId idVehicle;

    private String username;

    @Field("vin_number")
    private String vinNumber;

    private String plate;

    private String brand;

    private String model;

    private Integer year;

    private String color;

    private boolean enabled;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

}
