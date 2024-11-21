package BookMyShow.com.example.demo.Controllers;

import BookMyShow.com.example.demo.Entity.Cast;
import BookMyShow.com.example.demo.Services.CastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cast")
public class CastController {

    private final CastService castService;

    @Autowired
    public CastController(CastService castService) {
        this.castService = castService;
    }

    // Get all cast members
    @GetMapping
    public List<Cast> getAllCast() {
        return castService.getAllCast();
    }

    // Get cast member by ID
    @GetMapping("/{id}")
    public Cast getCastById(@PathVariable Long id) {
        return castService.getCastById(id);
    }

    @GetMapping("/movie/{movieId}")
    public Cast getCastByMovieId(@PathVariable Long movieId) {
        return castService.getCastByMovieId(movieId);
    }

    // Add a new cast member
    @PostMapping
    public Cast addCast(@RequestBody Cast cast, @PathVariable Long id) {
        return castService.addCast(cast,id);
    }

    // Delete a cast member
    @DeleteMapping("/{id}")
    public String deleteCast(@PathVariable Long id) {
        castService.deleteCast(id);
        return "Cast member with ID " + id + " deleted successfully.";
    }
}
