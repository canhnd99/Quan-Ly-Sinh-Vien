package models;

public class Course {

    private String courseId;
    private String courseName;
    private int courseTime;
    private int courseLevel;

    public Course() {
    }

    public Course(String courseId, String courseName, int courseTime, int courseLevel) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseTime = courseTime;
        this.courseLevel = courseLevel;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(int courseTime) {
        this.courseTime = courseTime;
    }

    public int getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(int courseLevel) {
        this.courseLevel = courseLevel;
    }
    
}
