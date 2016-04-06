package ua.stqu.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;

@XStreamAlias("contact")
public class ContactData {
    @XStreamOmitField
    private int id = Integer.MAX_VALUE;
    @Expose
    private String firstname;
    @Expose
    private String middlename;
    @Expose
    private String lastname;
    private String nickname;
    private String company;
    @Expose
    private String homephone;
    @Expose
    private String workphone;
    @Expose
    private String mobilephone;
    //  private String photo;
    private String title;
    @Expose
    private String address;
    private String fax;
    @Expose
    private String email;
    private String email2;
    private String email3;
    private String allPhones;
    private String allEmails;
    private String allData;
    private String fio;
    private String group;
    private File photo;

    public File getPhoto() {
        return photo;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

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

    public ContactData withHomePhone(String home) {
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

    //    public ContactData withPhoto(File photo) {
//        this.photo = photo.getPath();
//        return this;
//    }
    public ContactData withTitle(String title) {
        this.title = title;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withFax(String fax) {
        this.fax = fax;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
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

    //    public File getPhoto() {
//        return new File(photo);
//    }
    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public String getFax() {
        return fax;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public String getAllData() {
        return allData;
    }

    public ContactData withAllData(String allData) {
        this.allData = allData;
        return this;
    }

    public String getEmail3() {
        return email3;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public String getEmail2() {
        return email2;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public String getFio() {
        return fio;
    }

    public ContactData withFio(String fio) {
        this.fio = fio;
        return this;
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
