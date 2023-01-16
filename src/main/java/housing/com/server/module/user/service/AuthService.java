package housing.com.server.module.user.service;

import housing.com.server.common.service.JWTProvider;
import housing.com.server.module.user.domain.type.SignInMethod;
import housing.com.server.module.user.dto.SignInRequestDTO;
import housing.com.server.module.user.domain.User;
import housing.com.server.module.user.dto.SignInResponseDTO;
import housing.com.server.module.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final JWTProvider jwtProvider;
    private final UserRepository userRepository;
    public AuthService(PasswordEncoder passwordEncoder, UserRepository userRepository, JWTProvider jwtProvider){
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
    }

    public SignInResponseDTO signIn(SignInMethod with, SignInRequestDTO dto){
        SignInResponseDTO signInResponseDTO = null;
        boolean result = false;

        User user = userRepository.findUserByEmail(dto.getEmail());
        if(with == SignInMethod.housing)
            result = signInWithHousing(dto, user);

        if(result){
            log.info("work?1");
            String accessToken = jwtProvider.createToken(user.getId());
            log.info(accessToken);
            signInResponseDTO = new SignInResponseDTO(accessToken, user.getId());
        }

        return signInResponseDTO;
    }

    public boolean signInWithHousing(SignInRequestDTO dto, User user){
        boolean resultForPassword = passwordEncoder.matches(dto.getPassword(), user.getHashPassword());
        boolean resultForEmail = Objects.equals(dto.getEmail(), user.getEmail());
        log.info(String.valueOf(resultForEmail));
        log.info(String.valueOf(resultForPassword));
        log.info(String.valueOf(resultForEmail && resultForPassword));
        return resultForEmail && resultForPassword;
    }

}
