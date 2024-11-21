package BookMyShow.com.example.demo.Controllers;

import BookMyShow.com.example.demo.Entity.BookingDetails;
import BookMyShow.com.example.demo.Services.BookingDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking-details")
public class BookingDetailsController {

    @Autowired
    private BookingDetailsService bookingDetailsService;

    // Get all booking details
    @GetMapping
    public List<BookingDetails> getAllBookingDetails() {
        return bookingDetailsService.getAllBookingDetails();
    }

    // Get a booking detail by ID
    @GetMapping("/{id}")
    public BookingDetails getBookingDetailsById(@PathVariable Long id) {
        return bookingDetailsService.getBookingDetailsById(id);
    }

    // Add new booking details
    @PostMapping
    public BookingDetails addBookingDetails(@RequestBody BookingDetails bookingDetails) {
        return bookingDetailsService.addBookingDetails(bookingDetails);
    }

    // Update booking details by ID
    @PutMapping("/{id}")
    public BookingDetails updateBookingDetails(@PathVariable Long id, @RequestBody BookingDetails bookingDetails) {
        return bookingDetailsService.updateBookingDetails(id, bookingDetails);
    }

    // Delete booking details by ID
    @DeleteMapping("/{id}")
    public String deleteBookingDetails(@PathVariable Long id) {
        return bookingDetailsService.deleteBookingDetails(id);
    }
}
