package hwJDI;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import hwJDI.enumJDI.UserEnum;
import hwJDI.pages.MetalsAndColorsPage;
import hwJDI.pages.HomePage;


@JSite("https://jdi-framework.github.io/tests/")
public class JDISite extends WebSite{

    @JPage(url = "index.htm", title = "Index Page")
    public static HomePage homePage;
    @JPage(url = "page2.htm", title = "Metals and Colors")
    public static MetalsAndColorsPage metalsAndColorsPage;

    public static void login(UserEnum userEnum) {
        homePage.header.loginAsUser(userEnum);
    }
}
