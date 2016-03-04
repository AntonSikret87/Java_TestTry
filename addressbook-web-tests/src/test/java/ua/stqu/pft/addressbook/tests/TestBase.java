package ua.stqu.pft.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.openqa.selenium.remote.BrowserType;
import ua.stqu.pft.addressbook.appmanager.ApplicationManager;

/**
 * Created by sikretSSD on 03.03.2016.
 */
public class TestBase {


    protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

}
