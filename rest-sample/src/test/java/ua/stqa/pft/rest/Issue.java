package ua.stqa.pft.rest;

/**
 * Created by sikretSSD on 23.04.2016.
 */
public class Issue {
    private int id;
    private String subject;
    private String description;


    public int getId() {
        return id;
    }

    public Issue withId(int id) {
        this.id = id;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public Issue withSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Issue withDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Issue issue11 = (Issue) o;

        if (id != issue11.id) return false;
        if (subject != null ? !subject.equals(issue11.subject) : issue11.subject != null) return false;
        return description != null ? description.equals(issue11.description) : issue11.description == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
