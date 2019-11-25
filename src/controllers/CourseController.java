package controllers;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import models.Course;

public class CourseController {

    public void addNewCourseIntoDatabase(JTextField txtCourseId, JTextField txtCourseName,
            JTextField txtCourseLevel, JTextField txtCourseTime) {

        String courseId = txtCourseId.getText();
        String courseName = txtCourseName.getText();
        String courseLevel = txtCourseLevel.getText();
        String courseTime = txtCourseTime.getText();

        if (courseId.equals("") || courseName.equals("")
                || courseLevel.equals("") || courseTime.equals("")) {
            JOptionPane.showMessageDialog(null, "One or more fields are empty.");
        } else {
            Course s = new Course();
            int level = Integer.parseInt(courseLevel);
            int time = Integer.parseInt(courseTime);
            s.addNewCourseIntoDatabase(courseId, courseName, level, time);
        }

    }

    public void addNewStudentCourseIntoDatabase(JTextField txtStudentId, JTextField txtCourseId,
            JTextField txtCourseName, JTextField txtCourseLevel, JTextField txtCourseTime) {

        String studentId = txtStudentId.getText().toUpperCase();
        String courseId = txtCourseId.getText().toUpperCase();
        String courseName = txtCourseName.getText();
        String courseLevel = txtCourseLevel.getText();
        String courseTime = txtCourseTime.getText();

        if (studentId.equals("") || courseId.equals("")
                || courseName.equals("") || courseLevel.equals("") || courseTime.equals("")) {
            JOptionPane.showMessageDialog(null, "One or more fields are empty.");
        } else {
            Course s = new Course();
            int level = Integer.parseInt(courseLevel);
            int time = Integer.parseInt(courseTime);
            s.addNewStudentCourseIntoDatabase(studentId, courseId, courseName, level, time);
        }
    }

    public void updateCourseInDatabase(JTextField couseId, JTextField courseName,
            JTextField courseLevel, JTextField courseTime) {
        String id = couseId.getText();
        String name = courseName.getText();
        String level = courseLevel.getText();
        String time = courseTime.getText();
        if (id.equals("") || name.equals("")
                || time.equals("") || level.equals("")) {
            JOptionPane.showMessageDialog(null, "One or more fields are empty.");
        } else {
            Course c = new Course();
            int lv = Integer.parseInt(level);
            int tg = Integer.parseInt(time);
            c.updateCourseInDatabase(id, name, lv, tg);
        }
    }

}
