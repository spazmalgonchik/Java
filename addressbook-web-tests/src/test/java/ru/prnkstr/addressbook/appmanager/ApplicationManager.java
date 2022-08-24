package ru.prnkstr.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;

import java.time.Duration;


public class ApplicationManager {
    WebDriver wd;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private final Browser browser;

    public ApplicationManager(Browser browser) {
        this.browser = browser;
    }


    public void init() {

        if (browser.equals(Browser.FIREFOX)) {
            System.setProperty("webdriver.gecko.driver", "..\\geckodriver.exe");
            wd = new FirefoxDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", "..\\chromedriver.exe");
            wd = new ChromeDriver();
        }

        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        wd.get("http://localhost/addressbook/");
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        contactHelper = new ContactHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        wd.quit();
    }


    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
