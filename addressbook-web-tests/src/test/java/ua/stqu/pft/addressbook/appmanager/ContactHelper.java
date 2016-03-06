package ua.stqu.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchContextException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ua.stqu.pft.addressbook.model.ContactData;

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
        type(By.name("firstname"),contactData.getFirstname());
        type(By.name("middlename"),contactData.getMiddlename());
        type(By.name("lastname"),contactData.getLastname());
        type(By.name("nickname"),contactData.getNickname());
        type(By.name("company"),contactData.getCompany());

        if(creation){
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }






    public void modifiContact() {
        click(By.cssSelector("img[alt=\"Edit\"]"));
    }

    public void initContactModify() {
        click(By.name("update"));
    }

    public void selectContact() {
        click(By.name("selected[]"));

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

    public void createContact(ContactData contact, boolean b) {
        goToAddNewPage();
        fillContactsFields(contact, b);
        submitContactCreation();
        returnToHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("submit"));

    }
    public void goToAddNewPage() {
        if(isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")){
            return;
        }
        click(By.linkText("add new"));
    }
}
