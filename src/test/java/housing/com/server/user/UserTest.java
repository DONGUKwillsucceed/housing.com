package housing.com.server.user;

import housing.com.server.module.user.domain.entity.User;
import housing.com.server.module.user.domain.type.UserRank;
import housing.com.server.module.user.domain.type.UserStatus;
import housing.com.server.module.user.presentation.dto.CreateUserReqDTO;
import housing.com.server.module.user.infra.UserRepository;
import housing.com.server.module.user.application.UserService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Nested
public class UserTest {
    UserService userService;
    public UserTest(UserService userService, UserRepository userRepository){
        this.userService = userService;
    }

    @Test
    public void testCreateUser(){
        String email = "test@test.com";
        String password = "test";
        String firstName = "Test";
        String lastName = "TestT";
        CreateUserReqDTO dto = new CreateUserReqDTO(email, password, firstName, lastName);

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

        assertEquals(user.getEmail(), email);
        assertEquals(user.getFirstName(), firstName);
        assertEquals(user.getLastName(), lastName);
        assertEquals(user.getFirstName(), firstName);
    }

}
