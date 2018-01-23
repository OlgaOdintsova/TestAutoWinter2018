package homework2;

import homework.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SmokeAndRegressTest extends TestBase {

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

    // Assert Browser title
    @Test(groups = {"regress"})
    public void testRegressPageTitle() {
        assertEquals(driver.getTitle(), "Index Page");
    }

    //7 Assert that there are 4 images on the Home Page and they are displayed
    @Test(groups = {"smoke","regress"})
    public void testImages() {
        List<WebElement> images = driver.findElements(By.className("benefit-icon"));
        assertEquals(images.size(), 4);
        for (WebElement icon : images) {
            assertTrue(icon.isDisplayed());
        }
    }
}
