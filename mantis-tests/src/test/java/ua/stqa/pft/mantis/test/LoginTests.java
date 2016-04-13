package ua.stqa.pft.mantis.test;

import org.testng.annotations.Test;
import ua.stqa.pft.mantis.appmanager.HttpSession;
import java.io.IOException;
import static org.testng.Assert.assertTrue;

/**
 * Created by sikretSSD on 13.04.2016.
 */
public class LoginTests extends TestBase {

    @Test
    public void testLogin() throws IOException {
        HttpSession session = app.newSession();
        assertTrue(session.login("administrator", "root"));
        assertTrue(session.isloggedInAs("administrator"));

    }
}
