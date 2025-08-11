package com.Project.CarRental.service;

import com.Project.CarRental.dto.BookingRequestDTO;
import com.Project.CarRental.entity.Booking;
import com.Project.CarRental.entity.User;
import com.Project.CarRental.entity.Vehicle;
import com.Project.CarRental.repository.BookingRepository;
import com.Project.CarRental.repository.UserRepository;
import com.Project.CarRental.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final VehicleRepository vehicleRepository;

    @Override
    public Booking createBooking(BookingRequestDTO request, String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Vehicle vehicle = vehicleRepository.findById(request.getVehicleId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        if (!vehicle.getAvailabilityStatus()) {
            throw new RuntimeException("Vehicle not available for booking");
        }

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setVehicle(vehicle);
        booking.setPickupDate(request.getPickupDate());
        booking.setDropoffDate(request.getDropoffDate());

        // Mark vehicle unavailable after booking
        vehicle.setAvailabilityStatus(false);
        vehicleRepository.save(vehicle);

        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getUserBookings(String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return bookingRepository.findAll()
                .stream()
                .filter(b -> b.getUser().getId().equals(user.getId()))
                .toList();
    }
}
