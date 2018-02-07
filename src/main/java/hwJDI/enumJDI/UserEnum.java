package hwJDI.enumJDI;

import lombok.Getter;

@Getter
public enum UserEnum {
        PITER("epam","1234","PITER CHAILOVSKI");

        public final String login;
        public final String password;
        public final String userName;

        UserEnum(String login, String password, String userName) {
            this.login = login;
            this.password = password;
            this.userName = userName;
        }
}
