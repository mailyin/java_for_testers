package model;

public record ContactData(String id, String first_name, String last_name, String address,
                          String email, String email2, String email3, String home_page, String home, String mobile,
                          String work, String fax, String nick_name, String company
) {

    public ContactData() {
        this("", "", "", "", "", "", "", "", "", "", "", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.first_name, this.last_name, this.address, this.email, this.email2, this.email3, this.home_page, this.home, this.mobile, this.work, this.fax, this.nick_name, this.company);
    }

    public ContactData withFirstName(String first_name) {
        return new ContactData(this.id, first_name, this.last_name, this.address, this.email, this.email2, this.email3, this.home_page, this.home, this.mobile, this.work, this.fax, this.nick_name, this.company);
    }

    public ContactData withLastName(String last_name) {
        return new ContactData(this.id, this.first_name, last_name, this.address, this.email, this.email2, this.email3, this.home_page, this.home, this.mobile, this.work, this.fax, this.nick_name, this.company);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.first_name, this.last_name, address, this.email, this.email2, this.email3, this.home_page, this.home, this.mobile, this.work, this.fax, this.nick_name, this.company);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, email, this.email2, this.email3, this.home_page, this.home, this.mobile, this.work, this.fax, this.nick_name, this.company);
    }

    public ContactData withEmail2(String email2) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, email, email2, this.email3, this.home_page, this.home, this.mobile, this.work, this.fax, this.nick_name, this.company);
    }

    public ContactData withEmail3(String email3) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, email, this.email2, email3, this.home_page, this.home, this.mobile, this.work, this.fax, this.nick_name, this.company);
    }

    //    public ContactData withPhoto(String photo) {
//        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.email, photo);
//    }
    public ContactData withNickName(String nick_name) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.email, this.email2, this.email3, this.home_page, this.home, this.mobile, this.work, this.fax, nick_name, this.company);
    }
    public ContactData withCompany(String company) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.email, this.email2, this.email3, this.home_page, this.home, this.mobile, this.work, this.fax, this.nick_name, company);
    }
    public ContactData withHomePage(String home_page) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.email, this.email2, this.email3, home_page, this.home, this.mobile, this.work, this.fax, this.nick_name, this.company);
    }
    public ContactData withHome(String home) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.email, this.email2, this.email3, home_page, home, this.mobile, this.work, this.fax, this.nick_name, this.company);
    }
    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.email, this.email2, this.email3, home_page, this.home, mobile, this.work, this.fax, this.nick_name, this.company);
    }
    public ContactData withWork(String work) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.email, this.email2, this.email3, home_page, this.home, this.mobile, work, this.fax, this.nick_name, this.company);
    }
    public ContactData withfax(String fax) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.email, this.email2, this.email3, home_page, this.home, this.mobile, this.work, fax, this.nick_name, this.company);
    }
}
