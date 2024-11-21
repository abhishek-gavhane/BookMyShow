package BookMyShow.com.example.demo.Repository;

import BookMyShow.com.example.demo.Entity.Cast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CastRepository extends JpaRepository<Cast, Long> {

    Optional<Cast> findByMovieId(Long movieId);
}
