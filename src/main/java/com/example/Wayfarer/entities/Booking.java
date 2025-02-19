package com.example.Wayfarer.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
@Entity
@Table(name = "bookings")
public class Booking {
    @EmbeddedId
    private BookingId id;

    @Column(nullable = false)
    private Date createdOn;

    @ManyToOne
    @MapsId("tripId")
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Data
    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BookingId implements Serializable {
        private Integer tripId;
        private Integer userId;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BookingId that = (BookingId) o;
            return Objects.equals(tripId, that.tripId) && Objects.equals(userId, that.userId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(tripId, userId);
        }
    }
}
