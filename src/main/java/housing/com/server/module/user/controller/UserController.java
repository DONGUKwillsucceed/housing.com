package housing.com.server.module.user.controller;

import housing.com.server.module.user.dto.CreateUserReqDTO;
import housing.com.server.module.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("users")
public class UserController {
    final UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("create")
    public void create(@RequestBody() CreateUserReqDTO dto){
        userService.create(dto);
    }

}
