package hwJDI.dataProviders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hwJDI.entities.MetalColorFormData;
import lombok.SneakyThrows;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;

public final class MetalColorProvider {

    private MetalColorProvider() {
    }

    @SneakyThrows
    @DataProvider(name = "getDataSet")
    public static Object[] getDataSet() {
        File dataFile = new File(MetalColorProvider.class.getResource("../../ex8_jdi_metalsColorsDataSet.json").getFile());
        Map<String, MetalColorFormData> testDataSets = new ObjectMapper().readValue(dataFile, new TypeReference<TreeMap<String, MetalColorFormData>>() {
        });
        return testDataSets.values().toArray();
    }
}
