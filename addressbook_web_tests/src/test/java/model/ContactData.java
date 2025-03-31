package model;

public record ContactData(String first_name, String last_name, String address, String phone_mobile, String email) {

    public ContactData() {
        this("", "", "", "", "");
    }

    public ContactData withFirstName(String first_name) {
        return new ContactData(first_name, this.last_name, this.address, this.phone_mobile, this.email);
    }
    public ContactData withLastName(String last_name) {
        return new ContactData(this.first_name, last_name, this.address, this.phone_mobile, this.email);
    }
    public ContactData withAddress(String address) {
        return new ContactData(this.first_name, this.last_name, address, this.phone_mobile, this.email);
    }
    public ContactData withPhoneMobile(String phone_mobile) {
        return new ContactData(this.first_name, this.last_name, this.address, phone_mobile, this.email);
    }
    public ContactData withEmail(String email) {
        return new ContactData(this.first_name, this.last_name, this.address, this.phone_mobile, email);
    }
}
