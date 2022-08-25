package ru.prnkstr.addressbook.tests;

import org.testng.annotations.Test;
import ru.prnkstr.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactHelper().createContact(new ContactData("Kirill", "Dmitrievich",
                "Sharov", "prnkstr", "raper", "Relex", "Grodnenskaya 65",
                "2209094", "89805442972", "2999999", "spazmalgonchik@yandex.ru",
                "Test_Group_Name_1"));
    }
}
