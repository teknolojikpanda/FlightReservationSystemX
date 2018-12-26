import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class editFlightsFrame extends JFrame {

    private static Statement st;
    SqlConnection connection = new SqlConnection();
    JPanel panel = new JPanel();
    JButton addBTN = new JButton("Add Flight");
    SqlOperation op = new SqlOperation();

    public editFlightsFrame() throws SQLException {

        initComponents();

        addBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int FlightID = 0;
                int Price = 0;
                int EcoSeat = 0;
                int BusSeat = 0;
                String DepCity = null;
                String ArivCity = null;
                String dateSelection = "11.11.2018";
                try {
                    addEditFlightFrame newFrame = new addEditFlightFrame(dateSelection,DepCity,ArivCity,Price,EcoSeat,BusSeat,FlightID,"ADD");
                    newFrame.setVisible(true);
                    newFrame.flightID.setEditable(true);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        st = connection.con.createStatement();
        ResultSet result = st.executeQuery("SELECT * FROM FLIGHTS");

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
            JButton editBTN = new JButton("EDIT");
            JButton deleteBTN = new JButton("DELETE");

            panel.add(flightIDLBL);
            panel.add(depDateLBL);
            panel.add(depCityLBL);
            panel.add(arrivCityLBL);
            panel.add(priceLBL);
            panel.add(ecoSeatLBL);
            panel.add(busSeatLBL);
            panel.add(editBTN);
            panel.add(deleteBTN);

            editBTN.addActionListener(new ActionListener() {  // 0 = Yes && 1 = No && 3 = Cancel
                public void actionPerformed(ActionEvent e){
                    addEditFlightFrame newFrame = null;
                    try {
                        newFrame = new addEditFlightFrame(depDate,depCity,arrivCity,price,ecoSeat,busSeat,flightID,"CHANGE");
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    newFrame.setVisible(true);
                    }
            });

            deleteBTN.addActionListener(new ActionListener() {  // 0 = Yes && 1 = No && 3 = Cancel
                public void actionPerformed(ActionEvent e){
                    int input = JOptionPane.showConfirmDialog(null,"Do you want delete "+depCity+" to "+arrivCity+" flight?");
                    if(input == 0){
                        op.delete("FLIGHTS","FLIGHT_ID",flightID);
                    }
                    else
                        dispose();
                }
            });
        }
        result.close();
        st.close();
        panel.setLayout(new GridLayout(0, 9));
    }

    private void initComponents() {

        setTitle("CIU Airlines - Flights");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Flights", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13))); // NOI18N

        GroupLayout panelLayout = new GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 372, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(659, Short.MAX_VALUE)
                                .addComponent(addBTN, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addBTN, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();

    }
}

