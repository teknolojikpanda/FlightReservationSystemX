import org.jdesktop.swingx.JXDatePicker;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class addEditFlightFrame extends JFrame {

    JLabel text = new JLabel("Please enter new flights information.");
    JLabel flightIDLBL = new JLabel("Flight ID");
    JLabel depCityLBL = new JLabel("Departure City");
    JLabel arivCityLBL = new JLabel("Arrival City");
    JLabel priceLBL = new JLabel("Price");
    JLabel ecoSeatLBL = new JLabel("Economy Seat");
    JLabel busSeatLBL = new JLabel("Business Seat");
    JLabel depDateLBL = new JLabel("Departure Date");

    JTextField flightID = new JTextField();
    JTextField depCity = new JTextField();
    JTextField arivCity = new JTextField();
    JTextField price = new JTextField();
    JTextField ecoSeat = new JTextField();
    JTextField busSeat = new JTextField();

    JXDatePicker depDate = new JXDatePicker();
    SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy");

    JButton changeBTN = new JButton();

    public addEditFlightFrame(String val1,String val2, String val3,int val4, int val5, int val6, int val7, String text) throws Exception {
        initComponents();
        changeBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int FlightID = 0;
                int Price = 0;
                int EcoSeat = 0;
                int BusSeat = 0;
                String DepCity = null;
                String ArivCity = null;
                String dateSelection = null;

                SqlOperation op = new SqlOperation();
                FlightID = Integer.parseInt(flightID.getText());
                DepCity = depCity.getText();
                ArivCity = arivCity.getText();
                Price = Integer.parseInt(price.getText());
                EcoSeat = Integer.parseInt(ecoSeat.getText());
                BusSeat = Integer.parseInt(busSeat.getText());
                dateSelection = formater.format(depDate.getDate());
                if (text == "ADD"){
                    op.addFlights(FlightID,DepCity,ArivCity,Price,EcoSeat,BusSeat,dateSelection);
                }
                else if (text == "CHANGE"){
                    op.editFlights(FlightID,DepCity,ArivCity,Price,EcoSeat,BusSeat,dateSelection);
                }
            }
        });
        flightID.setEditable(false);
        flightID.setText(String.valueOf(val7));
        depCity.setText(val2);
        arivCity.setText(val3);
        price.setText(String.valueOf(val4));
        ecoSeat.setText(String.valueOf(val5));
        busSeat.setText(String.valueOf(val6));
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse(val1);
        depDate.setDate(date);
        changeBTN.setText(text);

    }
    public void initComponents(){

        depDate.setFormats(formater);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(arivCityLBL)
                                                        .addComponent(priceLBL)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(depCityLBL)
                                                                        .addComponent(flightIDLBL))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(flightID, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(depCity, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(79, 79, 79)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(arivCity, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(price, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))))
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(text)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addComponent(depDateLBL)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(depDate, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(busSeatLBL)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(busSeat, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(ecoSeatLBL)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(ecoSeat, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(207, 207, 207))))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(changeBTN, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(text)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(flightIDLBL)
                                        .addComponent(flightID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(depCityLBL)
                                        .addComponent(depCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(arivCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(arivCityLBL))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(priceLBL))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(ecoSeat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ecoSeatLBL))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(busSeat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(busSeatLBL))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(depDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(depDateLBL))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(changeBTN, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();

    }
}