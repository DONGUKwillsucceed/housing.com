package housing.com.server;

import housing.com.server.user.UserTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DirectHousingApplicationTests {
    @Test
    @DisplayName("유져 생성 테스트")
    void testCreateUser() {
        UserTest userTest = new UserTest();
        userTest.testCreateUser();
    }

}
