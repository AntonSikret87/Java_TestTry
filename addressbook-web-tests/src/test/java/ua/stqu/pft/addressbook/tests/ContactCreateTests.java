package ua.stqu.pft.addressbook.tests;

import org.testng.annotations.Test;
import ua.stqu.pft.addressbook.model.ContactData;
import ua.stqu.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreateTests extends TestBase {

    @Test
    public void newContactCreating() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstname("Anton").withMiddlename("Olegovich").withLastname("Karabeinikov")
                .withNickname("Sikret87").withCompany("Accesssoftek");
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size() +1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before
                .withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
    @Test
    public void newBadContactCreating() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstname("Anton'").withMiddlename("Olegovich'").withLastname("Karabeinikov'")
                .withNickname("Sikret87'").withCompany("Accesssoftek'");
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));
    }
}
