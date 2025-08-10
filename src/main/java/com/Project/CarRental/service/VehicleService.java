package com.Project.CarRental.service;

import com.Project.CarRental.dto.VehicleAvailabilityDTO;
import com.Project.CarRental.dto.VehicleRequestDTO;
import com.Project.CarRental.entity.Vehicle;

public interface VehicleService {
    Vehicle registerVehicle(VehicleRequestDTO requestDTO);
    Vehicle updateAvailability(Long vehicleId, VehicleAvailabilityDTO availabilityDTO);
}
