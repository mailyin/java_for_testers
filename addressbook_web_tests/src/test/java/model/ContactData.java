package model;

public record ContactData(String id, String first_name, String last_name, String address,
                          String email, String nick_name, String company, String home_page, String home, String mobile,
                          String work, String fax) {

    public ContactData() {
        this("", "", "", "", "", "", "", "", "", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.first_name, this.last_name, this.address, this.email, this.nick_name, this.company, this.home_page, this.home, this.mobile, this.work, this.fax);
    }

    public ContactData withFirstName(String first_name) {
        return new ContactData(this.id, first_name, this.last_name, this.address, this.email, this.nick_name, this.company, this.home_page, this.home, this.mobile, this.work, this.fax);
    }

    public ContactData withLastName(String last_name) {
        return new ContactData(this.id, this.first_name, last_name, this.address, this.email, this.nick_name, this.company, this.home_page, this.home, this.mobile, this.work, this.fax);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.first_name, this.last_name, address, this.email, this.nick_name, this.company, this.home_page, this.home, this.mobile, this.work, this.fax);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, email, this.nick_name, this.company, this.home_page, this.home, this.mobile, this.work, this.fax);
    }

    //    public ContactData withPhoto(String photo) {
//        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.email, photo);
//    }
    public ContactData withNickName(String nick_name) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.email, nick_name, this.company, this.home_page, this.home, this.mobile, this.work, this.fax);
    }
    public ContactData withCompany(String company) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.email, this.nick_name, company, this.home_page, this.home, this.mobile, this.work, this.fax);
    }
    public ContactData withHomePage(String home_page) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.email, this.nick_name, this.company, home_page, this.home, this.mobile, this.work, this.fax);
    }
    public ContactData withHome(String home) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.email, this.nick_name, this.company, home_page, home, this.mobile, this.work, this.fax);
    }
    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.email, this.nick_name, this.company, home_page, this.home, mobile, this.work, this.fax);
    }
    public ContactData withWork(String work) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.email, this.nick_name, this.company, home_page, this.home, this.mobile, work, this.fax);
    }
    public ContactData withfax(String fax) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.email, this.nick_name, this.company, home_page, this.home, this.mobile, this.work, fax);
    }
}
