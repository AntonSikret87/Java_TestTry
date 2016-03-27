package ua.stqu.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.stqu.pft.addressbook.model.ContactData;

import java.util.Set;

/**
 * Created by sikretSSD on 04.03.2016.
 */
public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public  void ensurePreconditions() {
        app.goTo().homePage();
        if(app.contact().all().size() == 0){
            app.contact().create(new ContactData().withId(0)
                    .withFirstname("Anton1").withMiddlename("Olegovich1").withLastname("Karabeinikov1")
                    .withNickname("Sikret871").withCompany("Accesssoftek1"));
        }
    }

    @Test
    public void testContactModification(){
        Set<ContactData> before = app.contact().all();
        ContactData modifyContcat =  before.iterator().next();
        //int index = before.size() -1;
        ContactData contact = new ContactData().withId(modifyContcat.getId())
                .withFirstname("Anton1").withMiddlename("Olegovich1").withLastname("Karabeinikov1")
                .withNickname("Sikret871").withCompany("Accesssoftek1");
        app.contact().modify(before, contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifyContcat);
        before.add(contact);
//        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
//        before.sort(byId);
//        after.sort(byId);
        Assert.assertEquals(before,after);
    }


}
