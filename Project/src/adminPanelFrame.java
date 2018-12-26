import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class adminPanelFrame extends JFrame implements ActionListener {

    JPanel basicOp = new JPanel();
    JPanel adminOp = new JPanel();

    JButton routes = new JButton("Edit Routes");
    JButton flights = new JButton("Edit Flights");
    JButton passengers = new JButton("Edit Passengers Information");
    JButton tickets = new JButton("Edit Tickets");
    JButton changePassword = new JButton("Change Passwords");

    public adminPanelFrame(){
        initComponents();
    }
    public void initComponents(){

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CIU Airlines - Admin Panel");
        basicOp.setBorder(BorderFactory.createTitledBorder("Basic Operations"));

        routes.addActionListener(this);
        flights.addActionListener(this);
        passengers.addActionListener(this);
        tickets.addActionListener(this);
        changePassword.addActionListener(this);

        GroupLayout basicOpLayout = new GroupLayout(basicOp);
        basicOp.setLayout(basicOpLayout);
        basicOpLayout.setHorizontalGroup(
                basicOpLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(basicOpLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(routes, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(flights, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(passengers, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tickets, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(23, Short.MAX_VALUE))
        );
        basicOpLayout.setVerticalGroup(
                basicOpLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(basicOpLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(basicOpLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(routes, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(flights, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passengers, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tickets, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(22, Short.MAX_VALUE))
        );

        adminOp.setBorder(BorderFactory.createTitledBorder("Admin Operations"));

        GroupLayout adminOpLayout = new GroupLayout(adminOp);
        adminOp.setLayout(adminOpLayout);
        adminOpLayout.setHorizontalGroup(
                adminOpLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(adminOpLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(changePassword)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        adminOpLayout.setVerticalGroup(
                adminOpLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(adminOpLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(changePassword, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(basicOp, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(adminOp, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(basicOp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(adminOp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == routes){
            routesFrame newFrame = new routesFrame();
            newFrame.setVisible(true);

        }
        else if (e.getSource() == flights){
            try {
                editFlightsFrame newFrame = new editFlightsFrame();
                newFrame.setVisible(true);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        else if (e.getSource() == passengers){
            try {
                editPassengerFrame newFrame =new editPassengerFrame();
                newFrame.setVisible(true);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        else if (e.getSource() == tickets){
            try {
                editTicketFrame newFrame = new editTicketFrame();
                newFrame.setVisible(true);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        else if (e.getSource() == changePassword){

        }
    }
}
