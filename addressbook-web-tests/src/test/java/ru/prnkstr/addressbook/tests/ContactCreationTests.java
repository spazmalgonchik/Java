package ru.prnkstr.addressbook.tests;

import org.testng.annotations.Test;
import ru.prnkstr.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("Kirill", "Dmitrievich", "Sharov", "prnkstr",
                "raper", "Relex", "Grodnenskaya 65", "2209094", "89805442972", "2999999", "spazmalgonchik@yandex.ru"));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
    }


}
