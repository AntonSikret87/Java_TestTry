package ua.stqu.pft.addressbook.tests;

import org.testng.annotations.Test;
import ua.stqu.pft.addressbook.model.ContactData;

public class CreateContactTests extends TestBase {

    @Test
    public void newContactCreating() {
        app.getContactHelper().goToAddNewPage();
        app.getContactHelper().fillContactsFields(new ContactData("Anton", "Olegovich", "Karabeinikov", "Sikret87", "Accesssoftek","test1"), true);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();

    }
}
