package housing.com.server.module.user.dto;

import housing.com.server.module.user.domain.User;
import housing.com.server.module.user.domain.type.UserRank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    Long id;
    String email;
    String firstName;
    String lastName;
    UserRank rank;

    public UserDTO(User user){
        this.id = user.getId();
        this.email = user.getEmail();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.rank = user.getRank();
    }
}
