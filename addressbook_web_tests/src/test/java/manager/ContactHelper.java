package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
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

    public void createContactInGroup(ContactData contact GroupData group) {
        openContactPage();
        fillContactForm(contact);
        selectGroup(group);
        submitContactCreation();
    }

    private void selectGroup(GroupData group) {
        new Select(managerr.driverr.findElement(By.name("new_group"))).selectByValue(group.id());
    }

    public void removeContact(ContactData contact) {
        openHomePage();
        selectContact(contact);
        removeSelectedContact();
        returnToHomePage();
    }

    public void modifyContact(ContactData contact, ContactData modifiedContact) {
        openHomePage();
        initContactModification(contact);
        fillContactForm(modifiedContact);
        submitContactModification();
        returnToHomePage();
    }

    private void selectContact(ContactData contact) {
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

    private void returnToHomePage() {
        click(By.linkText("home"));
    }

    private void submitContactModification() {
        click(By.name("update"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.first_name());
        type(By.name("lastname"), contact.last_name());
        type(By.name("address"), contact.address());
        type(By.name("mobile"), contact.phone_mobile());
        type(By.name("email"), contact.email());
        //attach(By.name("photo"), contact.photo());
        type(By.name("nickname"), contact.nick_name());
        type(By.name("company"), contact.company());
        type(By.name("homepage"), contact.home_page());
    }

    private void initContactModification(ContactData contact) {
        click(By.cssSelector(String.format("a[href*='edit.php?id=%s']", contact.id())));
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
