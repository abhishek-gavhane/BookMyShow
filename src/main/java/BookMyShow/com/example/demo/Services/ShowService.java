package BookMyShow.com.example.demo.Services;

import BookMyShow.com.example.demo.Entity.Showss;
import BookMyShow.com.example.demo.Exception.ResourceNotFoundException;
import BookMyShow.com.example.demo.Repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    // Get all shows
    public List<Showss> getAllShows() {
        return showRepository.findAll();
    }

    // Get a show by ID
    public Showss getShowById(Long id) {
        return showRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Show not found with id: " + id));
    }

    // Add a new show
    public Showss addShow(Showss show) {
        return showRepository.save(show);
    }

    // Update a show by ID
    public Showss updateShow(Long id, Showss showDetails) {
        Showss show = showRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Show not found with id: " + id));

        show.setShowDate(showDetails.getShowDate());
        show.setShowTime(showDetails.getShowTime());
        show.setShowPrice(showDetails.getShowPrice());
        show.setVenue(showDetails.getVenue());
        show.setMovie(showDetails.getMovie());

        return showRepository.save(show);
    }

    // Delete a show by ID
    public String deleteShow(Long id) {
        Showss show = showRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Show not found with id: " + id));

        showRepository.delete(show);
        return "Show with id: " + id + " deleted successfully.";
    }
}
