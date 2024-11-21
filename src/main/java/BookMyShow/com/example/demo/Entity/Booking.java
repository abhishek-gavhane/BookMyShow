package BookMyShow.com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@Entity

public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    // Foreign Key to User
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId") // Optional custom column name
    private User user;

    // Foreign Key to Show
    @ManyToOne
    @JoinColumn(name = "show_id", referencedColumnName = "showId") // Optional custom column name
    private Showss show;

    private Date bookingDate;
    private Float totalPrice;


}


