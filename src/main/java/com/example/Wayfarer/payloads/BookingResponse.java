package com.example.Wayfarer.payloads;


import lombok.Data;

@Data
public class BookingResponse {
    private Integer bookingId;
    private String busLicenseNumber;
    private String tripDate;
    private String firstName;
    private String lastName;
    private String userEmail;
}