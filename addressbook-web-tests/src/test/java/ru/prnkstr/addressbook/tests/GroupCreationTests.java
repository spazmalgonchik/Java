package ru.prnkstr.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.prnkstr.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().createGroup(new GroupData("Test_Group_Name_1", "Test_Group_Header_1", "Test_Group_Footer_1"));
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);
    }
}
