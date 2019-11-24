package models;

import connections.ConnectToDatabase;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Course {

    private String studentId;
    private String courseId;
    private String courseName;
    private int courseTime;
    private int courseLevel;

    public Course() {
    }

    public Course(String studentId, String courseId, String courseName, int courseTime, int courseLevel) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseTime = courseTime;
        this.courseLevel = courseLevel;
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

    public void loadCourseIdToCombobox(JComboBox courseBox) {
        ConnectToDatabase cnt = new ConnectToDatabase();
        Connection c = cnt.getConnection();
        try {
            String query = "SELECT * FROM course";
            Statement stm = c.createStatement();
            ResultSet res = stm.executeQuery(query);
            while (res.next()) {
                courseBox.addItem(res.getString("course_id"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void fillCourseFields(String id, JTextField txtId, JTextField txtName,
            JTextField txtLevel, JTextField txtTime) {
        ConnectToDatabase cnt = new ConnectToDatabase();
        Connection c = cnt.getConnection();
        try {
            String query = "SELECT * FROM course WHERE course_id = '" + id + "'";
            Statement stm = c.createStatement();
            ResultSet res = stm.executeQuery(query);
            while (res.next()) {
                txtId.setText(res.getString("course_id"));
                txtId.setForeground(Color.BLACK);
                txtName.setText(res.getString("course_name"));
                txtName.setForeground(Color.BLACK);
                txtTime.setText(res.getString("course_time"));
                txtTime.setForeground(Color.BLACK);
                txtLevel.setText(res.getString("course_level"));
                txtLevel.setForeground(Color.BLACK);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ArrayList<Course> getListStudentCourses(int option, String id) {
        ArrayList<Course> listCourses = new ArrayList<>();
        ConnectToDatabase cnt = new ConnectToDatabase();
        Connection c = cnt.getConnection();
        try {
            String query = "";
            switch (option) {
                case 0:
                    query = "SELECT * FROM student_course";
                    break;
                case 1:
                    query = "SELECT * FROM student_course WHERE student_id = '" + id + "'";
                    break;
                default:
                    break;
            }
            Statement stm = c.createStatement();
            ResultSet res = stm.executeQuery(query);
            while (res.next()) {
                String msv = res.getString("student_id");
                String mkh = res.getString("course_id");
                String tkh = res.getString("course_name");
                int md = res.getInt("course_level");
                int tg = res.getInt("course_time");
                Course khoaHoc = new Course(msv, mkh, tkh, md, tg);
                listCourses.add(khoaHoc);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return listCourses;
    }

    public void addNewCourseIntoDatabase(String courseId, String courseName, int time, int level) {
        ConnectToDatabase cnt = new ConnectToDatabase();
        Connection c = cnt.getConnection();
        try {
            String query = "INSERT INTO course VALUES ('" + courseId + "', '" + courseName + "', '" + time + "'," + "'" + level + "')";
            Statement stm = c.createStatement();
            stm.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "ADD NEW COURSE.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void addNewStudentCourseIntoDatabase(String studentId, String courseId,
            String courseName, int level, int time) {
        ConnectToDatabase cnt = new ConnectToDatabase();
        Connection c = cnt.getConnection();
        try {

            String query1 = "SELECT * FROM student WHERE student_id = '" + studentId + "'";
            String query = "INSERT INTO student_course VALUES ('" + studentId + "', '" + courseId + "', '" + courseName + "', '" + level + "'," + "'" + time + "')";
            Statement stm = c.createStatement();
            ResultSet res1 = stm.executeQuery(query1);
            if (res1.next()) {
                stm.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "ADD NEW STUDENT'S COURSE.");
            } else {
                JOptionPane.showMessageDialog(null, "Student ID is incorrect.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void updateCourseInDatabase(String courseId, String courseName,
            int time, int level) {
        ConnectToDatabase cnt = new ConnectToDatabase();
        Connection c = cnt.getConnection();
        try {
            String query = "UPDATE course SET course_name = '" + courseName + "', course_level = '" + level + "', course_time = '" + time + "' WHERE course_id = '" + courseId + "'";
            Statement stm = c.createStatement();
            stm.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "UPDATE!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void delete(int option, String studentId, String courseId) {
        ConnectToDatabase cnt = new ConnectToDatabase();
        Connection c = cnt.getConnection();
        try {
            String query = "";
            switch (option) {
                case 0:
                    query = "DELETE FROM course WHERE course_id = '" + courseId + "'";
                    break;
                case 1:
                    query = "DELETE FROM student_course WHERE student_id = '" + studentId + "' AND course_id = '" + courseId + "'";
                default:
                    break;
            }
            Statement stm = c.createStatement();
            stm.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "DELETE");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
