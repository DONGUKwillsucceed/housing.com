package housing.com.server.module.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateUserReqDTO {
    @Email(message = "Badly formed email")
    @NotBlank(message = "Email is a must")
    String email;
    @NotBlank(message = "Password is a must")
    String password;
    @Size(max = 50, message = "First Name is too long")
    @NotBlank(message = "First Name is a must")
    String firstName;
    @Size(max = 50, message = "Last Name is too long")
    @NotBlank(message = "Last Name is a must")
    String lastName;
}
