package ru.prnkstr.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.prnkstr.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
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

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void acceptContactDeletion() {
        wd.switchTo().alert().accept();
    }

    public void initContactModification() {
        click(By.xpath("//img[@title='Edit']"));
    }

    public void submitContactModification() {
        click(By.xpath("//input[@Value='Update'] [1]"));
    }
}
