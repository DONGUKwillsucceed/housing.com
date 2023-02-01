package housing.com.server.module.user.presentation;

import housing.com.server.module.user.presentation.dto.CreateUserReqDTO;
import housing.com.server.module.user.presentation.dto.UserDTO;
import housing.com.server.module.user.application.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("{userId}")
    public UserDTO findUnique(@PathVariable Long userId){
        return userService.findUnique(userId);
    }
    @PostMapping("create")
    public void create(@Valid @RequestBody() CreateUserReqDTO dto){
        userService.create(dto);
    }

}
