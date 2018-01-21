package homework2;

import homework.base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SmokeTest extends TestBase {

    @Test(groups = {"smoke"})
    public void test() {
        assertEquals(driver.getTitle(), "Index Page");
    }

    @Test(groups = {"smoke"})
    public void test1() {
        assertTrue(driver.findElement(By.cssSelector(".main-title")).isDisplayed());
    }

}
