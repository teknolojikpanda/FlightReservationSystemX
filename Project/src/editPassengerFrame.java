import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class editPassengerFrame extends JFrame {

    JPanel infoPanel = new JPanel();
    JLabel info0 = new JLabel("Gender \t");
    JLabel info1 = new JLabel("Name \t");
    JLabel info2 = new JLabel("Surname \t");
    JLabel info3 = new JLabel("Passport Number \t");
    JLabel info4 = new JLabel("Birthday \t");
    JLabel info5 = new JLabel("Phone Number \t");
    JLabel info6 = new JLabel("E-Mail");
    JLabel info7 = new JLabel("");


    private static Statement st;
    SqlConnection connection = new SqlConnection();
    JPanel panel = new JPanel();

    public editPassengerFrame() throws SQLException{


        initComponents("Edit Passenger");
        setVisible(true);

        st = connection.con.createStatement();


        ResultSet result = st.executeQuery("SELECT * FROM PASSENGERS");

        while(result.next()){

            String gender = result.getString(1);
            String passName = result.getString(2);
            String passSurname = result.getString(3);
            String passportNumber = result.getString(4);
            String birthDay = result.getString(5);
            String telNo = result.getString(6);
            String email = result.getString(7);

            JLabel genderLBL = new JLabel(String.valueOf(gender));
            JLabel passNameLBL = new JLabel( passName );
            JLabel passSurnameLBL = new JLabel( passSurname );
            JLabel passportNumberLBL = new JLabel( passportNumber );
            JLabel birthdayLBL = new JLabel( birthDay );
            JLabel telNoLBL = new JLabel( telNo );
            JLabel emailLBL = new JLabel( email );
            JButton editBTN = new JButton("EDIT");

            panel.add(genderLBL);
            panel.add(passNameLBL);
            panel.add(passSurnameLBL);
            panel.add(passportNumberLBL);
            panel.add(birthdayLBL);
            panel.add(telNoLBL);
            panel.add(emailLBL);
            panel.add(editBTN);

            editBTN.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    try {
                        editPassengers newFrame = new editPassengers(gender,passName,passSurname,passportNumber,telNo,email,birthDay);
                        newFrame.setVisible(true);
                    } catch (Exception e1) {
                        e1.printStackTrace();
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