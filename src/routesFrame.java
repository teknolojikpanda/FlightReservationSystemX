import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;


public class routesFrame extends JFrame implements ActionListener {

    JButton departureBTN = new JButton("Edit Departure City");
    JButton arrivalBTN = new JButton("Edit Arrival City");

    public routesFrame() {

        initComponents();
    }

    private void initComponents() {

        setSize(400, 100);
        setLayout(new GridLayout(0, 2));
        setTitle("CIU Airlines - Select");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        add(departureBTN);
        add(arrivalBTN);

        departureBTN.addActionListener(this);
        arrivalBTN.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == departureBTN){
            try {
                editCityFrame newFrame = new editCityFrame("DEPARTURECITY");
                newFrame.setVisible(true);
                this.dispose();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        else if (e.getSource() == arrivalBTN){
            try {
                editCityFrame newFrame = new editCityFrame("ARRIVALCITY");
                newFrame.setVisible(true);
                this.dispose();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
