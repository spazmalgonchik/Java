package ru.prnkstr.addressbook.tests;

import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.prnkstr.addressbook.appmanager.ApplicationManager;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(Browser.CHROME);

    @BeforeMethod
    public void setUp() {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }


}
