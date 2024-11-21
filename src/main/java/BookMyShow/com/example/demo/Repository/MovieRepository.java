package BookMyShow.com.example.demo.Repository;
import BookMyShow.com.example.demo.Entity.Movie;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
