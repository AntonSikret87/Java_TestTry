package ua.stqu.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.stqu.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

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

//        if(creation){
//            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
//        } else {
//            Assert.assertFalse(isElementPresent(By.name("new_group")));
//        }
    }



    public void initContactModification(int contacts_size) {
        click(By.xpath("//*[@id='maintable']/tbody/tr[" + contacts_size + "]/td[8]/a"));
    }

    public void modifiContact() {
        click(By.cssSelector("img[alt=\"Edit\"]"));
    }

    public void initContactModify() {
        click(By.name("update"));
    }
    public void initContactCreation() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();

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

    public void createContact(ContactData contact) {
        initContactCreation();
        fillContactsFields(contact);
        submitContactCreation();
        returnToHomePage();
    }

    public void modifyContact(List<ContactData> before, int index, ContactData contact) {
        selectContact(index);
        initContactModification(before.size()+1);
        fillContactsFields(contact);
        initContactModify();
        returnToHomePage();
    }


    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));

    }


    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts =  new ArrayList<ContactData>();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for(WebElement row : rows){
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String lastname = cells.get(2).getText();
            String firstname = cells.get(1).getText();
            int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData(id,lastname , null, firstname, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
