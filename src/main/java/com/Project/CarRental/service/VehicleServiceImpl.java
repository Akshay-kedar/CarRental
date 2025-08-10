package com.Project.CarRental.service;


import com.Project.CarRental.dto.VehicleAvailabilityDTO;
import com.Project.CarRental.dto.VehicleRequestDTO;
import com.Project.CarRental.entity.Location;
import com.Project.CarRental.entity.Vehicle;
import com.Project.CarRental.entity.VehicleCategory;
import com.Project.CarRental.entity.VehicleSubcategory;
import com.Project.CarRental.repository.LocationRepository;
import com.Project.CarRental.repository.VehicleRepository;
import com.Project.CarRental.repository.VehicleSubcategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService{

    private final VehicleRepository vehicleRepository;
    private final LocationRepository locationRepository;
    private final VehicleSubcategoryRepository subcategoryRepository;


    @Override
    public Vehicle registerVehicle(VehicleRequestDTO requestDTO) {
        Location location=locationRepository.findById(requestDTO.getLocationId()).orElseThrow(()->new RuntimeException("Location Not found"));

        VehicleSubcategory subcategory= subcategoryRepository.findById(requestDTO.getVehicleSubcategoryId())
                .orElseThrow(() -> new RuntimeException("Vehicle Subcategory not found"));


        Vehicle vehicle=new Vehicle();

        vehicle.setVehicleNumber(requestDTO.getVehicleNumber());
        vehicle.setVehicleModel(requestDTO.getVehicleModel());
        vehicle.setColor(requestDTO.getColor());
        vehicle.setFuelType(requestDTO.getFuelType());
        vehicle.setAvailabilityStatus(requestDTO.getAvailabilityStatus());
        vehicle.setLocation(location);
        vehicle.setVehicleSubcategory(subcategory);




        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle updateAvailability(Long vehicleId, VehicleAvailabilityDTO availabilityDTO) {

        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        vehicle.setAvailabilityStatus(availabilityDTO.getAvailabilityStatus());

        return vehicleRepository.save(vehicle);
    }
}
