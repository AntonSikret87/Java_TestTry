package ua.stqu.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.stqu.pft.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by sikretSSD on 04.03.2016.
 */
public class ContactDeletionTest extends TestBase{

    @BeforeMethod
    public  void ensurePreconditions() {
        app.goTo().homePage();
        if(app.contact().contactList().size() == 0){
            app.contact().create(new ContactData()
                    .withFirstname("Anton").withMiddlename("Olegovich").withLastname("Karabeinikov")
                    .withNickname("Sikret87").withCompany("Accesssoftek"));
        }
    }

    @Test
    public void testDeletionContact(){
        List<ContactData> before = app.contact().contactList();
        int index = before.size() -1;
        app.contact().delete(index);
        app.goTo().homePage();
        List<ContactData> after = app.contact().contactList();
        Assert.assertEquals(after.size(), before.size(), 1);

        before.remove(index);
        Assert.assertEquals(before,after);


    }

}
