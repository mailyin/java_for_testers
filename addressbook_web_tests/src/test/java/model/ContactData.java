package model;

public record ContactData(String id, String first_name, String last_name, String address, String phone_mobile,
                          String email, String nick_name, String company, String home_page) {

    public ContactData() {
        this("", "", "", "", "", "", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.first_name, this.last_name, this.address, this.phone_mobile, this.email, this.nick_name, this.company, this.home_page);
    }

    public ContactData withFirstName(String first_name) {
        return new ContactData(this.id, first_name, this.last_name, this.address, this.phone_mobile, this.email, this.nick_name, this.company, this.home_page);
    }

    public ContactData withLastName(String last_name) {
        return new ContactData(this.id, this.first_name, last_name, this.address, this.phone_mobile, this.email, this.nick_name, this.company, this.home_page);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.first_name, this.last_name, address, this.phone_mobile, this.email, this.nick_name, this.company, this.home_page);
    }

    public ContactData withPhoneMobile(String phone_mobile) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, phone_mobile, this.email, this.nick_name, this.company, this.home_page);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.phone_mobile, email, this.nick_name, this.company, this.home_page);
    }

    //    public ContactData withPhoto(String photo) {
//        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.phone_mobile, this.email, photo);
//    }
    public ContactData withNickName(String nick_name) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.phone_mobile, this.email, nick_name, this.company, this.home_page);
    }
    public ContactData withCompany(String company) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.phone_mobile, this.email, this.nick_name, company, this.home_page);
    }
    public ContactData withHomePage(String home_page) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.phone_mobile, this.email, this.nick_name, this.company, home_page);
    }
}
