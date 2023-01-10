package housing.com.server.module.user.controller;

import housing.com.server.module.user.dto.CreateUserReqDTO;
import housing.com.server.module.user.service.UserService;
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

    @GetMapping()
    @ResponseBody
    public String findMany(){
        log.info("many");
        String many = "many";
        return many;
    }
    @PostMapping("create")
    public void create(@Valid @RequestBody() CreateUserReqDTO dto){
        userService.create(dto);
    }

}
