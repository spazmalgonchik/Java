package ru.prnkstr.addressbook.tests;

import org.testng.annotations.Test;
import ru.prnkstr.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("Test_Group_Name_1", "Test_Group_Header_1", "Test_Group_Footer_1"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
    }

}
