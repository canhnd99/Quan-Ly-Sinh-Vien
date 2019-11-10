package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectToDatabase {
    public Connection getConnection(){
        String url = "jdbc:mysql://localhost/sms";
        String user = "root";
        String pass = "1234";
        try {
            Connection cnt = DriverManager.getConnection(url, user, pass);
            return cnt;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
}
