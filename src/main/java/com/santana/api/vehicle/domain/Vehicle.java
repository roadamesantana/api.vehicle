package com.santana.api.vehicle.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Vehicle {

    @Id
    @Field("_id")
    private String idVehicle;

    private String username;

    private String vinNumber;

    private String plate;

    private String brand;

    private String model;

    private Integer year;

    private String color;

    private boolean enabled;

    private Time createdAt;

    private Time updatedAt;

    private Time deletedAt;

}
