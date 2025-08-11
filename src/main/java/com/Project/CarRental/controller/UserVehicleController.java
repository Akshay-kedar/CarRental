package com.Project.CarRental.controller;


import com.Project.CarRental.dto.BookingRequestDTO;
import com.Project.CarRental.entity.Booking;
import com.Project.CarRental.entity.Vehicle;
import com.Project.CarRental.repository.VehicleRepository;
import com.Project.CarRental.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserVehicleController {

    private final VehicleRepository vehicleRepository;
    private final BookingService bookingService;

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/vehicles")
    public List<Vehicle> getAvailableVehicles() {
        return vehicleRepository.findAll()
                .stream()
                .filter(Vehicle::getAvailabilityStatus)
                .toList();

    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/bookings")
    public Booking createBooking(@RequestBody BookingRequestDTO request, Authentication authentication) {
        return bookingService.createBooking(request, authentication.getName());
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/bookings")
    public List<Booking> getUserBookings(Authentication authentication) {
        return bookingService.getUserBookings(authentication.getName());
    }
}
