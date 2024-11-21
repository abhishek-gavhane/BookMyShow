package BookMyShow.com.example.demo.Controllers;

import BookMyShow.com.example.demo.Entity.Booking;
import BookMyShow.com.example.demo.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }


    @PostMapping
    public Booking addBooking(@RequestBody Booking booking) {
        return bookingService.addBooking(booking);
    }

    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable Long id, @RequestBody Booking bookingDetails) {
        return bookingService.updateBooking(id, bookingDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable Long id) {
        return bookingService.deleteBooking(id);
    }
}
