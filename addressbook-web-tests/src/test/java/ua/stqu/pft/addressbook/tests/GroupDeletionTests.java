package ua.stqu.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.stqu.pft.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {


    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().goToGroupPage();
        int before = app.getGroupsHelper().getGroupCount();
        if(! app.getGroupsHelper().isThereAGroup()){
            app.getGroupsHelper().createAGroup(new GroupData("test1", "test2", "test3"));
        }
        app.getGroupsHelper().selectGroup(before -1);
        app.getGroupsHelper().deleteSelectedGroups();
        app.getGroupsHelper().returnToGroupPage();
        int after = app.getGroupsHelper().getGroupCount();
        Assert.assertEquals(after,before -1);
    }
}
