package ua.stqu.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
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
public class AddContactToGroupTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditionsGroups(){
        if (app.db().groups().size() == 0){
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("group1").withHeader("header1").withFooter("footer1"));
        }
        if (app.db().contacts().size() == 0){
            app.goTo().homePage();
            app.contact().create(new ContactData().withFirstname("Firstname").withLastname("Lastname")
                    .withEmail("lala@gmail.com").withHomePhone("111111"));
        }
    }

    @Test
    public void testAddContactToGroup(){
        Contacts contacts = app.db().contacts();
        ContactData selectedContact = contacts.iterator().next();
        Groups groups = app.db().groups();
        GroupData group = groups.iterator().next();
        GroupData validGroup = new GroupData().withId(group.getId()).withName("group " + group.getId());
        app.goTo().groupPage();
        app.group().modify(validGroup);
        app.goTo().homePage();
        app.contact().selectContactById(selectedContact.getId());
        app.contact().selectGroupForAdding(validGroup.getName());
        app.contact().addToGroup();
        app.goTo().homePage();
        group.withName("group " + group.getId());
        selectedContact.inGroup(group);
        ContactData dbContact = app.db().contacts().stream()
                .filter(c->c.getId() == selectedContact.getId()).findFirst().get();
        assertThat(app.contact().count(), equalTo(contacts.size()));
        assertThat(selectedContact.getGroups(), equalTo(dbContact.getGroups()));

    }
}
