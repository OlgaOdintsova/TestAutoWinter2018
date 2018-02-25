package homework.page;

import homework.enums.PageContentTextEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Set;

import static homework.enums.UnderImagesTextEnum.getExpectedText;
import static java.util.stream.Collectors.toSet;
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
        assertTrue(images.stream().allMatch(WebElement::isDisplayed));
    }

    public void checkTextsUnderImages() {
        Set<String> actual = texts.stream()
                                  .map(WebElement::getText)
                                  .map(text -> text.replaceAll("\n", " "))
                                  .collect(toSet());

        assertEquals(getExpectedText(), actual);
        assertTrue(texts.stream().allMatch(WebElement::isDisplayed));
    }

    public void checkPageContent() {
        assertEquals(PageContentTextEnum.TEXT_HEADER.getText(), headline.getText());
        assertTrue(headline.isDisplayed());
        assertEquals(PageContentTextEnum.TEXT_CONTENT.getText(), textBelowHeadline.getText());
        assertTrue(textBelowHeadline.isDisplayed());
    }
}
