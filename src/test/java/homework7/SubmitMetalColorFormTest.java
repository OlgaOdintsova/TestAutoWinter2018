package homework7;

import com.epam.jdi.uitests.core.settings.JDISettings;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import hwJDI.JDISite;
import hwJDI.entities.MetalColorFormData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static hwJDI.enumJDI.HeaderMenuEnum.METALS_AND_COLORS;
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

    @BeforeMethod
    public void beforeMethod() {
        //Login on JDI site as User
        JDISite.login(PITER);
    }

    // TODO i cant execute your test
    //    java.lang.RuntimeException: java.lang.AssertionError: Do action Open page 'Home Page' failed. Can't get result. Reason: java.lang.AssertionError: Can't get driver; Thread: 1
    //    Drivers: CHROME:com.epam.jdi.uitests.web.selenium.driver.SeleniumDriverFactory$$Lambda$34/1353070773@35dab4eb; Run: java.lang.ThreadLocal@72cc7e6fException: Timed out waiting for driver server to start.
    //    Build info: version: '3.8.1', revision: '6e95a6684b', time: '2017-12-01T18:33:54.468Z'
    //    Driver info: driver.version: ChromeDriver
    // !TODO
    @Test
    public void submitMetalColorFormTest() {
        //Open Metals & Colors page by Header menu
        JDISite.homePage.header.selectOnMenu(METALS_AND_COLORS);

        //Check Metals & Colors page is opened
        JDISite.metalsAndColorsPage.shouldBeOpened();

        //Fill form Metals & Colors by data
        JDISite.metalsAndColorsPage.metalColorForm.submit(MetalColorFormData.DEFAULT);

        //Check Result section
        JDISite.metalsAndColorsPage.checkResult(MetalColorFormData.DEFAULT);
    }
}
