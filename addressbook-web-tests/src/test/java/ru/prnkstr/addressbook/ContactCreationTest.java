package ru.prnkstr.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ContactCreationTest {
    ChromeDriver wd;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
        wd = new ChromeDriver();
        new WebDriverWait(wd, Duration.ofSeconds(10));
        wd.get("http://localhost/addressbook/");
        login("admin", "secret");
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }

    @Test
    public void contactCreation() {
        initContactCreation();
        fillContactForm(new ContactData("Kirill", "Dmitrievich", "Sharov", "prnkstr", "raper", "Relex", "Grodnenskaya 65", "2209094", "89805442972", "2999999", "spazmalgobchik@yandex.ru"));
        submitContactCreation();
        returnToHomePage();
    }

    private void returnToHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    private void submitContactCreation() {
        wd.findElement(By.xpath("//input[@value='Enter'][2]")).click();
    }

    private void fillContactForm(ContactData contactData) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).sendKeys(contactData.firstName());
        wd.findElement(By.name("middlename")).sendKeys(contactData.middleName());
        wd.findElement(By.name("lastname")).sendKeys(contactData.lastName());
        wd.findElement(By.name("nickname")).sendKeys(contactData.nickname());
        wd.findElement(By.name("title")).sendKeys(contactData.title());
        wd.findElement(By.name("company")).sendKeys(contactData.company());
        wd.findElement(By.name("address")).sendKeys(contactData.address());
        wd.findElement(By.name("home")).sendKeys(contactData.homePhone());
        wd.findElement(By.name("mobile")).sendKeys(contactData.mobilePhone());
        wd.findElement(By.name("work")).sendKeys(contactData.workPhone());
        wd.findElement(By.name("email")).sendKeys(contactData.email());
    }

    private void initContactCreation() {
        wd.findElement(By.linkText("add new")).click();
    }

    private void login(String username, String password) {
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//input[@value]")).click();
    }
}
