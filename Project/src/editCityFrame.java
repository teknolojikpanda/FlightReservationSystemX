import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class editCityFrame extends JFrame {

    private static Statement st;
    SqlConnection connection = new SqlConnection();
    JPanel panel = new JPanel();
    JButton addBTN = new JButton("Add City");
    SqlOperation op = new SqlOperation();

    public editCityFrame(String tableName) throws SQLException {

        initComponents();

        addBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(null,"Please enter city name");
                op.add(tableName,tableName, input);
            }
        });

        st = connection.con.createStatement();
        ResultSet result = st.executeQuery("SELECT * FROM "+tableName);

        while (result.next()) {

            String City = result.getString(1);

            JLabel CityLBL = new JLabel(City);
            JButton deleteBTN = new JButton("DELETE");

            panel.add(CityLBL);
            panel.add(deleteBTN);

            deleteBTN.addActionListener(new ActionListener() {  // 0 = Yes && 1 = No && 3 = Cancel
                public void actionPerformed(ActionEvent e) {

                op.delete2(tableName,tableName,City);

                }
            });
        }
        result.close();
        st.close();
        panel.setLayout(new GridLayout(0, 2));
    }

    private void initComponents() {

        setTitle("CIU Airlines - Cities");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cities", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13))); // NOI18N

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
