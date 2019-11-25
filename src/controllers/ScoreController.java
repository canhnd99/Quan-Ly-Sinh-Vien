package controllers;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import models.Score;

public class ScoreController {

    public void addNewScoreIntoDatabase(JTextField txtStudentId, JTextField txtCourseId,
            JTextField txtScore, JTextField txtStatus) {

        String studentId = txtStudentId.getText().toUpperCase();
        String courseId = txtCourseId.getText().toUpperCase();
        String score = txtScore.getText();
        String status = txtStatus.getText();

        if (studentId.equals("") || courseId.equals("")
                || score.equals("") || status.equals("")) {
            JOptionPane.showMessageDialog(null, "One or more fields are empty.");
        } else {
            Score s = new Score();
            double diemso = Double.parseDouble(score);
            if (diemso < 0 || diemso > 10) {
                JOptionPane.showMessageDialog(null, "Your score is illegal!");
            } else {
                s.addNewScoreIntoDatabase(studentId, courseId, diemso, status);
            }
        }
    }

    public void updateScoreInDatabase(JTextField txtStudentId, JTextField txtCourseId,
            JTextField txtScore, JTextField txtStatus) {
        String studentId = txtStudentId.getText();
        String courseId = txtCourseId.getText();
        String score = txtScore.getText();
        String status = txtStatus.getText();
        if (studentId.equals("") || courseId.equals("")
                || score.equals("") || status.equals("")) {
            JOptionPane.showMessageDialog(null, "One or more fields are empty.");
        } else {
            Score s = new Score();
            double diemso = Double.parseDouble(score);
            s.updateScoreInDatabase(studentId, courseId, diemso, status);
        }
    }
}
