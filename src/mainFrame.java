import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.swingx.JXDatePicker;

public class mainFrame extends JFrame implements ActionListener {

    GroupLayout layout = new GroupLayout(getContentPane());
    JRadioButton economyRadioBTN = new JRadioButton("Economy Class",true);
    JRadioButton businessRadioBTN = new JRadioButton("Business Class",false);
    ButtonGroup classSelection = new ButtonGroup();
    JComboBox fromComboBox = new JComboBox(new Object[]{"From"});
    JComboBox toComboBox = new JComboBox(new Object[]{"To"});
    JComboBox passangersCB = new JComboBox(new Object[]{"Passenger"});
    JButton searchBTN = new JButton("Search");
    JButton refreshBTN = new JButton("Refresh");
    JXDatePicker departureDate = new JXDatePicker();
    JMenuBar menuBar = new JMenuBar();
    JMenu tools = new JMenu("Tools");
    JMenu help = new JMenu("Help");
    JMenuItem adminPanel = new JMenuItem("Admin Panel");
    JMenuItem quit = new JMenuItem("Quit");
    JMenuItem about = new JMenuItem("About");
    JLabel fromLbl = new JLabel("From");
    JLabel toLbl = new JLabel("To");
    JLabel departureDateLbl = new JLabel("Departure Date");
    JLabel passangersLbl = new JLabel("Passangers");
    SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy");

    public mainFrame() throws SQLException {

        initComponents();
        //unnecessary...
        passangersCB.setVisible(false);
        passangersLbl.setVisible(false);

        getFromToStr getSTR = new getFromToStr();
        fromComboBox.setModel(getSTR.getItem("DEPARTURECITY"));
        toComboBox.setModel(getSTR.getItem("ARRIVALCITY"));

    }

    public void initComponents() {

        classSelection.add(economyRadioBTN);
        classSelection.add(businessRadioBTN);

        searchBTN.addActionListener(this);
        refreshBTN.addActionListener(this);
        quit.addActionListener(this);
        adminPanel.addActionListener(this);
        about.addActionListener(this);

        setTitle("CIU Airlines - Flight Reservation");
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fromComboBox.setSelectedItem(null);
        toComboBox.setSelectedItem(null);

        tools.add(adminPanel);
        tools.add(quit);
        menuBar.add(tools);
        help.add(about);
        menuBar.add(help);
        setJMenuBar(menuBar);

        departureDate.setDate(Calendar.getInstance().getTime());
        departureDate.setFormats(formater);

        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(searchBTN)
                                .addGap(18, 18, 18)
                                .addComponent(refreshBTN)
                                .addGap(27, 27, 27))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(economyRadioBTN)
                                                .addGap(18, 18, 18)
                                                .addComponent(businessRadioBTN))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(fromComboBox, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(fromLbl))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(toLbl)
                                                        .addComponent(toComboBox, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(departureDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(departureDateLbl))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(passangersLbl)
                                                        .addComponent(passangersCB,GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(fromLbl)
                                        .addComponent(toLbl))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(fromComboBox, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(toComboBox, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(departureDateLbl)
                                        .addComponent(passangersLbl))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(departureDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passangersCB, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(businessRadioBTN)
                                        .addComponent(economyRadioBTN))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchBTN)
                                        .addComponent(refreshBTN))
                                .addGap(22, 22, 22))
        );

        pack();
    }

    public void actionPerformed(ActionEvent e) {
        BTNFunction function = null;
        try {
            function = new BTNFunction();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        if (e.getSource() == searchBTN){
            int classSelection = 0;
            if (economyRadioBTN.isSelected() == true){
                classSelection = 1;
            }
            else{
                classSelection = 2;
            }

            String dateSelection = formater.format(departureDate.getDate());

            String depCity = (String) fromComboBox.getSelectedItem();
            String arrivCity = (String) toComboBox.getSelectedItem();

            try {
                function.search(classSelection,dateSelection,depCity,arrivCity);
            } catch (SQLException ex) {
                Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (e.getSource() == refreshBTN){
            /*fromComboBox.setSelectedItem(null);
            toComboBox.setSelectedItem(null);
            departureDate.setDate(Calendar.getInstance().getTime());
            economyRadioBTN.isSelected();*/
            this.dispose();
            try {
                mainFrame newFrame = new mainFrame();
                newFrame.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

        if (e.getSource() == quit){
            function.menuQuit();
        }

        else if(e.getSource() == adminPanel){
        adminLoginFrame newFrame = new adminLoginFrame();
        newFrame.setVisible(true);
        }

        else if(e.getSource() == about){
            function.aboutMenuBTN();
        }
    }
}