package com.Project.CarRental.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicle_subcategory")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleSubcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double pricePerDay;

    @Column(nullable = false)
    private String subcategoryName;

    @ManyToOne
    @JoinColumn(name="vehicle_category_id",nullable = false)
    private VehicleCategory vehicleCategory;
}
