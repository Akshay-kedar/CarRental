package com.Project.CarRental.repository;

import com.Project.CarRental.entity.Role;
import com.Project.CarRental.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
