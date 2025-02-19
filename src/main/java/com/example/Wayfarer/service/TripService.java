package com.example.Wayfarer.service;

import com.example.Wayfarer.entities.Trip;
import com.example.Wayfarer.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {
    @Autowired
    private TripRepository tripRepository;

    public Trip createTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }



public Trip getTripById(Integer tripId) {
        return tripRepository.findById(tripId).orElseThrow(() -> new RuntimeException("Trip not found"));
    }

    public String cancelTrip(Integer tripId) {
        Trip trip = getTripById(tripId);
        trip.setStatus("Cancelled");
        tripRepository.save(trip);
        return "Trip cancelled successfully";
    }
}