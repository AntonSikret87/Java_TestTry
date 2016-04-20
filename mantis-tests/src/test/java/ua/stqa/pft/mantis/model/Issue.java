package ua.stqa.pft.mantis.model;

/**
 * Created by sikretSSD on 19.04.2016.
 */
public class Issue {

    private int id;
    private String summary;
    private String description;
    private Project project;

    public int getId() {
        return id;
    }

    public Issue withId(int id) {
        this.id = id;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public Issue withSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Issue withDescription(String description) {
        this.description = description;
        return this;
    }

    public Project getProject() {
        return project;
    }

    public Issue withProject(Project project) {
        this.project = project;
        return this;
    }
}


//    private int id;
//    private String summaru;
//    private String description;
//    private Project project;
//
//    public int getId() {
//        return id;
//    }
//
//    public Issue withId(int id) {
//        this.id = id;
//        return this;
//    }
//
//    public String getSummaru() {
//        return summaru;
//    }
//
//    public Issue withSummary(String summaru) {
//        this.summaru = summaru;
//        return this;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public Issue withDescription(String description) {
//        this.description = description;
//        return this;
//    }
//
//    public Project getProject() {
//        return project;
//    }
//
//    public Issue withProject(Project project) {
//        this.project = project;
//        return this;
//    }
//}
