package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ContactModificationTests extends TestBase {

    @Test
    void canModifyContact() {
        if (app.contacts().getContactsCount() == 0) {
            app.contacts().createContact(new ContactData("", "Jason", "Bourne", "Paris",
                    "jb@rambler.com"/*, "src/test/resources/images/avatar.jpg")*/, "", "", "treadstone.com", "", "", "", "Foma Kiniaev", "CIA"));
        }
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var testData = new ContactData().withFirstName("modified first name").withLastName("modified last name").withHomePage("modified home page");
        app.contacts().modifyContact(oldContacts.get(index), testData);
        var newContacts = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.set(index, testData.withId(oldContacts.get(index).id()));
        newContacts.sort((o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        });
        expectedList.sort((o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        });
        Assertions.assertEquals(newContacts, expectedList);
    }

    @Test
    public void canAddContactToGroup() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData("", "Jason", "Bourne", "Paris",
                    "jb@rambler.com"/*,"src/test/resources/images/avatar.jpg"*/, "", "", "treadstone.com", "", "", "", "Foma Kiniaev", "CIA"));
        }
        if (app.hbm().getGroupsCount() == 0) {
            app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
        }

        var allContacts = app.hbm().getContactList();
        var contactsAndGroup = app.hbm().getAllContactsInGroups();
        var contactsNotInGroup = app.contacts().getContactsNotInGroup(contactsAndGroup, allContacts);

        ContactData selectedContact = null;

        if (!contactsNotInGroup.isEmpty()) {
            Random randomContact = new Random();
            selectedContact = contactsNotInGroup.get(randomContact.nextInt(contactsNotInGroup.size()));
        } else {
            app.contacts().createContact(new ContactData("", "Jason", "Bourne", "Paris",
                    "jb@rambler.com"/*,"src/test/resources/images/avatar.jpg"*/, "", "", "treadstone.com", "", "", "", "Foma Kiniaev", "CIA"));

            allContacts = app.hbm().getContactList();
            contactsAndGroup = app.hbm().getAllContactsInGroups();
            selectedContact = app.contacts().getContactsNotInGroup(contactsAndGroup, allContacts).get(0);
        }

        var groups = app.hbm().getGroupList();
        Random randomGroup = new Random();
        GroupData selectedGroup = groups.get(randomGroup.nextInt(groups.size()));

        var oldRelated = app.hbm().getContactsInGroup(selectedGroup);
        app.contacts().addContactToGroup(selectedContact, selectedGroup);
        var newRelated = app.hbm().getContactsInGroup(selectedGroup);
        Assertions.assertEquals(oldRelated.size() + 1, newRelated.size());
    }


    @Test
    public void canRemoveContactFromGroup() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData("", "Jason", "Bourne", "Paris",
                    "jb@rambler.com"/*,"src/test/resources/images/avatar.jpg"*/, "", "", "treadstone.com", "", "", "", "Foma Kiniaev", "CIA"));
        }
        if (app.hbm().getGroupsCount() == 0) {
            app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        var group = app.hbm().getGroupList().get(0);
        var contact = app.hbm().getContactList().get(0);
//Предварительное добавление контакта в группу для последующего удаления из группы
        app.contacts().addContactToGroup(contact, group);
        var oldRelated = app.hbm().getContactsInGroup(group);

        app.contacts().removeContactFromGroup(contact, group);
        var newRelated = app.hbm().getContactsInGroup(group);
        Assertions.assertEquals(oldRelated.size() - 1, newRelated.size());
    }
}
