package ua.stqu.pft.addressbook.tests;


import org.testng.annotations.Test;
import ua.stqu.pft.addressbook.model.GroupData;
import ua.stqu.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreateTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test1");
        app.group().create(group);
        Groups after = app.group().all();
        assertThat(after.size(), equalTo(before.size() +1));

//        group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
//        group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
//        before.add(group);
//        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
//        before.sort(byId);
//        after.sort(byId);
//        Assert.assertEquals(before, after);
        assertThat(after, equalTo(before.
                withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    }

}
