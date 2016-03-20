package ua.stqu.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.stqu.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by sikretSSD on 04.03.2016.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification(){
        app.getNavigationHelper().goToHomePage();

        if(! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData(0, "Anton", "Olegovich", "Karabeinikov", "Sikret87", "Accesssoftek"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() -1);
        app.getContactHelper().initContactModification(before.size()+1);
        ContactData contact = new ContactData(before.get(before.size() -1).getId(),"Anton1", "Olegovich1", "Karabeinikov1", "Sikret871", "Accesssoftek1") ;
        app.getContactHelper().fillContactsFields(contact);
        app.getContactHelper().initContactModify();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() -1);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }
}
