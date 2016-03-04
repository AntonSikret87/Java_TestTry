package ua.stqu.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ua.stqu.pft.addressbook.model.ContactData;

import java.util.concurrent.TimeUnit;

/**
 * Created by sikretSSD on 04.03.2016.
 */
public class ApplicationManager {
    FirefoxDriver wd;

    private SessionHelper  sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupsHelper groupsHelper;
    private ContactHelper contactHelper;

    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost:8080/addressbook/group.php");
        groupsHelper = new GroupsHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        contactHelper = new ContactHelper(wd);
        sessionHelper.login("admin","secret");
    }


    public void returnToHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }


    public void stop() {
        wd.quit();
    }

    public GroupsHelper getGroupsHelper() {
        return groupsHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
