package hwJDI.form;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import hwJDI.elements.JDIDropdown;
import hwJDI.entities.MetalColorFormData;
import org.openqa.selenium.support.FindBy;

public class MetalColorForm extends Form<MetalColorFormData> {


    @FindBy(css = "#odds-selector label")
    private RadioButtons firstSummary;

    @FindBy(css = "#even-selector label")
    private RadioButtons secondSummary;

    @FindBy(css = ".vertical-group p label")
    private CheckList elements;

    @JDropdown(
            jroot = @JFindBy(css = ".colors"),
            jlist = @JFindBy(tagName = "li"),
            jvalue = @JFindBy(css = ".filter-option")
    )
    private Dropdown color;

    @FindBy(css = "[jtype='combobox'] input")
    private TextField metals;

    @JDropdown(
            root = @FindBy(id = "salad-dropdown"),
            list = @FindBy(tagName = "li"),
            value = @FindBy(tagName = "button")
    )
    private JDIDropdown vegetables;

    @FindBy(id = "submit-button")
    private Button submit;

    public void submit(MetalColorFormData mcData) {

        // TODO you should check the data field in certain UI element
        if (!mcData.getSummary().isEmpty()) {
            firstSummary.select(mcData.getSummary().get(0).toString());
            secondSummary.select(mcData.getSummary().get(1).toString());
        }
        mcData.getElements().forEach(elements::select);
        if (!mcData.getColor().isEmpty()) {
            color.select(mcData.getColor());
        }
        if (!mcData.getMetals().isEmpty()) {
            metals.newInput(mcData.getMetals());
        }

        vegetables.select(mcData.getVegetables()); // <-- TODO for the example. Take a look on JDIDropdown::select

        submit.click();
    }
}
