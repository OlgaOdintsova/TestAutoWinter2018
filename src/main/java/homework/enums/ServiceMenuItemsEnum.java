package homework.enums;

public enum ServiceMenuItemsEnum {

    ITEM_1("SUPPORT"),
    ITEM_2("DATES"),
    ITEM_3("COMPLEX TABLE"),
    ITEM_4("SIMPLE TABLE"),
    ITEM_5("TABLE WITH PAGES"),
    ITEM_6("DIFFERENT ELEMENTS");

    public String item;

    ServiceMenuItemsEnum(String item) {
        this.item = item;
    }
}
