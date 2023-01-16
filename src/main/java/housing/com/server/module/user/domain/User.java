package housing.com.server.module.user.domain;


import housing.com.server.module.user.dto.CreateUserReqDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Entity
@Table(name = "User", schema = "Housing")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "email", nullable = false)
    private String email;
    @Basic
    @Column(name = "hash_password")
    private String hashPassword;
    @Basic
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Basic
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;
    @Basic
    @Column(name = "modified_at", nullable = false)
    private Timestamp modifiedAt;
    @Basic
    @Column(name = "user_status", nullable = false)
    private UserStatus status;

    @Basic
    @Column(name = "user_rank", nullable = false)
    private UserRank rank;

    public User(CreateUserReqDTO dto){
        this.email = dto.getEmail();
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.hashPassword = dto.getPassword();
        this.status = UserStatus.Activate;
        this.rank = UserRank.Normal;
        this.createdAt = new Timestamp(new Date().getTime());
        this.modifiedAt = new Timestamp(new Date().getTime());
    }

    public void updateName(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public void updateStatus(UserStatus status){
        this.status = status;
    }

    public void updateRank(UserRank rank){this.rank = rank;}
}
