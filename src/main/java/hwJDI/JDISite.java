package hwJDI;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import hwJDI.enumJDI.UserEnum;
import hwJDI.pages.HomePage;
import hwJDI.pages.MetalsAndColorsPage;


@JSite("https://epam.github.io/JDI")
public class JDISite extends WebSite {

    @JPage(url = "index.html", title = "Index Page")
    public static HomePage homePage;

    @JPage(url = "metals-colors.html", title = "Metal and Colors")
    public static MetalsAndColorsPage metalsAndColorsPage;

    public static void login(UserEnum userEnum) {
        homePage.header.loginAsUser(userEnum);
    }
}
