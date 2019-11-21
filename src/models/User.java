package models;

import connections.ConnectToDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class User {

    ConnectToDatabase cnt = new ConnectToDatabase();

    private String username;
    private String password;
    private String email;

    public User() {
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    /*
    * Return true if user already exist in database.
    * Call this method when user sign in.
    */
    public boolean checkUserIsExist(String name, String pass, String email) {
        Connection c = cnt.getConnection();
        PreparedStatement ps;
        try {
            String query = "SELECT * FROM user WHERE username = ? AND password = ?";
            ps = c.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, pass);
            ps.setString(2, email);
            ps.execute();
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }
    
    /*
    * Add new user into DB if 
    */
    public void addUserIntoDatabase(String name, String pass, String email) {
        Connection c = cnt.getConnection();
        PreparedStatement ps;
        try {
            String query = "INSERT INTO user VALUES(?, ?, ?)";
            ps = c.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, pass);
            ps.setString(3, email);
            ps.execute();
            JOptionPane.showMessageDialog(null, "ADD NEW USER.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    

    public ArrayList<User> getListUsers() {
        ArrayList<User> listUsers = new ArrayList<>();
        try {
            Connection c = cnt.getConnection();
            Statement statement = c.createStatement();
            String query = "SELECT * FROM user";
            ResultSet res = statement.executeQuery(query);
            while (res.next()) {
                String user = res.getString("username");
                String pass = res.getString("password");
                String mail = res.getString("email");
                User u = new User(user, pass, mail);
                listUsers.add(u);
            }
            return listUsers;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }
}
