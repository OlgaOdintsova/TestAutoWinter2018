package homework.enums;

public enum ElementEnum {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    public String element;

    ElementEnum(String element) {
        this.element = element;
    }

    public String getElement() {
        return element;
    }
}
