package ua.stqa.pft.github;


import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by sikretSSD on 23.04.2016.
 */
public class GitHubTests {

    @Test
    public void testCommits() throws IOException {
        Github github = new RtGithub("95557c840170a563a20da2d36292784b72befdd8");
        RepoCommits commits = github.repos().get(new Coordinates.Simple("AntonSikret87", "Java_TestTry")).commits();
        for(RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())){
            System.out.println("Link commits " + commit);
            System.out.println("Text of commits " + new RepoCommit.Smart(commit).message());
        }
    }
}
