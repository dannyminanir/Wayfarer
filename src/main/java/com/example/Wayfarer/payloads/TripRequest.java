package com.example.Wayfarer.payloads;


import lombok.Data;

@Data
public class TripRequest {
    private Integer seatingCapacity;
    private String busLicenseNumber;
    private String origin;
    private String destination;
    private String tripDate;
    private Float fare;
}