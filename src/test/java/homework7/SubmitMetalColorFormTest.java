package homework7;

import com.epam.jdi.uitests.core.settings.JDISettings;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import hwJDI.JDISite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static hwJDI.enumJDI.UserEnum.PITER;

public class SubmitMetalColorFormTest extends TestNGBase {

    @SuppressWarnings("unchecked")
    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        WebSite.init(JDISite.class);
        JDISettings.logger.info("Run tests...");
    }

    @BeforeClass(alwaysRun = true)
    public void openHomePage() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        JDISite.homePage.open();
    }

    @Test
    public void submitMetalColorFormTest() {
        JDISite.login(PITER);
    }
}
