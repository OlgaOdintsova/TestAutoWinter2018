package hwJDI.hw7.enumJDI;

public enum HeaderMenuEnum {
    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE("Service"),
    SERVICE_SUPPORT("Service|Support"),
    SERVICE_DATES("Service|Dates"),
    SERVICE_COMPLEX_TABLE("Service|Complex Table"),
    SERVICE_SIMPLE_TABLE("Service|Simple Table"),
    SERVICE_USER_TABLE("Service|User Table"),
    SERVICE_TABLE_WITH_PAGES("Service|Table with pages"),
    SERVICE_DIFFERENT_ELEMENTS("Service|Different elements"),
    METALS_AND_COLORS("Metals & Colors");

    public final String page;

    HeaderMenuEnum(String page) {
        this.page = page;
    }
}
