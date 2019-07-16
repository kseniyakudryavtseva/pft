package pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XStreamAlias("contact")
@Entity
@Table (name = "addressbook")
public class ContactData {

    @XStreamOmitField
    @Id
    @Column (name = "id")
    private int id = Integer.MAX_VALUE;;
    @Column (name = "firstname")
    private String firstname;
    @Column (name = "middlename")
    private String middlename;
    @Column (name = "lastname")
    private String lastname;
    @Column (name = "home")
    @Type(type = "text")
    private String homephone;
    @Column (name = "mobile")
    @Type(type = "text")
    private String mobilephone;
    @Column (name = "work")
    @Type(type = "text")
    public  String workphone;
    @Column (name = "address")
    @Type(type = "text")
    public String address;
    @Column (name = "email")
    @Type(type = "text")
    public String email;
    @Column (name = "email2")
    @Type(type = "text")
    public String email2;
    @Column (name = "email3")
    @Type(type = "text")
    public String email3;
    @Transient
    public String allEmails;
    @Transient
    public String allPhones;
    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable (name="address_in_groups", joinColumns = @JoinColumn(name="id"),
            inverseJoinColumns = @JoinColumn (name = "group_id"))
    private Set<GroupData> groups = new HashSet<GroupData>();

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withHomephone(String homephone) {
        this.homephone = homephone;
        return this;
    }
    public ContactData withMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
        return this;
    }

    public ContactData withtWorkphone(String workphone) {
        this.workphone = workphone;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public Groups getGroups() {
        return new Groups(groups);
    }

    public int getId() {return id; }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getHomephone() {
        return homephone;
    }

    public String getMobilephone() {return mobilephone;}

    public String getWorkphone() {return workphone;}

    public String getAddress() {return address;}

    public String getEmail() {return email;}

    public String getEmail2() {return email2;}

    public String getEmail3() {return email3;}

    public String getAllEmails() {return allEmails;}

    public String getAllPhones() {return allPhones;}

    @Override
    public String toString() {
        return "ContactData{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(middlename, that.middlename) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(homephone, that.homephone) &&
                Objects.equals(mobilephone, that.mobilephone) &&
                Objects.equals(workphone, that.workphone) &&
                Objects.equals(address, that.address) &&
                Objects.equals(email, that.email) &&
                Objects.equals(email2, that.email2) &&
                Objects.equals(email3, that.email3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, middlename, lastname, homephone, mobilephone, workphone, address, email, email2, email3);
    }

    public ContactData inGroup(GroupData group) {
        groups.add(group);
        return this;
    }
}
