package ru.prnkstr.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.prnkstr.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Kirill", "Dmitrievich", "Sharov", "prnkstr", "raper", "Relex", "Grodnenskaya 65", "2209094", "89805442972", "2999999", "spazmalgonchik@yandex.ru", "Test_Group_Name_1"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData contact = new ContactData("Kirill", "Dmitrievich", "Sharov", "prnkstr", "raper", "Relex", "Grodnenskaya 65", "2209094", "89805442972", "2999999", "spazmalgonchik@yandex.ru", null);
        app.getContactHelper().modifyContact(contact, before.size() - 1);
        List<ContactData> after = app.getContactHelper().getContactList();
        //Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);

        Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);

        //Assert.assertEquals(after, before);
    }
}
