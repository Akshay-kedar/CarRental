package com.Project.CarRental.repository;


import com.Project.CarRental.entity.VehicleSubcategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleSubcategoryRepository extends JpaRepository<VehicleSubcategory, Long> {
}