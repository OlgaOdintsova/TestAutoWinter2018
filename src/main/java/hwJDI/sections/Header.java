package hwJDI.sections;

import com.codeborne.selenide.Condition;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JMenu;
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

    @JMenu(
            level1 = @JFindBy(css = "ul.m-l8>li a"),
            level2 = @JFindBy(css = "ul.dropdown-menu>ul>li a")
    )
    private Menu multipleHeaderMenu;

    public void loginAsUser(UserEnum userEnum) {
        profilePhoto.click();
        loginForm.loginAs(userEnum.getUser());
        userName.should(Condition.text(userEnum.getUser().getUserName()));
    }

    public void selectOnMenu(HeaderMenuEnum headerMenuEnum) {
        String[] splitString = headerMenuEnum.page.split("\\|");
        multipleHeaderMenu.hoverAndClick(splitString[0]);
        if (splitString.length == 2) {
            multipleHeaderMenu.hoverAndClick(splitString[1]);
        }
    }
}
