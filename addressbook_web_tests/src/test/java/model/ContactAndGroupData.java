package model;

public record ContactAndGroupData(String id, String group_id) {

    public ContactAndGroupData() {
        this("", "");
    }

    public ContactAndGroupData withId(String id) {
        return new ContactAndGroupData(id, this.group_id);
    }

    public ContactAndGroupData withGroupId(String group_id) {
        return new ContactAndGroupData(this.id, group_id);
    }
}
