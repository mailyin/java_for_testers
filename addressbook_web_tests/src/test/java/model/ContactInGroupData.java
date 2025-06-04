package model;

public record ContactInGroupData(String id, String group_id) {

    public ContactInGroupData() {
        this("", "");
    }

    public ContactInGroupData withId(String id) {
        return new ContactInGroupData(id, this.group_id);
    }

    public ContactInGroupData withGroupId(String group_id) {
        return new ContactInGroupData(this.id, group_id);
    }
}
