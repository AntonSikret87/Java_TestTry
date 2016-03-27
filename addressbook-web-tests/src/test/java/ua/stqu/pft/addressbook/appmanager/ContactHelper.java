package ua.stqu.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public void fillContactsFields(ContactData contactData) {
        type(By.name("firstname"),contactData.getFirstname());
        type(By.name("middlename"),contactData.getMiddlename());
        type(By.name("lastname"),contactData.getLastname());
        type(By.name("nickname"),contactData.getNickname());
        type(By.name("company"),contactData.getCompany());
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
        fillContactsFields(contact);
        submitContactCreation();
        contactCache = null;
        returnToHomePage();
    }

    public void modify(Set<ContactData> before, ContactData contact) {
        selectContactById(contact.getId());
        initContactModification(before.size()+1);
        fillContactsFields(contact);
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
         if(contactCache != null) {
             return new Contacts(contactCache);
         }
         contactCache =  new Contacts();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for(WebElement row : rows){
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String lastname = cells.get(2).getText();
            String firstname = cells.get(1).getText();
            String[] phones = cells.get(5).getText().split("\n");
            int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
            contactCache.add(new ContactData().withId(id).withLastname(firstname).withFirstname(lastname).withHomePhome(phones[0])
                    .withMobilePhone(phones[1]).withWorkPhone(phones[2]));
        }
        return new Contacts(contactCache);
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firsname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId())
                .withFirstname(firsname).withLastname(lastname).withHomePhome(home)
                .withMobilePhone(mobile).withWorkPhone(work);
    }

    private void initContactModificationById(int id) {
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row =  checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells =  row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();
    }
}
