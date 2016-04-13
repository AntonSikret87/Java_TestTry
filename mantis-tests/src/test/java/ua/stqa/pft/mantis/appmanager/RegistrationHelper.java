package ua.stqa.pft.mantis.appmanager;

import org.openqa.selenium.WebDriver;

/**
 * Created by sikretSSD on 13.04.2016.
 */
public class RegistrationHelper {
    private final ApplicationManager app;
    private WebDriver wd;


    public RegistrationHelper(ApplicationManager app) {
        this.app=app;
        wd = app.getDriver();
    }

    public void start(String username, String email) {
        wd.get(app.getProperty("web.BaseURL") + "/signup_page.php");
    }
}
