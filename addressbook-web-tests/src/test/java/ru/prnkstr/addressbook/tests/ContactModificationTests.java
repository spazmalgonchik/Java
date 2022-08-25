package ru.prnkstr.addressbook.tests;


import org.testng.annotations.Test;
import ru.prnkstr.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Kirill", "Dmitrievich", "Sharov", "prnkstr", "raper", "Relex", "Grodnenskaya 65", "2209094", "89805442972", "2999999", "spazmalgonchik@yandex.ru", "Test_Group_Name_1"));
        }
        app.getContactHelper().modifyContact(new ContactData("Kirill", "Dmitrievich", "Sharov", "prnkstr", "raper", "Relex", "Grodnenskaya 65", "2209094", "89805442972", "2999999", "spazmalgonchik@yandex.ru", null));

    }
}
