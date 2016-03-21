package ua.stqu.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.stqu.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by sikretSSD on 04.03.2016.
 */
public class GroupModificationTests extends TestBase{

    @BeforeMethod
    public  void ensurePreconditions(){
        app.getNavigationHelper().goToGroupPage();
        if(! app.getGroupsHelper().isThereAGroup()){
            app.getGroupsHelper().createAGroup(new GroupData("test1", "test2", "test3"));
        }
    }

    @Test
    public void testGroupModofocation(){
        List<GroupData> before = app.getGroupsHelper().getGroupList();
        int index = before.size() -1;
        GroupData group = new GroupData(before.get(index).getId(), "test1", "test2", "test3");
        app.getGroupsHelper().modifyGroup(index, group);
        List<GroupData> after = app.getGroupsHelper().getGroupList();
        Assert.assertEquals(after.size(),before.size() );

        before.remove(index);
        before.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}
