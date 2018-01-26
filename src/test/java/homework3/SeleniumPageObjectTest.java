package homework3;

import homework.page.IndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SeleniumPageObjectTest {

    private WebDriver driver;
    private IndexPage indexPage;

    @BeforeSuite
    public void setUpBrowser() {
        driver = new ChromeDriver();
        indexPage = PageFactory.initElements(driver, IndexPage.class);
        driver.manage().window().maximize();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

    //Create a new test in a new Java class, specify test name in accordance with checking functionality
    @Test
    public void checkPageFunctionality() {

        //Open test site by URL
        indexPage.open(driver);

        //Assert Browser title
        indexPage.checkTitle(driver);

        //Perform login
        indexPage.login("epam", "1234");

        //Assert User name in the left-top side of screen that user is logged
        indexPage.checkUserName();

        //Assert Browser title
        indexPage.checkTitle(driver);

        //Assert that there are 4 images on the Home Page and they are displayed
        indexPage.checkImages();

        //Assert that there are 4 texts on the Home Page and check them by getting texts
        indexPage.checkTextsUnderImages();

        //Assert that there are the main header and the text below it on the Home Page
        indexPage.checkPageContent();
    }
}

