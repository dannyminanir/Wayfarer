package com.example.Wayfarer.controllers;

import com.example.Wayfarer.entities.Trip;
import com.example.Wayfarer.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripController {
    @Autowired
    private TripService tripService;

    @PostMapping
    public ResponseEntity<Trip> createTrip(@RequestBody Trip trip) {
        return ResponseEntity.ok(tripService.createTrip(trip));
    }

    @GetMapping
    public ResponseEntity<List<Trip>> getAllTrips() {
        return ResponseEntity.ok(tripService.getAllTrips());
    }



@GetMapping("/{tripId}")
    public ResponseEntity<?> getTrip(@PathVariable Integer tripId) {
        return ResponseEntity.ok(tripService.getTripById(tripId));
    }

    @PatchMapping("/{tripId}/cancel")
    public ResponseEntity<?> cancelTrip(@PathVariable Integer tripId) {
        return ResponseEntity.ok(tripService.cancelTrip(tripId));
    }
}
