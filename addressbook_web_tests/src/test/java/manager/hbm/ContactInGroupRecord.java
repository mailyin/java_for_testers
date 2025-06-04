package manager.hbm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "address_in_groups")
public class ContactInGroupRecord {

    @Id
    @Column(name = "id")
    public int id;
    @Column(name = "group_id")
    public String group_id;

    public Date deprecated = new Date();

    public ContactInGroupRecord() {
    }

    public ContactInGroupRecord(int id, String group_id) {
        this.id = id;
        this.group_id = group_id;

    }
}
