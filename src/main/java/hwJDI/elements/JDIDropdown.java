package hwJDI.elements;

import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class JDIDropdown extends Dropdown {

    @SuppressWarnings("unchecked")
    private List<WebElement> expandGetElements() {
        expand();
        return getElements();
    }

    private void clear() {
        expandGetElements().stream()
                           .filter(element -> element.findElement(By.tagName("input")).getAttribute("selected") != null)
                           .forEach(WebElement::click);
    }

    public void select(List<String> items) {
        clear();
        items.forEach(this::select);
    }
}
