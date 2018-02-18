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
        MetalColorFormDataSet data = mapper.readValue(dataFile, MetalColorFormDataSet.class);
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
