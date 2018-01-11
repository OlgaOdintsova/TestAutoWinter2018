import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTestEx1 {

    //Create a new test in a new Java class, specify test name in accordance with checking functionality
    @Test
    public void testLogin(){

        //Open test site by URL
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://jdi-framework.github.io/tests");

        //Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Index Page");

    }

}
