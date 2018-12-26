import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class buyFunction {

    private static Statement st;
    private SqlConnection connection = new SqlConnection();
    String passportMatch = null;
    String phoneMatch = null;
    String emailMatch = null;


    public void buyFunction(String gender, String name, String surname, String passNum, String birthDate, String telNo, String email, int flightID, int classVal,int busSeat, int ecoSeat) throws SQLException{

        String validatePerson = "SELECT * FROM PASSENGERS WHERE PASSPORT_NUM='"+passNum+"' OR TEL_NO='"+telNo+"' OR EMAIL='"+email+"'";

        int seat = 0;
        String classValStr = "";
        st = connection.con.createStatement();
        String removePerson = "DELETE FROM PASSENGERS WHERE PASSPORT_NUM='"+passNum+"'";
        String downSeat = "";
        String addPerson = "INSERT INTO PASSENGERS (GENDER,PASS_NAME,PASS_SURNAME,PASSPORT_NUM,BIRTH_DATE,TEL_NO,EMAIL) VALUES (" + "'" + gender + "','" + name + "','" + surname + "','" + passNum + "','" + birthDate + "','" + telNo + "','" + email + "')";

        if (classVal == 1){
            classValStr = "Economy";
            seat = ecoSeat;
            seat--;
            downSeat = "UPDATE FLIGHTS SET ECOSEAT =" + seat + "WHERE FLIGHT_ID = "+ flightID ;
        }
        else if(classVal == 2){
            classValStr = "Business";
            seat = busSeat;
            seat --;
            downSeat = "UPDATE FLIGHTS SET BUSINESSSEAT =" + seat + "WHERE FLIGHT_ID = "+ flightID ;
        }

        String addTicket = "INSERT INTO TICKETS (FLIGHT_ID,PASSPORT_NUM,SEAT) VALUES ("+ flightID +",'"+ passNum +"','"+ classValStr +"')";

        ResultSet result = st.executeQuery(validatePerson);
        while (result.next()){
            passportMatch = result.getString(4);
            phoneMatch = result.getString(6);
            emailMatch = result.getString(7);
        }

        if (passportMatch == null || phoneMatch == null ||  emailMatch == null){
            try {
                st.executeUpdate(addPerson);
            } catch (SQLException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null,"Your payment is FAILED.");
            }

            operation(removePerson, downSeat);

            operation2(seat, removePerson, downSeat, addTicket);
        }
        else{
            JOptionPane.showMessageDialog(null,"User already recorded!");

            operation(removePerson, downSeat);

            operation2(seat, removePerson, downSeat, addTicket);
        }

    }

    private void operation2(int seat, String removePerson, String downSeat, String addTicket) throws SQLException {
        try {
            st.executeUpdate(addTicket);
            JOptionPane.showMessageDialog(null,"Your payment is DONE.");
            System.exit(0);
        } catch (SQLException e1) {
            int newSeat = seat++;
            e1.printStackTrace();
            st.executeUpdate(removePerson);
            st.executeUpdate(downSeat);//upSeat
            JOptionPane.showMessageDialog(null,"Your payment is FAILED.");
            connection.closeConnection();
        }
    }

    private void operation(String removePerson, String downSeat) throws SQLException {
        try {
            st.executeUpdate(downSeat);
        } catch (SQLException e1) {
            e1.printStackTrace();
            st.executeUpdate(removePerson);
            JOptionPane.showMessageDialog(null,"Your payment is FAILED.");
        }
    }

}
