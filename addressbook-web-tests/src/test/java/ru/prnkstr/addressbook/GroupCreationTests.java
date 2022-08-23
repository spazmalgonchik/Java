package ru.prnkstr.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GroupCreationTests {

    ChromeDriver wd;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "E:\\Java\\java_test\\chromedriver.exe");
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }

    @Test
    public void groupCreationTests() {
        wd.get("http://localhost/addressbook/");
        wd.findElement(By.name("user")).sendKeys("admin");
        wd.findElement(By.name("pass")).sendKeys("secret");
        wd.findElement(By.xpath("//input[@value]")).click();
        wd.findElement(By.linkText("groups")).click();
        wd.findElement(By.name("new")).click();
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).sendKeys("Test_Group_Name_1");
        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).sendKeys("Test");
        wd.findElement(By.name("group_header")).sendKeys("Test_Group_Header_1");
        wd.findElement(By.name("group_footer")).sendKeys("Test_Group_Footer_1");
        wd.findElement(By.name("submit")).click();
        wd.findElement(By.linkText("group page")).click();
        wd.manage().window().setSize(new Dimension(1900, 1020));
    }
}
