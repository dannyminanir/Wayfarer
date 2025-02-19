package com.example.Wayfarer.payloads;

import lombok.Data;

@Data
public class BookingRequest {
    private Integer tripId;
    private Integer userId;
}
