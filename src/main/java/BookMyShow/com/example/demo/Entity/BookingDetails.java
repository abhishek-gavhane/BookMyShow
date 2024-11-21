package BookMyShow.com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BookingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingDetailsId;

    // Foreign Key to User
    @ManyToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "bookingId") // Optional custom column name
    private Booking booking;

    // Foreign Key to Show
    @ManyToOne
    @JoinColumn(name = "seat_id", referencedColumnName = "seatId") // Optional custom column name
    private Seat seat;

}
