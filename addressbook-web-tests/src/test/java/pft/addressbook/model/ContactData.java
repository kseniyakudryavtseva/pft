package pft.addressbook.model;

public class ContactData {
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String homephone;

    public ContactData(String firstname, String middlename, String lastname, String homephone) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.homephone = homephone;
    }

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
}
