package giese.std.Riwi.services;

import giese.std.Riwi.models.user.CreateUserRequest;
import giese.std.Riwi.models.user.User;
import giese.std.Riwi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UserService {
    Logger logger = Logger.getLogger(UserService.class.getName());
    @Autowired
    UserRepository userRepository;
    public User createUser(CreateUserRequest newUserRequest) {
        User newUser = User.createUser(newUserRequest.email, newUserRequest.password);
        UUID uuid = newUser.getId();
        logger.log(Level.INFO, "User "+newUserRequest.email+" created with UUID: "+uuid);
        userRepository.save(newUser);
        return newUser;
    }

    public User[] getAllUsers() {
        return userRepository.findAll().toArray(new User[0]);
    }
}
