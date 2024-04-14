package giese.std.Riwi.repositories;

import giese.std.Riwi.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID>{
}
