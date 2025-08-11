package com.Project.CarRental.service;

import com.Project.CarRental.dto.BookingRequestDTO;
import com.Project.CarRental.entity.Booking;

import java.util.List;

public interface BookingService {
    Booking createBooking(BookingRequestDTO request, String userEmail);
    List<Booking> getUserBookings(String userEmail);
}