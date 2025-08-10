package com.Project.CarRental.controller;

import com.Project.CarRental.dto.VehicleAvailabilityDTO;
import com.Project.CarRental.dto.VehicleRequestDTO;
import com.Project.CarRental.entity.Vehicle;
import com.Project.CarRental.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/vehicles")
@RequiredArgsConstructor
public class AdminVehicleController {

    private final VehicleService vehicleService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/register")
    public Vehicle registerVehicle(@RequestBody VehicleRequestDTO requestDTO) {
        return vehicleService.registerVehicle(requestDTO);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/{vehicleId}/availability")
    public Vehicle updateAvailability(@PathVariable Long vehicleId,
                                      @RequestBody VehicleAvailabilityDTO availabilityDTO) {
        return vehicleService.updateAvailability(vehicleId, availabilityDTO);
    }
}