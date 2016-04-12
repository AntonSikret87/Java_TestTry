package ua.stqu.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.stqu.pft.addressbook.model.ContactData;
import ua.stqu.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by sikretSSD on 04.03.2016.
 */
public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.db().contacts().size() == 0) {
        //if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withId(0)
                    .withFirstname("Anton1").withMiddlename("Olegovich1").withLastname("Karabeinikov1")
                    .withNickname("Sikret871").withCompany("Accesssoftek1"));
        }
    }

    @Test
    public void testContactModification() {
        Contacts before = app.db().contacts();
        ContactData modifyContcat = before.iterator().next();
        ContactData contact = new ContactData().withId(modifyContcat.getId())
                .withFirstname("Anton1").withMiddlename("Olegovich1").withLastname("Karabeinikov1")
                .withNickname("Sikret871").withCompany("Accesssoftek1");
        app.goTo().homePage();
        app.contact().modify(before, contact);
        Assert.assertEquals(app.contact().count(), before.size());
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(modifyContcat).withAdded(contact)));
        verifyContactListInUI();
    }


}
