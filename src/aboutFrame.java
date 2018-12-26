import javax.swing.*;
import java.awt.*;

public class aboutFrame extends JFrame {

    JLabel label1 = new JLabel("Developed by:");
    JLabel label2 = new JLabel("- CAN DOĞA UÇAK");
    JLabel label3 = new JLabel("- MURAT ARI");
    JLabel label4 = new JLabel("- MUSTAPHA MOHAMED KARGBO");
    JLabel label5 = new JLabel("- MUSA KARGBO");
    JLabel label6 = new JLabel("All rights reserved by CIU Airlines.");

    public aboutFrame(){
        initComponents();
    }
    public void initComponents(){
        setTitle("CIU Airlines - About1");
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(65, 65, 65)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(label3)
                                                        .addComponent(label2)
                                                        .addComponent(label4)
                                                        .addComponent(label5)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(45, 45, 45)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(label6)
                                                        .addComponent(label1))))
                                .addContainerGap(157, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(label1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label5)
                                .addGap(18, 18, 18)
                                .addComponent(label6)
                                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }
}

