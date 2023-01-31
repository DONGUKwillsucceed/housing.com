package housing.com.server.module.user.domain;


import housing.com.server.module.user.domain.type.UserRank;
import housing.com.server.module.user.domain.type.UserStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "User", schema = "Housing")
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
    //@Enumerated(EnumType.STRING)
    @Column(name = "user_status", nullable = false)
    private UserStatus status;
    @Basic
    //@Enumerated(EnumType.STRING)
    @Column(name = "user_rank", nullable = false)
    private UserRank rank;

    @Builder
    public User(long id, String email, String hashPassword, String firstName, String lastName, Timestamp modifiedAt, Timestamp createdAt, UserStatus status, UserRank rank){
        this.id = id;
        this.email = email;
        this.hashPassword = hashPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.modifiedAt = modifiedAt;
        this.createdAt = createdAt;
        this.status = status;
        this.rank = rank;
    }
}
