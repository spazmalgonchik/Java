package ru.prnkstr.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.prnkstr.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

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

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("title"), contactData.getTitle());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("work"), contactData.getWorkPhone());
        type(By.name("email"), contactData.getEmail());

        if (creation) {
            Select dropDown = new Select(wd.findElement(By.name("new_group")));
            if (isThereAGroupForContact(dropDown)) {
                dropDown.selectByVisibleText(contactData.getGroup());
            }
            Assert.assertTrue(isElementPresent(By.name("new_group")));
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void acceptContactDeletion() {
        wd.switchTo().alert().accept();
    }

    public void initContactModification(int index) {
        wd.findElements(By.xpath("//img[@title='Edit']")).get(index).click();
    }

    public void submitContactModification() {
        click(By.xpath("//input[@Value='Update'] [1]"));
    }

    public void createContact(ContactData contact) {
        initContactCreation();
        fillContactForm(contact, true);
        submitContactCreation();
        returnToHomePage();
    }

    public void modifyContact(ContactData contact, int index) {
        initContactModification(index);
        fillContactForm(contact, false);
        submitContactModification();
        returnToHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public boolean isThereAGroupForContact(Select dropDown) {
        return (dropDown.getOptions().size() - 1) > 0;
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name = 'entry']"));
        for (WebElement el : elements) {
            String lastName = el.findElement(By.xpath("//td[2]")).getText();
            String firstName = el.findElement(By.xpath("//td[3]")).getText();
            int id = Integer.parseInt(el.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData(id, firstName, null, lastName, null, null, null, null, null, null, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
