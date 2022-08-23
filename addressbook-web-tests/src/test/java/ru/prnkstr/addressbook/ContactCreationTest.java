package ru.prnkstr.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase{

    @Test
    public void testContactCreation() {
        initContactCreation();
        fillContactForm(new ContactData("Kirill", "Dmitrievich", "Sharov", "prnkstr",
                "raper", "Relex", "Grodnenskaya 65", "2209094", "89805442972", "2999999", "spazmalgonchik@yandex.ru"));
        submitContactCreation();
        returnToHomePage();
    }


}
