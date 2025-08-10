package com.Project.CarRental.dto;

import lombok.Data;

@Data
public class VehicleRequestDTO {
    private String vehicleNumber;
    private String vehicleModel;
    private String color;
    private String fuelType;
    private Boolean availabilityStatus;
    private Long locationId;
    private Long vehicleSubcategoryId;
}
