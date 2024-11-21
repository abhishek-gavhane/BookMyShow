package BookMyShow.com.example.demo.Services;

import BookMyShow.com.example.demo.Entity.User;
import BookMyShow.com.example.demo.Exception.BadRequestException;
import BookMyShow.com.example.demo.Exception.ResourceNotFoundException;
import BookMyShow.com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get a user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    // Get user by email
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));
    }

    // Add a new user
    public User addUser(User user) {
        if (user.getUserName() == null || user.getUserName().isEmpty()) {
            throw new BadRequestException("Name cannot be empty.");
        }
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new BadRequestException("Email cannot be empty.");
        }
        return userRepository.save(user);
    }

    // Update a user by ID
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        user.setUserName(userDetails.getUserName());
        user.setEmail(userDetails.getEmail());
        user.setUserPhoneNumber(userDetails.getUserPhoneNumber());
        user.setUserPassword(userDetails.getUserPassword());

        return userRepository.save(user);
    }

    // Delete a user by ID
    public String deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        userRepository.delete(user);
        return "User with id: " + id + " deleted successfully.";
    }
}
