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
