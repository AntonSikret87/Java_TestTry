package ua.stqu.pft.addressbook.tests;

import org.testng.annotations.Test;
import ua.stqu.pft.addressbook.tests.TestBase;

public class GroupDeletionTests extends TestBase {


    @Test
    public void testGroupDeletion() {
        app.goToGroupPage();
        app.selectGroup();
        app.deleteSelectedGroups();
        app.returnToGroupPage();
    }
}
