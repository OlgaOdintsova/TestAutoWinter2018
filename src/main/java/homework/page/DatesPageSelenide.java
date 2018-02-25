package homework.page;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static org.testng.AssertJUnit.assertEquals;

public class DatesPageSelenide {
    @FindBy(css = "title")
    private SelenideElement title;

    @FindBy(css = ".range")
    private SelenideElement slider;

    @FindBy(css = ".ui-slider-handle:nth-child(1)")
    private SelenideElement leftSlider;

    @FindBy(css = ".ui-slider-handle:nth-child(3)")
    private SelenideElement rightSlider;

    @Step("check Dates page title")
    public void checkTitle() {
        assertEquals("Dates", WebDriverRunner.getWebDriver().getTitle());
    }

    @Step("move slider: left to {0}, right to {1}")
    public void moveSlider(int left, int right) {
        int leftPosition = Integer.parseInt(leftSlider.getText());
        int rightPosition = Integer.parseInt(rightSlider.getText());

        if (leftPosition == rightPosition && leftPosition == 0) {
            moveRightSlider(right, rightPosition);
            moveLeftSlider(left, leftPosition);
        } else if (leftPosition == rightPosition && leftPosition == 100) {
            moveLeftSlider(left, leftPosition);
            moveRightSlider(right, rightPosition);
        } else {
            moveLeftSlider(left, leftPosition);
            moveRightSlider(right, rightPosition);
        }
    }

    @Step("check slider position: left {0}, right {1}")
    public void checkSliderPosition(int left, int right) {
        assertEquals(leftSlider.getText(), String.valueOf(left));
        assertEquals(rightSlider.getText(), String.valueOf(right));
    }

    private void moveLeftSlider(int left, int leftPosition) {
        int countLeft;
        if (left <= leftPosition) {
            countLeft = leftPosition - left;
            for (int i = 1; i <= countLeft; i++) {
                leftSlider.sendKeys(Keys.ARROW_LEFT);
            }
        } else {
            countLeft = left - leftPosition;
            for (int i = 1; i <= countLeft; i++) {
                leftSlider.sendKeys(Keys.ARROW_RIGHT);
            }
        }
    }

    private void moveRightSlider(int right, int rightPosition) {
        int countRight;
        if (right <= rightPosition) {
            countRight = rightPosition - right;
            for (int i = 1; i <= countRight; i++) {
                rightSlider.sendKeys(Keys.ARROW_LEFT);
            }
        } else {
            countRight = right - rightPosition;
            for (int i = 1; i <= countRight; i++) {
                rightSlider.sendKeys(Keys.ARROW_RIGHT);
            }
        }
    }
}
