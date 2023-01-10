package housing.com.server.module.user.domain;

import lombok.Getter;

@Getter
public enum UserRank {
    Normal("normal"),
    Realter("realter"),
    Admin("admin");

    UserRank(String rank) {}
}
