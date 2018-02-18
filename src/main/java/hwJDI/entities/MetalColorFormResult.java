package hwJDI.entities;

        import lombok.Value;

        import java.util.Arrays;
        import java.util.HashSet;
        import java.util.Objects;
        import java.util.Set;

@Value
public class MetalColorFormResult {

    Integer summary;
    Set<String> elements;
    String color;
    String metals;
    Set<String> vegetables;

    public static MetalColorFormResult from(MetalColorFormData data) {
        return new MetalColorFormResult(
                data.getSummary().stream().mapToInt(Integer::intValue).sum(),
                new HashSet<>(data.getElements()),
                data.getColor(),
                data.getMetals(),
                new HashSet<>(data.getVegetables())
        );
    }

    public static MetalColorFormResult from(String data) {
        Integer summary = null;
        Set<String> elements = null;
        String color = null;
        String metals = null;
        Set<String> vegetables = null;

        String[] lines = data.split("\n");
        for (String line : lines) {
            String[] parts = line.split(": ");
            switch (parts[0]) {
                case "Summary":
                    summary = Integer.valueOf(parts[1]);
                    break;

                case "Color":
                    color = parts[1];
                    break;

                case "Metal":
                    metals = parts[1];
                    break;

                case "Elements":
                    elements = new HashSet<>(Arrays.asList(parts[1].split(", ")));
                    break;

                case "Vegetables":
                    vegetables = new HashSet<>(Arrays.asList(parts[1].split(", ")));
                    break;
            }
        }
        return new MetalColorFormResult(summary, elements, color, metals, vegetables);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        MetalColorFormResult that = (MetalColorFormResult) other;
        return Objects.equals(summary, that.summary)
                && Objects.equals(elements, that.elements)
                && Objects.equals(color, that.color)
                && Objects.equals(metals, that.metals)
                && Objects.equals(vegetables, that.vegetables);
    }
}
