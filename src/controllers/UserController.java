package controllers;

import connections.ConnectToDatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.User;

public class UserController {

    public boolean checkInput(String username, String password, String email) {

        if (username.equals("") || password.equals("") || email.equals("")) {
            return false;
        }

        return true;
    }
    
    public void addUserIntoDatabase(){
        
    }

    public ArrayList<User> getListUsers(String username, String password, String email) {

        ArrayList<User> lisetUsers = new ArrayList<>();

        ConnectToDatabase cnt = new ConnectToDatabase();

        try {
            Connection c = cnt.getConnection();

            Statement statement = c.createStatement();

            String query = "SELECT * FROM users";

            ResultSet res = statement.executeQuery(query);

            while (res.next()) {
                int id = res.getInt("id");
                String user = res.getString("username");
                String pass = res.getString("password");
                String mail = res.getString("email");
                User u = new User(id, user, pass, mail);
                lisetUsers.add(u);
            }
            return lisetUsers;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }

}
