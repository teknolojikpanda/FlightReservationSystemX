import java.sql.SQLException;

public class BTNFunction extends mainFrame {

    public BTNFunction() throws SQLException {
    }

    public void search(int classVal, String depDate, String depCity, String arrivCity) throws SQLException{
        selectionFrame selectionFrame = new selectionFrame(classVal,depDate,depCity,arrivCity);
    }

    public void menuQuit(){
        SqlConnection connection = new SqlConnection();
        connection.closeConnection();
        System.exit(0);
    }

    public void yesButton(String depDate, String depCity, String arrivCity, int price, int classVal, int flightID, int ecoSeat, int busSeat) throws SQLException {

        buyFrame frame = new buyFrame(depDate, depCity, arrivCity, price, classVal);
        frame.setBusSeat(busSeat);
        frame.setEcoSeat(ecoSeat);
        frame.setFlightID(flightID);
    }

    public void aboutMenuBTN() {
        aboutFrame newFrame = new aboutFrame();
    }
}
