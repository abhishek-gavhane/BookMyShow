package BookMyShow.com.example.demo.Services;

import BookMyShow.com.example.demo.Entity.Cast;
import BookMyShow.com.example.demo.Exception.ResourceNotFoundException;
import BookMyShow.com.example.demo.Repository.CastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CastService {

    private  CastRepository castRepository;

    @Autowired
    public CastService(CastRepository castRepository) {
        this.castRepository = castRepository;
    }

    // Retrieve all cast members
    public List<Cast> getAllCast() {
        return castRepository.findAll();
    }

    // Retrieve cast by ID
    public Cast getCastById(Long id) {
        return castRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cast not found with id: " + id));
    }

    public Cast getCastByMovieId(Long movieId) {
        return castRepository.findByMovieId(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Cast not found for movie with ID: " + movieId));
    }


    // Add a new cast member
    public Cast addCast(Cast cast, Long id) {
        Cast castDetails = castRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cast not found with id: " + id));

        cast.setCastName(castDetails.getCastName());
        cast.setRole(castDetails.getRole());
        cast.setMovieId(castDetails.getMovieId());

        return castRepository.save(cast);
    }

    // Delete a cast member
    public String deleteCast(Long id) {
        Cast cast = castRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cast not found with id: " + id));

        castRepository.delete(cast);
        return "Cast with id: " + id + " deleted successfully.";
    }
}
