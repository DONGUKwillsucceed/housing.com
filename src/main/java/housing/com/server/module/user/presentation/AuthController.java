package housing.com.server.module.user.presentation;

import housing.com.server.common.exception.SignInException;
import housing.com.server.module.user.domain.type.SignInMethod;
import housing.com.server.module.user.presentation.dto.SignInRequestDTO;
import housing.com.server.module.user.presentation.dto.SignInResponseDTO;
import housing.com.server.module.user.application.AuthService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("auth")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("sign-in")
    public SignInResponseDTO signIn(@RequestParam SignInMethod with, @Valid @RequestBody()SignInRequestDTO dto) throws SignInException {
        SignInResponseDTO signInResponseDTO = authService.signIn(with, dto);
        if(signInResponseDTO == null) throw new SignInException("Sign In Failed");
        return signInResponseDTO;
    }
}
