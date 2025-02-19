package com.example.Wayfarer.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table(name = "trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer seatingCapacity;

    @Column(nullable = false, unique = true)
    private String busLicenseNumber;

    @Column(nullable = false)
    private String origin;

    @Column(nullable = false)
    private String destination;

    @Column(nullable = false)
    private Date tripDate;

    @Column(nullable = false)
    private Float fare;

    @Column(nullable = false)
    private String status;

    // Getters and Setters
}