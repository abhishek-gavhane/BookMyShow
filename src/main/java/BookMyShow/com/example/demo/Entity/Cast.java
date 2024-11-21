package BookMyShow.com.example.demo.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor


public class Cast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long castId;
   private String castName;
    private String role;
    @Column(nullable = false)
    private Long movieId;
}
