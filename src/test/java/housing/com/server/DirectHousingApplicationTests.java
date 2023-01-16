package housing.com.server;

import housing.com.server.user.UserTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class DirectHousingApplicationTests {
    @Autowired
    MockMvc mvc;
    @InjectMocks
    @Spy
    UserTest userTest;
    public DirectHousingApplicationTests(UserTest userTest){
        this.userTest = userTest;
    }
    @Test
    @DisplayName("유져 생성 테스트")
    void testCreateUser() {
        userTest.testCreateUser();
    }


}
