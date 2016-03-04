package ua.stqu.pft.addressbook.tests;

import org.testng.annotations.Test;
import ua.stqu.pft.addressbook.model.GroupData;

/**
 * Created by sikretSSD on 04.03.2016.
 */
public class GroupModificationTests extends TestBase{

    @Test
    public void testGroupModofocation(){
        app.getNavigationHelper().goToGroupPage();
        app.getGroupsHelper().selectGroup();
        app.getGroupsHelper().initGroupModofocation();
        app.getGroupsHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
        app.getGroupsHelper().submitGroupModification();
        app.getGroupsHelper().returnToGroupPage();
    }
}
