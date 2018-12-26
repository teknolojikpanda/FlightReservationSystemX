import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class selectionFrame extends JFrame {

    JPanel infoPanel = new JPanel();
    JLabel info0 = new JLabel("Flight ID \t");
    JLabel info1 = new JLabel("Departure Date \t");
    JLabel info2 = new JLabel("Departure City \t");
    JLabel info3 = new JLabel("Arrival City \t");
    JLabel info4 = new JLabel("Price \t");
    JLabel info5 = new JLabel("Economy Seat \t");
    JLabel info6 = new JLabel("Business Seats");
    JLabel info7 = new JLabel("");


    private static Statement st;
    SqlConnection connection = new SqlConnection();
    JPanel panel = new JPanel();

    public selectionFrame(int classVal,String departureDate, String departureCity, String arrivalCity) throws SQLException{


        initComponents("Flight Selection");
        setVisible(true);

        st = connection.con.createStatement();


        ResultSet result = st.executeQuery("SELECT * FROM flights WHERE DEPARTUREDATE='"+departureDate+"' AND DEPARTURECITY='"+departureCity+"' AND ARRIVALCITY='"+arrivalCity+"'");

        while(result.next()){

            String depDate = result.getString(1);
            String depCity = result.getString(2);
            String arrivCity = result.getString(3);
            int price = result.getInt(4);
            int ecoSeat = result.getInt(5);
            int busSeat = result.getInt(6);
            int flightID = result.getInt(7);

            JLabel flightIDLBL = new JLabel(String.valueOf(flightID));
            JLabel depDateLBL = new JLabel( depDate );
            JLabel depCityLBL = new JLabel( depCity );
            JLabel arrivCityLBL = new JLabel( arrivCity );
            JLabel priceLBL = new JLabel( Integer.toString(price) + "TL" );
            JLabel ecoSeatLBL = new JLabel( Integer.toString(ecoSeat) );
            JLabel busSeatLBL = new JLabel( Integer.toString(busSeat) );
            JButton buyBTN = new JButton("BUY");

            panel.add(flightIDLBL);
            panel.add(depDateLBL);
            panel.add(depCityLBL);
            panel.add(arrivCityLBL);
            panel.add(priceLBL);
            panel.add(ecoSeatLBL);
            panel.add(busSeatLBL);
            panel.add(buyBTN);

            buyBTN.addActionListener(new ActionListener() {  // 0 = Yes && 1 = No && 3 = Cancel
                public void actionPerformed(ActionEvent e){
                    if (ecoSeat == 0){
                        JOptionPane.showMessageDialog(null,"Economy class seats are not avaiable");
                    }
                    else if(busSeat == 0){
                        JOptionPane.showMessageDialog(null,"Business class seats are not avaiable");
                    }
                    else {
                        String message = "";
                        if (classVal == 1) {
                            message = "Do you really want to buy " + depCity + " to " + arrivCity + " flight?";
                        } else if (classVal == 2) {
                            message = "You are selected business class and ticket price will be double!!!" +
                                    "\nDo you really want to buy " + depCity + " to " + arrivCity + " flight?";
                        }

                        int input = JOptionPane.showConfirmDialog(null, message);

                        if (input == 0) {
                            BTNFunction function = null;
                            try {
                                function = new BTNFunction();
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            }
                            try {
                                function.yesButton(depDate, depCity, arrivCity, price, classVal, flightID, ecoSeat, busSeat);
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            }
                        } else if (input == 1) {


                        } else {
                            connection.closeConnection();
                            System.exit(0);
                        }
                    }

                }
            });
        }

        add(panel);
        panel.setLayout(new GridLayout(0,8));
        result.close();
        st.close();
    }

    private void initComponents(String title){

        setSize(800,600);
        setLayout(new GridLayout(6,0));
        setTitle("CIU Airlines - " + title);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        add(infoPanel);
        infoPanel.setLayout(new GridLayout(0,8));
        infoPanel.add(info0);
        infoPanel.add(info1);
        infoPanel.add(info2);
        infoPanel.add(info3);
        infoPanel.add(info4);
        infoPanel.add(info5);
        infoPanel.add(info6);
        infoPanel.add(info7);

    }
}