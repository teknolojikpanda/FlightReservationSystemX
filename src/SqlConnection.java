import java.sql.*;
import javax.swing.JOptionPane;

public class SqlConnection extends main {


    private static String dbURL = "jdbc:derby://localhost:1527//Project;create=true;user=APP";
    public static Connection con;


    public static void openConnection() {

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();

            con = DriverManager.getConnection(dbURL);

            JOptionPane.showMessageDialog(null, "Database connection is sucessful");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection Failed", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.print(e.getMessage());
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static void closeConnection() {

        try {
            JOptionPane.showMessageDialog(null, "Database connection is closed sucessful");
            con.close();
            con = null;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection not closed", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
    }
}