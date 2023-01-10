package housing.com.server.module.user.service;

import housing.com.server.module.user.domain.User;
import housing.com.server.module.user.dto.CreateUserReqDTO;
import housing.com.server.module.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public void create(CreateUserReqDTO dto){
        User user = new User(dto);
        userRepository.save(user);
    }
}
