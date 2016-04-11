package ua.stqu.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ua.stqu.pft.addressbook.model.ContactData;
import ua.stqu.pft.addressbook.model.Contacts;

import java.util.List;
import java.util.Set;

/**
 * Created by sikretSSD on 04.03.2016.
 */
public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillContactsFields(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        //type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("lastname"), contactData.getLastname());
        //type(By.name("nickname"), contactData.getNickname());
        //type(By.name("company"), contactData.getCompany());
        //attach(By.name("photo"), contactData.getPhoto());
        //type(By.name("title"), contactData.getTitle());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("work"), contactData.getWorkPhone());
        //type(By.name("fax"), contactData.getFax());
        //type(By.name("email"), contactData.getEmail());
        if (creation) {
            if (contactData.getGroups().size() > 0) {
                Assert.assertTrue(contactData.getGroups().size() == 1);
                new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
            }
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }




    public void initContactModification(int contacts_size) {
        click(By.xpath("//*[@id='maintable']/tbody/tr[" + contacts_size + "]/td[8]/a"));
    }

    public void initContactModify() {
        click(By.name("update"));
    }

    public void initContactCreation() {
        wd.findElement(By.linkText("add new")).click();
    }


    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void returnToHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    public void alertAccept() {
        wd.switchTo().alert().accept();
    }

    public void deletionContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
        wd.switchTo().alert().accept();
    }

    public void create(ContactData contact) {
        initContactCreation();
        fillContactsFields(contact, true);
        submitContactCreation();
        contactCache = null;
        returnToHomePage();
    }

    public void modify(Set<ContactData> before, ContactData contact) {
        selectContactById(contact.getId());
        initContactModification(before.size() + 1);
        fillContactsFields(contact, true);
        initContactModify();
        contactCache = null;
        returnToHomePage();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedContacts();
        contactCache = null;
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));

    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));
            String lastname = cells.get(1).getText();
            String firstname = cells.get(2).getText();
            String allPhones = cells.get(5).getText();
            String Address = cells.get(3).getText();
            String allEmails = cells.get(4).getText();
            contactCache.add(new ContactData().withId(id).withLastname(lastname).withFirstname(firstname).withAddress(Address).withAllEmails(allEmails).withAllPhones(allPhones));
        }
        return new Contacts(contactCache);
    }
//    public ContactData infoFromEditForm(ContactData contact) {
//        initContactModificationById(contact.getId());
//        String firsname = wd.findElement(By.name("firstname")).getAttribute("value");
//        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
//        String home = wd.findElement(By.name("home")).getAttribute("value");
//        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
//        String work = wd.findElement(By.name("work")).getAttribute("value");
//        wd.navigate().back();
//        return new ContactData().withId(contact.getId())
//                .withFirstname(firsname).withLastname(lastname).withHomePhome(home)
//                .withMobilePhone(mobile).withWorkPhone(work);
//    }

    private void initContactModificationById(int id) {
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();
    }


    //    public ContactData infoFIOFromEditForm(ContactData contact) {
//        initContactModificationById(contact.getId());
//        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
//        String middlename = wd.findElement(By.name("middlename")).getAttribute("value");
//        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
//        String fio = firstname.concat(" ").concat(middlename).concat(" ").concat(lastname);
//        String nickname = wd.findElement(By.name("nickname")).getAttribute("value");
//        String home = "H: " + wd.findElement(By.name("home")).getAttribute("value");
//        String mobile = "M: " + wd.findElement(By.name("mobile")).getAttribute("value");
//        String work = "W: " + wd.findElement(By.name("work")).getAttribute("value").concat("\n");
//        String address = wd.findElement(By.cssSelector("textarea[name='address']")).getAttribute("value").concat("\n");
//        String email1 = wd.findElement(By.cssSelector("input[name='email']")).getAttribute("value");
//        String email2 = wd.findElement(By.cssSelector("input[name='email2']")).getAttribute("value");
//        String email3 = wd.findElement(By.cssSelector("input[name='email3']")).getAttribute("value");
//        wd.navigate().back();
//        initViewContactDetailsById(contact.getId());
//        String domain1 = wd.findElement(By.xpath("//div[@id='content']//a[2]")).getText();
//        String domain2 = wd.findElement(By.xpath("//div[@id='content']//a[4]")).getText();
//        String domain3 = wd.findElement(By.xpath("//div[@id='content']//a[6]")).getText();
//        email1 = email1.concat(" (").concat(domain1).concat(")");
//        email2 = email2.concat(" (").concat(domain2).concat(")");
//        email3 = email3.concat(" (").concat(domain3).concat(")");
//        wd.navigate().back();
//        return new ContactData().withId(contact.getId()).withFio(fio).withNickname(nickname).withAddress(address).
//                withEmail(email1).withEmail2(email2).withEmail3(email3).withHomePhone(home).withMobilePhone(mobile).
//                withWorkPhone(work);
//    }
    //.withFio(fio)
    public ContactData infoFIOFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String middlename = wd.findElement(By.name("middlename")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String fio = firstname.concat(" ").concat(middlename).concat(" ").concat(lastname);
        String nickname = wd.findElement(By.name("nickname")).getAttribute("value");
        String home = "H: " + wd.findElement(By.name("home")).getAttribute("value");
        String mobile = "M: " + wd.findElement(By.name("mobile")).getAttribute("value");
        String work = "W: " + wd.findElement(By.name("work")).getAttribute("value").concat("\n");
        String address = wd.findElement(By.cssSelector("textarea[name='address']")).getAttribute("value").concat("\n");
        String email1 = wd.findElement(By.cssSelector("input[name='email']")).getAttribute("value");
        String email2 = wd.findElement(By.cssSelector("input[name='email2']")).getAttribute("value");
        String email3 = wd.findElement(By.cssSelector("input[name='email3']")).getAttribute("value");
        wd.navigate().back();
        initViewContactDetailsById(contact.getId());
        String domain1 = wd.findElement(By.xpath("//div[@id='content']//a[2]")).getText();
        String domain2 = wd.findElement(By.xpath("//div[@id='content']//a[4]")).getText();
        String domain3 = wd.findElement(By.xpath("//div[@id='content']//a[6]")).getText();
        email1 = email1.concat(" (").concat(domain1).concat(")");
        email2 = email2.concat(" (").concat(domain2).concat(")");
        email3 = email3.concat(" (").concat(domain3).concat(")");
        wd.navigate().back();
        return new ContactData().withId(contact.getId())
                .withFio(fio).withNickname(nickname)
                .withAddress(address).
                        withEmail(email1).withEmail2(email2).withEmail3(email3).withHomePhone(home).withMobilePhone(mobile).
                        withWorkPhone(work);
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String middlename = wd.findElement(By.name("middlename")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String nickname = wd.findElement(By.name("nickname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String address = wd.findElement(By.cssSelector("textarea[name='address']")).getAttribute("value");
        String email1 = wd.findElement(By.cssSelector("input[name='email']")).getAttribute("value");
        String email2 = wd.findElement(By.cssSelector("input[name='email2']")).getAttribute("value");
        String email3 = wd.findElement(By.cssSelector("input[name='email3']")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).withMiddlename(middlename)
                .withLastname(lastname).
                        withNickname(nickname).withAddress(address).withEmail(email1)
                .withEmail2(email2).withEmail3(email3).
                        withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
    }

//    private void initContactModificationById(int id) {
//        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
//    }

    public ContactData infoFromDetailsForm(ContactData contact) {
        initViewContactDetailsById(contact.getId());
        String allData = wd.findElement(By.xpath("//*[@id='content']")).getText();
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withAllData(allData);
    }

    private void initViewContactDetailsById(int id) {
        wd.findElement(By.cssSelector(String.format("a[href='view.php?id=%s']", id))).click();
    }
}
