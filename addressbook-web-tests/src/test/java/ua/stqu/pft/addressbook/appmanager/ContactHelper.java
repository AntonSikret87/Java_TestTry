package ua.stqu.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ua.stqu.pft.addressbook.model.ContactData;

/**
 * Created by sikretSSD on 04.03.2016.
 */
public class ContactHelper extends HelperBase {

    public ContactHelper(FirefoxDriver wd) {
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
}
