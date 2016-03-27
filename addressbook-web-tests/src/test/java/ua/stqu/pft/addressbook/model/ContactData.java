package ua.stqu.pft.addressbook.model;

public class ContactData {

    private int id = Integer.MAX_VALUE;;
    private String firstname;
    private String middlename;
    private String lastname;
    private String nickname;
    private String company;
    private String homephone;
    private String workphone;
    private String mobilephone;

//
//
//    public ContactData(int id, String firstname, String middlename, String lastname, String nickname, String company) {
//        this.id = id;
//        this.firstname = firstname;
//        this.middlename = middlename;
//        this.lastname = lastname;
//        this.nickname = nickname;
//        this.company = company;
//
//    }
//
//    public ContactData(String firstname, String middlename, String lastname, String nickname, String company) {
//        this.id = Integer.MAX_VALUE;
//        this.firstname = firstname;
//        this.middlename = middlename;
//        this.lastname = lastname;
//        this.nickname = nickname;
//        this.company = company;
//
//    }

    public ContactData withCompany(String company) {
        this.company = company;
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

    public ContactData withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }
    public ContactData withHomePhome(String home) {
        this.homephone = home;
        return this;
    }
    public ContactData withMobilePhone(String mobile) {
        this.mobilephone = mobile;
        return this;
    }
    public ContactData withWorkPhone(String work) {
        this.workphone = work;
        return this;
    }


    public int getId() {
        return id;
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

    public String getNickname() {
        return nickname;
    }

    public String getCompany() {
        return company;
    }

    public String getHomePhone() {
        return homephone;
    }
    public String getMobilePhone() {
        return mobilephone;
    }
    public String getWorkPhone() {
        return workphone;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "ContactData{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
