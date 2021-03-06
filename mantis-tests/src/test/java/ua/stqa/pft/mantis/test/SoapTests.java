package ua.stqa.pft.mantis.test;

import org.testng.annotations.Test;
import ua.stqa.pft.mantis.model.Issue;
import ua.stqa.pft.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

/**
 * Created by sikretSSD on 19.04.2016.
 */
public class SoapTests extends TestBase {

    @Test
    public void testGetProject() throws MalformedURLException, ServiceException, RemoteException {
        Set<Project> projects = app.soap().getProjects();
        System.out.println(projects.size());
        for(Project project : projects){
            System.out.println(project.getName());
        }
    }

    @Test
    public void testCreateIssue() throws RemoteException, ServiceException, MalformedURLException {
        Set<Project> projects = app.soap().getProjects();
        Issue issue = new Issue().withSummary("Test summaru")
                .withDescription("Test description").withProject(projects.iterator().next());
        Issue created = app.soap().addIssue(issue);
        assertEquals(issue.getSummary(), created.getSummary());
    }

    @Test
    public void testCreateIssueIntegrationMantis() throws RemoteException, ServiceException, MalformedURLException {
        skipIfNotFixed(10000);
        Set<Project> projects = app.soap().getProjects();
        Issue issue = new Issue().withSummary("Test summaru")
                .withDescription("Test description").withProject(projects.iterator().next());
        Issue created = app.soap().addIssue(issue);
        assertEquals(issue.getSummary(), created.getSummary());
    }

    @Test
    public void testIssueStatusAPI() throws RemoteException, ServiceException, MalformedURLException {
        skipIfNotFixed(1);
        System.err.println("test");
    }
}
