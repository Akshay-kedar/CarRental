package com.Project.CarRental.repository;


import com.Project.CarRental.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}