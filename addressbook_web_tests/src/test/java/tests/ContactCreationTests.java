package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContact() {
        app.contactt().openContactPage();
        app.contactt().createContact(new ContactData("Jason", "Born", "Paris", "+33 1 223-322", "jb@rambler.com"));
    }

    @Test
    public void canCreateContactWithEmptyName() {
        app.contactt().createContact(new ContactData().withFirstName(""));
    }

    @Test
    public void canCreateContactWithFirstNameOnly() {
        app.contactt().createContact(new ContactData().withFirstName("Jason"));
    }

    @Test
    public void canCreateGContactWithLastNameOnly() {
        app.contactt().createContact(new ContactData().withLastName("Born"));
    }

    @Test
    public void canCreateGroupWithAddressOnly() {
        app.contactt().createContact(new ContactData().withAddress("Paris"));
    }

    @Test
    public void canCreateGroupWithPhoneMobileOnly() {
        app.contactt().createContact(new ContactData().withPhoneMobile("+33 1 223-322"));
    }

    @Test
    public void canCreateGroupWithEmailOnly() {
        app.contactt().createContact(new ContactData().withEmail("jb@rambler.com"));
    }
}
