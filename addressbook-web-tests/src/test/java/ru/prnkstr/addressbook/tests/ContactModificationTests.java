package ru.prnkstr.addressbook.tests;


import org.testng.annotations.Test;
import ru.prnkstr.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("QQQQQ", "Dmitrievich", "QWWEEE", "prnkstr",
                "raper", "Relex", "Grodnenskaya 65", "2209094", "89805442972", "2999999", "spazmalgonchik@yandex.ru"));
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().gotoHomePage();

    }
}
