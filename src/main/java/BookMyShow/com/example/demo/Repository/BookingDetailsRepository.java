package BookMyShow.com.example.demo.Repository;

import BookMyShow.com.example.demo.Entity.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDetailsRepository extends JpaRepository<BookingDetails, Long> {
}
