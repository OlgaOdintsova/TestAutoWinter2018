package homework.emun;

import java.util.ArrayList;
import java.util.List;

public enum UnderImagesTextEnum {

    TEXT_1("To include good practices and ideas from successful EPAM projec"),
    TEXT_2("To be flexible and customizable"),
    TEXT_3("To be multiplatform"),
    TEXT_4("Already have good base (about 20 internal and some external projects), wish to get more…");

    public String text;
    private static List<String> textsEnum;

    UnderImagesTextEnum(String text) {
        this.text = text;
    }

    public static List<String> getExpectedText() {
        textsEnum = new ArrayList<>();
        textsEnum.add(TEXT_1.text);
        textsEnum.add(TEXT_2.text);
        textsEnum.add(TEXT_3.text);
        textsEnum.add(TEXT_4.text);
        return textsEnum;
    }
}
