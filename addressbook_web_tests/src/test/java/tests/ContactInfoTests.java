package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase {

    @Test
    void testPhones() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData("", "Jason", "Bourne", "Paris", "+33 1 223-322",
                    "jb@rambler.com"/*,"src/test/resources/images/avatar.jpg"*/, "Foma Kiniaev", "CIA", "treadstone.com", "223322", "", "456123", ""));
        }
        var contacts = app.hbm().getContactList();
        var contact = contacts.get(0);
        var phones = app.contacts().getPhones(contact);
        var expected = Stream.of(contact.home(), contact.mobile(), contact.work(), contact.phone2())
                .filter(s -> s != null && ! "".equals(s))
                .collect(Collectors.joining("\n"));
        Assertions.assertEquals(expected, phones);
    }
}
