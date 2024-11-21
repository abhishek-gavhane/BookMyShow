package BookMyShow.com.example.demo.Services;

import BookMyShow.com.example.demo.Entity.Movie;
import BookMyShow.com.example.demo.Exception.ResourceNotFoundException;
import BookMyShow.com.example.demo.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    // Get all movies
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Get a movie by ID
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));
    }

    // Add a new movie
    public Movie addMovie(Movie movie) {
        if (movie.getTitle() == null || movie.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty.");
        }
        return movieRepository.save(movie);
    }

    // Update a movie by ID
    public Movie updateMovie(Long id, Movie movieDetails) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));

        movie.setTitle(movieDetails.getTitle());
        movie.setGenre(movieDetails.getGenre());
        movie.setLanguage(movieDetails.getLanguage());
        movie.setDuration(movieDetails.getDuration());

        return movieRepository.save(movie);
    }

    // Delete a movie by ID
    public String deleteMovie(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));

        movieRepository.delete(movie);
        return "Movie with id: " + id + " deleted successfully.";
    }
}
