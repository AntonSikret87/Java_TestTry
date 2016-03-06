package ua.stqu.pft.addressbook.tests;

import org.testng.annotations.Test;
import ua.stqu.pft.addressbook.model.ContactData;

/**
 * Created by sikretSSD on 04.03.2016.
 */
public class ContactDeletionTest extends TestBase{

    @Test
    public void testDeletionContact(){
        app.getNavigationHelper().goToHomePage();
        if(! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("Anton", "Olegovich", "Karabeinikov", "Sikret87", "Accesssoftek","test1"), true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deletionContact();
        app.getContactHelper().alertAccept();

    }
}
