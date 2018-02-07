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


    @FindBy(css = "#odds-selector p")
    private RadioButtons firstSummary;

    @FindBy(css = "#even-selector p")
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

    public void submit(MetalColorFormData mc) {
        firstSummary.select(mc.getSummary().get(0).toString());
        secondSummary.select(mc.getSummary().get(1).toString());
        mc.getElements().forEach(elements::select);
        color.select(mc.getColor());
        metals.newInput(mc.getMetals());
        vegetables.select(mc.getVegetables());

        submit.click();
    }
}
