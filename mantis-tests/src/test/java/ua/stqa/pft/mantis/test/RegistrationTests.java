package ua.stqa.pft.mantis.test;

import org.testng.annotations.Test;

/**
 * Created by sikretSSD on 13.04.2016.
 */
public class RegistrationTests extends TestBase {

    @Test
    public void testRegistration(){
        app.registration().start("user1", "user1@localhost.localdomain");
    }
}
