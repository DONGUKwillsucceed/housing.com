package housing.com.server.module.user.infra;

import housing.com.server.module.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findUserById(Long id);
    User findUserByEmail(String email);
    User save(User user);
}
