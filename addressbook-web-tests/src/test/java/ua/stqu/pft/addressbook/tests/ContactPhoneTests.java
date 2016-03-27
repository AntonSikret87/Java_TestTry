package ua.stqu.pft.addressbook.tests;

import org.testng.annotations.Test;
import ua.stqu.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by sikretSSD on 27.03.2016.
 */
public class ContactPhoneTests extends TestBase {

//    @BeforeMethod
//    public  void ensurePreconditions() {
//        app.goTo().homePage();
//        if(app.contact().all().size() == 0){
//            app.contact().create(new ContactData()
//                    .withFirstname("Anton").withMiddlename("Olegovich").withLastname("Karabeinikov")
//                    .withNickname("Sikret87").withCompany("Accesssoftek"));
////                    .withHomePhome("111").withMobilePhone("222").withWorkPhone("333"));
//        }
//    }


    @Test
    public void testContactPhones(){
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));

    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMiddlename(), contact.getWorkPhone())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone){
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}
