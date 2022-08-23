package ru.prnkstr.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("Test_Group_Name_1", "Test_Group_Header_1", "Test_Group_Footer_1"));
        submitGroupCreation();
        returnToGroupPage();
    }

}
