package hwJDI.entities;

import com.epam.commons.DataClass;
import hwJDI.enumJDI.UserEnum;

public class User extends DataClass { // <-- !!

    private String login;
    private String password;
    private String userName;

    public User(UserEnum userEnum) {
        this.login = userEnum.login;
        this.password = userEnum.password;
        this.userName = userEnum.userName;
    }
}
