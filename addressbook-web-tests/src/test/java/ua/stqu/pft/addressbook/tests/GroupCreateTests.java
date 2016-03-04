package ua.stqu.pft.addressbook.tests;


import org.testng.annotations.Test;
import ua.stqu.pft.addressbook.model.GroupData;


public class GroupCreateTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().goToGroupPage();
        app.getGroupsHelper().initGroupCreation();
        app.getGroupsHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
        app.getGroupsHelper().submitGroupCreation();
        app.getGroupsHelper().returnToGroupPage();
    }

}
