package model;

public record ContactData(String id, String first_name, String last_name, String address, String phone_mobile,
                          String email, String nick_name, String company, String home_page, String home, String mobile,
                          String work, String phone2) {

    public ContactData() {
        this("", "", "", "", "", "", "", "", "", "", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.first_name, this.last_name, this.address, this.phone_mobile, this.email, this.nick_name, this.company, this.home_page, this.home, this.mobile, this.work, this.phone2);
    }

    public ContactData withFirstName(String first_name) {
        return new ContactData(this.id, first_name, this.last_name, this.address, this.phone_mobile, this.email, this.nick_name, this.company, this.home_page, this.home, this.mobile, this.work, this.phone2);
    }

    public ContactData withLastName(String last_name) {
        return new ContactData(this.id, this.first_name, last_name, this.address, this.phone_mobile, this.email, this.nick_name, this.company, this.home_page, this.home, this.mobile, this.work, this.phone2);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.first_name, this.last_name, address, this.phone_mobile, this.email, this.nick_name, this.company, this.home_page, this.home, this.mobile, this.work, this.phone2);
    }

    public ContactData withPhoneMobile(String phone_mobile) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, phone_mobile, this.email, this.nick_name, this.company, this.home_page, this.home, this.mobile, this.work, this.phone2);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.phone_mobile, email, this.nick_name, this.company, this.home_page, this.home, this.mobile, this.work, this.phone2);
    }

    //    public ContactData withPhoto(String photo) {
//        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.phone_mobile, this.email, photo);
//    }
    public ContactData withNickName(String nick_name) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.phone_mobile, this.email, nick_name, this.company, this.home_page, this.home, this.mobile, this.work, this.phone2);
    }
    public ContactData withCompany(String company) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.phone_mobile, this.email, this.nick_name, company, this.home_page, this.home, this.mobile, this.work, this.phone2);
    }
    public ContactData withHomePage(String home_page) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.phone_mobile, this.email, this.nick_name, this.company, home_page, this.home, this.mobile, this.work, this.phone2);
    }
    public ContactData withHome(String home) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.phone_mobile, this.email, this.nick_name, this.company, home_page, home, this.mobile, this.work, this.phone2);
    }
    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.phone_mobile, this.email, this.nick_name, this.company, home_page, this.home, mobile, this.work, this.phone2);
    }
    public ContactData withWork(String work) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.phone_mobile, this.email, this.nick_name, this.company, home_page, this.home, this.mobile, work, this.phone2);
    }
    public ContactData withPhone2(String secondary) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.phone_mobile, this.email, this.nick_name, this.company, home_page, this.home, this.mobile, this.work, secondary);
    }
}
