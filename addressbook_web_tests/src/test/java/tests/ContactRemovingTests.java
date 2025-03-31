package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactRemovingTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (!app.contactt().isContactPresent()) {
            app.contactt().createContact(new ContactData("Jason", "Born", "Paris", "+33 1 223-322", "jb@rambler.com"));
        }
        app.contactt().removeContact();
    }
}
