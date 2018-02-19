package hwJDI.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MetalColorFormData {
    public static final MetalColorFormData DEFAULT = new MetalColorFormData(
            Arrays.asList(3, 8),
            Arrays.asList("Water", "Fire"),
            "Red",
            "Selen",
            Arrays.asList("Cucumber", "Tomato")
    );

    private List<Integer> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;
}
