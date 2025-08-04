package com.Project.CarRental.repository;

import com.Project.CarRental.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository  extends JpaRepository<Vehicle,Long> {
}
