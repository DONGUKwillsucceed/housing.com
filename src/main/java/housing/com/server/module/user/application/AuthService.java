package housing.com.server.module.user.application;

import housing.com.server.common.service.JWTProvider;
import housing.com.server.module.user.domain.type.SignInMethod;
import housing.com.server.module.user.presentation.dto.SignInRequestDTO;
import housing.com.server.module.user.domain.entity.User;
import housing.com.server.module.user.presentation.dto.SignInResponseDTO;
import housing.com.server.module.user.infra.UserRepository;
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
            String accessToken = jwtProvider.createToken(user.getId());
            signInResponseDTO = new SignInResponseDTO(accessToken, user.getId());
        }

        return signInResponseDTO;
    }

    public boolean signInWithHousing(SignInRequestDTO dto, User user){
        boolean resultForPassword = passwordEncoder.matches(dto.getPassword(), user.getHashPassword());
        boolean resultForEmail = Objects.equals(dto.getEmail(), user.getEmail());

        return resultForEmail && resultForPassword;
    }

}
