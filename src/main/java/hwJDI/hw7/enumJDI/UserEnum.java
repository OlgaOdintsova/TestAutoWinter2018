package hwJDI.hw7.enumJDI;

import hwJDI.hw7.entities.User;
import lombok.Getter;

@Getter
public enum UserEnum {
    PITER(new User("epam", "1234", "PITER CHAILOVSKI"));

    private final User user;

    UserEnum(User user) {
        this.user = user;
    }
}
