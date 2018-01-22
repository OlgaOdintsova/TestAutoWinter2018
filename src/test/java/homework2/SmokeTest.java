package homework2;

import homework.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SmokeTest {

    private static WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to("https://jdi-framework.github.io/tests");
        driver.manage().window().maximize();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

    // Assert Browser title
    @Test(groups = {"smoke"})
    public void testPageTitle() {
        assertEquals(driver.getTitle(), "Index Page");
    }

    //Assert that the main header is displayed
    @Test(groups = {"smoke"})
    public void testDisplayedTitle() {
        assertTrue(driver.findElement(By.cssSelector(".main-title")).isDisplayed());
    }

}
