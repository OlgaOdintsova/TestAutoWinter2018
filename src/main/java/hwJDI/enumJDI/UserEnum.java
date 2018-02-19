package hwJDI.enumJDI;

import hwJDI.entities.User;
import lombok.Getter;

// TODO I dont get it, what is the reason why you need USER_ENUM and USER_CLASS at once ??
// TODO why dont you use smth one ?
@Getter
public enum UserEnum {
    PITER(new User("epam", "1234", "PITER CHAILOVSKI"));

    private final User user;

    UserEnum(User user) {
        this.user = user;
    }
}
