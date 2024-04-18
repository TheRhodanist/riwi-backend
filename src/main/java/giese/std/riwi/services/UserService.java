package giese.std.riwi.services;

import giese.std.riwi.models.user.CreateUserRequest;
import giese.std.riwi.models.user.User;
import giese.std.riwi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UserService {
    Logger logger = Logger.getLogger(UserService.class.getName());
    @Autowired
    UserRepository userRepository;
    public User createUser(CreateUserRequest newUserRequest) {
        String userEmail = newUserRequest.email.toLowerCase();
        User newUser = User.createUser(userEmail, newUserRequest.password);
        logger.log(Level.INFO, "User "+newUserRequest.email+" created with email: "+userEmail);
        userRepository.save(newUser);
        return newUser;
    }

    public User[] getAllUsers() {
        return userRepository.findAll().toArray(new User[0]);
    }
}
