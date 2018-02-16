package hwJDI.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    public Set<String> toLog(){
        Set<String> result = new HashSet<>();
        result.add("Summary: " + summary.stream().mapToInt(Integer::intValue).sum());
        result.add("Elements: " + elements.stream().collect(Collectors.joining(", ")));
        result.add("Color: " + color);
        result.add("Metal: " + metals);
        result.add("Vegetables: " + vegetables.stream().collect(Collectors.joining(", ")));
        return result;
    }
}
