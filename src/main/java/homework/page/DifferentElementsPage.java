package homework.page;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import homework.enums.ColorsEnum;
import homework.enums.ElementEnum;
import homework.enums.MetalsEnum;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class DifferentElementsPage {
    @FindBy(css = "title")
    private SelenideElement title;

    @FindBy(css = ".label-checkbox")
    private List<SelenideElement> checkboxesList;

    @FindBy(css = ".label-radio")
    private List<SelenideElement> radioButtonList;

    @FindBy(css = ".colors")
    private SelenideElement colorsDropdown;

    @FindBy(css = "[name='Default Button']")
    private SelenideElement defaultButton;

    @FindBy(css = "[value='Button']")
    private SelenideElement button;

    @FindBy(css = "#mCSB_1")
    private SelenideElement leftSection;

    @FindBy(css = "aside:nth-child(3) > div")
    private SelenideElement rightSection;

    @FindBy(css = ".panel-body-list.logs li")
    private List<SelenideElement> logPanelList;

    @Step("check Different Element page title")
    public void checkTitle() {
        assertEquals("Different Element", WebDriverRunner.getWebDriver().getTitle());
    }

    @Step("check interface on Different Elements Page")
    public void checkDifferentElements() {
        assertEquals(checkboxesList.size(), 4);
        assertEquals(radioButtonList.size(), 4);
        for (int i = 1; i < 4; i++) {
            checkboxesList.get(i).should(visible);
            radioButtonList.get(i).should(visible);
        }
        colorsDropdown.should(visible);

        defaultButton.should(visible);
        assertEquals(defaultButton.getText(), "DEFAULT BUTTON");
        button.should(visible);
        assertEquals(button.val().toUpperCase(), "BUTTON");

        leftSection.should(visible);
        rightSection.should(visible);
    }

    @Step("select checkbox with {0} text and check that it's checked")
    public void checkCertainCheckBoxChecked(ElementEnum elementEnum) {
        for (SelenideElement aCheckboxesList : checkboxesList) {
            if (aCheckboxesList.getText().equals(elementEnum.element)) {
                aCheckboxesList.click();
                aCheckboxesList.find("input").should(checked);
            }
            aCheckboxesList.should(visible);
        }
    }

    @Step("unselect checkbox with {0} text and check that it's unchecked")
    public void checkCertainCheckBoxUnchecked(ElementEnum text) {
        for (SelenideElement aCheckboxesList : checkboxesList) {
            if (aCheckboxesList.getText().equals(text.element)) {
                aCheckboxesList.click();
                aCheckboxesList.find("input").shouldNot(checked);
            }
            aCheckboxesList.should(visible);
        }
    }

    @Step("select radio with {0} text and check that it's checked")
    public void checkCertainRadioBox(MetalsEnum metalsEnum) {
        for (SelenideElement aRadioButtonList : radioButtonList) {
            if (aRadioButtonList.getText().equals(metalsEnum.metal)) {
                aRadioButtonList.click();
                aRadioButtonList.find("input").should(checked);
            }
            aRadioButtonList.should(visible);
        }
    }

    @Step("select dropdown with {0} text")
    public void selectDropDown(ColorsEnum colorsEnum) {
        colorsDropdown.click();
        List<SelenideElement> dropDownList = $$(".colors option");
        for (SelenideElement aDropDownList : dropDownList) {
            if (aDropDownList.getText().equals(colorsEnum.color)) {
                aDropDownList.click();
            }
        }
    }

    @Step("check logs for checkbox: value {0} flag {1} index {2}")
    public void checkLogsForCheckBox(String value, boolean flag, int index) {
        assertTrue(logPanelList.get(index).getText().contains(value));
        assertTrue(logPanelList.get(index).getText().contains(String.valueOf(flag)));
    }

    @Step("check logs for radio and dropdown: value1 {0} value2 {1} index {2}")
    public void checkLogsForRadioAndDropDown(String value1, String value2, int index) {
        assertTrue(logPanelList.get(index).getText().contains(value1));
        assertTrue(logPanelList.get(index).getText().contains(value2));
    }
}
