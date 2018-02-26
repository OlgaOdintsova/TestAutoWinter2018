package homework.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import homework.enums.PageContentTextEnum;
import homework.enums.ServiceMenuItemsEnum;
import homework.enums.UserEnum;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.Condition.visible;
import static homework.enums.UnderImagesTextEnum.getExpectedText;
import static java.util.stream.Collectors.toSet;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class IndexPageSelenide {
    @FindBy(css = ".profile-photo")
    private SelenideElement loginFormButton;

    @FindBy(css = "#Login")
    private SelenideElement loginInput;

    @FindBy(css = "#Password")
    private SelenideElement passwordInput;

    @FindBy(css = ".uui-button.dark-blue.btn-login")
    private SelenideElement submitButton;

    @FindBy(css = ".benefit-icon")
    private List<SelenideElement> images;

    @FindBy(css = ".benefit-txt")
    private List<SelenideElement> texts;

    @FindBy(css = ".main-title.text-center")
    private SelenideElement headline;

    @FindBy(css = ".main-txt.text-center")
    private SelenideElement textBelowHeadline;

    @FindBy(css = "title")
    private SelenideElement title;

    @FindBy(css = ".sub-menu>a")
    private SelenideElement leftMenuServiceButton;

    @FindBy(css = ".sub-menu > ul > li")
    private List<SelenideElement> leftMenuServiceCategories;

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8 :nth-child(3)")
    private SelenideElement headerMenuServiceButton;

    @FindBy(css = "ul[role] :nth-child(1)")
    private List<SelenideElement> headerMenuServiceCategories;

    @FindBy(css = "[href='page8.htm']")
    private SelenideElement differentElementsButton;

    @FindBy(css = "[href='page4.htm']")
    private SelenideElement dataButton;
    private List<String> serviceList;


    @Step("open site")
    public void open() {
        Selenide.open("https://jdi-framework.github.io/tests");
    }

    @Step("check Home page title")
    public void checkTitle() {
        assertEquals("Index Page", WebDriverRunner.getWebDriver().getTitle());
    }

    @Step("login with {0}")
    public void login(UserEnum user) {
        loginFormButton.click();
        loginInput.sendKeys(user.getLogin());
        passwordInput.sendKeys(user.getPassword());
        submitButton.click();
    }

    @Step("check userName")
    public void checkUsername(UserEnum user) {
        assertEquals(user.getUserName(), loginFormButton.getText());
    }

    @Step("check images on Home page")
    private void checkImages() {
        Assert.assertEquals(images.size(), 4);
        assertTrue(images.stream().allMatch(SelenideElement::isDisplayed));
    }

    @Step("check main text on Home page")
    private void checkPageContent() {
        Assert.assertEquals(PageContentTextEnum.TEXT_HEADER.getText(), headline.getText());
        assertTrue(headline.isDisplayed());
        Assert.assertEquals(PageContentTextEnum.TEXT_CONTENT.getText(), textBelowHeadline.getText());
        assertTrue(textBelowHeadline.isDisplayed());
    }

    @Step("check text under images on Home page")
    private void checkTextsUnderImages() {
        Set<String> actual = texts.stream()
                                  .map(SelenideElement::getText)
                                  .map(text -> text.replaceAll("\n", " "))
                                  .collect(toSet());

        Assert.assertEquals(getExpectedText(), actual);
        assertTrue(texts.stream().allMatch(SelenideElement::isDisplayed));
    }

    @Step("check Home Page interface")
    public void checkHomePageInterface() {
        checkImages();
        checkTextsUnderImages();
        checkPageContent();
    }

    @Step("check HeaderSubMenu has all elements")
    public void checkHeaderSubMenu(ServiceMenuItemsEnum[] items) {
        headerMenuServiceButton.click();
        for (int i = 0; i < items.length; i++) {
            headerMenuServiceCategories.get(i).should(visible);
            assertEquals(items[i - 1].item, headerMenuServiceCategories.get(i).getText());
        }
    }

    @Step("check LeftSubMenu has all elements")
    public void checkLeftSubMenu(ServiceMenuItemsEnum[] items) {
        leftMenuServiceButton.click();
        for (int i = 0; i < items.length; i++) {
            leftMenuServiceCategories.get(i).should(visible);
            leftMenuServiceCategories.get(i).should(Condition.text(items[i].item));
        }
    }

    @Step("open SubMenu with {0}")
    public void openSubMenu(String sumMenutext) {
        headerMenuServiceButton.click();
        for (int i = 0; i < headerMenuServiceCategories.size(); i++) {
            if (sumMenutext.equals(headerMenuServiceCategories.get(i).getText())) {
                headerMenuServiceCategories.get(i).click();
            }
        }
    }
}
