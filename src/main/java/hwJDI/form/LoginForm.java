package hwJDI.form;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import hwJDI.entities.User;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends Form<User>{

    @FindBy(css = "#Login")
    private TextField login;

    @FindBy(css = "#Password")
    private TextField password;

    @FindBy(css = ".profile-photo span")
    private Text profileInfo;

    @FindBy(css = "[type=submit]")
    private Button enter;
}
