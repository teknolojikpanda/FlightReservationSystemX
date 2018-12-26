import org.jdesktop.swingx.JXDatePicker;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class editPassengers extends JFrame {

    JLabel text = new JLabel("Please enter new passenger information.");
    JLabel genderLBL = new JLabel("Flight ID");
    JLabel passNameLBL = new JLabel("Departure City");
    JLabel passSurnameLBL = new JLabel("Arrival City");
    JLabel passportNumLBL = new JLabel("passportNum");
    JLabel birthdateLBL = new JLabel("Economy Seat");
    JLabel telNoLBL = new JLabel("Business Seat");
    JLabel emailLBL = new JLabel("Departure Date");

    JComboBox gender = new JComboBox();
    JTextField passName = new JTextField();
    JTextField passSurname = new JTextField();
    JTextField passportNum = new JTextField();
    JTextField telNo = new JTextField();
    JTextField email = new JTextField();

    JXDatePicker birthdate = new JXDatePicker();
    SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy");

    JButton changeBTN = new JButton("CHANGE");

    public editPassengers(String val1,String val2, String val3,String val4, String val5, String val6, String val7) throws Exception {
        initComponents();
        gender.setModel(new DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        changeBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SqlOperation op = new SqlOperation();
                String genderVal = String.valueOf(gender.getSelectedItem());
                String passNameVal = passName.getText();
                String passSurnameVal = passSurname.getText();
                String passportNumVal = passportNum.getText();
                String telNoVal = telNo.getText();
                String emailval = email.getText();
                String birthdateSelection = formater.format(birthdate.getDate());
                op.editPassenger(genderVal,passNameVal,passSurnameVal,passportNumVal,telNoVal,emailval,birthdateSelection);

            }
        });
        gender.setSelectedItem(val1);
        passName.setText(val2);
        passSurname.setText(val3);
        passportNum.setText(val4);
        telNo.setText(val5);
        email.setText(val6);
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse(val7);
        birthdate.setDate(date);

        passportNum.setEditable(false);

    }
    public void initComponents(){

        birthdate.setFormats(formater);
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
                                                        .addComponent(passSurnameLBL)
                                                        .addComponent(passportNumLBL)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(passNameLBL)
                                                                        .addComponent(genderLBL))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(gender, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(passName, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(79, 79, 79)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(passSurname, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(passportNum, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))))
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(text)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addComponent(birthdateLBL)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(birthdate, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(emailLBL)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(email, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(telNoLBL)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(telNo, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
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
                                        .addComponent(genderLBL)
                                        .addComponent(gender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(passNameLBL)
                                        .addComponent(passName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(passSurname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passSurnameLBL))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(passportNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passportNumLBL))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(telNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(telNoLBL))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(emailLBL))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(birthdate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(birthdateLBL))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(changeBTN, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();

    }
}
