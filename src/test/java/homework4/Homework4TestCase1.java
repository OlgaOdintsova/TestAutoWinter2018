package homework4;

import homework.base.SelenideBase;
import homework.enums.ServiceMenuItemsEnum;
import homework.listeners.AllureAttachmentListener;
import homework.page.DifferentElementsPage;
import homework.page.IndexPageSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.page;
import static homework.enums.ColorsEnum.COLORS;
import static homework.enums.ColorsEnum.YELLOW;
import static homework.enums.MetalsEnum.METALS;
import static homework.enums.MetalsEnum.SELEN;
import static homework.enums.ElementEnum.WATER;
import static homework.enums.ElementEnum.WIND;
import static homework.enums.ServiceMenuItemsEnum.ITEM_6;
import static homework.enums.UserEnum.PITER;


@Listeners(AllureAttachmentListener.class)
public class Homework4TestCase1 extends SelenideBase {
    private IndexPageSelenide indexPageSelenide;
    private DifferentElementsPage differentElementsPage;

    @BeforeClass
    public void setUp() {
        indexPageSelenide = page(IndexPageSelenide.class);
        differentElementsPage = page(DifferentElementsPage.class);
    }

    @AfterMethod
    public void closeBrowser() {
        close();
    }

    @Title("DifferentElements test")
    @Test
    public void testDifferentElements() {

        indexPageSelenide.open();
        indexPageSelenide.checkTitle();

        //Login
        indexPageSelenide.login(PITER);

        //Assert User name in the left-top side of screen
        indexPageSelenide.checkUsername(PITER);
        indexPageSelenide.checkTitle();

        //Check interface on Home page
        indexPageSelenide.checkHomePageInterface();

        //In the header check that drop down contains options
        indexPageSelenide.checkHeaderSubMenu(ServiceMenuItemsEnum.values());

        //In the left section check that dropdown contains options
        indexPageSelenide.checkLeftSubMenu(ServiceMenuItemsEnum.values());

        //Open through the header menu Service -> Different Elements Page
        indexPageSelenide.openSubMenu(ITEM_6.item);
        differentElementsPage.checkTitle();

        //Check interface on Different Elements Page
        differentElementsPage.checkDifferentElements();

        //Select checkboxes
        differentElementsPage.checkCertainCheckBoxChecked(WATER);
        differentElementsPage.checkCertainCheckBoxChecked(WIND);

        //Select radio
        differentElementsPage.checkCertainRadioBox(SELEN);

        //Select dropdown
        differentElementsPage.selectDropDown(YELLOW);

        //Check in logs section selected values
        differentElementsPage.checkLogsForCheckBox(WATER.element, true, 3);
        differentElementsPage.checkLogsForCheckBox(WIND.element, true, 2);
        differentElementsPage.checkLogsForRadioAndDropDown(METALS.metal, SELEN.metal, 1);
        differentElementsPage.checkLogsForRadioAndDropDown(COLORS.color, YELLOW.color, 0);

        //Unselect checkboxes
        differentElementsPage.checkCertainCheckBoxUnchecked(WATER);
        differentElementsPage.checkCertainCheckBoxUnchecked(WIND);

        //Check in logs section unselected values
        differentElementsPage.checkLogsForCheckBox(WATER.element, false, 1);
        differentElementsPage.checkLogsForCheckBox(WIND.element, false, 0);
    }
}
