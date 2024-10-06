
package Frontend;

import Backend.Appointment;
import Backend.Billing;
import Backend.Database;
import Backend.Debug;
import Backend.Doctor;
import Backend.Patient;
import Backend.QueryAction;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Backend.setup;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Junaid
 */
public class MainFrame extends javax.swing.JFrame {

    int is_clicked = 1;
    
    public MainFrame() {
        
        initComponents();
        
        patientbutton.setBackground(colorList[1]);
        p_text.setForeground(Color.WHITE);
    }
    

    public static final Color BACKGROUND = new Color(244,244,244);
    public static final Color SELECTED_BUTTON = new Color(253, 130, 125);
    public static final Color BUTTON_FONT = new Color(217, 217, 217);
    public static final Color FOUR = new Color(216, 185, 195);
    public static final Color FIVE = new Color (236, 244, 197);
    public static final Color PANEL_BUTTON_TEXT_UNSELECTED = new Color (153,153,153);
    public static final Color PANELBUTTON_HOVER = new Color (255, 196, 196);
    public static final Color PURPLE_BUTTON = new Color (152, 143, 206);
    public static final Color BLUE_BUTTON = new Color (130,208, 228);
    
    public static Color[] colorList = { BACKGROUND, SELECTED_BUTTON, BUTTON_FONT, FOUR, FIVE };
    
    
    //------------------------------------------------------------------------
    
    public void ClearTable (JTable table){
        DefaultTableModel newTable = (DefaultTableModel) table.getModel();
        for (int i = table.getRowCount() -1; i >= 0; i --){
            newTable.removeRow(i);
        }
    }
    
    public <T extends setup> void PopulateTable (JTable table, ArrayList<T> datalist){
        ClearTable(table);
        
        DefaultTableModel newTable = (DefaultTableModel) table.getModel();
        
        if (!datalist.isEmpty()){
            if (datalist.get(0).getAllData().length == table.getColumnCount()){
                for (T obj : datalist){ newTable.addRow(obj.getAllData()); }
            }
        }
    }
    
    public Object[] GetRowData (JTable table){
        Object[] data = new Object[table.getColumnCount()];
        
        for (int i = 0; i < table.getColumnCount(); i++){
            try
            {
                data[i] = table.getModel().getValueAt(table.getSelectedRow(), i);
            }
            catch (Exception e){
                data[i] = "";
                System.out.println(e.getMessage());
            }
        }
        
        return data;
    }
    
    public void addRow (JTable table){
        ((DefaultTableModel) table.getModel()).addRow(new Object[table.getColumnCount()]);
    }
    
    public void removeRow (JTable table){
        ((DefaultTableModel) table.getModel()).removeRow(table.getSelectedRow());
    }
    
    //------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        patientbutton = new javax.swing.JPanel();
        p_text = new javax.swing.JLabel();
        doctorbutton = new javax.swing.JPanel();
        d_text = new javax.swing.JLabel();
        appointmentbutton = new javax.swing.JPanel();
        a_text = new javax.swing.JLabel();
        billingbutton = new javax.swing.JPanel();
        b_text = new javax.swing.JLabel();
        maintab = new javax.swing.JTabbedPane();
        patient_tab = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        patient_table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        patient_search = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        doctor_tab = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        doctor_table = new javax.swing.JTable();
        doctor_search = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        appointment_tab = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        appointment_table = new javax.swing.JTable();
        appointment_search = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        billing_tab = new javax.swing.JPanel();
        billing_search = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        billing_table = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        patientbutton.setBackground(new java.awt.Color(255, 255, 255));
        patientbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientbuttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                patientbuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                patientbuttonMouseExited(evt);
            }
        });

        p_text.setBackground(new java.awt.Color(204, 204, 204));
        p_text.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        p_text.setForeground(new java.awt.Color(153, 153, 153));
        p_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p_text.setText("Patient");

        javax.swing.GroupLayout patientbuttonLayout = new javax.swing.GroupLayout(patientbutton);
        patientbutton.setLayout(patientbuttonLayout);
        patientbuttonLayout.setHorizontalGroup(
            patientbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_text, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        patientbuttonLayout.setVerticalGroup(
            patientbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(p_text, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        getContentPane().add(patientbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 200, -1));

        doctorbutton.setBackground(new java.awt.Color(255, 255, 255));
        doctorbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doctorbuttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                doctorbuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                doctorbuttonMouseExited(evt);
            }
        });

        d_text.setBackground(new java.awt.Color(204, 204, 204));
        d_text.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        d_text.setForeground(new java.awt.Color(153, 153, 153));
        d_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        d_text.setText("Dactor");

        javax.swing.GroupLayout doctorbuttonLayout = new javax.swing.GroupLayout(doctorbutton);
        doctorbutton.setLayout(doctorbuttonLayout);
        doctorbuttonLayout.setHorizontalGroup(
            doctorbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d_text, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        doctorbuttonLayout.setVerticalGroup(
            doctorbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(d_text, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        getContentPane().add(doctorbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 480, 200, -1));

        appointmentbutton.setBackground(new java.awt.Color(255, 255, 255));
        appointmentbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appointmentbuttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                appointmentbuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                appointmentbuttonMouseExited(evt);
            }
        });

        a_text.setBackground(new java.awt.Color(204, 204, 204));
        a_text.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        a_text.setForeground(new java.awt.Color(153, 153, 153));
        a_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a_text.setText("Appointment");

        javax.swing.GroupLayout appointmentbuttonLayout = new javax.swing.GroupLayout(appointmentbutton);
        appointmentbutton.setLayout(appointmentbuttonLayout);
        appointmentbuttonLayout.setHorizontalGroup(
            appointmentbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a_text, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        appointmentbuttonLayout.setVerticalGroup(
            appointmentbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(a_text, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        getContentPane().add(appointmentbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 480, -1, -1));

        billingbutton.setBackground(new java.awt.Color(255, 255, 255));
        billingbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                billingbuttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                billingbuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                billingbuttonMouseExited(evt);
            }
        });

        b_text.setBackground(new java.awt.Color(204, 204, 204));
        b_text.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        b_text.setForeground(new java.awt.Color(153, 153, 153));
        b_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b_text.setText("Billing");

        javax.swing.GroupLayout billingbuttonLayout = new javax.swing.GroupLayout(billingbutton);
        billingbutton.setLayout(billingbuttonLayout);
        billingbuttonLayout.setHorizontalGroup(
            billingbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(b_text, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        billingbuttonLayout.setVerticalGroup(
            billingbuttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(b_text, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        getContentPane().add(billingbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 480, -1, -1));

        patient_tab.setBackground(colorList[0]);

        patient_table.setFont(new java.awt.Font("sansserif", 0, 13)); // NOI18N
        patient_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Age", "Disease", "Phone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        patient_table.setGridColor(new java.awt.Color(153, 153, 153));
        patient_table.setRowHeight(25);
        patient_table.setSelectionBackground(colorList[4]);
        patient_table.setSelectionForeground(new java.awt.Color(51, 51, 51));
        patient_table.setShowGrid(true);
        jScrollPane1.setViewportView(patient_table);
        if (patient_table.getColumnModel().getColumnCount() > 0) {
            patient_table.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        jButton1.setBackground(PURPLE_BUTTON);
        jButton1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton1.setText("Add");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        patient_search.setBackground(new java.awt.Color(255, 255, 255));
        patient_search.setForeground(new java.awt.Color(153, 153, 153));
        patient_search.setText("search");
        patient_search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                patient_searchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                patient_searchFocusLost(evt);
            }
        });
        patient_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patient_searchActionPerformed(evt);
            }
        });
        patient_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                patient_searchKeyPressed(evt);
            }
        });

        jButton2.setBackground(PURPLE_BUTTON);
        jButton2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton2.setText("Update");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(PURPLE_BUTTON);
        jButton3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton3.setText("Delete");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AD");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        javax.swing.GroupLayout patient_tabLayout = new javax.swing.GroupLayout(patient_tab);
        patient_tab.setLayout(patient_tabLayout);
        patient_tabLayout.setHorizontalGroup(
            patient_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patient_tabLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(patient_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(patient_search)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(patient_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        patient_tabLayout.setVerticalGroup(
            patient_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patient_tabLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(patient_search, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(patient_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(patient_tabLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        maintab.addTab("tab1", patient_tab);

        doctor_tab.setBackground(colorList[0]);

        doctor_table.setFont(new java.awt.Font("sansserif", 0, 13)); // NOI18N
        doctor_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Qualification", "Designation", "Salary", "Department"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        doctor_table.setGridColor(new java.awt.Color(153, 153, 153));
        doctor_table.setRowHeight(25);
        doctor_table.setSelectionBackground(colorList[4]);
        doctor_table.setSelectionForeground(new java.awt.Color(51, 51, 51));
        doctor_table.setShowGrid(true);
        jScrollPane2.setViewportView(doctor_table);
        if (doctor_table.getColumnModel().getColumnCount() > 0) {
            doctor_table.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        doctor_search.setBackground(new java.awt.Color(255, 255, 255));
        doctor_search.setForeground(new java.awt.Color(153, 153, 153));
        doctor_search.setText("search");
        doctor_search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                doctor_searchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                doctor_searchFocusLost(evt);
            }
        });
        doctor_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                doctor_searchKeyPressed(evt);
            }
        });

        jButton4.setBackground(PURPLE_BUTTON);
        jButton4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton4.setText("Add");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(PURPLE_BUTTON);
        jButton5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton5.setText("Update");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setFocusable(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(PURPLE_BUTTON);
        jButton6.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton6.setText("Delete");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setFocusable(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("AD");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        javax.swing.GroupLayout doctor_tabLayout = new javax.swing.GroupLayout(doctor_tab);
        doctor_tab.setLayout(doctor_tabLayout);
        doctor_tabLayout.setHorizontalGroup(
            doctor_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doctor_tabLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(doctor_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(doctor_search)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(doctor_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        doctor_tabLayout.setVerticalGroup(
            doctor_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doctor_tabLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(doctor_search, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(doctor_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(doctor_tabLayout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        maintab.addTab("tab2", doctor_tab);

        appointment_tab.setBackground(colorList[0]);

        appointment_table.setFont(new java.awt.Font("sansserif", 0, 13)); // NOI18N
        appointment_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Type", "Patient ID", "Dactor ID", "DateTime"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        appointment_table.setGridColor(new java.awt.Color(153, 153, 153));
        appointment_table.setRowHeight(25);
        appointment_table.setSelectionBackground(colorList[4]);
        appointment_table.setSelectionForeground(new java.awt.Color(51, 51, 51));
        appointment_table.setShowGrid(true);
        jScrollPane4.setViewportView(appointment_table);
        if (appointment_table.getColumnModel().getColumnCount() > 0) {
            appointment_table.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        appointment_search.setBackground(new java.awt.Color(255, 255, 255));
        appointment_search.setForeground(new java.awt.Color(153, 153, 153));
        appointment_search.setText("search");
        appointment_search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                appointment_searchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                appointment_searchFocusLost(evt);
            }
        });
        appointment_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                appointment_searchKeyPressed(evt);
            }
        });

        jButton10.setBackground(PURPLE_BUTTON);
        jButton10.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton10.setText("Add");
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.setFocusable(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton12.setBackground(PURPLE_BUTTON);
        jButton12.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton12.setText("Delete");
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.setFocusable(false);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("AD");
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jButton7.setBackground(PURPLE_BUTTON);
        jButton7.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton7.setText("Confirm");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setFocusable(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout appointment_tabLayout = new javax.swing.GroupLayout(appointment_tab);
        appointment_tab.setLayout(appointment_tabLayout);
        appointment_tabLayout.setHorizontalGroup(
            appointment_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appointment_tabLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(appointment_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(appointment_search)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(appointment_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        appointment_tabLayout.setVerticalGroup(
            appointment_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appointment_tabLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(appointment_search, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(appointment_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(appointment_tabLayout.createSequentialGroup()
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        maintab.addTab("tab3", appointment_tab);

        billing_tab.setBackground(colorList[0]);

        billing_search.setBackground(new java.awt.Color(255, 255, 255));
        billing_search.setForeground(new java.awt.Color(153, 153, 153));
        billing_search.setText("search");
        billing_search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                billing_searchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                billing_searchFocusLost(evt);
            }
        });
        billing_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                billing_searchKeyPressed(evt);
            }
        });

        billing_table.setFont(new java.awt.Font("sansserif", 0, 13)); // NOI18N
        billing_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Amount", "Appointment ID", "Payer", "DateTime"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        billing_table.setGridColor(new java.awt.Color(153, 153, 153));
        billing_table.setRowHeight(25);
        billing_table.setSelectionBackground(colorList[4]);
        billing_table.setSelectionForeground(new java.awt.Color(51, 51, 51));
        billing_table.setShowGrid(true);
        jScrollPane5.setViewportView(billing_table);
        if (billing_table.getColumnModel().getColumnCount() > 0) {
            billing_table.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        jButton11.setBackground(PURPLE_BUTTON);
        jButton11.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton11.setText("Add");
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.setFocusable(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("AD");
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jButton8.setBackground(PURPLE_BUTTON);
        jButton8.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton8.setText("Save");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.setFocusable(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout billing_tabLayout = new javax.swing.GroupLayout(billing_tab);
        billing_tab.setLayout(billing_tabLayout);
        billing_tabLayout.setHorizontalGroup(
            billing_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(billing_tabLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(billing_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(billing_search)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(billing_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        billing_tabLayout.setVerticalGroup(
            billing_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(billing_tabLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(billing_search, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(billing_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(billing_tabLayout.createSequentialGroup()
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        maintab.addTab("tab4", billing_tab);

        getContentPane().add(maintab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 800, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    void RepaintPatientButton(){
        patientbutton.setBackground(Color.WHITE);
        p_text.setForeground(PANEL_BUTTON_TEXT_UNSELECTED);
    }
    
    void RepaintDoctorButton(){
        doctorbutton.setBackground(Color.WHITE);
        d_text.setForeground(PANEL_BUTTON_TEXT_UNSELECTED);
    }
    
    void RepaintAppointmentButton(){
        appointmentbutton.setBackground(Color.WHITE);
        a_text.setForeground(PANEL_BUTTON_TEXT_UNSELECTED);
    }
    
    void RepaintBillingButton(){
        billingbutton.setBackground(Color.WHITE);
        b_text.setForeground(PANEL_BUTTON_TEXT_UNSELECTED);
    }
    
    
    private void patientbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientbuttonMouseEntered
        if (is_clicked != 1){
            patientbutton.setBackground(PANELBUTTON_HOVER);
            p_text.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_patientbuttonMouseEntered

    private void patientbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientbuttonMouseExited
        if (is_clicked != 1){
            patientbutton.setBackground(Color.WHITE);
            p_text.setForeground(PANEL_BUTTON_TEXT_UNSELECTED);
        }
    }//GEN-LAST:event_patientbuttonMouseExited

    private void patientbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientbuttonMouseClicked
        maintab.setSelectedIndex(0);
        patientbutton.setBackground(colorList[1]);
        p_text.setForeground(Color.WHITE);
        is_clicked = 1;
        
        PopulateTable(patient_table, Database.getPatientList());
        
        RepaintDoctorButton();
        RepaintAppointmentButton();
        RepaintBillingButton();
    }//GEN-LAST:event_patientbuttonMouseClicked

    private void doctorbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorbuttonMouseEntered
        if (is_clicked != 2){
            doctorbutton.setBackground(PANELBUTTON_HOVER);
            d_text.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_doctorbuttonMouseEntered

    private void doctorbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorbuttonMouseExited
        if (is_clicked != 2){
            doctorbutton.setBackground(Color.WHITE);
            d_text.setForeground(PANEL_BUTTON_TEXT_UNSELECTED);
        }
    }//GEN-LAST:event_doctorbuttonMouseExited

    private void doctorbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorbuttonMouseClicked
        maintab.setSelectedIndex(1);
        
        doctorbutton.setBackground(colorList[1]);
        d_text.setForeground(Color.WHITE);
        is_clicked = 2;
        
        PopulateTable(doctor_table, Database.getDoctorList());
        
        RepaintPatientButton();
        RepaintAppointmentButton();
        RepaintBillingButton();
    }//GEN-LAST:event_doctorbuttonMouseClicked

    private void appointmentbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointmentbuttonMouseEntered
        if (is_clicked != 3){
            appointmentbutton.setBackground(PANELBUTTON_HOVER);
            a_text.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_appointmentbuttonMouseEntered

    private void appointmentbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointmentbuttonMouseExited
        if (is_clicked != 3){
            appointmentbutton.setBackground(Color.WHITE);
            a_text.setForeground(PANEL_BUTTON_TEXT_UNSELECTED);
        }
    }//GEN-LAST:event_appointmentbuttonMouseExited

    private void appointmentbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointmentbuttonMouseClicked
        maintab.setSelectedIndex(2);
        
        appointmentbutton.setBackground(colorList[1]);
        a_text.setForeground(Color.WHITE);
        is_clicked = 3;
        
        PopulateTable(appointment_table, Database.getAppointmentList());
        
        RepaintPatientButton();
        RepaintDoctorButton();
        RepaintBillingButton();
    }//GEN-LAST:event_appointmentbuttonMouseClicked

    private void billingbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billingbuttonMouseEntered
        if (is_clicked != 4){
            billingbutton.setBackground(PANELBUTTON_HOVER);
            b_text.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_billingbuttonMouseEntered

    private void billingbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billingbuttonMouseExited
        if (is_clicked != 4){
            billingbutton.setBackground(Color.WHITE);
            b_text.setForeground(PANEL_BUTTON_TEXT_UNSELECTED);
        }
    }//GEN-LAST:event_billingbuttonMouseExited

    private void billingbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billingbuttonMouseClicked
        maintab.setSelectedIndex(3);
        
        billingbutton.setBackground(colorList[1]);
        b_text.setForeground(Color.WHITE);
        is_clicked = 4;
        
        PopulateTable(billing_table, Database.getBillingList());
        
        RepaintPatientButton();
        RepaintDoctorButton();
        RepaintAppointmentButton();
    }//GEN-LAST:event_billingbuttonMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        addRow (patient_table);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Object[] data = GetRowData(patient_table);
        
        boolean check = true;
        
        if (data[1] == null || data[2] == null || data[3] == null || data[4] == null){
            Debug.showMessage("Fields Cannot Be Empty");
            check = false;
        }
        else if (! Debug.isValidNumber("" + data[2])){
            Debug.showMessage("Invalid Age");
            check = false;
        }
        
        if (check){
            if (data[0] != null && Database.getPatientByID((int) data[0]) != null){
                int choice = Debug.confirmMessage("Patient Already Exist. Want to edit the info?");
                
                if (choice == 0){
                    Patient p = new Patient((String) data[1], (int) data[2], (String) data[3], (String) data[4]);
                    boolean success = Database.updatePatient((int) data[0], p);
                    
                    if (success) { Debug.showMessage("Patient Updated !"); }
                    else { Debug.showMessage("Error Updating Patient with ID : " + data[0]); }
                }
            }
            else
            { 
                Patient p = new Patient((String) data[1], Integer.parseInt("" + data[2]), (String) data[3], (String) data[4]);
                p.setId(Database.getPatientList().size() + 1);
                boolean success = Database.addPatient(p);
                
                if (success) { Debug.showMessage("Patient Added !"); }
                else { Debug.showMessage("Error Adding Patient"); }
            }
            
            PopulateTable(patient_table, Database.getPatientList());
        }
        else
        {
            Debug.showMessage("Error Occured");
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Object[] data = GetRowData(patient_table);
        
        if (data[0] == null){
            removeRow(patient_table);
        }
        else{
            int id = Integer.parseInt("" + data[0]);
            boolean success = Database.deleteEntry(Database.getPatientList(), id);
            
            if (success) {
                Debug.showMessage("Patient Deleted !");
                PopulateTable(patient_table, Database.getPatientList());
            }
            else { Debug.showMessage("Error Deleting Patient"); }
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void patient_searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_patient_searchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            PopulateTable(patient_table, Database.search(patient_search.getText(), Database.getPatientList()));
        }
    }//GEN-LAST:event_patient_searchKeyPressed

    private void doctor_searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_doctor_searchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            PopulateTable(doctor_table, Database.search(doctor_search.getText(), Database.getDoctorList()));
        }
    }//GEN-LAST:event_doctor_searchKeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        addRow(doctor_table);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Object[] data = GetRowData(doctor_table);
        
        boolean check = true;
        
        if (data[1] == null || data[2] == null || data[3] == null || data[4] == null || data[5] == null){
            Debug.showMessage("Fields Cannot Be Empty");
            check = false;
        }
        else if (! Debug.isValidNumber("" + data[4])){
            Debug.showMessage("Invalid Salary");
            check = false;
        }
        
        if (check){
            if (data[0] != null && Database.getDoctorByID((int) data[0]) != null){
                int choice = Debug.confirmMessage("Doctor Already Exist. Want to edit the info?");
                
                if (choice == 0){
                    Doctor d = new Doctor("" + data[1], "" + data[2], (String) data[3], Double.parseDouble("" + data[4]), "" + data[5]);
                    boolean success = Database.updateDoctor((int) data[0], d);
                    
                    if (success) { Debug.showMessage("Doctor Updated !"); }
                    else { Debug.showMessage("Error Updating Doctor with ID : " + data[0]); }
                }
            }
            else
            { 
                Doctor d = new Doctor("" + data[1], "" + data[2], (String) data[3], Double.parseDouble("" + data[4]), "" + data[5]);
                d.setId(Database.getDoctorList().size() + 1);
                boolean success = Database.addDoctor(d);
                
                if (success) { Debug.showMessage("Doctor Added !"); }
                else { Debug.showMessage("Error Adding Doctor"); }
            }
            
            PopulateTable(doctor_table, Database.getDoctorList());
        }
        else
        {
            Debug.showMessage("Error Occured");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Object[] data = GetRowData(doctor_table);
        
        if (data[0] == null){
            removeRow(doctor_table);
        }
        else{
            int id = Integer.parseInt("" + data[0]);
            boolean success = Database.deleteEntry(Database.getDoctorList(), id);
            
            if (success) {
                Debug.showMessage("Doctor Deleted !");
                PopulateTable(doctor_table, Database.getDoctorList());
            }
            else { Debug.showMessage("Error Deleting Doctor"); }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void doctor_searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_doctor_searchFocusGained
        if (doctor_search.getText().equalsIgnoreCase("search")){
            doctor_search.setText("");
        }
    }//GEN-LAST:event_doctor_searchFocusGained

    private void doctor_searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_doctor_searchFocusLost
        if (doctor_search.getText().isBlank()){
            doctor_search.setText("search");
        }
    }//GEN-LAST:event_doctor_searchFocusLost

    private void patient_searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_patient_searchFocusGained
        if (patient_search.getText().equalsIgnoreCase("search")){
            patient_search.setText("");
        }
    }//GEN-LAST:event_patient_searchFocusGained

    private void patient_searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_patient_searchFocusLost
        if (patient_search.getText().isBlank()){
            patient_search.setText("search");
        }
    }//GEN-LAST:event_patient_searchFocusLost

    private void appointment_searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_appointment_searchFocusGained
        if (appointment_search.getText().equalsIgnoreCase("search")){
            appointment_search.setText("");
        }
    }//GEN-LAST:event_appointment_searchFocusGained

    private void appointment_searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_appointment_searchFocusLost
        if (appointment_search.getText().isBlank()){
            appointment_search.setText("search");
        }
    }//GEN-LAST:event_appointment_searchFocusLost

    private void appointment_searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_appointment_searchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            PopulateTable(appointment_table, Database.search(appointment_search.getText(), Database.getAppointmentList()));
        }
    }//GEN-LAST:event_appointment_searchKeyPressed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        addRow(appointment_table);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        Object[] data = GetRowData(appointment_table);
        
        int confirm  = Debug.confirmMessage("Confirm want to delete this appointment?");
        if (confirm == 0){
            if (data[0] == null){
                removeRow(appointment_table);
            }
            else
            {
                Database.deleteEntry(Database.getAppointmentList(), Integer.parseInt("" + data[0]));
                removeRow(appointment_table);
                PopulateTable(appointment_table, Database.getAppointmentList());
            }
        }
        
    }//GEN-LAST:event_jButton12ActionPerformed

    private void billing_searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_billing_searchFocusGained
        if (billing_search.getText().equalsIgnoreCase("search")){
            billing_search.setText("");
        }
    }//GEN-LAST:event_billing_searchFocusGained

    private void billing_searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_billing_searchFocusLost
        if (billing_search.getText().isBlank()){
            billing_search.setText("search");
        }
    }//GEN-LAST:event_billing_searchFocusLost

    private void billing_searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_billing_searchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            PopulateTable(billing_table, Database.search(billing_search.getText(), Database.getBillingList()));
        }
    }//GEN-LAST:event_billing_searchKeyPressed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        addRow(billing_table);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Object[] data = GetRowData(appointment_table);
        
        if (data[1] != null && data[2] != null && data[3] != null){
            if (Debug.isValidNumber("" + data[2]) && Debug.isValidNumber("" + data[3])){
                int doc_id = Integer.parseInt("" + data[3]);
                int pat_id = Integer.parseInt("" + data[2]);
                
                if (Database.getPatientByID(pat_id) != null && Database.getDoctorByID(doc_id) != null){
                    if (!Database.isPatientAppointed(pat_id)){
                        
                        Appointment a = new Appointment("" + data[1], pat_id, doc_id);
                        a.setId(Database.getAppointmentList().size() + 1);
                        a.setDatetime(LocalDateTime.now());
                        
                        boolean success = Database.addAppointment(a);
                        
                        if (success){
                            Debug.showMessage("Appointment Added");
                            PopulateTable(appointment_table, Database.getAppointmentList());
                        }
                        else
                        {
                            Debug.showMessage("Error while making appointment");
                        }
                    }
                    else
                    {
                        Debug.showMessage("Patient Already Appointed");
                    }
                }
                else
                {
                    Debug.showMessage("Doctor or Patient does not exist");
                }
            }
            else
            {
                Debug.showMessage("Invalid ID Format");
            }
        }
        else
        {
            Debug.showMessage("Enter All the Data");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Object[] data = GetRowData(billing_table);
        
        if (data[0] != null && data[1] != null && data[2] != null){
            if (Debug.isValidNumber("" + data[0]) && Debug.isValidNumber("" + data[1])){
                int app_id = Integer.parseInt("" + data[1]);
                double amount = Double.parseDouble("" + data[0]);
                
                if (Database.getAppointmentByID(app_id) != null){
                    if (!Database.isAppointmentBilled(app_id)){
                        Billing b = new Billing(amount, app_id, "" + data[2]);
                        b.setDatetime(LocalDateTime.now());
                    
                        Database.addBilling(b);
                        Debug.showMessage("Billing confirmed !");
                        PopulateTable(billing_table, Database.getBillingList());
                    }
                    else
                    {
                        Debug.showMessage("Billing already exist for this appointment");
                    }
                }
                else
                {
                    Debug.showMessage("This Appointment is not made");
                }
            }
            else
            {
                Debug.showMessage("Invalid IDs");
            }
        }
        else
        {
            Debug.showMessage("Data must not be empty");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Database.SaveDataToDatabase();
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Database.LoadDataFromDatabase();
        Database.TestData();
        PopulateTable(patient_table, Database.getPatientList());
    }//GEN-LAST:event_formWindowOpened

    private void patient_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patient_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patient_searchActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel a_text;
    private javax.swing.JTextField appointment_search;
    private javax.swing.JPanel appointment_tab;
    private javax.swing.JTable appointment_table;
    private javax.swing.JPanel appointmentbutton;
    private javax.swing.JLabel b_text;
    private javax.swing.JTextField billing_search;
    private javax.swing.JPanel billing_tab;
    private javax.swing.JTable billing_table;
    private javax.swing.JPanel billingbutton;
    private javax.swing.JLabel d_text;
    private javax.swing.JTextField doctor_search;
    private javax.swing.JPanel doctor_tab;
    private javax.swing.JTable doctor_table;
    private javax.swing.JPanel doctorbutton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane maintab;
    private javax.swing.JLabel p_text;
    private javax.swing.JTextField patient_search;
    private javax.swing.JPanel patient_tab;
    private javax.swing.JTable patient_table;
    private javax.swing.JPanel patientbutton;
    // End of variables declaration//GEN-END:variables

}
