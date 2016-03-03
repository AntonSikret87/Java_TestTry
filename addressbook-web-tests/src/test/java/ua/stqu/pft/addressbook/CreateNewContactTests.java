package ua.stqu.pft.addressbook;

import org.testng.annotations.Test;

public class CreateNewContactTests extends TestBase {

    @Test
    public void newContactCreating() {
        goToAddNewPage();
        fillContactsFields(new ContactData("Anton", "Olegovich", "Karabeinikov", "Sikret87", "Accesssoftek"));
        submitContactCreation();
        returnToHomePage();

    }
}
