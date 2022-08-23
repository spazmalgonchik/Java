package ru.prnkstr.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    ChromeDriver wd;

    public static boolean isAlertPresented(ChromeDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
        wd = new ChromeDriver();
        new WebDriverWait(wd, Duration.ofSeconds(10));
        wd.get("http://localhost/addressbook/");
        login("admin", "secret");
    }

    private void login(String username, String password) {
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//input[@value]")).click();
    }

    protected void returnToGroupPage() {
        wd.findElement(By.linkText("group page")).click();
    }

    protected void submitGroupCreation() {
        wd.findElement(By.name("submit")).click();
    }

    protected void fillGroupForm(GroupData groupData) {
        wd.findElement(By.name("group_name")).sendKeys(groupData.name());
        wd.findElement(By.name("group_header")).sendKeys(groupData.header());
        wd.findElement(By.name("group_footer")).sendKeys(groupData.footer());
    }

    protected void initGroupCreation() {
        wd.findElement(By.name("new")).click();
    }

    protected void gotoGroupPage() {
        wd.findElement(By.linkText("groups")).click();
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }

    protected void deleteSelectedGroups() {
        wd.findElement(By.name("delete")).click();
    }

    protected void selectGroup() {
        wd.findElement(By.name("selected[]")).click();
    }

    protected void returnToHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    protected void submitContactCreation() {
        wd.findElement(By.xpath("//input[@value='Enter'][2]")).click();
    }

    protected void fillContactForm(ContactData contactData) {
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

    protected void initContactCreation() {
        wd.findElement(By.linkText("add new")).click();
    }
}
