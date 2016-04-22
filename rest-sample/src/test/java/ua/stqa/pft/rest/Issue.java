package ua.stqa.pft.rest;

/**
 * Created by sikretSSD on 22.04.2016.
 */
public class Issue {
    private int id;
    private String subject;
    private String descroption;

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

    public String getDescroption() {
        return descroption;
    }

    public Issue withDescroption(String descroption) {
        this.descroption = descroption;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Issue issue = (Issue) o;

        if (id != issue.id) return false;
        if (subject != null ? !subject.equals(issue.subject) : issue.subject != null) return false;
        return descroption != null ? descroption.equals(issue.descroption) : issue.descroption == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (descroption != null ? descroption.hashCode() : 0);
        return result;
    }
}
