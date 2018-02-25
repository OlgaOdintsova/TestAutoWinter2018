package homework.enums;

public enum MetalsEnum {
    METALS("metal"),
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    public String metal;

    MetalsEnum(String metal) {
        this.metal = metal;
    }

    public String getMetal() {
        return metal;
    }
}
