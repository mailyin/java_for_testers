package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactRemovingTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (!app.contact().isContactPresent()) {
            app.contact().createContact(new ContactData("Jason", "Bourne", "Paris", "+33 1 223-322", "jb@rambler.com"));
        }
        app.contact().removeContact();
    }
}
