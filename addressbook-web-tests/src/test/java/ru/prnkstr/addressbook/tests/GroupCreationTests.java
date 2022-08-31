package ru.prnkstr.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.prnkstr.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        GroupData group = new GroupData("Test_Group_Name_1", "Test_Group_Header_1", "Test_Group_Footer_1");
        app.getGroupHelper().createGroup(group);
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);

        group.setId(after.stream().max(Comparator.comparingInt(GroupData::getId)).get().getId());
        before.add(group);

        Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);

        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }
}
