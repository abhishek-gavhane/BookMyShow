package BookMyShow.com.example.demo.Repository;

import BookMyShow.com.example.demo.Entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue, Long> {
}
