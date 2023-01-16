package housing.com.server.module.user.domain.type;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public enum SignInMethod {
    google("google"),
    housing("housing"),
    apple("apple"),
    facebook("face book"),
    ;

    SignInMethod(String google) {
    }
}
