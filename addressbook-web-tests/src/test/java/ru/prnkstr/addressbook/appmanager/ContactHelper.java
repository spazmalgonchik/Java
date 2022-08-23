package ru.prnkstr.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.prnkstr.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(ChromeDriver wd) {
        super(wd);
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void submitContactCreation() {
        click(By.xpath("//input[@value='Enter'][2]"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.firstName());
        type(By.name("middlename"), contactData.middleName());
        type(By.name("lastname"), contactData.lastName());
        type(By.name("nickname"), contactData.nickname());
        type(By.name("title"), contactData.title());
        type(By.name("company"), contactData.company());
        type(By.name("address"), contactData.address());
        type(By.name("home"), contactData.homePhone());
        type(By.name("mobile"), contactData.mobilePhone());
        type(By.name("work"), contactData.workPhone());
        type(By.name("email"), contactData.email());

    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }
}
