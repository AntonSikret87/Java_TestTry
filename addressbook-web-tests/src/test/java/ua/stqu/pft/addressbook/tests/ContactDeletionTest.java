package ua.stqu.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by sikretSSD on 04.03.2016.
 */
public class ContactDeletionTest extends TestBase{

    @Test
    public void testDeletionContact(){
        app.getContactHelper().goToHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deletionContact();
        app.getContactHelper().alertAccept();

    }
}
