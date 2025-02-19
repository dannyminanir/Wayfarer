package com.example.Wayfarer.service;

import com.example.Wayfarer.entities.Booking;
import com.example.Wayfarer.entities.Trip;
import com.example.Wayfarer.entities.User;
import com.example.Wayfarer.payloads.BookingRequest;
import com.example.Wayfarer.repositories.BookingRepository;
import com.example.Wayfarer.repositories.TripRepository;
import com.example.Wayfarer.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private UserRepository userRepository;

    public Booking bookTrip(BookingRequest request) {
        Trip trip = tripRepository.findById(request.getTripId())
                .orElseThrow(() -> new RuntimeException("Trip not found"));

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Booking booking = new Booking();
        booking.setId(new Booking.BookingId(request.getTripId(), request.getUserId())); // Set composite key
        booking.setTrip(trip);
        booking.setUser(user);
        booking.setCreatedOn(new Date());

        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Transactional
    public String deleteBooking(Integer bookingId) {
        if (!bookingRepository.existsById(bookingId)) {
            throw new RuntimeException("Booking not found");
        }
        bookingRepository.deleteById(bookingId);
        return "Booking deleted successfully";
    }
}
