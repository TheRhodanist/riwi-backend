package giese.std.Riwi.models.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;
@Entity
@Table(name = "users")
public class User {


    @Id
    @Column(name = "user_id", updatable = false, nullable = false)
    private UUID id;
    private String email;
    private String password;

    public User() {

    }

    public User(UUID id, String email, String password) {
        this.email = email;
        this.password = password;
        this.id = id;
    }

    public static User createUser(String email, String password) {
        return new User(UUID.randomUUID(), email, password);
    }
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
