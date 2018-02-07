package hwJDI.enumJDI;

public enum HeaderMenuEnum {
    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE("Service"),
    METALS_AND_COLORS("Metals & Colors");

    public final String page;

    HeaderMenuEnum(String page) {
        this.page = page;
    }
}
