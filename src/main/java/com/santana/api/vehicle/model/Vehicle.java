package com.santana.api.vehicle.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Vehicle {

    @Id
    private Integer idVehicle;

    @ManyToOne
    private User user;

    private String vinNumber;

    private String brand;

    private String model;

    private Integer year;

    private String color;

    private String isDeleted;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;
}
