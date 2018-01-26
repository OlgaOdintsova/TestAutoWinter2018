package homework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static homework.emun.PageContentTextEnum.TEXT_CONTENT;
import static homework.emun.PageContentTextEnum.TEXT_HEADER;
import static homework.emun.PageContentTextEnum.getExpectedContent;
import static homework.emun.UnderImagesTextEnum.getExpectedText;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IndexPage {

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

    private WebElement getUserName() {
        return userName;
    }

    private List<WebElement> getImages() {
        return images;
    }

    private WebElement getHeadline() {
        return headline;
    }

    private WebElement getTextBelowHeadline() {
        return textBelowHeadline;
    }

    public void open(WebDriver driver) {
        driver.navigate().to("https://jdi-framework.github.io/tests/");
    }

    public void checkTitle(WebDriver driver) {
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
        assertEquals(texts.size(), 4);
        for (WebElement text : texts) {
            assertTrue(text.isDisplayed());
            assertTrue(getExpectedText().contains(text.getText().replaceAll("\n", " ")));
        }
    }

    public void checkPageContent() {
        assertTrue(getExpectedContent().contains(getHeadline().getText()));
        assertTrue(getHeadline().isDisplayed());
        assertTrue(getExpectedContent().contains(getTextBelowHeadline().getText()));
        assertTrue(getTextBelowHeadline().isDisplayed());
    }
}
