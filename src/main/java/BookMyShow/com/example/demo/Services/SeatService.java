package BookMyShow.com.example.demo.Services;

import BookMyShow.com.example.demo.Entity.Seat;
import BookMyShow.com.example.demo.Exception.ResourceNotFoundException;
import BookMyShow.com.example.demo.Repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    // Get all seats
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    // Get a seat by ID
    public Seat getSeatById(Long id) {
        return seatRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seat not found with id: " + id));
    }

    // Add a new seat
    public Seat addSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    // Update a seat by ID
    public Seat updateSeat(Long id, Seat seatDetails) {
        Seat seat = seatRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seat not found with id: " + id));

        seat.setSeatNo(seatDetails.getSeatNo());
        seat.setIsAvailable(seatDetails.getIsAvailable());
        seat.setShow(seatDetails.getShow());

        return seatRepository.save(seat);
    }

    // Delete a seat by ID
    public String deleteSeat(Long id) {
        Seat seat = seatRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seat not found with id: " + id));

        seatRepository.delete(seat);
        return "Seat with id: " + id + " deleted successfully.";
    }
}
