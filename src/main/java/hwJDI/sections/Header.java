package hwJDI.sections;

import com.codeborne.selenide.Condition;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JMenu;
import hwJDI.elements.HeaderMenu;
import hwJDI.enumJDI.UserEnum;
import hwJDI.form.LoginForm;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;

public class Header extends Section {

    @FindBy(css = ".profile-photo>span")
    private Button userName;

    @FindBy(css = ".logout button")
    private Button logoutButton;

    @FindBy(css = ".profile-photo")
    private Button profilePhoto;

    @FindBy(css = ".form-horizontal")
    private LoginForm loginForm;

    @Getter
    @FindBy(css = ".m-l8")
    @JMenu(
        level1 = @JFindBy(css = "ul.top-navigation__list>li span a"),
        level2 = @JFindBy(css = "ul.top-navigation__grand-sub-list>li a"))
    private HeaderMenu headerMenu;

    public void loginAsUser(UserEnum userEnum) {
        profilePhoto.click();
        loginForm.loginAs(userEnum);
        userName.should(Condition.text(userEnum.getUserName()));
    }
}
