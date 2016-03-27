package ua.stqu.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.stqu.pft.addressbook.model.GroupData;
import ua.stqu.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by sikretSSD on 04.03.2016.
 */
public class GroupModificationTests extends TestBase{

    @BeforeMethod
    public  void ensurePreconditions(){
        app.goTo().groupPage();
        if(app.group().all().size() == 0){
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupModofocation(){
        Groups before = app.group().all();
        GroupData modifyGroup =  before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifyGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
        app.group().modify(group);
        Assert.assertEquals(app.group().count(),before.size());
        Groups after = app.group().all();
        assertThat(after , equalTo(before
                .without(modifyGroup).withAdded(group)));
    }

}
