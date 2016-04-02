package ua.stqu.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.stqu.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by sikretSSD on 30.03.2016.
 */
public class ContactEmailsTests extends TestBase{

    @BeforeMethod
    public  void ensurePreconditions() {
        app.goTo().homePage();
        if(app.contact().all().size() == 0){
            app.contact().create(new ContactData()
                    .withFirstname("Anton").withMiddlename("Olegovich").withLastname("Karabeinikov")
                    .withNickname("Sikret87").withCompany("Accesssoftek"));
//                    .withHomePhome("111").withMobilePhone("222").withWorkPhone("333"));
        }
    }

    @Test
    public void testContactEmails() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    }

    private String mergeEmails(ContactData contactInfoFromEditForm) {
        return Arrays.asList(contactInfoFromEditForm.getEmail(), contactInfoFromEditForm.getEmail2(), contactInfoFromEditForm.getEmail3())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactEmailsTests::cleanedEmails)
                .collect(Collectors.joining("\n"));
    }

    public static String cleanedEmails(String email) {

        return email.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}

