package manager;

import model.ContactData;
import org.openqa.selenium.By;
import tests.HelperBase;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager managerr) {
        super(managerr);
    }

    public boolean isContactPresent() {
        openHomePage();
        return managerr.isElementPresent(By.name("selected[]"));
    }

    public void createContact(ContactData contact) {
        openContactPage();
        fillContactForm(contact);
        submitContactCreation();
        returnToContactsPage();
    }

    public void removeContact() {
        openHomePage();
        selectContact();
        removeSelectedContact();
    }

    private void selectContact() {
        click(By.name("selected[]"));
    }

    private void removeSelectedContact() {
        click(By.cssSelector("[value='Delete']"));
    }

    private void returnToContactsPage() {
        click(By.linkText("home page"));
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

    private void fillContactForm(ContactData contact1) {
        type(By.name("firstname"), contact1.first_name());
        type(By.name("lastname"), contact1.last_name());
        type(By.name("address"), contact1.address());
        type(By.name("mobile"), contact1.phone_mobile());
        type(By.name("email"), contact1.email());
    }

    public void openContactPage() {
        if (!managerr.isElementPresent(By.name("firstname"))) {
            click(By.linkText("add new"));
        }
    }

    public void openHomePage() {
        click(By.linkText("home"));
    }

    public int getContactsCount() {
        openHomePage();
        return managerr.driverr.findElements(By.name("selected[]")).size();
    }
}
