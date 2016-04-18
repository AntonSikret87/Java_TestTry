package ua.stqa.pft.mantis.test;

import org.testng.annotations.Test;
import ua.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by sikretSSD on 15.04.2016.
 */
public class ChangePasswordTests extends TestBase {


    @Test
    public void testPasswordChange () throws IOException, MessagingException {
        app.admin().startResetPassword();
        String email = app.admin().getUserEmail();
        System.out.println(email);
        String username = app.admin().getUsername();
        System.out.println(username);
        app.admin().resetPassword();
        List<MailMessage> mailMessages = app.mail().waitForMail(1, 90000);
        String confirmationLink = app.mail().findConfirmationLink(mailMessages, email);
        String newPassword = "newpassword";
        app.admin().completeResetPassword(confirmationLink, newPassword);
        assertTrue(app.newSession().login(username, newPassword));
    }

}
