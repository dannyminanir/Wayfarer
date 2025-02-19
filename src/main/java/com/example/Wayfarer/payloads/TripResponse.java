package com.example.Wayfarer.payloads;

import lombok.Data;

@Data
public class TripResponse {
    private Integer tripId;
    private Integer seatingCapacity;
    private String origin;
    private String destination;
    private String tripDate;
    private Float fare;
}
