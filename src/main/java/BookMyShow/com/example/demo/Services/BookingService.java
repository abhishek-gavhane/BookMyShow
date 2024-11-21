package BookMyShow.com.example.demo.Services;

import BookMyShow.com.example.demo.Entity.Booking;
import BookMyShow.com.example.demo.Exception.BadRequestException;
import BookMyShow.com.example.demo.Exception.ResourceNotFoundException;
import BookMyShow.com.example.demo.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    private SeatService seatService;

    // Get all bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Get a booking by ID
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));
    }

    // Add a new booking
    public Booking addBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    // Update a booking by ID
    public Booking updateBooking(Long id, Booking bookingDetails) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));

        booking.setBookingDate(bookingDetails.getBookingDate());
        booking.setTotalPrice(bookingDetails.getTotalPrice());
        booking.setUser(bookingDetails.getUser());
        booking.setShow(bookingDetails.getShow());

        return bookingRepository.save(booking);
    }

    // Delete a booking by ID
    public String deleteBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));

        bookingRepository.delete(booking);
        return "Booking with id: " + id + " deleted successfully.";
    }
}
