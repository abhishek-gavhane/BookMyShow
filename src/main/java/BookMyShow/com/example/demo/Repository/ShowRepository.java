package BookMyShow.com.example.demo.Repository;

import BookMyShow.com.example.demo.Entity.Showss;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Showss, Long> {
}
