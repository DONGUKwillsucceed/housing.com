package housing.com.server.module.user.domain.type;

import lombok.Getter;

@Getter
public enum UserRank {
    Normal("normal"),
    Realter("realter"),
    Admin("admin");

    UserRank(String rank) {}
}
