package homework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

    public void open(WebDriver driver) {
        driver.navigate().to("https://jdi-framework.github.io/tests/");
    }

    public void checkTitle(WebDriver driver) {
        assertEquals(driver.getTitle(), "Index Page");
    }

    public void checkUserName() {
        assertTrue(userName.isDisplayed());
        assertTrue(userName.getText().equalsIgnoreCase("PITER CHAILOVSKII"));
    }

    public void checkImages() {
        assertEquals(images.size(), 4);
        images.forEach(list -> assertTrue(list.isDisplayed()));
    }

    public void checkTextsUnderImages() {
        assertEquals(texts.size(), 4);
        for (WebElement text : texts) {
            assertTrue(text.isDisplayed());
            assertTrue(getExpectedText().contains(text.getText().replaceAll("\n", " ")));
        }
    }

    public void checkPageContent() {
        assertTrue(getExpectedContent().contains(headline.getText()));
        assertTrue(headline.isDisplayed());
        assertTrue(getExpectedContent().contains(textBelowHeadline.getText()));
        assertTrue(textBelowHeadline.isDisplayed());
    }
}
