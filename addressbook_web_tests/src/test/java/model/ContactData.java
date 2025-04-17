package model;

public record ContactData(String id, String first_name, String last_name, String address, String phone_mobile, String email, String photo) {

    public ContactData() {
        this("", "", "", "", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.first_name, this.last_name, this.address, this.phone_mobile, this.email, this.photo);
    }
        public ContactData withFirstName(String first_name) {
        return new ContactData(this.id, first_name, this.last_name, this.address, this.phone_mobile, this.email, this.photo);
    }
    public ContactData withLastName(String last_name) {
        return new ContactData(this.id, this.first_name, last_name, this.address, this.phone_mobile, this.email, this.photo);
    }
    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.first_name, this.last_name, address, this.phone_mobile, this.email, this.photo);
    }
    public ContactData withPhoneMobile(String phone_mobile) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, phone_mobile, this.email, this.photo);
    }
    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.phone_mobile, email, this.photo);
    }
    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.phone_mobile, this.email, photo);
    }
}
