package homework2;


import homework.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RegressTest extends TestBase {

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to("https://jdi-framework.github.io/tests");
        driver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

    // Assert Browser title
    @Test(groups = {"regress"})
    public void testPageTitle() {
        assertEquals(driver.getTitle(), "Index Page");
    }

    // Perform login
    @Test(groups = {"regress"})
    public void testLogin() {
        driver.findElement(By.cssSelector(".uui-profile-menu")).click();
        driver.findElement(By.id("Login")).sendKeys("epam");
        driver.findElement(By.id("Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".fa-sign-in")).click();
    }

    //Assert that the main header is displayed
    @Test(groups = {"regress"})
    public void testDisplayedTitle() {
        assertTrue(driver.findElement(By.cssSelector(".main-title")).isDisplayed());
    }
}
