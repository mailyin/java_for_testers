package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class ContactCreationTests extends TestBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var first_name : List.of("", "Jason")) {
            for (var last_name : List.of("", "Bourne")) {
                for (var address : List.of("", "Paris")) {
                    for (var phone_mobile : List.of("", "+33 1 223-322")) {
                        for (var email : List.of("", "jb@rambler.com")) {
                            result.add(new ContactData(first_name, last_name, address, phone_mobile, email));
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new ContactData(randomString(i * 10), randomString(i * 10), randomString(i * 10), randomString(i * 10),randomString(i * 10)));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contact) {
        int contactCount = app.contact().getContactsCount();
        app.contact().createContact(contact);
        int newContactCount = app.contact().getContactsCount();
        Assertions.assertEquals(contactCount + 1, newContactCount);
    }


    public static List<ContactData> negativeContactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData("Jason'", "", "", "", "")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void canNotContacts(ContactData contact) {
        int contactCount = app.contact().getContactsCount();
        app.contact().createContact(contact);
        int newContactCount = app.contact().getContactsCount();
        Assertions.assertEquals(contactCount, newContactCount);
    }
}
