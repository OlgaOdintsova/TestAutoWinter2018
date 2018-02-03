package homework.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

public abstract class TestBase {

    protected WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }
}
