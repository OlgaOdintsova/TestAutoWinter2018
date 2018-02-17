package hwJDI.hw7.form;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import hwJDI.hw7.entities.MetalColorFormData;
import org.openqa.selenium.support.FindBy;

public class SummaryForm extends Form<MetalColorFormData> {

    @FindBy(css = "#odds-selector label")
    public RadioButtons oddsRadioButton;

    @FindBy(css = "#even-selector label")
    public RadioButtons evenRadioButton;

    @FindBy(css = "#calculate-button")
    private Button calculatingButton;
}
