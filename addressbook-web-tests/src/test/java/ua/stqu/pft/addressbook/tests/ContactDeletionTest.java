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
        app.getNavigationHelper().goToHomePage();
        if(! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("Anton", "Olegovich", "Karabeinikov", "Sikret87", "Accesssoftek"));
        }
    }

    @Test
    public void testDeletionContact(){
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() -1);
        app.getContactHelper().deletionContact();
        app.getContactHelper().alertAccept();
        app.getNavigationHelper().goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size(), 1);

        before.remove(before.size() -1);
        Assert.assertEquals(before,after);


    }
}
