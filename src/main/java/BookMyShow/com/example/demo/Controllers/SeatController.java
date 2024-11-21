package BookMyShow.com.example.demo.Controllers;

import BookMyShow.com.example.demo.Entity.Seat;
import BookMyShow.com.example.demo.Services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping
    public List<Seat> getAllSeats() {
        return seatService.getAllSeats();
    }

    @GetMapping("/{id}")
    public Seat getSeatById(@PathVariable Long id) {
        return seatService.getSeatById(id);
    }

    @PostMapping
    public Seat addSeat(@RequestBody Seat seat) {
        return seatService.addSeat(seat);
    }

    @PutMapping("/{id}")
    public Seat updateSeat(@PathVariable Long id, @RequestBody Seat seatDetails) {
        return seatService.updateSeat(id, seatDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteSeat(@PathVariable Long id) {
        return seatService.deleteSeat(id);
    }
}
