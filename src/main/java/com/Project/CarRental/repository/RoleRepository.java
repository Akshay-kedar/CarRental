package com.Project.CarRental.repository;

import com.Project.CarRental.entity.Role;
import com.Project.CarRental.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(String name);
}
