package BookMyShow.com.example.demo.Controllers;

import BookMyShow.com.example.demo.Entity.Showss;
import BookMyShow.com.example.demo.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @GetMapping
    public List<Showss> getAllShows() {
        return showService.getAllShows();
    }

    @GetMapping("/{id}")
    public Showss getShowById(@PathVariable Long id) {
        return showService.getShowById(id);
    }

    @PostMapping
    public Showss addShow(@RequestBody Showss show) {
        return showService.addShow(show);
    }

    @PutMapping("/{id}")
    public Showss updateShow(@PathVariable Long id, @RequestBody Showss showDetails) {
        return showService.updateShow(id, showDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteShow(@PathVariable Long id) {
        return showService.deleteShow(id);
    }
}
