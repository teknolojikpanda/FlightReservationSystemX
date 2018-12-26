import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class loginBTNfunction {

    private static PreparedStatement st;
    SqlConnection connection = new SqlConnection();

    public void loginCheck(String username, String password) {

        try {

            st = connection.con.prepareStatement("SELECT * FROM LOGIN_INFOS WHERE USERNAME= ? AND PASSWORD= ?");
            st.setString(1,username);
            st.setString(2,password);

            ResultSet result = st.executeQuery();

            if(result.next()){
                adminPanelFrame newFrame = new adminPanelFrame();
                newFrame.setVisible(true);
            }

            else {
                JOptionPane.showMessageDialog(null, "Your username or password are incorrect","Error", JOptionPane.ERROR_MESSAGE);
            }

            result.close();
            st.close();

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Records cannot return from the database", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
    }
}
