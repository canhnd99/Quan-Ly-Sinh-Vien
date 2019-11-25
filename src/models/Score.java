package models;

import connections.ConnectToDatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Score {

    private String studentId;
    private String courseId;
    private double score;
    private String status;

    public Score() {
    }

    public Score(String studentId, String courseId, double score, String status) {
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

    public ArrayList<Score> getListScores(int option, double score, String id) {
        ArrayList<Score> listScores = new ArrayList<>();
        ConnectToDatabase cnt = new ConnectToDatabase();
        Connection c = cnt.getConnection();
        try {
            String query = "";
            switch (option) {
                case 0:
                    query = "SELECT * FROM score";
                    break;
                case 1:
                    query = "SELECT * FROM score WHERE student_id = '" + id + "'";
                    break;
                case 2:
                    query = "SELECT * FROM score WHERE course_id = '" + id + "'";
                    break;
                case 3:
                    query = "SELECT * FROM score WHERE score > '" + score + "'";
                    break;
                case 4:
                    query = "SELECT * FROM score WHERE score < '" + score + "'";
                    break;
                default:
                    break;
            }
            Statement stm = c.createStatement();
            ResultSet res = stm.executeQuery(query);
            while (res.next()) {
                String msv = res.getString("student_id");
                String mkh = res.getString("course_id");
                double ds = res.getDouble("score");
                String tt = res.getString("status");
                Score diemSo = new Score(msv, mkh, ds, tt);
                listScores.add(diemSo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return listScores;
    }

    public void addNewScoreIntoDatabase(String studentId, String courseId,
            double score, String status) {
        ConnectToDatabase cnt = new ConnectToDatabase();
        Connection c = cnt.getConnection();
        try {
            String selectQuery = "SELECT * FROM student, course WHERE student.student_id = '" + studentId + "' AND course.course_id = '" + courseId + "'";
            String updateQuery = "INSERT INTO score VALUES ('" + studentId + "', '" + courseId + "', '" + score + "', '" + status + "')";
            Statement stm = c.createStatement();
            ResultSet res1 = stm.executeQuery(selectQuery);
            if (res1.next()) {
                stm.executeUpdate(updateQuery);
                JOptionPane.showMessageDialog(null, "ADD NEW SCORE.");
            } else {
                JOptionPane.showMessageDialog(null, "Student ID or Course ID is incorrect!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Student or course code matches.");
        }
    }

    public void deleteScoreInDatabase(String studentId) {
        ConnectToDatabase cnt = new ConnectToDatabase();
        Connection c = cnt.getConnection();
        try {
            int choose = JOptionPane.showConfirmDialog(null, "DELETE THIS SCORE?");
            if (choose == 0) {
                String query = "DELETE FROM score WHERE student_id = '" + studentId + "'";
                Statement stm = c.createStatement();
                stm.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "DELETED!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void updateScoreInDatabase(String studentId, String courseId,
            double score, String status) {
        ConnectToDatabase cnt = new ConnectToDatabase();
        Connection c = cnt.getConnection();
        try {
            int choose = JOptionPane.showConfirmDialog(null, "UPDATE THIS SCORE?");
            if (choose == 0) {
                String query = "UPDATE score "
                        + "SET score = '" + score + "', status = '" + status + "'"
                        + " WHERE student_id = '" + studentId + "' AND course_id = '" + courseId + "'";
                Statement stm = c.createStatement();
                stm.executeUpdate(query);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
