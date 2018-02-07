package hwJDI.pages;

import hwJDI.entities.MetalColorFormData;
import hwJDI.form.MetalColorForm;
import hwJDI.sections.ResultSection;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class MetalsAndColorsPage extends CommonPage {
    public MetalColorForm metalColorForm;;
    public ResultSection resultSection;

    public void checkResult(MetalColorFormData metalColorFormData) {
        List<String> actual = Arrays.asList(resultSection.results.getText().split("\n"));
        List<String> expected = metalColorFormData.toLog();

        Assert.assertEquals(actual.size(), expected.size());
        for (String e : expected) {
            Assert.assertTrue(actual.contains(e));
        }
    }
}
