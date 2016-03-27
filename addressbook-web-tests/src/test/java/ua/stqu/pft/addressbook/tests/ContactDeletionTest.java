package ua.stqu.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.stqu.pft.addressbook.model.ContactData;

import java.util.Set;

/**
 * Created by sikretSSD on 04.03.2016.
 */
public class ContactDeletionTest extends TestBase{

    @BeforeMethod
    public  void ensurePreconditions() {
        app.goTo().homePage();
        if(app.contact().all().size() == 0){
            app.contact().create(new ContactData()
                    .withFirstname("Anton").withMiddlename("Olegovich").withLastname("Karabeinikov")
                    .withNickname("Sikret87").withCompany("Accesssoftek"));
        }
    }

    @Test
    public void testDeletionContact(){
        Set<ContactData> before = app.contact().all();
        ContactData deletedContact =  before.iterator().next();
       // int index = before.size() -1;
        app.contact().delete(deletedContact);
        app.goTo().homePage();
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size(), 1);

        before.remove(deletedContact);
        Assert.assertEquals(before,after);


    }

}
