package hwJDI.sections;

import com.codeborne.selenide.Condition;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import hwJDI.entities.User;
import hwJDI.enumJDI.HeaderMenuEnum;
import hwJDI.enumJDI.UserEnum;
import hwJDI.form.LoginForm;
import org.openqa.selenium.support.FindBy;

public class Header extends Section{

    @FindBy(css = ".profile-photo>span")
    private Button userName;

    @FindBy(css = ".logout button")
    private Button logoutButton;

    @FindBy(css = ".profile-photo")
    private Button profilePhoto;

    @FindBy(css = ".form-horizontal")
    private LoginForm loginForm;

    @FindBy(css = ".m-l8")
    private Menu<HeaderMenuEnum> menuHeader;

    public void loginAsUser(UserEnum userEnum) {
        profilePhoto.click();
        loginForm.loginAs(userEnum.getUser());
        userName.should(Condition.text(userEnum.getUser().getUserName()));
    }

    public void selectOnMenu(String firstLevelOfMenu) {
        menuHeader.select(firstLevelOfMenu);
    }
}
