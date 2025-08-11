package com.Project.CarRental.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingRequestDTO {
    private Long vehicleId;
    private LocalDate pickupDate;
    private LocalDate dropoffDate;
}
