package controllers;

import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import models.Student;

public class StudentController {

    Student std = new Student();

    public void addNewStudentIntoDatabase(JTextField txt_id, JTextField txt_name,
            String gender, JDateChooser birthDate, JTextField txt_phone, JTextArea txt_address) {

        String msv = txt_id.getText().toUpperCase();
        String ten = txt_name.getText();
        String gt = gender;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String ns = dateFormat.format(birthDate.getDate());
        String sdt = txt_phone.getText();
        String dc = txt_address.getText();

        if (msv.equals("") || ten.equals("")
                || ns.equals("") || sdt.equals("") || dc.equals("")) {
            JOptionPane.showMessageDialog(null, "One or more field are empty!");
        } else if ((sdt.length() > 10 || sdt.length() < 9) && !sdt.startsWith("0")) {
            JOptionPane.showMessageDialog(null, "Your phone number is incorrect!");
        } else {
            std.addNewStudentIntoDatabase(msv, ten, gt, ns, sdt, dc);
        }
    }

    public void updateStudentInfo(JTextField txt_id, JTextField txt_name,
            String gender, JDateChooser birthDate, JTextField txt_phone, JTextArea txt_address) {

        String msv = txt_id.getText();
        String ten = txt_name.getText();
        String gt = gender;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String ns = dateFormat.format(birthDate.getDate());
        String sdt = txt_phone.getText();
        String dc = txt_address.getText();

        if (msv.equals("") || ten.equals("")
                || ns.equals("") || sdt.equals("") || dc.equals("")) {
            JOptionPane.showMessageDialog(null, "One or more field are empty!");
        } else {
            std.updateStudentInfo(msv, ten, gt, ns, sdt, dc);
        }
    }
}
