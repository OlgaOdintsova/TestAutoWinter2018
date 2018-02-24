package hwJDI.enumJDI;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserEnum {
    PITER("epam", "1234", "PITER CHAILOVSKI");

    private final String login;
    private final String password;
    private final String userName;
}
