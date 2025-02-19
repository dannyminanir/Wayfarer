package com.example.Wayfarer.controllers;

import com.example.Wayfarer.payloads.BookingRequest;
import com.example.Wayfarer.service.BookingService;
import com.example.Wayfarer.entities.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> bookTrip(@RequestBody BookingRequest request) {
        Booking booking = bookingService.bookTrip(request);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<?> deleteBooking(@PathVariable Integer bookingId) {
        try {
            return ResponseEntity.ok(bookingService.deleteBooking(bookingId));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
