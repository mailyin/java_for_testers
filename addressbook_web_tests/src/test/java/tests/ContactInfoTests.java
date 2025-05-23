package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase {


    @Test
    void testAddress() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData("", "Jason", "Bourne", "Paris",
                    "jb@rambler.com"/*,"src/test/resources/images/avatar.jpg"*/, "jb@google.com", "jb@mail.ru", "treadstone.com", "223322", "", "456123", "Foma Kiniaev", "CIA"));
        }
        var contacts = app.hbm().getContactList();
        var expected = contacts.stream().collect(Collectors.toMap(contact -> contact.id(), contact ->
                Stream.of(contact.address())
                        .filter(s -> s != null && !"".equals(s))
                        .collect(Collectors.joining("\n"))
        ));
        var address = app.contacts().getAddress();
        Assertions.assertEquals(expected, address);
    }

    @Test
    void testEmails() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData("", "Jason", "Bourne", "Paris", "jb@rambler.com"
                    /*,"src/test/resources/images/avatar.jpg"*/, "jb@google.com", "jb@mail.ru", "treadstone.com",
                    "223322", "555555", "456123", "Foma Kiniaev", "CIA"));
        }
        app.contacts().openHomePage();
        var contacts = app.hbm().getContactList();
        var expected = contacts.stream().collect(Collectors.toMap(contact -> contact.id(), contact ->
                Stream.of(contact.email(), contact.email2(), contact.email3())
                        .filter(s -> s != null && !"".equals(s))
                        .collect(Collectors.joining("\n"))
        ));
        var emails = app.contacts().getEmails();
        Assertions.assertEquals(expected, emails);
    }

    @Test
    void testPhones() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData("", "Jason", "Bourne", "Paris",
                    "jb@rambler.com"/*,"src/test/resources/images/avatar.jpg"*/, "jb@google.com", "jb@mail.ru", "treadstone.com", "223322", "349242", "456123", "Foma Kiniaev", "CIA"));
        }
        app.contacts().openHomePage();
        var contacts = app.hbm().getContactList();
        var expected = contacts.stream().collect(Collectors.toMap(contact -> contact.id(), contact ->
                Stream.of(contact.home(), contact.mobile(), contact.work())
                        .filter(s -> s != null && !"".equals(s))
                        .collect(Collectors.joining("\n"))
        ));
        var phones = app.contacts().getPhones();
        Assertions.assertEquals(expected, phones);
    }
}
