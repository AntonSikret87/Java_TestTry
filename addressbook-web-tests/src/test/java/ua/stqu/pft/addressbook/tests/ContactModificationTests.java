package ua.stqu.pft.addressbook.tests;

import org.testng.annotations.Test;
import ua.stqu.pft.addressbook.model.ContactData;

/**
 * Created by sikretSSD on 04.03.2016.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification(){
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().modifiContact();
        app.getContactHelper().fillContactsFields(new ContactData("Anton1", "Olegovich1", "Karabeinikov1", "Sikret871", "Accesssoftek1", null ), false);
        app.getContactHelper().initContactModify();
        app.returnToHomePage();
    }
}
