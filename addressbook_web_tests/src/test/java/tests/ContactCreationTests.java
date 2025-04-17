package tests;

import common.CommonFunctions;
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
                for (var photo : List.of("src/test/resources/images/avatar.jpg", "src/test/resources/images/avatar.jpg")) {
                    result.add(new ContactData().withFirstName(first_name).withLastName(last_name).withPhoto(photo));
                }
            }
            for (int i = 0; i < 5; i++) {
                result.add(new ContactData()
                        .withFirstName(CommonFunctions.randomString(i * 10))
                        .withLastName(CommonFunctions.randomString(i * 10))
                        .withAddress(CommonFunctions.randomString(i * 10))
                        .withPhoneMobile(CommonFunctions.randomString(i * 10))
                        .withEmail(CommonFunctions.randomString(i * 10))
                        .withPhoto(randomFile("src/test/resources/images")));
            }
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contact) {
        var oldContacts = app.contacts().getList();
        app.contacts().createContact(contact);
        var newContacts = app.contacts().getList();
        newContacts.sort((o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        });
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact.withId(newContacts.get(newContacts.size() - 1).id()).withAddress("").withPhoneMobile("").withEmail("").withPhoto(""));
        expectedList.sort((o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        });
        Assertions.assertEquals(newContacts, expectedList);
    }


    public static List<ContactData> negativeContactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData("", "Jason'", "", "", "", "", "")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void canNotCreateContacts(ContactData contact) {
        var oldContacts = app.contacts().getList();
        app.contacts().createContact(contact);
        var newContacts = app.contacts().getList();
        Assertions.assertEquals(newContacts, oldContacts);
    }
}
