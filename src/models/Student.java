package models;

import java.sql.Date;

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
    public Object[] toObjects(){
        return new Object[]{studentId, studentName, studentGender, studentBirthDate, studentPhone,  studentAddress};
    }
}
