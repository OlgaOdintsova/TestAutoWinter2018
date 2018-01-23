package homework2;

import homework.base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SmokeTest extends TestBase {

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
