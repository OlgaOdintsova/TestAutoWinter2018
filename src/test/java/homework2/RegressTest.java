package homework2;

import homework.base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RegressTest extends TestBase {

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
