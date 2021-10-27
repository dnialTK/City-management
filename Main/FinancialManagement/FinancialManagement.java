/*
 * Created by JFormDesigner on Sun Jul 04 10:28:53 IRDT 2021
 */

package Main.FinancialManagement;

import Main.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;

/**
 * @author danial
 */
public class FinancialManagement extends JFrame {
    public DefaultTableModel defaultTableModel;

    public FinancialManagement() {
        initComponents();
        defaultTableModel = (DefaultTableModel) table1.getModel();
        DefaultTableCellRenderer defaultTableModel = new DefaultTableCellRenderer();
        defaultTableModel.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table1.getModel().getColumnCount(); i++) {
            table1.getColumnModel().getColumn(i).setCellRenderer(defaultTableModel);
        }
    }

    private void button1ActionPerformed(ActionEvent e) {
        Main.isEntered = false;
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        label1 = new JLabel();

        //======== this ========
        setTitle("Financial Management");
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "Name", "Family", "ID", "Money", "Bank", "City", "Profit", "Time"
                }
            ));
            scrollPane1.setViewportView(table1);
        }

        //---- button1 ----
        button1.setText("Finish");
        button1.addActionListener(e -> button1ActionPerformed(e));

        //---- label1 ----
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 1104, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 3, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGap(0, 489, Short.MAX_VALUE)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                            .addGap(487, 487, 487))))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(460, Short.MAX_VALUE)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                    .addGap(512, 512, 512))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(15, Short.MAX_VALUE)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                    .addGap(55, 55, 55))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    public JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
