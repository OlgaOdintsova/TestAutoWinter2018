package homework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IndexPage {
    private WebDriver driver;

    @FindBy(css = ".uui-profile-menu .dropdown-toggle")
    private WebElement loginFromButton;

    @FindBy(css = "#Login")
    private WebElement loginInput;

    @FindBy(css = "#Password")
    private WebElement passwordInput;

    @FindBy(css = ".btn-login")
    private WebElement submitButton;

    @FindBy(css = ".profile-photo")
    private WebElement userName;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> images;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> texts;

    @FindBy(css = ".main-title")
    private WebElement headline;

    @FindBy(css = ".main-txt")
    private WebElement textBelowHeadline;

    public void login(String name, String password) {
        loginFromButton.click();
        loginInput.sendKeys(name);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    public WebElement getUserName() {
        return userName;
    }

    public List<WebElement> getImages() {
        return images;
    }

    public WebElement getHeadline() {
        return headline;
    }

    public WebElement getTextBelowHeadline() {
        return textBelowHeadline;
    }

    public void open(String url, WebDriver driver) {
        driver.navigate().to(url);
        this.driver = driver;
    }

    public void checkTitle() {
        assertEquals(driver.getTitle(), "Index Page");
    }

    public void checkUserName() {
        assertTrue(getUserName().isDisplayed());
        assertTrue(getUserName().getText().equalsIgnoreCase("PITER CHAILOVSKII"));
    }

    public void checkImages() {
        assertEquals(getImages().size(), 4);
        getImages().forEach(list -> assertTrue(list.isDisplayed()));
    }

    public void checkTextsUnderImages() {
        List<WebElement> texts = driver.findElements(By.className("benefit-txt"));
        assertEquals(texts.size(), 4);
        for (WebElement text : texts) {
            assertTrue(text.isDisplayed());
        }
        assertEquals(texts.get(0).getText(), "To include good practices\n" + "and ideas from successful\n" + "EPAM projec");
        assertEquals(texts.get(1).getText(), "To be flexible and\n" + "customizable");
        assertEquals(texts.get(2).getText(), "To be multiplatform");
        assertEquals(texts.get(3).getText(), "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…");

    }

    public void checkPageContent() {
        assertEquals(getHeadline().getText(), "EPAM FRAMEWORK WISHES…");
        assertTrue(getHeadline().isDisplayed());
        assertEquals(getTextBelowHeadline().getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING " +
                        "ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, " +
                        "QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE " +
                        "IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
        assertTrue(getTextBelowHeadline().isDisplayed());
    }
}
