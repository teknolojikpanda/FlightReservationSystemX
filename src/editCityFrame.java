import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class editCityFrame extends JFrame {

    private static Statement st;
    SqlConnection connection = new SqlConnection();
    JPanel panel = new JPanel();
    JButton addBTN = new JButton("Add City");
    JButton refreshBTN = new JButton("Refresh");
    SqlOperation op = new SqlOperation();

    public editCityFrame(String tableName) throws SQLException {

        initComponents();
        setSize(500,500);
        setLocationRelativeTo(null);
        addBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(null,"Please enter city name");
                if(input == null){
                    JOptionPane.showMessageDialog(null,"NOT ADDED!");
                }
                else{
                    op.add(tableName,tableName, input);
                }
            }
        });
        
        refreshBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
      
                editCityFrame newFrame;
                try {
                    newFrame = new editCityFrame(tableName);
                    newFrame.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(editCityFrame.class.getName()).log(Level.SEVERE, null, ex);
                }  
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(796, Short.MAX_VALUE)
                .addComponent(refreshBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(139, Short.MAX_VALUE))
        );

        pack();

    }
}
