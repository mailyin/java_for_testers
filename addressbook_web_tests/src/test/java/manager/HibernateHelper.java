package manager;

import io.qameta.allure.Step;
import manager.hbm.ContactRecord;
import manager.hbm.GroupRecord;
import manager.hbm.ContactAndGroupRecord;
import model.ContactData;
import model.ContactAndGroupData;
import model.GroupData;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import tests.HelperBase;

import java.util.List;
import java.util.stream.Collectors;

public class HibernateHelper extends HelperBase {

    private SessionFactory sessionFactory;

    public HibernateHelper(ApplicationManager managerr) {
        super(managerr);
        sessionFactory = new Configuration()
                .addAnnotatedClass(GroupRecord.class)
                .addAnnotatedClass(ContactRecord.class)
                .addAnnotatedClass(ContactAndGroupRecord.class)
                .setProperty(AvailableSettings.URL, "jdbc:mysql://localhost/addressbook?zeroDateTimeBehavior=convertToNull")
                .setProperty(AvailableSettings.USER, "root")
                .setProperty(AvailableSettings.PASS, "")
                .buildSessionFactory();
    }

    //Преобразовывает GroupRecord в GroupData
    static List<GroupData> convertGroupList(List<GroupRecord> records) {
        return records.stream().map(HibernateHelper::convert).collect(Collectors.toList());
    }

    //Преобразовывает GroupData в GroupRecord
    private static GroupData convert(GroupRecord record) {
        return new GroupData("" + record.id, record.name, record.header, record.footer);
    }

    private static GroupRecord convert(GroupData data) {
        var id = data.id();
        if ("".equals(id)) {
            id = "0";
        }
        return new GroupRecord(Integer.parseInt(id), data.name(), data.header(), data.footer());
    }


    //Преобразовывает ContactRecord в ContactData
    static List<ContactData> convertContactList(List<ContactRecord> records) {
        return records.stream().map(HibernateHelper::convert).collect(Collectors.toList());
    }

    //Преобразовывает ContactData в ContactRecord
    private static ContactData convert(ContactRecord record) {
        return new ContactData().withId("" + record.id)
                .withFirstName(record.first_name)
                .withLastName(record.last_name)
                .withAddress(record.address)
                .withEmail(record.email)
                .withEmail2(record.email2)
                .withEmail3(record.email3)
                .withNickName(record.nickname)
                .withCompany(record.company)
                .withHomePage(record.home_page)
                .withHome(record.home)
                .withMobile(record.mobile)
                .withWork(record.work);
        //return new ContactData("" + record.id, record.first_name, record.last_name, record.address, record.email, record.nickname, record.company, record.home_page, record.home, record.mobile, record.work, record.fax);
    }

    private static ContactRecord convert(ContactData data) {
        var id = data.id();
        if ("".equals(id)) {
            id = "0";
        }
        return new ContactRecord(Integer.parseInt(id), data.first_name(), data.last_name(), data.address(), data.email(), data.email2(), data.email3(), data.nick_name(), data.company(), data.home_page(), data.home(), data.mobile(), data.work());
    }


    //Преобразовывает ContactInGroupRecord в ContactInGroupData
    static List<ContactAndGroupData> convertContactAndGroupList(List<ContactAndGroupRecord> records) {
        return records.stream().map(HibernateHelper::convert).collect(Collectors.toList());
    }

    //Преобразовывает ContactInGroupData в ContactInGroupRecord
    private static ContactAndGroupData convert(ContactAndGroupRecord record) {
        return new ContactAndGroupData("" + record.id, record.group_id);
    }

    private static ContactAndGroupRecord convert(ContactAndGroupData data) {
        var id = data.id();
        if ("".equals(id)) {
            id = "0";
        }
        return new ContactAndGroupRecord(Integer.parseInt(id), data.group_id());
    }


    @Step
    public List<GroupData> getGroupList() {
        return convertGroupList((List<GroupRecord>) sessionFactory.fromSession(session -> {
            return session.createQuery("from GroupRecord", GroupRecord.class).list();
        }));
    }

    public long getGroupsCount() {
        return sessionFactory.fromSession(session -> {
            return session.createQuery("select count (*) from GroupRecord", Long.class).getSingleResult();
        });
    }

    @Step
    public void createGroup(GroupData groupData) {
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.persist(convert(groupData));
            session.getTransaction().commit();
        });
    }


    public List<ContactData> getContactList() {
        return convertContactList((List<ContactRecord>) sessionFactory.fromSession(session -> {
            return session.createQuery("from ContactRecord", ContactRecord.class).list();
        }));
    }

    public long getContactsCount() {
        return sessionFactory.fromSession(session -> {
            return session.createQuery("select count (*) from ContactRecord", Long.class).getSingleResult();
        });
    }

    public void createContact(ContactData contactData) {
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.persist(convert(contactData));
            session.getTransaction().commit();
        });
    }

    public List<ContactData> getContactsInGroup(GroupData group) {
        return sessionFactory.fromSession(session -> {
            return convertContactList(session.get(GroupRecord.class, group.id()).contacts);
        });
    }

    public List<ContactAndGroupData> getAllContactsInGroups() {
        return convertContactAndGroupList((List<ContactAndGroupRecord>) sessionFactory.fromSession(session -> {
            return session.createQuery("from ContactAndGroupRecord", ContactAndGroupRecord.class).list();
        }));
    }
}
