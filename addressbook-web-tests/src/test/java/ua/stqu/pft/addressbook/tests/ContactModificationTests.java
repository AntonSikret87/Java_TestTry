package ua.stqu.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.stqu.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by sikretSSD on 04.03.2016.
 */
public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public  void ensurePreconditions() {
        app.goTo().homePage();
        if(app.contact().contactList().size() == 0){
            app.contact().create(new ContactData().withId(0)
                    .withFirstname("Anton").withMiddlename("Olegovich").withLastname("Karabeinikov")
                    .withNickname("Sikret87").withCompany("Accesssoftek"));
        }
    }

    @Test
    public void testContactModification(){
        List<ContactData> before = app.contact().contactList();
        int index = before.size() -1;
        ContactData contact = new ContactData().withId(before.get(index).getId())
                .withFirstname("Anton1").withMiddlename("Olegovich1").withLastname("Karabeinikov1")
                .withNickname("Sikret871").withCompany("Accesssoftek1");
        app.contact().modify(before, index, contact);
        List<ContactData> after = app.contact().contactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }


}
