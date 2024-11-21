package BookMyShow.com.example.demo.Services;

import BookMyShow.com.example.demo.Entity.Venue;
import BookMyShow.com.example.demo.Exception.ResourceNotFoundException;
import BookMyShow.com.example.demo.Repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueService {

    @Autowired
    private VenueRepository venueRepository;

    // Get all venues
    public List<Venue> getAllVenues() {
        return venueRepository.findAll();
    }

    // Get a venue by ID
    public Venue getVenueById(Long id) {
        return venueRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Venue not found with id: " + id));
    }

    // Add a new venue
    public Venue addVenue(Venue venue) {
        return venueRepository.save(venue);
    }

    // Update a venue by ID
    public Venue updateVenue(Long id, Venue venueDetails) {
        Venue venue = venueRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Venue not found with id: " + id));

        venue.setVenueName(venueDetails.getVenueName());
        venue.setVenueLocation(venueDetails.getVenueLocation());
        venue.setVenueCity(venueDetails.getVenueCity());

        return venueRepository.save(venue);
    }

    // Delete a venue by ID
    public String deleteVenue(Long id) {
        Venue venue = venueRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Venue not found with id: " + id));

        venueRepository.delete(venue);
        return "Venue with id: " + id + " deleted successfully.";
    }
}
