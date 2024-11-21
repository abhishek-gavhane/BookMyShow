package BookMyShow.com.example.demo.Services;

import BookMyShow.com.example.demo.Entity.BookingDetails;
import BookMyShow.com.example.demo.Exception.ResourceNotFoundException;
import BookMyShow.com.example.demo.Repository.BookingDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingDetailsService {

    @Autowired
    private BookingDetailsRepository bookingDetailsRepository;

    // Get all booking details
    public List<BookingDetails> getAllBookingDetails() {
        return bookingDetailsRepository.findAll();
    }

    // Get a booking detail by ID
    public BookingDetails getBookingDetailsById(Long id) {
        return bookingDetailsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking detail not found with id: " + id));
    }

    // Add new booking details
    public BookingDetails addBookingDetails(BookingDetails bookingDetails) {
        return bookingDetailsRepository.save(bookingDetails);
    }

    // Update booking details by ID
    public BookingDetails updateBookingDetails(Long id, BookingDetails bookingDetails) {
        BookingDetails existingBookingDetails = bookingDetailsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking detail not found with id: " + id));

        existingBookingDetails.setBooking(bookingDetails.getBooking());
        existingBookingDetails.setSeat(bookingDetails.getSeat());

        return bookingDetailsRepository.save(existingBookingDetails);
    }

    // Delete booking details by ID
    public String deleteBookingDetails(Long id) {
        BookingDetails bookingDetails = bookingDetailsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking detail not found with id: " + id));

        bookingDetailsRepository.delete(bookingDetails);
        return "Booking detail with id: " + id + " deleted successfully.";
    }
}
