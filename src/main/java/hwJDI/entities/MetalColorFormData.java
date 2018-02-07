package hwJDI.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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

    public List<String> toLog() {
        return new LinkedList<String>() {{
            add(String.format("Summary: %s", summary.stream().mapToInt(Integer::new).sum()));
            add(String.format("Elements: %s", elements.stream().collect(Collectors.joining(", "))));
            add(String.format("Color: %s", color));
            add(String.format("Metal: %s", metals));
            add(String.format("Vegetables: %s", vegetables.stream().collect(Collectors.joining(", "))));
        }};
    }
}



//public class MetalColorFormData extends DataClass {
//
//    public String oddsRadioButton;
//    public String evenRadioButton;
//    public String colorDropdown;
//    public String metalDropdown;
//    public String[] elements;
//    public String[] vegetables;
//
//    public MetalColorFormData(DataUpdate newData) {
//        this.oddsRadioButton = newData.oddsRadioButton;
//        this.evenRadioButton = newData.evenRadioButton;
//        this.colorDropdown = newData.colorDropdown;
//        this.metalDropdown = newData.metalDropdown;
//        this.elements = newData.elements;
//        this.vegetables = newData.vegetables;
//    }
//}
