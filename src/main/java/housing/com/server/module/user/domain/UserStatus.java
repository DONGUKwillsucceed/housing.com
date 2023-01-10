package housing.com.server.module.user.domain;

import lombok.Getter;

@Getter
public enum UserStatus {
    Activate("activate"),
    Deactivate("deactivate"),
    Deleted("deleted");

    UserStatus(String status){}
}
