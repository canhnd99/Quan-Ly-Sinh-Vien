package controllers;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import models.User;

public class UserController {

    
    public boolean checkUserIsExist(JTextField txtUsername,
            JPasswordField txtPassword, JTextField txtEmail) {
        User user = new User();
        String username = txtUsername.getText();
        String password = String.valueOf(txtPassword.getPassword());
        String email = txtEmail.getText();
        if (username.equals("") || password.equals("") || email.equals("")) {
            JOptionPane.showMessageDialog(null, "One or more fields are empty.");
        } else {
            if (user.checkUserIsExist(username, password, email)) {
                return true;
            }
        }
        return false;
    }

    
    public void addUserIntoDatabase(JTextField txtUsername,
            JPasswordField txtPassword, JTextField txtEmail) {
        User user = new User();
        String username = txtUsername.getText();
        String password = String.valueOf(txtPassword.getPassword());
        String email = txtEmail.getText();
        if (username.equals("") || password.equals("") || email.equals("")) {
            JOptionPane.showMessageDialog(null, "One or more fields are empty.");
        } else {
            user.addUserIntoDatabase(username, password, email);
        }
    }

}
