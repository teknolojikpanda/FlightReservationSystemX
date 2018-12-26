import java.sql.SQLException;

public class main {

    public static void main(String[] args) throws SQLException {

        SqlConnection connection = new SqlConnection();
        connection.openConnection();

        mainFrame mainFrame = new mainFrame();
        mainFrame.setVisible(true);
    }
}
