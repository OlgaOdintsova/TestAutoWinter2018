package hwJDI.pages;

import hwJDI.entities.MetalColorFormData;
import hwJDI.entities.MetalColorFormResult;
import hwJDI.form.MetalColorForm;
import hwJDI.sections.ResultSection;

import static org.junit.Assert.assertEquals;

public class MetalsAndColorsPage extends CommonPage {
    public MetalColorForm metalColorForm;
    private ResultSection resultSection;

    public void checkResult(MetalColorFormData data) {
        MetalColorFormResult expected = MetalColorFormResult.from(data);
        MetalColorFormResult actual = MetalColorFormResult.from(resultSection.results.getText());

        assertEquals(expected, actual);
    }
}
