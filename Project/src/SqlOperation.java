import javax.swing.*;
import java.sql.PreparedStatement;

public class SqlOperation {

    private static PreparedStatement st;
    SqlConnection connection = new SqlConnection();

    public void delete(String tableName, String columnName, int value) {

        try {

            st = connection.con.prepareStatement("DELETE FROM "+ tableName +" WHERE "+ columnName +"="+ value);
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null,"DELETED!");

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "DELETE FAILED!", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
    }

    public void delete2(String tableName, String columnName, String value) {

        try {

            st = connection.con.prepareStatement("DELETE FROM "+ tableName +" WHERE "+ columnName +"='"+ value+"'");
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null,"DELETED!");

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "DELETE FAILED!", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
    }

    public void add(String tableName, String columnName, String city){
        try {

            st = connection.con.prepareStatement("INSERT INTO "+ tableName +"("+ columnName +") VALUES ('"+ city +"')");
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null,"ADDED!");

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ADD FAILED!", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
    }

    public void editFlights(int FlightID,String DepCity,String ArivCity,int Price,int EcoSeat,int BusSeat,String dateSelection){
        try {
            System.out.println(FlightID +" "+ DepCity +" "+ ArivCity +" "+ Price +" "+ EcoSeat +" "+ BusSeat +" "+ dateSelection);
            st = connection.con.prepareStatement("UPDATE FLIGHTS SET DEPARTURECITY='"+ DepCity +"', ARRIVALCITY='"+ ArivCity +"', PRICE="+ Price+", ECOSEAT="+ EcoSeat +", BUSINESSSEAT="+ BusSeat +", DEPARTUREDATE='"+ dateSelection +"' WHERE FLIGHT_ID ="+FlightID);
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null,"FLIGHT CHANGED!");

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "CHANGE FAILED!", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
    }

    public void addFlights(int FlightID,String DepCity,String ArivCity,int Price,int EcoSeat,int BusSeat,String dateSelection){
        try {
            System.out.println(FlightID +" "+ DepCity +" "+ ArivCity +" "+ Price +" "+ EcoSeat +" "+ BusSeat +" "+ dateSelection);
            st = connection.con.prepareStatement("INSERT INTO FLIGHTS (FLIGHT_ID,DEPARTURECITY,ARRIVALCITY,PRICE,ECOSEAT,BUSINESSSEAT,DEPARTUREDATE) VALUES (" + FlightID + ",'" + DepCity + "','" + ArivCity + "'," + Price + "," + EcoSeat + "," + BusSeat + ",'" + dateSelection + "')");
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null,"FLIGHT ADDED!");


        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ADD FAILED!", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
    }

    public void editPassenger(String gender,String passName, String passSurname, String passNumber, String telNo, String email, String birthdate){
        try {

            st = connection.con.prepareStatement("UPDATE PASSENGERS SET GENDER='"+ gender +"', PASS_NAME='"+ passName +"', PASS_SURNAME='"+ passSurname +"', BIRTH_DATE='"+ birthdate +"', TEL_NO='"+ telNo +"', EMAIL='"+ email +"' WHERE PASSPORT_NUM ='"+passNumber+"'");
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null,"PASSENGER INFORMATION CHANGED!");

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "CHANGE FAILED!", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
    }

    public void editTicket(int flightID, String passportNumber, String classSelection){
        try {

            st = connection.con.prepareStatement("UPDATE TICKETS SET FLIGHT_ID="+ flightID +", SEAT='"+ classSelection +"' WHERE PASSPORT_NUM ='"+passportNumber+"'");
            st.executeUpdate();
            st.close();
            JOptionPane.showMessageDialog(null,"TICKET INFORMATION CHANGED!");

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "CHANGE FAILED!", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
    }
}
