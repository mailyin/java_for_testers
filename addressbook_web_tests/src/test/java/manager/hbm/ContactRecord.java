//Так как Hibernate не умеет работать с Record, вместо GroupData используется промежуточный класс GroupRecord

package manager.hbm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "addressbook")
public class ContactRecord {

    @Id
    @Column(name = "id")
    public int id;
    @Column(name = "firstname")
    public String first_name;
    @Column(name = "lastname")
    public String last_name;
    @Column(name = "address")
    public String address;
    @Column(name = "email")
    public String email;
    //    @Column(name = "photo")
//    public String photo;
    @Column(name = "nickname")
    public String nickname;
    @Column(name = "company")
    public String company;
    @Column(name = "homepage")
    public String home_page;
    @Column(name = "home")
    public String home;
    @Column(name = "mobile")
    public String mobile;
    @Column(name = "work")
    public String work;
    @Column(name = "fax")
    public String fax;

    public Date deprecated = new Date();

    public ContactRecord() {
    }

    public ContactRecord(int id, String first_name, String last_name, String address, String email, String nickname, String company, String home_page,
                         String home, String mobile, String work, String fax) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.email = email;
//        this.photo = photo;
        this.nickname = nickname;
        this.company = company;
        this.home_page = home_page;
        this.home = home;
        this.mobile = mobile;
        this.work = work;
        this.fax = fax;
    }
}
