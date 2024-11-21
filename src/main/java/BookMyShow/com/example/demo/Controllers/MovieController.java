package BookMyShow.com.example.demo.Controllers;

import BookMyShow.com.example.demo.Entity.Movie;
import BookMyShow.com.example.demo.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // Get all movies
    @GetMapping("/getAllMovies")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    // Get a movie by ID
    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    // Add a new movie
    @PostMapping("/addMovie")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    // Update a movie by ID
    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movieDetails) {
        return movieService.updateMovie(id, movieDetails);
    }

    // Delete a movie by ID
    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable Long id) {
        return movieService.deleteMovie(id);
    }
}
