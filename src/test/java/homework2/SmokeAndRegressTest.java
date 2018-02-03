package homework2;

import homework.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SmokeAndRegressTest extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to("https://jdi-framework.github.io/tests");
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

    @Test(groups = {"smoke"})
    public void testSmokePageLogin() {

        //Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");

        //Perform login
        driver.findElement(By.cssSelector(".uui-profile-menu")).click();
        driver.findElement(By.id("Login")).sendKeys("epam");
        driver.findElement(By.id("Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".fa-sign-in")).click();

        //Assert User name in the left-top side of screen that user is loggined;
        assertEquals(driver.findElement(By.cssSelector(".profile-photo")).getText(), "PITER CHAILOVSKII");

        //Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");

        //Assert that there are 4 images on the Home Page and they are displayed
        List<WebElement> images = driver.findElements(By.className("benefit-icon"));
        assertEquals(images.size(), 4);
        for (WebElement icon : images) {
            assertTrue(icon.isDisplayed());
        }

        //Assert that there are 4 texts on the Home Page and check them by getting texts
        List<WebElement> texts = driver.findElements(By.className("benefit-txt"));
        assertEquals(texts.size(), 4);
        for (WebElement text : texts) {
            assertTrue(text.isDisplayed());
        }
        assertEquals("To include good practices\n" + "and ideas from successful\n" + "EPAM projec", texts.get(0).getText());
        assertEquals("To be flexible and\n" + "customizable", texts.get(1).getText());
        assertEquals("To be multiplatform", texts.get(2).getText());
        assertEquals("Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…", texts.get(3).getText());

        //Assert that there are the main header and the text below it on the Home Page
        assertTrue(driver.findElement(By.cssSelector(".main-title")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector(".main-txt")).isDisplayed());
    }

    @Test(groups = {"regress"})
    public void testRegressPageLogin() {

        //Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");

        //Perform login
        driver.findElement(By.cssSelector(".uui-profile-menu")).click();
        driver.findElement(By.id("Login")).sendKeys("epam");
        driver.findElement(By.id("Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".fa-sign-in")).click();

        //Assert User name in the left-top side of screen that user is loggined;
        assertEquals(driver.findElement(By.cssSelector(".profile-photo")).getText(), "PITER CHAILOVSKII");

        //Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");

        //Assert that there are 4 images on the Home Page and they are displayed
        List<WebElement> images = driver.findElements(By.className("benefit-icon"));
        assertEquals(images.size(), 4);
        for (WebElement icon : images) {
            assertTrue(icon.isDisplayed());
        }

        //Assert that there are 4 texts on the Home Page and check them by getting texts
        List<WebElement> texts = driver.findElements(By.className("benefit-txt"));
        assertEquals(texts.size(), 4);
        for (WebElement text : texts) {
            assertTrue(text.isDisplayed());
        }
        assertEquals("To include good practices\n" + "and ideas from successful\n" + "EPAM projec", texts.get(0).getText());
        assertEquals("To be flexible and\n" + "customizable", texts.get(1).getText());
        assertEquals("To be multiplatform", texts.get(2).getText());
        assertEquals("Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…", texts.get(3).getText());

        //Assert that there are the main header and the text below it on the Home Page
        assertTrue(driver.findElement(By.cssSelector(".main-title")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector(".main-txt")).isDisplayed());
    }

    @Test(groups = {"smoke","regress"})
    public void testBothPageLogin() {

        //Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");

        //Perform login
        driver.findElement(By.cssSelector(".uui-profile-menu")).click();
        driver.findElement(By.id("Login")).sendKeys("epam");
        driver.findElement(By.id("Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".fa-sign-in")).click();

        //Assert User name in the left-top side of screen that user is loggined;
        assertEquals(driver.findElement(By.cssSelector(".profile-photo")).getText(), "PITER CHAILOVSKII");

        //Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");

        //Assert that there are 4 images on the Home Page and they are displayed
        List<WebElement> images = driver.findElements(By.className("benefit-icon"));
        assertEquals(images.size(), 4);
        for (WebElement icon : images) {
            assertTrue(icon.isDisplayed());
        }

        //Assert that there are 4 texts on the Home Page and check them by getting texts
        List<WebElement> texts = driver.findElements(By.className("benefit-txt"));
        assertEquals(texts.size(), 4);
        for (WebElement text : texts) {
            assertTrue(text.isDisplayed());
        }
        assertEquals("To include good practices\n" + "and ideas from successful\n" + "EPAM projec", texts.get(0).getText());
        assertEquals("To be flexible and\n" + "customizable", texts.get(1).getText());
        assertEquals("To be multiplatform", texts.get(2).getText());
        assertEquals("Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…", texts.get(3).getText());

        //Assert that there are the main header and the text below it on the Home Page
        assertTrue(driver.findElement(By.cssSelector(".main-title")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector(".main-txt")).isDisplayed());
    }
}
