package giese.std.riwi.models.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "users")
@Data
public class User {


    @Id
    @Column(name = "user_id", updatable = false, nullable = false)
    private UUID id;
    private String email;
    @Column(nullable = false)
    private String password;

    public User() {

    }

    public User(UUID id, String email, String password) {
        this.email = email;
        this.password = password;
        this.id = id;
    }

    public static User createUser(String email, String password) {
        UUID newId = UUID.randomUUID();
        return new User(newId, email, password);
    }

}
