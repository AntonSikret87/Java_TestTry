package ua.stqu.pft.addressbook.tests;

import org.testng.annotations.Test;
import ua.stqu.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by sikretSSD on 02.04.2016.
 */
public class ContactDetailsTests extends TestBase {


    @Test
    public void testContactComparisonData() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFIOFromEditForm(contact);
        ContactData contactInfoFromDetailsForm = app.contact().infoFromDetailsForm(contact);
        assertThat(contactInfoFromDetailsForm.getAllData(), equalTo(mergeData(contactInfoFromEditForm)));
    }

    private String mergeData(ContactData contact) {
        return Arrays.asList(
                contact.getFio(),
               // contact.getFirstname(),contact.getLastname(),contact.getMiddlename(),
                 contact.getNickname(), contact.getAddress(), contact.getHomePhone(), contact.getMobilePhone()
                , contact.getWorkPhone(), contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> !s.equals("")) //фильтрация от пустых значений
                //.map(ContactComparisonDataTest::fio) //очистка от лишних символов
                //.map(ContactComparisonDataTest::cleanedEmails)//очистка от лишних символов
                .collect(Collectors.joining("\n")); //склейка
    }

    }


