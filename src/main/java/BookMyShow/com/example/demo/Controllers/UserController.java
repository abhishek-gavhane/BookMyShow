package BookMyShow.com.example.demo.Controllers;

import BookMyShow.com.example.demo.Entity.User;
import BookMyShow.com.example.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userServices;


    @GetMapping
    public List<User> getAllUsers() {
        return userServices.getAllUsers();
    }


    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userServices.getUserById(id);
    }

    // Get a user by email
    @GetMapping("/email")
    public User getUserByEmail(@RequestParam String email) {
        return userServices.getUserByEmail(email);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userServices.addUser(user);
    }


    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userServices.updateUser(id, userDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userServices.deleteUser(id);
    }
}
