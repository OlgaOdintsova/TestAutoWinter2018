package homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class SeleniumEx1RefactorTest {

    private static WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {

        setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void checkDriverAfterSuite() {
        if (driver.toString().contains("null")) {
            driver.quit();
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void setWindowSize() {
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void notificationAfterMetod() {
        System.out.println(System.currentTimeMillis());
        System.out.println("AfterMethod annotation worked");
    }

    @BeforeTest
    public void navigateBrowser() {
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
        System.out.println(driver.getTitle());
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        System.out.println("AfterTest annotation worked");
    }

    //Create a new test in a new Java class, specify test name in accordance with checking functionality
    @Test
    public void testPageLogin() {

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
        assertEquals(texts.get(0).getText(), "To include good practices\n" + "and ideas from successful\n" + "EPAM projec");
        assertEquals(texts.get(1).getText(), "To be flexible and\n" + "customizable");
        assertEquals(texts.get(2).getText(), "To be multiplatform");
        assertEquals(texts.get(3).getText(), "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…");

        //Assert that there are the main header and the text below it on the Home Page
        assertTrue(driver.findElement(By.cssSelector(".main-title")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector(".main-txt")).isDisplayed());
    }
}
