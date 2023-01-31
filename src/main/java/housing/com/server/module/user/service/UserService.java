package housing.com.server.module.user.service;

import housing.com.server.module.user.domain.User;
import housing.com.server.module.user.domain.type.UserRank;
import housing.com.server.module.user.domain.type.UserStatus;
import housing.com.server.module.user.dto.CreateUserReqDTO;
import housing.com.server.module.user.dto.UserDTO;
import housing.com.server.module.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDTO findUnique(Long userId){
        User user = userRepository.findUserById(userId);
        return new UserDTO(user);
    }
    public void create(CreateUserReqDTO dto){
        if(dto.getPassword() != null)
            dto.setPassword(passwordEncoder.encode(dto.getPassword()));

        User user = User.builder()
                .email(dto.getEmail())
                .hashPassword(dto.getPassword())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .rank(UserRank.Normal)
                .status(UserStatus.Activate)
                .createdAt(new Timestamp(new Date().getTime()))
                .modifiedAt(new Timestamp(new Date().getTime()))
                .build();
        log.info(String.valueOf(user));
        userRepository.save(user);
    }
}
