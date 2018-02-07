package hwJDI.pages;

import hwJDI.entities.MetalColorFormData;
import hwJDI.form.MetalColorForm;
import hwJDI.sections.ResultSection;
import org.testng.Assert;

import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MetalsAndColorsPage extends CommonPage {
    public MetalColorForm metalColorForm;;
    private ResultSection resultSection;

    public void checkResult(MetalColorFormData metalColorFormData) {
        Set<String> actual = Pattern.compile("\n").splitAsStream(resultSection.results.getText()).collect(Collectors.toSet());
        Set<String> expected = metalColorFormData.toLog();

        Assert.assertEquals(expected, actual);
    }
}
