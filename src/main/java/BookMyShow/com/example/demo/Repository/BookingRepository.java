package BookMyShow.com.example.demo.Repository;

import BookMyShow.com.example.demo.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
