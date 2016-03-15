package ua.stqu.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ua.stqu.pft.addressbook.model.GroupData;

import java.util.List;


public class GroupCreateTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().goToGroupPage();
        List<GroupData> before = app.getGroupsHelper().getGroupList();
        app.getGroupsHelper().initGroupCreation();
        app.getGroupsHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
        app.getGroupsHelper().submitGroupCreation();
        app.getGroupsHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupsHelper().getGroupList();
        Assert.assertEquals(after.size(),before.size() +1);
    }

}
