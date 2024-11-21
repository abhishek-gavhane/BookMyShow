package BookMyShow.com.example.demo.Repository;

import BookMyShow.com.example.demo.Entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
