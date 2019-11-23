package models;

import connections.ConnectToDatabase;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Student {

    private String studentId;
    private String studentName;
    private String studentGender;
    private String studentBirthDate;
    private String studentPhone;
    private String studentAddress;

    public Student() {
    }

    public Student(String studentId, String studentName, String studentGender, String studentBirthDate, String studentPhone, String studentAddress) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentGender = studentGender;
        this.studentBirthDate = studentBirthDate;
        this.studentPhone = studentPhone;
        this.studentAddress = studentAddress;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public String getStudentBirthDate() {
        return studentBirthDate;
    }

    public void setStudentBirthDate(String studentBirthDate) {
        this.studentBirthDate = studentBirthDate;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public Object[] toObjects() {
        return new Object[]{studentId, studentName, studentGender, studentBirthDate, studentPhone, studentAddress};
    }

    public ArrayList<Student> getListStudents(int option, String id) {
        ArrayList<Student> listStudents = new ArrayList<>();
        ConnectToDatabase cnt = new ConnectToDatabase();
        Connection c = cnt.getConnection();
        try {
            String query = "";
            switch (option) {
                case 0:
                    query = "SELECT * FROM student";
                    break;
                case 1:
                    query = "SELECT * FROM student WHERE student_id = '" + id + "'";
                    break;
                default:
                    break;
            }
            Statement stm = c.createStatement();
            ResultSet res = stm.executeQuery(query);
            while (res.next()) {
                String msv = res.getString("student_id");
                String ten = res.getString("student_name");
                String gt = res.getString("student_gender");
                String sn = res.getString("student_birthDate");
                String sdt = res.getString("student_phone");
                String dc = res.getString("student_address");
                Student s = new Student(msv, ten, gt, sn, sdt, dc);
                listStudents.add(s);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return listStudents;
    }

    public void addNewStudentIntoDatabase(String id, String name, String gender,
            String birthDate, String phone, String address) {
        ConnectToDatabase cnt = new ConnectToDatabase();
        Connection c = cnt.getConnection();
        try {
            String query = "INSERT INTO student VALUES ('" + id + "', '" + name + "', '" + gender + "', '" + birthDate + "'," + "'" + phone + "', '" + address + "')";
            Statement stm = c.createStatement();
            stm.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "ADD NEW STUDENT.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
