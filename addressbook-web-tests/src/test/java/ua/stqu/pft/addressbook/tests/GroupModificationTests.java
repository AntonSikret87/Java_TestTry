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
        app.goTo().groupPage();
        if(app.group().groupList().size() == 0){
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupModofocation(){
        List<GroupData> before = app.group().groupList();
        int index = before.size() -1;
        GroupData group = new GroupData()
                .withId(before.get(index).getId()).withName("test1").withHeader("test2").withFooter("test3");
        app.group().modify(index, group);
        List<GroupData> after = app.group().groupList();
        Assert.assertEquals(after.size(),before.size() );

        before.remove(index);
        before.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}
