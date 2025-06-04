package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import tests.HelperBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    public void createContactInGroup(ContactData contact, GroupData group) {
        openContactPage();
        fillContactForm(contact);
        selectGroup(group);
        submitContactCreation();
    }

    public void selectGroup(GroupData group) {
        new Select(managerr.driverr.findElement(By.name("new_group"))).selectByValue(group.id());
    }

    public void removeContact(ContactData contact) {
        openHomePage();
        selectContact(contact);
        removeSelectedContact();
        returnToHomePage();
    }

    public void addContactToGroup(ContactData contact, GroupData group) {
        openHomePage();
        //selectGroupFilter();
        selectContact(contact);
        selectGroupToAdd(group);
        addSelectedContactToGroup(group);
        returnToHomePage();
    }

    public void removeContactFromGroup(ContactData contact, GroupData group) {
        openHomePage();
        selectGroupsFilter(group);
        selectContact(contact);
        removeSelectedContactFromGroup();
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

    private void selectGroupFilter() {
        new Select(managerr.driverr.findElement(By.name("group"))).selectByValue("[none]");
    }

    private void selectGroupToAdd(GroupData group) {
        new Select(managerr.driverr.findElement(By.name("to_group"))).selectByValue(group.id());
    }

    private void addSelectedContactToGroup(GroupData group) {
        click(By.name("add"));
    }

    private void selectGroupsFilter(GroupData group) {
        new Select(managerr.driverr.findElement(By.name("group"))).selectByValue(group.id());
    }

    private void removeSelectedContact() {
        click(By.cssSelector("[value='Delete']"));
    }

    private void removeSelectedContactFromGroup() {
        click(By.name("remove"));
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
        //type(By.name("mobile"), contact.phone_mobile());
        type(By.name("email"), contact.email());
        type(By.name("email2"), contact.email2());
        type(By.name("email3"), contact.email3());
        //attach(By.name("photo"), contact.photo());
        type(By.name("nickname"), contact.nick_name());
        type(By.name("company"), contact.company());
        type(By.name("homepage"), contact.home_page());
        type(By.name("home"), contact.home());
        type(By.name("mobile"), contact.mobile());
        type(By.name("work"), contact.work());
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

    public String getPhones(ContactData contact) {
        return managerr.driverr.findElement(By.xpath(
                String.format("//input[@id='%s']/../../td[6]", contact.id()))).getText();
    }

    public Object getAddress() {
        var result = new HashMap<String, String>();
        List<WebElement> rows = managerr.driverr.findElements(By.name("entry"));
        for (WebElement row : rows) {
            var id = row.findElement(By.tagName("input")).getDomAttribute("id");
            var address = row.findElements(By.tagName("td")).get(3).getText();
            result.put(id, address);
        }
        return result;
    }

    public Object getEmails() {
        var result = new HashMap<String, String>();
        List<WebElement> rows = managerr.driverr.findElements(By.name("entry"));
        for (WebElement row : rows) {
            var id = row.findElement(By.tagName("input")).getDomAttribute("id");
            var emails = row.findElements(By.tagName("td")).get(4).getText();
            result.put(id, emails);
        }
        return result;
    }

    public Map<String, String> getPhones() {
        var result = new HashMap<String, String>();
        List<WebElement> rows = managerr.driverr.findElements(By.name("entry"));
        for (WebElement row : rows) {
            var id = row.findElement(By.tagName("input")).getDomAttribute("id");
            var phones = row.findElements(By.tagName("td")).get(5).getText();
            result.put(id, phones);
        }
        return result;
    }
}
