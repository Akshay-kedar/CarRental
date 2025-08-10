package com.Project.CarRental.entity;

import jakarta.persistence.*;
        import lombok.*;

@Entity
@Table(name = "vehicle_category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String categoryName; // e.g. Car, Bike
}
