package ua.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

/**
 * Created by sikretSSD on 13.04.2016.
 */
public class RegistrationHelper extends HelperBase{
   // private final ApplicationManager app;
   // private WebDriver wd;


    public RegistrationHelper(ApplicationManager app) {
        super(app);
       // this.app=app;
       // wd = app.getDriver();
    }

    public void start(String username, String email) {
        wd.get(app.getProperty("web.BaseURL") + "/signup_page.php");
        type(By.name("username"),username);
        type(By.name("email"),email);
        click(By.cssSelector("input[value='Signup']"));
    }

    public void finish(String confirmationLink, String password) {
        wd.get(confirmationLink);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.cssSelector("input[value='Update User']"));
    }
}
