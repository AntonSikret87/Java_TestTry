package ua.stqa.pft.mantis.model;

/**
 * Created by sikretSSD on 13.04.2016.
 */
public class MailMessage {
    public String to;
    public String text;

    public MailMessage (String to, String text){
        this.to = to;
        this.text = text;
    }
}
