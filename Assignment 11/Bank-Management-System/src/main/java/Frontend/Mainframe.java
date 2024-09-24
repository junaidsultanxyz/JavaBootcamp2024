
package Frontend;

import Backend.Account;
import Backend.Database;
import Backend.FileHandling;
import Backend.Other;
import Backend.Transaction;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Junaid Sultan
 */
public class Mainframe extends javax.swing.JFrame {

    /**
     * Creates new form Mainframe
     */
    public Mainframe() {
//        Database.TestAccountData();
        initComponents();
    }
    
    Color one = new Color (0,0,0);
    Color x = new Color (23,23,23);
    Color two = new Color(69,69,69);
    Color three = new Color(93,93,93);
    Color four = new Color(79,79,79);
    Color five = new Color(109,109,109);
    Color six = new Color(136,136,136);
    Color seven = new Color (176,176,176);
    Color eight = new Color (231,231,231);
    Color nine = new Color (246,246,246);
    
    public Color[] colorList = {one, x, two, three, four, five, six, seven, eight, nine};
    
    
    //-------------------------------------------------------------------------------------------
    
    public void ReloadAccountTableFromDatabase(ArrayList<Account> accounts){
        DefaultTableModel table = (DefaultTableModel) accounttable.getModel();
        
        if (accounttable.getRowCount() > 0){
            for (int i = accounttable.getRowCount() - 1; i >= 0; i--){
                table.removeRow(i);
            }
        }
        
        for (Account acc : accounts){
            String[] data = {acc.getName(), acc.getAccountId(), acc.getType(), acc.getInterestRate() + "", acc.getBalance() + ""};
            table.addRow(data);
        }
    }
    
    public void ReloadTransitTableFromDatabase(ArrayList<Transaction> transactions){
        DefaultTableModel table = (DefaultTableModel) transactiontable.getModel();
        
        if (transactiontable.getRowCount() > 0){
            for (int i = transactiontable.getRowCount() - 1; i >= 0; i--){
                table.removeRow(i);
            }
        }
        
        for (Transaction t : transactions){
            String[] data = {t.getTransitID(), t.getReceivingID(), t.getSenderID(), "" + t.getAmount(), t.getDate().toString()};
            table.addRow(data);
        }
        
    }
    //-------------------------------------------------------------------------------------------
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        accountbutton = new javax.swing.JPanel();
        accountbuttontext = new javax.swing.JLabel();
        transactionbutton = new javax.swing.JPanel();
        transactionbuttontext = new javax.swing.JLabel();
        maintab = new javax.swing.JTabbedPane();
        accounttab = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        accounttable = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        accountsearchfield = new javax.swing.JTextField();
        transactiontab = new javax.swing.JPanel();
        receivingaccount = new javax.swing.JTextField();
        senderaccount = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        amountfield = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        transactiontable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        transitlog = new javax.swing.JTextArea();
        receivingaccountbalance = new javax.swing.JLabel();
        senderaccountbalance = new javax.swing.JLabel();
        searchtransaction = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(969, 660));
        setMinimumSize(new java.awt.Dimension(969, 660));
        setPreferredSize(new java.awt.Dimension(969, 660));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        accountbutton.setBackground(colorList[1]);
        accountbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountbuttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accountbuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accountbuttonMouseExited(evt);
            }
        });

        accountbuttontext.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        accountbuttontext.setForeground(colorList[9]);
        accountbuttontext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        accountbuttontext.setText("Account");

        javax.swing.GroupLayout accountbuttonLayout = new javax.swing.GroupLayout(accountbutton);
        accountbutton.setLayout(accountbuttonLayout);
        accountbuttonLayout.setHorizontalGroup(
            accountbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(accountbuttontext, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );
        accountbuttonLayout.setVerticalGroup(
            accountbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(accountbuttontext, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        getContentPane().add(accountbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 60));

        transactionbutton.setBackground(colorList[1]);
        transactionbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transactionbuttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                transactionbuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                transactionbuttonMouseExited(evt);
            }
        });

        transactionbuttontext.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        transactionbuttontext.setForeground(colorList[9]);
        transactionbuttontext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        transactionbuttontext.setText("Transaction");

        javax.swing.GroupLayout transactionbuttonLayout = new javax.swing.GroupLayout(transactionbutton);
        transactionbutton.setLayout(transactionbuttonLayout);
        transactionbuttonLayout.setHorizontalGroup(
            transactionbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transactionbuttonLayout.createSequentialGroup()
                .addComponent(transactionbuttontext, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                .addContainerGap())
        );
        transactionbuttonLayout.setVerticalGroup(
            transactionbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(transactionbuttontext, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        getContentPane().add(transactionbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 490, 60));

        maintab.setBackground(new java.awt.Color(255, 255, 255));
        maintab.setForeground(new java.awt.Color(255, 255, 255));
        maintab.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        accounttab.setBackground(new java.awt.Color(153, 153, 153));

        accounttable.setBackground(colorList[5]);
        accounttable.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        accounttable.setForeground(colorList[9]);
        accounttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "name", "acc. no", "acc. type", "interest rate", "balance"
            }
        ));
        accounttable.setGridColor(new java.awt.Color(255, 255, 255));
        accounttable.setRowHeight(25);
        accounttable.setSelectionBackground(colorList[0]);
        accounttable.setSelectionForeground(colorList[9]);
        accounttable.setShowGrid(true);
        jScrollPane1.setViewportView(accounttable);

        jButton3.setBackground(colorList[1]);
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setForeground(colorList[9]);
        jButton3.setText("Delete");
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(colorList[1]);
        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setForeground(colorList[9]);
        jButton4.setText("Update");
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(colorList[1]);
        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton5.setForeground(colorList[9]);
        jButton5.setText("Add");
        jButton5.setFocusable(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        accountsearchfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        accountsearchfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        accountsearchfield.setText("search");
        accountsearchfield.setSelectedTextColor(colorList[9]);
        accountsearchfield.setSelectionColor(colorList[1]);
        accountsearchfield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                accountsearchfieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                accountsearchfieldFocusLost(evt);
            }
        });
        accountsearchfield.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                accountsearchfieldCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        accountsearchfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountsearchfieldActionPerformed(evt);
            }
        });
        accountsearchfield.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                accountsearchfieldPropertyChange(evt);
            }
        });
        accountsearchfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                accountsearchfieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout accounttabLayout = new javax.swing.GroupLayout(accounttab);
        accounttab.setLayout(accounttabLayout);
        accounttabLayout.setHorizontalGroup(
            accounttabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accounttabLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(accounttabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(accounttabLayout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(accountsearchfield, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 921, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        accounttabLayout.setVerticalGroup(
            accounttabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accounttabLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(accounttabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(accounttabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(accountsearchfield))
                .addGap(68, 68, 68))
        );

        maintab.addTab("tab1", accounttab);

        transactiontab.setBackground(new java.awt.Color(153, 153, 153));

        receivingaccount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        receivingaccount.setText("receiving account");
        receivingaccount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                receivingaccountFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                receivingaccountFocusLost(evt);
            }
        });

        senderaccount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        senderaccount.setText("sender account (optional)");
        senderaccount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                senderaccountFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                senderaccountFocusLost(evt);
            }
        });

        jButton1.setBackground(colorList[1]);
        jButton1.setForeground(colorList[9]);
        jButton1.setText("Deposit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton6.setBackground(colorList[1]);
        jButton6.setForeground(colorList[9]);
        jButton6.setText("Withdraw");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        amountfield.setText("amount");
        amountfield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                amountfieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                amountfieldFocusLost(evt);
            }
        });

        jLabel1.setText("balance : ");

        jLabel2.setText("balance : ");

        transactiontable.setBackground(colorList[5]);
        transactiontable.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        transactiontable.setForeground(colorList[9]);
        transactiontable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "transit id", "receiver", "sender", "amount", "date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        transactiontable.setGridColor(new java.awt.Color(255, 255, 255));
        transactiontable.setRowHeight(25);
        transactiontable.setSelectionBackground(colorList[0]);
        transactiontable.setSelectionForeground(colorList[9]);
        transactiontable.setShowGrid(true);
        jScrollPane3.setViewportView(transactiontable);

        transitlog.setBackground(colorList[8]);
        transitlog.setColumns(20);
        transitlog.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        transitlog.setForeground(colorList[1]);
        transitlog.setRows(5);
        jScrollPane2.setViewportView(transitlog);

        receivingaccountbalance.setText("0");

        senderaccountbalance.setText("0");

        searchtransaction.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchtransaction.setText("search");
        searchtransaction.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchtransactionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchtransactionFocusLost(evt);
            }
        });
        searchtransaction.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchtransactionKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout transactiontabLayout = new javax.swing.GroupLayout(transactiontab);
        transactiontab.setLayout(transactiontabLayout);
        transactiontabLayout.setHorizontalGroup(
            transactiontabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transactiontabLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(transactiontabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(senderaccount, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                    .addComponent(receivingaccount)
                    .addGroup(transactiontabLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(receivingaccountbalance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(transactiontabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(amountfield, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, transactiontabLayout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(senderaccountbalance, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(transactiontabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchtransaction)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE))
                .addGap(45, 45, 45))
        );
        transactiontabLayout.setVerticalGroup(
            transactiontabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transactiontabLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(transactiontabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(transactiontabLayout.createSequentialGroup()
                        .addComponent(receivingaccount, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(transactiontabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(receivingaccountbalance))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(senderaccount, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(transactiontabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(senderaccountbalance))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(amountfield, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(transactiontabLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchtransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        maintab.addTab("tab2", transactiontab);

        getContentPane().add(maintab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 58, -1, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void accountbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountbuttonMouseClicked
        ReloadAccountTableFromDatabase(Database.getAccountList());
        maintab.setSelectedIndex(0);
    }//GEN-LAST:event_accountbuttonMouseClicked

    private void transactionbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionbuttonMouseClicked
        ReloadTransitTableFromDatabase(Database.getTransitList());
        maintab.setSelectedIndex(1);
    }//GEN-LAST:event_transactionbuttonMouseClicked

    private void accountbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountbuttonMouseEntered
        accountbutton.setBackground(colorList[0]);
        accountbuttontext.setForeground(colorList[8]);
        accountbutton.setBorder(BorderFactory.createLineBorder( colorList[2], 3));
    }//GEN-LAST:event_accountbuttonMouseEntered

    private void transactionbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionbuttonMouseEntered
        transactionbutton.setBackground(colorList[0]);
        transactionbuttontext.setForeground(colorList[8]);
        transactionbutton.setBorder(BorderFactory.createLineBorder( colorList[2], 3));
    }//GEN-LAST:event_transactionbuttonMouseEntered

    private void accountbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountbuttonMouseExited
        accountbutton.setBackground(colorList[1]);
        accountbuttontext.setForeground(colorList[9]);
        accountbutton.setBorder(BorderFactory.createEmptyBorder());
    }//GEN-LAST:event_accountbuttonMouseExited

    private void transactionbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionbuttonMouseExited
        transactionbutton.setBackground(colorList[1]);
        transactionbuttontext.setForeground(colorList[9]);
        transactionbutton.setBorder(BorderFactory.createEmptyBorder());
    }//GEN-LAST:event_transactionbuttonMouseExited

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        DefaultTableModel table = (DefaultTableModel) accounttable.getModel();
        String[] data = {"", "", "", "", ""};
        table.addRow(data);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DefaultTableModel table = (DefaultTableModel) accounttable.getModel();
        
        if (Other.isValidNumber(table.getValueAt(accounttable.getSelectedRow(), 3).toString()) || Other.isValidNumber(table.getValueAt(accounttable.getSelectedRow(), 4).toString())){
            String name = table.getValueAt(accounttable.getSelectedRow(), 0).toString();
            String id = table.getValueAt(accounttable.getSelectedRow(), 1).toString();
            String accType = table.getValueAt(accounttable.getSelectedRow(), 2).toString();
            float interest = Float.parseFloat(table.getValueAt(accounttable.getSelectedRow(), 3).toString());
            double balance = Double.parseDouble(table.getValueAt(accounttable.getSelectedRow(), 4).toString());
            
            Account acc = new Account(name, id, balance, accType, interest);
            
            if (!Database.accExist(id)){
                Database.addAccount(acc);
                JOptionPane.showMessageDialog(null, "Account Successfully Added to databse");    
                ReloadAccountTableFromDatabase(Database.getAccountList());
            }
            else
            {
                int confirm = JOptionPane.showConfirmDialog(null, "Account ID already exist, want to override the details?");
                
                if (confirm == 0)
                {
                    Database.updateAccount(id, acc);
                    JOptionPane.showMessageDialog(null, "Account Successfully Updated");  
                    
                }
            
            }
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Enter valid value");
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (accounttable.getRowCount() > 0){
            DefaultTableModel table = (DefaultTableModel) accounttable.getModel();
            
            String id = table.getValueAt(accounttable.getSelectedRow(), 1).toString();
            if (Database.accExist(id)){
                Database.removeAccount(id);
                JOptionPane.showMessageDialog(null, "account deleted");
            }
                
            
            table.removeRow(accounttable.getSelectedRow());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void accountsearchfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountsearchfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accountsearchfieldActionPerformed

    private void accountsearchfieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_accountsearchfieldFocusGained
        if (accountsearchfield.getText().equalsIgnoreCase("search")){
            accountsearchfield.setText("");
        }
    }//GEN-LAST:event_accountsearchfieldFocusGained

    private void accountsearchfieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_accountsearchfieldFocusLost
        if (accountsearchfield.getText().isBlank()){
            accountsearchfield.setText("search");
        }
    }//GEN-LAST:event_accountsearchfieldFocusLost

    private void accountsearchfieldCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_accountsearchfieldCaretPositionChanged
        
    }//GEN-LAST:event_accountsearchfieldCaretPositionChanged

    private void accountsearchfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_accountsearchfieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            ReloadAccountTableFromDatabase(Database.searchAccount(accountsearchfield.getText()));
        }
    }//GEN-LAST:event_accountsearchfieldKeyPressed

    private void accountsearchfieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_accountsearchfieldPropertyChange
       
    }//GEN-LAST:event_accountsearchfieldPropertyChange

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Database.LoadData();
        ReloadAccountTableFromDatabase(Database.getAccountList());
    }//GEN-LAST:event_formWindowOpened

    private void receivingaccountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_receivingaccountFocusGained
        if (receivingaccount.getText().equalsIgnoreCase("receiving account")){
            receivingaccount.setText("");
        }
    }//GEN-LAST:event_receivingaccountFocusGained

    private void receivingaccountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_receivingaccountFocusLost
        if (receivingaccount.getText().isBlank()){
            receivingaccount.setText("receiving account");
        }
        
        try
        {
            receivingaccountbalance.setText("" + Database.getAccountByID(receivingaccount.getText()).getBalance()); 
        }
        catch (Exception e){}
    }//GEN-LAST:event_receivingaccountFocusLost

    private void senderaccountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_senderaccountFocusGained
        if (senderaccount.getText().equalsIgnoreCase("sender account (optional)")){
            senderaccount.setText("");
        }
    }//GEN-LAST:event_senderaccountFocusGained

    private void senderaccountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_senderaccountFocusLost
        if (senderaccount.getText().isBlank()){
            senderaccount.setText("sender account (optional)");
        }
        
        
        try
        {
            senderaccountbalance.setText("" + Database.getAccountByID(senderaccount.getText()).getBalance());
        }
        catch(Exception e){}
    }//GEN-LAST:event_senderaccountFocusLost

    private void amountfieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_amountfieldFocusGained
        if (amountfield.getText().equalsIgnoreCase("amount")){
            amountfield.setText("");
        }
    }//GEN-LAST:event_amountfieldFocusGained

    private void amountfieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_amountfieldFocusLost
        if (amountfield.getText().isBlank()){
            amountfield.setText("amount");
        }
    }//GEN-LAST:event_amountfieldFocusLost

    private void searchtransactionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchtransactionFocusGained
        if (searchtransaction.getText().equalsIgnoreCase("search")){
            searchtransaction.setText("");
        }
    }//GEN-LAST:event_searchtransactionFocusGained

    private void searchtransactionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchtransactionFocusLost
        if (searchtransaction.getText().isBlank()){
            searchtransaction.setText("search");
        }
    }//GEN-LAST:event_searchtransactionFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!receivingaccount.getText().equalsIgnoreCase("receiving account") && Other.isValidNumber(amountfield.getText())){
            
            double amount = Double.parseDouble(amountfield.getText()); // amount
            String receiverAcc = receivingaccount.getText();
            
            if (amount > 0)
            {
                if (!senderaccount.getText().equalsIgnoreCase("sender account (optional)")){
                    String senderAcc = senderaccount.getText();

                    if (Database.accExist(senderAcc) && Database.accExist(receiverAcc)){
                        if ((Database.getAccountByID(senderAcc).getBalance() >= amount)){
                            Database.getAccountByID(senderAcc).setBalance(Database.getAccountByID(senderAcc).getBalance() - amount);
                            Database.getAccountByID(receiverAcc).setBalance(Database.getAccountByID(receiverAcc).getBalance() + amount);

                            Database.addTransaction(new Transaction(Database.generateTransitID("D"), senderAcc, receiverAcc, amount));

                            transitlog.setText(transitlog.getText() + "\n" + amount + " transferred to " + receiverAcc + " by " + senderAcc); 
                            
                            ReloadTransitTableFromDatabase(Database.getTransitList());

                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Not enough balance to send");
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Account not found");
                    }
                }
                else
                {
                    if (Database.accExist(receiverAcc)){

                        Database.getAccountByID(receiverAcc).setBalance(Database.getAccountByID(receiverAcc).getBalance() + amount);
                        Database.addTransaction(new Transaction(Database.generateTransitID("D"), "SYSTEM", receiverAcc, amount));

                        transitlog.setText(transitlog.getText() + "\n" + amount + " transferred to " + receiverAcc);
                        
                        ReloadTransitTableFromDatabase(Database.getTransitList());

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Account not found");
                    }
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Amount must not be negative");
            }
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (!receivingaccount.getText().equalsIgnoreCase("receiving account") && Other.isValidNumber(amountfield.getText())){
            double amount = Double.parseDouble(amountfield.getText());
            
            if (amount > 0){
                String receiving = receivingaccount.getText() ;
                
                if (Database.accExist(receiving)){
                    if (Database.getAccountByID(receiving).getBalance() >= amount){
                        Database.getAccountByID(receiving).setBalance(Database.getAccountByID(receiving).getBalance() - amount);
                        Database.addTransaction(new Transaction(Database.generateTransitID("W"), "", receiving, amount));

                        transitlog.setText(transitlog.getText() + "\n" + amount + " withdrawm from " + receiving);
                        
                        ReloadTransitTableFromDatabase(Database.getTransitList());
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Amount not available");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Account doesn't exist");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Amount must not be negative");
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void searchtransactionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchtransactionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            ReloadTransitTableFromDatabase(Database.searchTransit(searchtransaction.getText()));
        }
    }//GEN-LAST:event_searchtransactionKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Database.WriteData();
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mainframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accountbutton;
    private javax.swing.JLabel accountbuttontext;
    private javax.swing.JTextField accountsearchfield;
    private javax.swing.JPanel accounttab;
    private javax.swing.JTable accounttable;
    private javax.swing.JTextField amountfield;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane maintab;
    private javax.swing.JTextField receivingaccount;
    private javax.swing.JLabel receivingaccountbalance;
    private javax.swing.JTextField searchtransaction;
    private javax.swing.JTextField senderaccount;
    private javax.swing.JLabel senderaccountbalance;
    private javax.swing.JPanel transactionbutton;
    private javax.swing.JLabel transactionbuttontext;
    private javax.swing.JPanel transactiontab;
    private javax.swing.JTable transactiontable;
    private javax.swing.JTextArea transitlog;
    // End of variables declaration//GEN-END:variables
}
