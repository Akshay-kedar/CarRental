package com.Project.CarRental.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "vehicle")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vehicleNumber;
    private String vehicleModel;
    private String color;
    private String fuelType;

    @Column(nullable = false)
    private Boolean availabilityStatus;

    // Relationships with Location and VehicleSubcategory will be added in later sprints
}