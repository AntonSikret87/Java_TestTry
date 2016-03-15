package ua.stqu.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ua.stqu.pft.addressbook.model.GroupData;


public class GroupCreateTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().goToGroupPage();
        int before = app.getGroupsHelper().getGroupCount();
        app.getGroupsHelper().initGroupCreation();
        app.getGroupsHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
        app.getGroupsHelper().submitGroupCreation();
        app.getGroupsHelper().returnToGroupPage();
        int after = app.getGroupsHelper().getGroupCount();
        Assert.assertEquals(after,before +1);
    }

}
