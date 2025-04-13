package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import tests.ContactRemovingTests;
import tests.HelperBase;

import java.util.ArrayList;
import java.util.List;

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
    }

    public void removeContact(ContactData contact) {
        openHomePage();
        selectContact(contact);
        removeSelectedContact();
        returnToHomePage();
    }

    private void selectContact(ContactData contact) {
        //click(By.name("selected[]"));
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
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

    private void returnToHomePage() { click(By.linkText("home"));
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

    public List<ContactData> getList() {
        openHomePage();
        var contacts = new ArrayList<ContactData>();
        var trs = managerr.driverr.findElements(By.name("entry"));
        for (var tr : trs) {
            var first = tr.findElement(By.cssSelector("td:nth-of-type(3)")).getText();
            var last = tr.findElement(By.cssSelector("td:nth-of-type(2)")).getText();
            var checkbox = tr.findElement(By.name("selected[]"));
            var id = checkbox.getDomAttribute("value");
            contacts.add(new ContactData().withId(id).withFirstName(first).withLastName(last));
        }
        return contacts;
    }
}
