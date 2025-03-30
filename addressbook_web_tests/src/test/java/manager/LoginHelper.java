package manager;

import org.openqa.selenium.By;
import tests.HelperBase;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager managerr) {
        super(managerr);
    }

    void loginn(String user, String password) {
        type(By.name("user"), user);
        type(By.name("pass"), password);
        click(By.xpath("//input[@value=\'Login\']"));
    }
}
