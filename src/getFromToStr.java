import javax.swing.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class getFromToStr {

    private static Statement st;
    private SqlConnection connection = new SqlConnection();

    public DefaultComboBoxModel getItem(String tableName){

        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();


        try {

            st = connection.con.createStatement();

            ResultSet result = st.executeQuery("SELECT * FROM "+tableName);

            while(result.next()){

                comboBoxModel.addElement(result.getString(1));

            }

            result.close();
            st.close();

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Records cannot return from the database", "Error",JOptionPane.ERROR_MESSAGE);
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
        return comboBoxModel;
    }
}