package homework.emun;

import java.util.ArrayList;
import java.util.List;

public enum PageContentTextEnum {

    TEXT_HEADER("EPAM FRAMEWORK WISHES…"),
    TEXT_CONTENT("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING " +
            "ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, " +
            "QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE " +
            "IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

    public String text;
    private static List<String> contentEnum;

    PageContentTextEnum(String text) {
        this.text = text;
    }

    public static List<String> getExpectedContent() {
        contentEnum = new ArrayList<>();
        contentEnum.add(TEXT_HEADER.text);
        contentEnum.add(TEXT_CONTENT.text);
        return contentEnum;
    }
}
