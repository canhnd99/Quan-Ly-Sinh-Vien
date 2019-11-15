package models;

public class Score {

    private Student student;
    private Course course;
    private double score;
    private String status;

    public Score() {
    }

    public Score(Student student, Course course, double score, String status) {
        this.student = student;
        this.course = course;
        this.score = score;
        this.status = status;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
