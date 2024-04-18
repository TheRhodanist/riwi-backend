package giese.std.riwi.api;

import giese.std.riwi.models.user.CreateUserRequest;
import giese.std.riwi.models.user.User;
import giese.std.riwi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    Logger logger = Logger.getLogger(UserController.class.getName());

    @GetMapping("/hello")
    public String hello() {
        return "Hello, You!";
    }

    @PostMapping("/users")
    public UUID createUser(@RequestBody CreateUserRequest request) {

        return userService.createUser(request).getId();
    }

    @GetMapping("/users")
    public User[] getUsers() {
        return userService.getAllUsers();
    }
}
