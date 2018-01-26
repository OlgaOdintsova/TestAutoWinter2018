package homework2;

import homework.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;


public class DPTest extends TestBase {

    private WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void setUp() {
        driver.navigate().to("https://jdi-framework.github.io/tests");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    @DataProvider(parallel = true)
    public Object[][] dp() {
        return new Object[][] {
                {0, "To include good practices and ideas from successful EPAM projec"},
                {1, "To be flexible and customizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base (about 20 internal and some external projects), wish to get more…"}
        };
    }

    @Test(dataProvider = "dp")
    public void assertTextsWithDPTest(int index, String text) {
        List<WebElement> elements = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(elements.get(index).getText().replaceAll("\n", " "), text);
    }
}
