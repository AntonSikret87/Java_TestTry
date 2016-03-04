package ua.stqu.pft.addressbook.tests;

import org.testng.annotations.Test;
import ua.stqu.pft.addressbook.model.ContactData;

public class CreateNewContactTests extends TestBase {

    @Test
    public void newContactCreating() {
        app.getNavigationHelper().goToAddNewPage();
        app.fillContactsFields(new ContactData("Anton", "Olegovich", "Karabeinikov", "Sikret87", "Accesssoftek"));
        app.submitContactCreation();
        app.returnToHomePage();

    }
}
