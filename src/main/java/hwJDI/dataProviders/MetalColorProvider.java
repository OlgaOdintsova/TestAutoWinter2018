package hwJDI.dataProviders;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.testng.annotations.DataProvider;

import java.io.File;

public final class MetalColorProvider {
    private MetalColorProvider() {
    }

    @SneakyThrows
    @DataProvider(name = "mcData")
    public static Object[][] mcData() {
        ObjectMapper mapper = new ObjectMapper();
        File dataFile = new File(MetalColorProvider.class.getResource("../../ex8_jdi_metalsColorsDataSet.json").getFile());
        // TODO oh really ??? What will you do in case if we have one more date set ?
        // TODO you have to modify algorithm for N cases, regardless the count of the data sets in the file, i mean !!
        // TODO this is the main point of DDT, actually. You should not modify ANYTHING except the file that contains data set.
        MetalColorFormDataSet data = mapper.readValue(dataFile, MetalColorFormDataSet.class);
        // TODO is that really necessary to return 2-dim array ?
        return new Object[][]{
                {data.getData_1()},
                {data.getData_2()},
                {data.getData_3()},
                {data.getData_4()},
                {data.getData_5()},
                {data.getData_6()}
        };
    }
}
