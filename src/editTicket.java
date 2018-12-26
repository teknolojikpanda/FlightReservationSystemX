import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class editTicket extends JFrame {

    JLabel flightIDLBL = new JLabel("Flight ID");
    JLabel passportNumLBL = new JLabel("Passport Number");
    JLabel classSelectionLBL = new JLabel("Class");

    JTextField flightID = new JTextField();
    JTextField passportNum = new JTextField();
    JTextField classSelection = new JTextField();

    JButton changeBTN = new JButton("CHANGE");

    public editTicket(int val1,String val2,String val3){
        initComponents();
        passportNum.setEditable(false);
        changeBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SqlOperation op = new SqlOperation();
                int flightid = Integer.parseInt(flightID.getText());
                String passnumber = passportNum.getText();
                String classselection = classSelection.getText();
                op.editTicket(flightid,passnumber,classselection);
            }
        });
        flightID.setText(Integer.toString(val1));
        passportNum.setText(val2);
        classSelection.setText(val3);
    }

    public void initComponents(){

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(classSelectionLBL)
                                        .addComponent(passportNumLBL)
                                        .addComponent(flightIDLBL))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(passportNum, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                        .addComponent(flightID)
                                        .addComponent(classSelection))
                                .addContainerGap(124, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(changeBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(flightIDLBL)
                                        .addComponent(flightID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(passportNumLBL)
                                        .addComponent(passportNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(classSelectionLBL)
                                        .addComponent(classSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46)
                                .addComponent(changeBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();

    }
}
