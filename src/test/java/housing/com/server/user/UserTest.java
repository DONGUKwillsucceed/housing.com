package housing.com.server.user;

import housing.com.server.module.user.domain.User;
import housing.com.server.module.user.dto.CreateUserReqDTO;
import housing.com.server.module.user.dto.UserDTO;
import housing.com.server.module.user.repository.UserRepository;
import housing.com.server.module.user.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

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

        User user = new User(dto);

        assertEquals(user.getEmail(), email);
        assertEquals(user.getFirstName(), firstName);
        assertEquals(user.getLastName(), lastName);
        assertEquals(user.getFirstName(), firstName);
    }

}
