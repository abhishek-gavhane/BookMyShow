package BookMyShow.com.example.demo.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;


    //Foreign key
    @ManyToOne
    @JoinColumn(name = "show_id", referencedColumnName = "showId")
    private Showss show;

    private String seatNo;
    private Boolean isAvailable;
}
