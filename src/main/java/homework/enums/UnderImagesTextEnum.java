package homework.enums;

import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

public enum UnderImagesTextEnum {

    TEXT_1("To include good practices and ideas from successful EPAM projec"),
    TEXT_2("To be flexible and customizable"),
    TEXT_3("To be multiplatform"),
    TEXT_4("Already have good base (about 20 internal and some external projects), wish to get more…");

    @Getter
    private final String text;

    UnderImagesTextEnum(String text) {
        this.text = text;
    }

    public static Set<String> getExpectedText() {
        return Arrays.stream(values())
                     .map(UnderImagesTextEnum::getText)
                     .collect(Collectors.toSet());
    }
}