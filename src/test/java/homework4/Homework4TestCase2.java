package homework4;

import homework.base.SelenideBase;
import homework.listeners.AllureAttachmentListener;
import homework.page.DatesPageSelenide;
import homework.page.IndexPageSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.page;
import static homework.enums.ServiceMenuItemsEnum.ITEM_2;
import static homework.enums.UserSelenEnum.PITER;


@Listeners(AllureAttachmentListener.class)
public class Homework4TestCase2 extends SelenideBase {
    private IndexPageSelenide indexPageSelenide;
    private DatesPageSelenide datesPageSelenide;

    @BeforeClass
    public void setUp() {
        indexPageSelenide = page(IndexPageSelenide.class);
        datesPageSelenide = page(DatesPageSelenide.class);
    }

    @AfterMethod
    public void closeBrowser() {
        close();
    }

    @Title("Slider test")
    @Test
    public void testSlider() {
        //Open test site by URL
        indexPageSelenide.open();
        indexPageSelenide.checkTitle();

        //Login
        indexPageSelenide.login(PITER);

        //Assert User name in the left-top side of screen
        indexPageSelenide.checkUsername(PITER);

        //Open Service -> Dates
        indexPageSelenide.openSubMenu(ITEM_2.item);
        datesPageSelenide.checkTitle();

        //Move slider and check position
        datesPageSelenide.moveSlider(0, 100);
        datesPageSelenide.checkSliderPosition(0, 100);

        //Move slider and check position
        datesPageSelenide.moveSlider(0, 0);
        datesPageSelenide.checkSliderPosition(0, 0);

        //Move slider and check position
        datesPageSelenide.moveSlider(100, 100);
        datesPageSelenide.checkSliderPosition(100, 100);

        //Move slider and check position
        datesPageSelenide.moveSlider(30, 70);
        datesPageSelenide.checkSliderPosition(30, 70);
    }
}

