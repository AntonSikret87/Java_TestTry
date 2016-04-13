package ua.stqa.pft.mantis.appmanager;

import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by sikretSSD on 13.04.2016.
 */
public class FtpHelper {

    private FTPClient ftp;
    private final ApplicationManager app;

    public FtpHelper(ApplicationManager app) {
        this.app = app;
        ftp = new FTPClient();
    }

    public void upload(File file, String target, String backup) throws IOException {
        ftp.connect(app.getProperty("ftp.host"));
        ftp.login(app.getProperty("ftp.login"),app.getProperty("ftp.password"));
        ftp.deleteFile(backup);
        ftp.rename(target,backup);
        ftp.enterLocalPassiveMode();
        ftp.storeFile(target,new FileInputStream(file));
        ftp.disconnect();
    }

    public void restore(String target, String backup) throws IOException {
        ftp.connect(app.getProperty("ftp.host"));
        ftp.login(app.getProperty("ftp.login"),app.getProperty("ftp.password"));
        ftp.deleteFile(target);
        ftp.rename(backup,target);
        ftp.disconnect();
    }
}

