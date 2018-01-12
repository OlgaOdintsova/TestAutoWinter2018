import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumTestEx1 {

    //1 Create a new test in a new Java class, specify test name in accordance with checking functionality
    @Test
    public void testLogin() {

        //2 Open test site by URL
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://jdi-framework.github.io/tests");

        //3 Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Index Page");

        //4 Perform login
        WebElement element = driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li"));
        element.click();
        element = driver.findElement(By.id("Login"));
        element.sendKeys("epam");
        element = driver.findElement(By.id("Password"));
        element.sendKeys("1234");
        element = driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li/div/form/button"));
        element.click();

        //5 Assert User name in the left-top side of screen that user is loggined (why expect not "Piter Chailovskii"?)
        element = driver.findElement(By.cssSelector("body > div > header > div > nav > ul.uui-navigation.nav.navbar-nav.navbar-right > li > a > div > span"));
        Assert.assertEquals(element.getText(), "PITER CHAILOVSKII");

        //6 Assert Browser title (again. why?)
        Assert.assertEquals(driver.getTitle(), "Index Page");

        //7 Assert that there are 4 images on the Home Page and they are displayed
        List<WebElement> images = driver.findElements(By.className("benefit-icon"));
        Assert.assertEquals(images.size(), 4);
        for (WebElement icon: images) {
            Assert.assertTrue(icon.isDisplayed());
        }

        //8 Assert that there are 4 texts on the Home Page and check them by getting texts
        List<WebElement> texts = driver.findElements(By.className("benefit-txt"));
        Assert.assertEquals(texts.size(), 4);
        for (WebElement text: texts) {
            Assert.assertTrue(text.isDisplayed());
        }
        Assert.assertEquals(texts.get(0).getText(), "To include good practices\n" +
                                                        "and ideas from successful\n" +
                                                        "EPAM projec");
        Assert.assertEquals(texts.get(1).getText(), "To be flexible and\n" + "customizable");
        Assert.assertEquals(texts.get(2).getText(), "To be multiplatform");
        Assert.assertEquals(texts.get(3).getText(), "Already have good base\n" +
                                                        "(about 20 internal and\n" +
                                                        "some external projects),\n" +
                                                        "wish to get more…");

        //9 Assert that there are the main header and the text below it on the Home Page
        element = driver.findElement(By.cssSelector("body > div > div > main > div.main-content > h3"));
        Assert.assertTrue(element.isDisplayed());
        element = driver.findElement(By.cssSelector("body > div > div > main > div.main-content > p"));
        Assert.assertTrue(element.isDisplayed());

        //10 Close Browser
        driver.close();

    }
}
