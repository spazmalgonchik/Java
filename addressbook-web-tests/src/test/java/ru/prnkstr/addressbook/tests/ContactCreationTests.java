package ru.prnkstr.addressbook.tests;

import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.prnkstr.addressbook.model.ContactData;


import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData contact = new ContactData("Kirill", "Dmitrievich",
                "Sharov", "prnkstr", "raper", "Relex", "Grodnenskaya 65",
                "2209094", "89805442972", "2999999", "spazmalgonchik@yandex.ru",
                "Test_Group_Name_1");
        app.getContactHelper().createContact(contact);
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.setId(after.stream().max(Comparator.comparingInt(ContactData::getId)).get().getId());
        before.add(contact);

        Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(after, before);
    }
}
