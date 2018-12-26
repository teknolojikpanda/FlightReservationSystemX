import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class adminLoginFrame extends JFrame implements ActionListener {

    private JLabel adminPanelLBL = new JLabel("Admin Panel");
    private JLabel usernameLBL = new JLabel("Username");
    private JLabel passwordLBL = new JLabel("Password");
    private JLabel frgtpsswrdLBL = new JLabel("Forgot My Password");
    private JTextField username = new JTextField();
    private JPasswordField password = new JPasswordField();
    private JButton loginBTN = new JButton("LOGIN");

    public adminLoginFrame(){
        initComponents();
    }

    public void initComponents(){
        setTitle("CIU Airlines - Admin Panel Login");
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        adminPanelLBL.setFont(new java.awt.Font("Tahoma", 1, 18));
        frgtpsswrdLBL.setFont(new java.awt.Font("Tahoma", 1, 11));
        frgtpsswrdLBL.setForeground(Color.blue);

        loginBTN.addActionListener(this);
        frgtpsswrdLBL.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JOptionPane.showMessageDialog(null, "Please contact with IT department for change the password.");
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(frgtpsswrdLBL)
                                                .addGap(37, 37, 37)
                                                .addComponent(loginBTN, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(passwordLBL)
                                                .addComponent(adminPanelLBL)
                                                .addComponent(usernameLBL)
                                                .addComponent(username, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                                .addComponent(password)))
                                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(adminPanelLBL)
                                .addGap(26, 26, 26)
                                .addComponent(usernameLBL)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(username, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(passwordLBL)
                                .addGap(9, 9, 9)
                                .addComponent(password, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(frgtpsswrdLBL)
                                        .addComponent(loginBTN, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                                .addGap(34, 34, 34))
        );

        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String usrname = username.getText();
        char[] charPassword = password.getPassword();
        String passwordSTR = new String(charPassword);
        loginBTNfunction function = new loginBTNfunction();
        function.loginCheck(usrname,passwordSTR);
        this.dispose();
    }
}
