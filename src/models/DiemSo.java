package models;

public class DiemSo {

    private String studentId;
    private String courseId;
    private double score;
    private String status;

    public DiemSo() {
    }

    public DiemSo(String studentId, String courseId, double score, String status) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.score = score;
        this.status = status;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
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
