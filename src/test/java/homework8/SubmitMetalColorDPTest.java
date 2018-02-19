package homework8;

import com.epam.jdi.uitests.core.settings.JDISettings;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import hwJDI.JDISite;
import hwJDI.dataProviders.MetalColorProvider;
import hwJDI.entities.MetalColorFormData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static hwJDI.enumJDI.HeaderMenuEnum.METALS_AND_COLORS;
import static hwJDI.enumJDI.UserEnum.PITER;

public class SubmitMetalColorDPTest extends TestNGBase {

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
        //Login on JDI site as User
        JDISite.login(PITER);
    }

    @Test(dataProvider = "mcData", dataProviderClass = MetalColorProvider.class)
    public void fillMetalColorFormTest(MetalColorFormData mcData) {
        //Open Metals & Colors page by Header menu
        JDISite.homePage.header.selectOnMenu(METALS_AND_COLORS);

        //Check Metals & Colors page is opened
        JDISite.metalsAndColorsPage.shouldBeOpened();

        //Fill form Metals & Colors by data(json)
        JDISite.metalsAndColorsPage.metalColorForm.submit(mcData);

        //Check Result section
        JDISite.metalsAndColorsPage.checkResult(mcData);
    }
}
