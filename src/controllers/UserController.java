package controllers;

import connections.ConnectToDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.User;

public class UserController {

    ConnectToDatabase cnt;

    public UserController() {
        cnt = new ConnectToDatabase();
    }

    public boolean checkInput(String username, String password, String email) {
        if (username.equals("") || password.equals("") || email.equals("")) {
            return false;
        }
        return true;
    }

    public boolean checkUserIsExist(String name, String pass) {

        Connection c = cnt.getConnection();
        PreparedStatement ps;
        try {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            ps = c.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, pass);
            ps.execute();
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex);
        }
        return false;

    }

    public void addUserIntoDatabase(String name, String pass, String email) {

        if (!checkInput(name, pass, email)) {
            JOptionPane.showMessageDialog(null, "One or more fields are empty!");
        } else if (checkUserIsExist(name, pass)) {
            JOptionPane.showMessageDialog(null, "Account already exist!");
        } else {
            Connection c = cnt.getConnection();
            PreparedStatement ps;
            try {
                String query = "INSERT INTO users VALUES(?, ?, ?)";
                ps = c.prepareStatement(query);
                ps.setString(1, name);
                ps.setString(2, pass);
                ps.setString(3, email);
                ps.execute();
                JOptionPane.showMessageDialog(null, "ADDED");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }

    }

    public ArrayList<User> getListUsers() {
        ArrayList<User> listUsers = new ArrayList<>();

        try {
            Connection c = cnt.getConnection();

            Statement statement = c.createStatement();

            String query = "SELECT * FROM users";

            ResultSet res = statement.executeQuery(query);

            while (res.next()) {
                String user = res.getString("username");
                String pass = res.getString("password");
                String mail = res.getString("email");
                User u = new User(user, pass, mail);
                listUsers.add(u);
                System.out.println("Heello Huy");
            }
            return listUsers;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }

}
