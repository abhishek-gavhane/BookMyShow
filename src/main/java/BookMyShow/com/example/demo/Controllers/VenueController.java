package BookMyShow.com.example.demo.Controllers;

import BookMyShow.com.example.demo.Entity.Venue;
import BookMyShow.com.example.demo.Services.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venues")
public class VenueController {

    @Autowired
    private VenueService venueService;

    @GetMapping
    public List<Venue> getAllVenues() {
        return venueService.getAllVenues();
    }

    @GetMapping("/{id}")
    public Venue getVenueById(@PathVariable Long id) {
        return venueService.getVenueById(id);
    }

    @PostMapping
    public Venue addVenue(@RequestBody Venue venue) {
        return venueService.addVenue(venue);
    }

    @PutMapping("/{id}")
    public Venue updateVenue(@PathVariable Long id, @RequestBody Venue venueDetails) {
        return venueService.updateVenue(id, venueDetails);
    }


    @DeleteMapping("/{id}")
    public String deleteVenue(@PathVariable Long id) {
        return venueService.deleteVenue(id);
    }
}
