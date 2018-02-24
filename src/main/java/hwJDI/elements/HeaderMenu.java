package hwJDI.elements;

import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import hwJDI.enumJDI.HeaderMenuEnum;

public class HeaderMenu extends Menu<HeaderMenuEnum> {

    public void selectOnMenu(HeaderMenuEnum menuElement) {
        String[] parts = menuElement.page.split("\\|");
        select(parts[0]);
        if (parts.length == 2) {
            select(parts[1]);
        }
    }
}
