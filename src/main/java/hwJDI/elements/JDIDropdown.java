package hwJDI.elements;

import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Objects;


public class JDIDropdown extends Dropdown {

    @SuppressWarnings("unchecked")
    private List<WebElement> expandGetElements() {
        expand();
        return getElements();
    }

    private void clear() {
        expandGetElements().stream()
                           .filter(element -> !Objects.isNull(element.findElement(By.tagName("input")).getAttribute("selected")))
                           .forEach(WebElement::click);
    }

    public void select(List<String> items) {
        clear();
        items.forEach(this::select);
    }
}
