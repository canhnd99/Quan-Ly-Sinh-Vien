package controllers;

import connections.ConnectToDatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.DiemSo;

public class ScoreController {

    /*
    * Hàm này sẽ trả về một ArrayList<Score> chứa toàn bộ đối tượng Score trong Database
     */
    public ArrayList<DiemSo> getListScores(String query) {

        ArrayList<DiemSo> listScores = new ArrayList<>();

        ConnectToDatabase cnt = new ConnectToDatabase();
        Connection c = cnt.getConnection();

        try {
            Statement stm = c.createStatement();
            ResultSet res = stm.executeQuery(query);
            while (res.next()) {
                String studentId = res.getString("student_id");
                String courseId = res.getString("course_id");
                double score = res.getDouble("score");
                String status = res.getString("status");
                DiemSo ds = new DiemSo(studentId, courseId, score, status);
                listScores.add(ds);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return listScores;
    }

    /*
    * Hàm này dùng để xóa một đối tượng điểm số trong Database
     */
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
                JOptionPane.showMessageDialog(null, "UPDATE!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
