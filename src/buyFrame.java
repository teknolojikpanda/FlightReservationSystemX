import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jdesktop.swingx.JXDatePicker;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.SQLException;

public class buyFrame extends JFrame implements ActionListener {

    private JButton buyBTN = new JButton("BUY");
    private JButton cancelBTN = new JButton("CANCEL");
    private JComboBox genderCB = new JComboBox();
    private JLabel routeLBL = new JLabel("Route :");
    private JLabel routeInfoLabel = new JLabel();
    private JLabel dateLBL = new JLabel("Date :");
    private JLabel dateInfoLBL = new JLabel();
    private JLabel classLBL = new JLabel("Class :");
    private JLabel classInfoLBL = new JLabel();
    private JLabel priceLBL = new JLabel("Price :");
    private JLabel priceInfoLBL = new JLabel();
    private JLabel genderLBL = new JLabel("Gender");
    private JLabel nameLBL = new JLabel("Name");
    private JLabel surnameLBL = new JLabel("Surname");
    private JLabel passNumLBL = new JLabel("Passport Number");
    private JLabel birthDateLBL = new JLabel("Birth Date");
    private JLabel telNoLBL = new JLabel("Telephone Number");
    private JLabel emailLBL = new JLabel("E-Mail");
    private JPanel flightInfoPan = new JPanel();
    private JPanel passengerInfoPan = new JPanel();
    private JTextField nameTxtFld = new JTextField();
    private JTextField surnameTxtFld = new JTextField();
    private JTextField passNumTxtFld = new JTextField();
    private JTextField telNoTxtFld = new JTextField();
    private JTextField emailTxtFld = new JTextField();
    private JXDatePicker birthDatePicker = new JXDatePicker();
    private SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
    private GroupLayout jPanel2Layout = new GroupLayout(passengerInfoPan);
    private GroupLayout layout = new GroupLayout(getContentPane());
    private GroupLayout jPanel1Layout = new GroupLayout(flightInfoPan);
    private buyFunction function = new buyFunction();
    private SqlConnection connection = new SqlConnection();

    private int FlightID;
    private int EcoSeat;
    private int BusSeat;
    private int ClassVal;

    public buyFrame(String depDate, String depCity, String arrivCity, int price ,int classVal) {

        setClassVal(classVal);
        String flightClass = "";
        if (classVal == 1){
            flightClass = "Economy Class";
        }
        else if (classVal == 2){
            flightClass = "Bussiness Class";
        }

        int showPrice = price;
        if (classVal == 2){
            showPrice = price * 2;
        }

        dateInfoLBL.setText(depDate);
        routeInfoLabel.setText(depCity + " TO " + arrivCity);
        priceInfoLBL.setText(showPrice + " TL");
        classInfoLBL.setText(flightClass);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        buyBTN.addActionListener(this);

        birthDatePicker.setDate(Calendar.getInstance().getTime());
        birthDatePicker.setFormats(new SimpleDateFormat("dd.MM.yyy"));

        flightInfoPan.setBorder(BorderFactory.createTitledBorder("Flight Information"));
        flightInfoPan.setToolTipText("");

        //GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        flightInfoPan.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(routeLBL)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(routeInfoLabel))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(dateLBL)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(dateInfoLBL))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(priceLBL)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(priceInfoLBL))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(classLBL)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(classInfoLBL)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(routeLBL)
                                        .addComponent(routeInfoLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(dateLBL)
                                        .addComponent(dateInfoLBL))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(classLBL)
                                        .addComponent(classInfoLBL))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(priceLBL)
                                        .addComponent(priceInfoLBL))
                                .addGap(0, 11, Short.MAX_VALUE))
        );

        passengerInfoPan.setBorder(BorderFactory.createTitledBorder("Passanger Information"));

        genderCB.setModel(new DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

         passengerInfoPan.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(genderLBL)
                                        .addComponent(surnameLBL)
                                        .addComponent(passNumLBL)
                                        .addComponent(birthDateLBL)
                                        .addComponent(telNoLBL)
                                        .addComponent(emailLBL)
                                        .addComponent(nameLBL))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(genderCB, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(emailTxtFld, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                        .addComponent(telNoTxtFld)
                                        .addComponent(birthDatePicker)
                                        .addComponent(passNumTxtFld)
                                        .addComponent(surnameTxtFld)
                                        .addComponent(nameTxtFld))
                                .addContainerGap(144, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(genderCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(genderLBL))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameTxtFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nameLBL))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(surnameTxtFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(surnameLBL))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(passNumLBL)
                                        .addComponent(passNumTxtFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(birthDatePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(birthDateLBL))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(telNoTxtFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(telNoLBL))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(emailTxtFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(emailLBL))
                                .addGap(0, 16, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buyBTN)
                                .addGap(18, 18, 18)
                                .addComponent(cancelBTN)
                                .addGap(44, 44, 44))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(flightInfoPan, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(passengerInfoPan, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(flightInfoPan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(passengerInfoPan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buyBTN)
                                        .addComponent(cancelBTN))
                                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();


    }


    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buyBTN){
            String birthDateSelection = formatter.format(birthDatePicker.getDate());

            String gender = (String) genderCB.getSelectedItem();
            String name = nameTxtFld.getText();
            String surname =  surnameTxtFld.getText();
            String passNum = passNumTxtFld.getText();
            String birthDate = birthDateSelection;
            String telNo = telNoTxtFld.getText();
            String email = emailTxtFld.getText();

            String appeal = "";
            if (genderCB.getSelectedItem() == "Male"){
                appeal = "Mr. ";
            }
            else if (genderCB.getSelectedItem() == "Female"){
                appeal = "Mrs. ";
            }

            String message = "Flight Information:" +
                    "\nRoute : " + routeInfoLabel.getText() +
                    "\nDate : " + dateInfoLBL.getText() +
                    "\nClass : " + classInfoLBL.getText() +
                    "\nPrice : " + priceInfoLBL.getText() +
                    "\nPassenger Information:" +
                    "\n" + appeal + name + " " + surname +
                    "\nPassport Number : " + passNum +
                    "\nBirth Date : " + birthDateSelection +
                    "\nPhone Number : " + telNo +
                    "\nE-Mail : " + email + "\n\nDo you confirm your information to buy the flight?";

            int input = JOptionPane.showConfirmDialog(null, message);

            if (input == 0){

                int flightID = getFlightID();
                int ecoSeat = getEcoSeat();
                int busSeat = getBusSeat();
                int classVal = getClassVal();

                try {
                    function.buyFunction(gender,name,surname,passNum,birthDate,telNo,email,flightID,classVal,busSeat,ecoSeat);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            else if (input == 1){
                JOptionPane.showMessageDialog(null,"Your operation CANCELED.");
            }
        }

        else if(e.getSource() == cancelBTN){
            System.exit(0);
            connection.closeConnection();
        }

    }

    public int getFlightID() {
        return FlightID;
    }

    public void setFlightID(int flightID) {
        FlightID = flightID;
    }

    public int getEcoSeat() {
        return EcoSeat;
    }

    public void setEcoSeat(int ecoSeat) {
        EcoSeat = ecoSeat;
    }

    public int getBusSeat() {
        return BusSeat;
    }

    public void setBusSeat(int busSeat) {
        BusSeat = busSeat;
    }

    public int getClassVal() {
        return ClassVal;
    }

    public void setClassVal(int classVal) {
        ClassVal = classVal;
    }
}