package housing.com.server.module.user.repository;

import housing.com.server.module.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findUserById(Long id);
    User save(User user);
}
