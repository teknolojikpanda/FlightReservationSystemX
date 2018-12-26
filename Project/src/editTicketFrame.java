import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.*;

public class editTicketFrame extends JFrame {

    private static PreparedStatement st;
    SqlConnection connection = new SqlConnection();
    JPanel panel = new JPanel();
    SqlOperation op = new SqlOperation();

    public editTicketFrame() throws SQLException {

        initComponents();


        st = connection.con.prepareStatement("SELECT * FROM TICKETS");
        ResultSet result = st.executeQuery();

        while(result.next()){

            int flightID = result.getInt(1);
            String passNum = result.getString(2);
            String classSelection = result.getString(3);

            JLabel flightIDLBL = new JLabel(String.valueOf(flightID));
            JLabel passNumLBL = new JLabel( passNum );
            JLabel classSelectionLBL = new JLabel( classSelection );
            JButton editBTN = new JButton("EDIT");
            JButton deleteBTN = new JButton("DELETE");

            panel.add(flightIDLBL);
            panel.add(passNumLBL);
            panel.add(classSelectionLBL);
            panel.add(editBTN);
            panel.add(deleteBTN);

            editBTN.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    editTicket newFrame = new editTicket(flightID,passNum,classSelection);
                    newFrame.setVisible(true);

                }
            });

            deleteBTN.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    int input = JOptionPane.showConfirmDialog(null,"Do you want delete ticket?");
                    if (input == 0){
                        try {

                            st = connection.con.prepareStatement("DELETE FROM TICKETS WHERE FLIGHT_ID="+ flightID +" AND PASSPORT_NUM='"+ passNum +"' AND SEAT='"+ classSelection +"'");
                            st.executeUpdate();
                            st.close();
                            JOptionPane.showMessageDialog(null,"DELETED!");

                        }catch(Exception e1){
                            JOptionPane.showMessageDialog(null, "DELETE FAILED!", "Error", JOptionPane.ERROR_MESSAGE);
                            System.out.print(e1.getMessage());
                            e1.printStackTrace();
                        }
                    }

                }
            });
        }
        result.close();
        st.close();
        panel.setLayout(new GridLayout(0, 5));
    }

    private void initComponents() {

        setTitle("CIU Airlines - Tickets");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tickets", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13))); // NOI18N

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
                                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();

    }
}

