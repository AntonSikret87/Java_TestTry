package ua.stqu.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ua.stqu.pft.addressbook.appmanager.ApplicationManager;

/**
 * Created by sikretSSD on 03.03.2016.
 */
public class TestBase {


    protected static final ApplicationManager app =
            new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
  //  new ApplicationManager(BrowserType.CHROME)
    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}
