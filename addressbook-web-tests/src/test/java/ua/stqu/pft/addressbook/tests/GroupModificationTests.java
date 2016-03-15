package ua.stqu.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.stqu.pft.addressbook.model.GroupData;

import java.util.List;

/**
 * Created by sikretSSD on 04.03.2016.
 */
public class GroupModificationTests extends TestBase{

    @Test
    public void testGroupModofocation(){
        app.getNavigationHelper().goToGroupPage();
        if(! app.getGroupsHelper().isThereAGroup()){
            app.getGroupsHelper().createAGroup(new GroupData("test1", "test2", "test3"));
        }
        List<GroupData> before = app.getGroupsHelper().getGroupList();
        app.getGroupsHelper().selectGroup(before.size() -1);
        app.getGroupsHelper().initGroupModofocation();
        app.getGroupsHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
        app.getGroupsHelper().submitGroupModification();
        app.getGroupsHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupsHelper().getGroupList();
        Assert.assertEquals(after.size(),before.size() );
    }
}
