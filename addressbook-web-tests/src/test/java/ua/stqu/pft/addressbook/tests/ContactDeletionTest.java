package ua.stqu.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.stqu.pft.addressbook.model.ContactData;
import ua.stqu.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by sikretSSD on 04.03.2016.
 */
public class ContactDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {


        app.goTo().homePage();
        if (app.db().contacts().size() == 0) {
   //     if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData()
                    .withFirstname("Anton").withMiddlename("Olegovich").withLastname("Karabeinikov")
                    .withNickname("Sikret87").withCompany("Accesssoftek"));
        }
    }

    @Test
    public void testDeletionContact() {
        Contacts before = app.db().contacts();
        ContactData deletedContact = before.iterator().next();
        app.goTo().homePage();
        app.contact().delete(deletedContact);
        app.goTo().homePage();
        assertEquals(app.contact().count(), before.size(), 1);
        Contacts after = app.db().contacts();
        assertThat(after,
                equalTo(before.without(deletedContact)));
    }
}
