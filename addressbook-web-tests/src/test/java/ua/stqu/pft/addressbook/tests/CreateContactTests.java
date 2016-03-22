package ua.stqu.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.stqu.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class CreateContactTests extends TestBase {

    @Test
    public void newContactCreating() {
        app.goTo().homePage();
        List<ContactData> before = app.contact().contactList();
        ContactData contact = new ContactData()
                .withFirstname("Anton").withMiddlename("Olegovich").withLastname("Karabeinikov")
                .withNickname("Sikret87").withCompany("Accesssoftek");
        app.contact().create(contact);
        List<ContactData> after = app.contact().contactList();
        Assert.assertEquals(after.size(), before.size() +1);


        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }
}
