package homework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class TestBase {

    protected WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
//        driver = new ChromeDriver();
//        driver.navigate().to("https://jdi-framework.github.io/tests");
//        driver.manage().window().maximize();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
//        driver.close();
    }
}
