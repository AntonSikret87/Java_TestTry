package ua.stqu.pft.addressbook.tests;

import org.testng.annotations.Test;
import ua.stqu.pft.addressbook.model.ContactData;
import ua.stqu.pft.addressbook.model.Contacts;
import ua.stqu.pft.addressbook.model.GroupData;
import ua.stqu.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by sikretSSD on 12.04.2016.
 */
public class DeleteContactFromGroup extends TestBase {

    @Test
    public void testDeleteContactFromGroup(){

        Contacts contacts = app.db().contacts();
        Groups groups = app.db().groups();
        GroupData group = groups.iterator().next();
        app.goTo().homePage();
        app.contact().selectGroupWithContacts(group.getName());
        app.contact().checkSelectedGroupFilterApplied();
        Contacts filteredGroupContacts = app.contact().all();
        ContactData selectedContact = filteredGroupContacts.iterator().next();
        app.contact().delete(selectedContact);
        app.goTo().homePage();
        selectedContact.outOfGroup(group);
        ContactData dbContact = app.db().contacts().stream()
                .filter(c->c.getId() == selectedContact.getId()).findFirst().get(); //тут падает =(
        assertThat(app.contact().count(), equalTo(contacts.size()));
        assertThat(selectedContact.getGroups(), equalTo(dbContact.getGroups()));

    }
}
