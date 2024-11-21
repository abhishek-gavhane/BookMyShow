package BookMyShow.com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@Entity
public class Showss {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long showId;

    // Foreign Key to Venue
    @ManyToOne
    @JoinColumn(name = "venue_id", referencedColumnName = "venueId")
    private Venue venue;

    // Foreign Key to Movie
    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "movieId")
    private Movie movie;

    private Date showDate;
    private Time showTime;
    private Float showPrice;
}
