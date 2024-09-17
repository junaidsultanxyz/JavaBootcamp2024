
package Frontend;

import Backend.Attendace.Attendance;
import Backend.Course.Course;
import Backend.Course.Section;
import Backend.Data.Database;
import Backend.Registeration.Request;
import Backend.Setup.Admin;
import Backend.Setup.Debug;
import Backend.Setup.Functions;
import Backend.Setup.Student;
import Backend.Setup.Teacher;
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Junaid
 */
public class MainFrame extends javax.swing.JFrame {
    public MainFrame() {
        Database.TestData();
        initComponents();
    }
    
    public Student student = null;
    public Teacher teacher = null;
    public Admin admin = null;

    public Attendance attendance = null;
    
    //--------------------------------------------------------- LOGIN/REGISTER TABS
    
    public void LoadLoginTab(){
        
    }
    
    public void LoadStudentRegisterTab(){
        
    }
    
    public void LoadTeacherRegisterTab(){
        RegisterTeacherCourse.removeAllItems();
        RegisterTeacherCourse.addItem("Select Course");
        for (Course c : Database.getCourseList()){
            RegisterTeacherCourse.addItem(c.getName());
        }
        RegisterTeacherCourse.setSelectedIndex(0);
    }
    
    //---------------------------------------------------------- STUDENT PORTAL TABS
    
    public void LoadStudentPortalDashboard(){
        StudenetDashboardName.setText(student.getName());
        StudentDashboardID.setText(student.getID());
        
        ReloadStudentDashboardCourseTable();
    }
            
    public void LoadStudentPortalCourseRegister(){
        StudentCourseRegisterCourse.removeAllItems();
        StudentCourseRegisterCourse.addItem("Select Course");
        for (Course c : Database.getAvailableCourses(student)){
            StudentCourseRegisterCourse.addItem(c.getName());
        }
        StudentCourseRegisterCourse.setSelectedIndex(0);
        
        
        ReloadStudentEnrollCourseTable();
        ReloadStudentPendingEnrollmentTable();
    }
            
    public void LoadStudentPortalAttendance(){
        
    } 
            
            
    //---------------------------------------------------------- TEACHER PORTAL TABS
    
    public void LoadTeacherPortalDashboard(){
        TeacherPortalDashboardName.setText(teacher.getName());
        
        ReloadTeacherDashboardCourseTable();
    }
    
    public void LoadTeacherPortalAttendance(){
        TeacherAttendanceCourse.removeAllItems();
        TeacherAttendanceCourse.addItem("Select Course");
        for (Course c : Database.getEnrolledCourses(teacher.getID())){
            TeacherAttendanceCourse.addItem(c.getName());
        }
        TeacherAttendanceCourse.setSelectedIndex(0);
        
        
    }
        
    public void LoadTeacherPortalCourse(){
        TeacherCourseCourse.removeAllItems();
        TeacherCourseCourse.addItem("Select Course");
        for (Course c : Database.getCourseList()){
            TeacherCourseCourse.addItem(c.getName());
        }
        TeacherCourseCourse.setSelectedIndex(0);
        
        ReloadTeacherCourseTable();
    }
            
    
    //---------------------------------------------------------- ADMIN PORTAL TABS
    
    public void LoadAdminPortalDashboard(){
        AdminDashboardTotalCourses.setText("" + Database.getCourseList().size());
        AdminDashboardTotalTeachers.setText("" + Database.getTeacherList().size());
        AdminDashboardTotalStudents.setText("" + Database.getStudentList().size());
        AdminDashboardTotalRequests.setText("" + Database.getAllEnrollmentList().size());
    }
    
    public void LoadAdminPortalRequests(){
        ReloadAdminRequestTable();
    }
    
    public void LoadAdminPortalStudents(){
        ReloadAdminStudentTable();
    }
    
    public void LoadAdminPortalTeachers(){
        ReloadAdminTeacherTable();
    }
    
    public void LoadAdminPortalCourses(){
        ReloadAdminCourseTable();
        
        AdminCourseSelect.removeAllItems();
        AdminCourseSelect.addItem("Select Course");
        for (Course c : Database.getCourseList()){
            AdminCourseSelect.addItem(c.getName());
        }
        AdminCourseSelect.setSelectedIndex(0);
        AdminSectionSelect.setSelectedIndex(0);
        
        AdminNewCourseName.setText("Course Name");
        AdminNewSectionName.setText("Section Name");
        AdminCourseSearch.setText("search course");
    }
    
    //-------------------------------------------------------------------------------------------------------------
    
    //---------------------------------------------------------- ADMIN PORTAL TABLES
    
    public void ReloadAdminRequestTable(){
        DefaultTableModel table = (DefaultTableModel) AdminEnrollmentTable.getModel();

            int elements = AdminEnrollmentTable.getRowCount() - 1;
            for (int x = elements; x >= 0; x--){
                table.removeRow(x);
            }
        
        for (Request r : Database.getPendingEnrollments()){
            String[] data = {r.getStudent().getName(), r.getStudent().getID() , r.getCourse().getName(), r.getSection().getName()};
            table.addRow(data);
        }
    }
    
    public void ReloadAdminStudentTable(){
        DefaultTableModel table = (DefaultTableModel) AdminStudentTable.getModel();

            int elements = AdminStudentTable.getRowCount() - 1;
            for (int x = elements; x >= 0; x--){
                table.removeRow(x);
            }
        
        for (Student s : Database.getStudentList()){
            String[] data = {s.getName(), s.getID(), s.getNumber(), "" + s.getAge(), s.getAccount().getEmail(), s.getAccount().getPassword()};
            table.addRow(data);
        }
    }
    
    public void ReloadAdminTeacherTable(){
        DefaultTableModel table = (DefaultTableModel) AdminTeacherTable.getModel();

            int elements = AdminTeacherTable.getRowCount() - 1;
            for (int x = elements; x >= 0; x--){
                table.removeRow(x);
            }
        
        for (Teacher t : Database.getTeacherList()){
            String[] data = {t.getName(), t.getID(), t.getNumber(), "" + t.getAge(), t.getAccount().getEmail(), t.getAccount().getPassword()};
            table.addRow(data);
        }
    }
    
    public void ReloadAdminCourseTable(){
        DefaultTableModel table = (DefaultTableModel) AdminCourseInfoTable.getModel();

            int elements = AdminCourseInfoTable.getRowCount() - 1;
            for (int x = elements; x >= 0; x--){
                table.removeRow(x);
            }
        
        for (Course c : Database.getCourseList()){
            for (Section s : c.getSectionList()){
                String teacherName = "";
                
                try
                {
                    teacherName += s.getTeacher().getName();
                }
                catch (Exception e){}

                String[] data = {c.getName(), s.getName(), teacherName, "" + s.getStudentList().size()};
                table.addRow(data);
            }
        }
    }
    
    
    public void ReloadAdminCourseTable(Course c){
        DefaultTableModel table = (DefaultTableModel) AdminCourseInfoTable.getModel();

            int elements = AdminCourseInfoTable.getRowCount() - 1;
            for (int x = elements; x >= 0; x--){
                table.removeRow(x);
            }
        
        for (Section s : c.getSectionList()){
                String teacherName = "";
                
                try
                {
                    teacherName += s.getTeacher().getName();
                }
                catch (Exception e){}

                String[] data = {c.getName(), s.getName(), teacherName, "" + s.getStudentList().size()};
                table.addRow(data);
            }
    }
    
    //---------------------------------------------------------- TEACHER PORTAL TABLES
    
    public void ReloadTeacherDashboardCourseTable(){
        DefaultTableModel table = (DefaultTableModel) TeacherCourseTableDashboard.getModel();

            int elements = TeacherCourseTableDashboard.getRowCount() - 1;
            for (int x = elements; x >= 0; x--){
                table.removeRow(x);
            }
        
        for (Course c : Database.getEnrolledCourses(teacher.getID())){
            for (Section s : c.getTeachersSections(teacher.getID())){
                
                String[] data = {c.getName(), s.getName(), "" + s.getStudentList().size()};
                table.addRow(data);
            }
        }
    }
    
    public void ReloadTeacherAttendanceTable(){
        DefaultTableModel table = (DefaultTableModel) TeacherAttendanceTable.getModel();

            int elements = TeacherAttendanceTable.getRowCount() - 1;
            for (int x = elements; x >= 0; x--){
                table.removeRow(x);
            }
        
        for (Student s : Database.getCourseByName(TeacherAttendanceCourse.getSelectedItem().toString()).getSectionByName(TeacherAttendanceSection.getSelectedItem().toString()).getStudentList()){
            
            String[] data = {s.getName(), s.getID(), "absent"};
            table.addRow(data);
        }
    }
    
    public void ReloadTeacherAttendanceTable(String date){
        DefaultTableModel table = (DefaultTableModel) TeacherAttendanceTable.getModel();

            int elements = TeacherAttendanceTable.getRowCount() - 1;
            for (int x = elements; x >= 0; x--){
                table.removeRow(x);
            }
        
        Attendance a = Database.getCourseByName(TeacherAttendanceCourse.getSelectedItem().toString()).getSectionByName(TeacherAttendanceSection.getSelectedItem().toString()).getAttendanceByDate(date);
        for (Student s : Database.getCourseByName(TeacherAttendanceCourse.getSelectedItem().toString()).getSectionByName(TeacherAttendanceSection.getSelectedItem().toString()).getStudentList()){
            String presence;
            
            if (a.isPresent(s)){ presence = "present"; }
            else { presence = "absent"; }
            
            String[] data = {s.getName(), s.getID(), presence};
            table.addRow(data);
        }
    }
    
    public void ReloadTeacherCourseTable(){
        DefaultTableModel table = (DefaultTableModel) TeacherCourseTableCourseTab.getModel();

            int elements = TeacherCourseTableCourseTab.getRowCount() - 1;
            for (int x = elements; x >= 0; x--){
                table.removeRow(x);
            }
        
        for (Course c : Database.getEnrolledCourses(teacher.getID())){
            for (Section s : c.getSectionList()){
                
                String[] data = {c.getName(), s.getName(), "" + s.getStudentList().size()};
                table.addRow(data);
            }
        }
    }
    
    
    //---------------------------------------------------------- STUDENT PORTAL TABLES
    
    public void ReloadStudentDashboardCourseTable(){
        DefaultTableModel table = (DefaultTableModel) StudentDashboardCourseTable.getModel();

            int elements = StudentDashboardCourseTable.getRowCount() - 1;
            for (int x = elements; x >= 0; x--){
                table.removeRow(x);
            }
        
        for (Course c : Database.getEnrolledCourses(student)){
            for (Section s : c.getSectionList()){
                String teacherName = "";
                
                try
                {
                    teacherName += s.getTeacher().getName();
                }
                catch (Exception e){}
                
                String[] data = {c.getName(), s.getName(), teacherName};
                table.addRow(data);
            }
        }
    }
    
    public void ReloadStudentEnrollCourseTable(){
        DefaultTableModel table = (DefaultTableModel) StudentCourseRegisterCourseDetailTable.getModel();

            int elements = StudentCourseRegisterCourseDetailTable.getRowCount() - 1;
            for (int x = elements; x >= 0; x--){
                table.removeRow(x);
            }
        
        for (Course c : Database.getCourseList()){
            for (Section s : c.getSectionList()){
                String teacherName = "";
                
                try
                {
                    teacherName += s.getTeacher().getName();
                }
                catch (Exception e){}
                
                String[] data = {c.getName(), s.getName(), teacherName};
                table.addRow(data);
            }
        }
    }
     
     
    public void ReloadStudentPendingEnrollmentTable(){
        DefaultTableModel table = (DefaultTableModel) StudentCourseRegisterRequestTable.getModel();

            int elements = StudentCourseRegisterRequestTable.getRowCount() - 1;
            for (int x = elements; x >= 0; x--){
                table.removeRow(x);
            }
            
        for (Request r : Database.getPendingEnrollments(student.getID())){
            String[] data = { r.getCourse().getName(), r.getSection().getName(), "" + r.getStatus()};
            table.addRow(data);
        }
    }
    
    
    
    //-------------------------------------------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton8 = new javax.swing.JButton();
        MainTab = new javax.swing.JTabbedPane();
        CredentialsTab = new javax.swing.JTabbedPane();
        Login = new javax.swing.JPanel();
        LoginBack = new javax.swing.JLabel();
        LoginEmail = new javax.swing.JTextField();
        LoginPassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        StudentRegister = new javax.swing.JPanel();
        RegisterStudentName = new javax.swing.JTextField();
        RegisterStudentPassword = new javax.swing.JTextField();
        RegisterStudentNumber = new javax.swing.JTextField();
        RegisterStudentAge = new javax.swing.JTextField();
        registersbutton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        RegisterStudentEmailConfirm = new javax.swing.JTextField();
        RegisterStudentPasswordConfirm = new javax.swing.JTextField();
        RegisterStudentIDConfirm = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        TeacherRegister = new javax.swing.JPanel();
        RegisterTeacherName = new javax.swing.JTextField();
        RegisterTeacherPassword = new javax.swing.JTextField();
        RegisterTeacherAge = new javax.swing.JTextField();
        RegisterTeacherNumber = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        RegisterTeacherEmailConfirm = new javax.swing.JTextField();
        RegisterTeacherPasswordConfirm = new javax.swing.JTextField();
        RegisterTeacherIDConfirm = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        RegisterTeacherCourseConfirm = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        RegisterTeacherCourse = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        PortalTab = new javax.swing.JTabbedPane();
        StudentPortal = new javax.swing.JTabbedPane();
        StudentDashboard = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        StudenetDashboardName = new javax.swing.JTextField();
        StudentDashboardID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        StudentDashboardCourseTable = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        StudentCourseRegister = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        StudentCourseRegisterCourseDetailTable = new javax.swing.JTable();
        StudentCourseRegisterCourse = new javax.swing.JComboBox<>();
        StudentCourseRegisterSection = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        StudentCourseRegisterRequestTable = new javax.swing.JTable();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        StudentAttendance = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton14 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton15 = new javax.swing.JButton();
        TeacherPortal = new javax.swing.JTabbedPane();
        TeacherDashboard = new javax.swing.JPanel();
        jButton16 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TeacherCourseTableDashboard = new javax.swing.JTable();
        TeacherPortalDashboardName = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        TeacherAttendance = new javax.swing.JPanel();
        jButton19 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        TeacherAttendanceTable = new javax.swing.JTable();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        TeacherAttendanceCourse = new javax.swing.JComboBox<>();
        TeacherAttendanceSection = new javax.swing.JComboBox<>();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        TeacherAttendanceDate = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jButton46 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        TeacherCourseDrop = new javax.swing.JPanel();
        jButton24 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        TeacherCourseTableCourseTab = new javax.swing.JTable();
        jButton25 = new javax.swing.JButton();
        TeacherCourseCourse = new javax.swing.JComboBox<>();
        TeacherCourseSection = new javax.swing.JComboBox<>();
        jButton26 = new javax.swing.JButton();
        AdminPortal = new javax.swing.JTabbedPane();
        AdminDashboard = new javax.swing.JPanel();
        jButton28 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        AdminDashboardTotalCourses = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        AdminDashboardTotalStudents = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        AdminDashboardTotalTeachers = new javax.swing.JLabel();
        jButton45 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        AdminDashboardTotalRequests = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        AdminEnrollment = new javax.swing.JPanel();
        jButton32 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        AdminEnrollmentTable = new javax.swing.JTable();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        AdminEnrollmentStudentName = new javax.swing.JTextField();
        AdminEnrollmentStudentID = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        AdminStudentDashboard = new javax.swing.JPanel();
        jButton35 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        AdminStudentTable = new javax.swing.JTable();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        AdminTeacherDashboard = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        AdminTeacherTable = new javax.swing.JTable();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        AdminCourses = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        AdminCourseInfoTable = new javax.swing.JTable();
        AdminCourseSelect = new javax.swing.JComboBox<>();
        AdminSectionSelect = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        AdminNewCourseName = new javax.swing.JTextField();
        AdminNewSectionName = new javax.swing.JTextField();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        AdminCourseSearch = new javax.swing.JTextField();

        jButton8.setText("jButton8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(840, 537));
        setMinimumSize(new java.awt.Dimension(840, 537));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MainTab.setMaximumSize(new java.awt.Dimension(840, 650));
        MainTab.setMinimumSize(new java.awt.Dimension(840, 650));
        MainTab.setPreferredSize(new java.awt.Dimension(840, 650));

        Login.setBackground(new java.awt.Color(255, 255, 255));

        LoginBack.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        LoginBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LoginBack.setText("GRAPHICS");
        LoginBack.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        LoginEmail.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        LoginEmail.setText("Email");

        LoginPassword.setText("jPasswordField1");

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setText("Login");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 153, 255));
        jButton2.setText("Student Register");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 153, 255));
        jButton3.setText("Teacher Register");
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LoginLayout = new javax.swing.GroupLayout(Login);
        Login.setLayout(LoginLayout);
        LoginLayout.setHorizontalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginLayout.createSequentialGroup()
                .addComponent(LoginBack, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LoginEmail)
                    .addComponent(LoginPassword)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62))
        );
        LoginLayout.setVerticalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LoginBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(LoginLayout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(LoginEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LoginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(107, 107, 107))
        );

        CredentialsTab.addTab("tab1", Login);

        StudentRegister.setBackground(new java.awt.Color(255, 255, 255));

        RegisterStudentName.setText("Name");

        RegisterStudentPassword.setText("New Password");

        RegisterStudentNumber.setText("Number");

        RegisterStudentAge.setText("Age");

        registersbutton.setBackground(new java.awt.Color(51, 153, 255));
        registersbutton.setText("Register");
        registersbutton.setFocusable(false);
        registersbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registersbuttonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GRAPHICS");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Email");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Password");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Student ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RegisterStudentEmailConfirm)
                    .addComponent(RegisterStudentPasswordConfirm)
                    .addComponent(RegisterStudentIDConfirm))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RegisterStudentEmailConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RegisterStudentPasswordConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(RegisterStudentIDConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton5.setBackground(new java.awt.Color(255, 102, 102));
        jButton5.setText("back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Registered Info");

        javax.swing.GroupLayout StudentRegisterLayout = new javax.swing.GroupLayout(StudentRegister);
        StudentRegister.setLayout(StudentRegisterLayout);
        StudentRegisterLayout.setHorizontalGroup(
            StudentRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(StudentRegisterLayout.createSequentialGroup()
                .addGroup(StudentRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StudentRegisterLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(StudentRegisterLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(StudentRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(StudentRegisterLayout.createSequentialGroup()
                                .addComponent(RegisterStudentAge, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(RegisterStudentNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                            .addComponent(RegisterStudentName)
                            .addComponent(RegisterStudentPassword)
                            .addComponent(registersbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(66, 66, 66)
                        .addGroup(StudentRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        StudentRegisterLayout.setVerticalGroup(
            StudentRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StudentRegisterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(StudentRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(StudentRegisterLayout.createSequentialGroup()
                        .addComponent(RegisterStudentName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RegisterStudentPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(StudentRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RegisterStudentNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RegisterStudentAge, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(registersbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(98, 98, 98)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
        );

        CredentialsTab.addTab("tab2", StudentRegister);

        TeacherRegister.setBackground(new java.awt.Color(255, 255, 255));

        RegisterTeacherName.setText("Name");

        RegisterTeacherPassword.setText("New Password");

        RegisterTeacherAge.setText("Age");

        RegisterTeacherNumber.setText("Number");

        jButton6.setBackground(new java.awt.Color(51, 153, 255));
        jButton6.setText("Register");
        jButton6.setFocusable(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Email");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Password");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Teacher ID");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Course/Section");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RegisterTeacherEmailConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(RegisterTeacherPasswordConfirm)
                    .addComponent(RegisterTeacherIDConfirm)
                    .addComponent(RegisterTeacherCourseConfirm))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RegisterTeacherEmailConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RegisterTeacherPasswordConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RegisterTeacherIDConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(RegisterTeacherCourseConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );

        jLabel9.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Registered Info");

        jButton7.setBackground(new java.awt.Color(255, 102, 102));
        jButton7.setText("back");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        RegisterTeacherCourse.setBackground(new java.awt.Color(153, 255, 255));
        RegisterTeacherCourse.setForeground(new java.awt.Color(0, 0, 0));
        RegisterTeacherCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Course" }));

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("GRAPHICS");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout TeacherRegisterLayout = new javax.swing.GroupLayout(TeacherRegister);
        TeacherRegister.setLayout(TeacherRegisterLayout);
        TeacherRegisterLayout.setHorizontalGroup(
            TeacherRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TeacherRegisterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TeacherRegisterLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(TeacherRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(TeacherRegisterLayout.createSequentialGroup()
                        .addComponent(RegisterTeacherAge, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RegisterTeacherNumber))
                    .addComponent(RegisterTeacherName)
                    .addComponent(RegisterTeacherPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                    .addComponent(RegisterTeacherCourse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(TeacherRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        TeacherRegisterLayout.setVerticalGroup(
            TeacherRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TeacherRegisterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TeacherRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(TeacherRegisterLayout.createSequentialGroup()
                        .addComponent(RegisterTeacherName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RegisterTeacherPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(TeacherRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RegisterTeacherNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RegisterTeacherAge, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(RegisterTeacherCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        CredentialsTab.addTab("tab3", TeacherRegister);

        MainTab.addTab("tab1", CredentialsTab);

        StudentPortal.setBackground(new java.awt.Color(102, 0, 102));

        StudentDashboard.setBackground(new java.awt.Color(255, 255, 255));
        StudentDashboard.setForeground(new java.awt.Color(0, 0, 0));

        jButton9.setBackground(new java.awt.Color(255, 102, 102));
        jButton9.setText("Logout");
        jButton9.setFocusable(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        StudenetDashboardName.setEditable(false);

        StudentDashboardID.setEditable(false);

        StudentDashboardCourseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course", "Section", "Teacher"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(StudentDashboardCourseTable);

        jButton10.setBackground(new java.awt.Color(102, 204, 255));
        jButton10.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(0, 0, 0));
        jButton10.setText("Register New Course");
        jButton10.setFocusable(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(255, 204, 255));
        jButton11.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(0, 0, 0));
        jButton11.setText("View Attendance");
        jButton11.setFocusable(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Student Name");

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Student ID");

        javax.swing.GroupLayout StudentDashboardLayout = new javax.swing.GroupLayout(StudentDashboard);
        StudentDashboard.setLayout(StudentDashboardLayout);
        StudentDashboardLayout.setHorizontalGroup(
            StudentDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StudentDashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(StudentDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(StudentDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StudentDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, StudentDashboardLayout.createSequentialGroup()
                            .addComponent(StudentDashboardID, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel13))
                        .addComponent(StudenetDashboardName)
                        .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        StudentDashboardLayout.setVerticalGroup(
            StudentDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StudentDashboardLayout.createSequentialGroup()
                .addGroup(StudentDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StudentDashboardLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StudentDashboardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12)
                        .addGap(10, 10, 10)))
                .addGroup(StudentDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(StudentDashboardLayout.createSequentialGroup()
                        .addComponent(StudenetDashboardName, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(StudentDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(StudentDashboardID, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(117, 117, 117)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        StudentPortal.addTab("Dashboard", StudentDashboard);

        StudentCourseRegister.setBackground(new java.awt.Color(255, 255, 255));

        StudentCourseRegisterCourseDetailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course", "Section", "Teacher"
            }
        ));
        jScrollPane2.setViewportView(StudentCourseRegisterCourseDetailTable);

        StudentCourseRegisterCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Course" }));

        StudentCourseRegisterSection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Section" }));
        StudentCourseRegisterSection.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                StudentCourseRegisterSectionPopupMenuWillBecomeVisible(evt);
            }
        });

        StudentCourseRegisterRequestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course", "Section", "Status"
            }
        ));
        jScrollPane3.setViewportView(StudentCourseRegisterRequestTable);

        jButton12.setBackground(new java.awt.Color(102, 204, 255));
        jButton12.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton12.setForeground(new java.awt.Color(0, 0, 0));
        jButton12.setText("Request Enrollment");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(255, 102, 102));
        jButton13.setText("back");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout StudentCourseRegisterLayout = new javax.swing.GroupLayout(StudentCourseRegister);
        StudentCourseRegister.setLayout(StudentCourseRegisterLayout);
        StudentCourseRegisterLayout.setHorizontalGroup(
            StudentCourseRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StudentCourseRegisterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(StudentCourseRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StudentCourseRegisterLayout.createSequentialGroup()
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(StudentCourseRegisterLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(StudentCourseRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(StudentCourseRegisterLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StudentCourseRegisterLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                                .addGroup(StudentCourseRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(StudentCourseRegisterCourse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(StudentCourseRegisterSection, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(61, 61, 61))))))
        );
        StudentCourseRegisterLayout.setVerticalGroup(
            StudentCourseRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StudentCourseRegisterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(StudentCourseRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StudentCourseRegisterLayout.createSequentialGroup()
                        .addComponent(StudentCourseRegisterCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(StudentCourseRegisterSection, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        StudentPortal.addTab("Enrollment", StudentCourseRegister);

        StudentAttendance.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course", "Section", "Date", "Attendance"
            }
        ));
        jScrollPane4.setViewportView(jTable1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Course" }));

        jButton14.setBackground(new java.awt.Color(255, 102, 102));
        jButton14.setText("back");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Section" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Date" }));

        jButton15.setBackground(new java.awt.Color(102, 204, 255));
        jButton15.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton15.setForeground(new java.awt.Color(0, 0, 0));
        jButton15.setText("View Attendance");

        javax.swing.GroupLayout StudentAttendanceLayout = new javax.swing.GroupLayout(StudentAttendance);
        StudentAttendance.setLayout(StudentAttendanceLayout);
        StudentAttendanceLayout.setHorizontalGroup(
            StudentAttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StudentAttendanceLayout.createSequentialGroup()
                .addGroup(StudentAttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StudentAttendanceLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(StudentAttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, 0, 310, Short.MAX_VALUE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(StudentAttendanceLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        StudentAttendanceLayout.setVerticalGroup(
            StudentAttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StudentAttendanceLayout.createSequentialGroup()
                .addGroup(StudentAttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StudentAttendanceLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(StudentAttendanceLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        StudentPortal.addTab("Attendance", StudentAttendance);

        PortalTab.addTab("tab1", StudentPortal);

        TeacherDashboard.setBackground(new java.awt.Color(255, 255, 255));

        jButton16.setBackground(new java.awt.Color(255, 102, 102));
        jButton16.setText("Logout");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        TeacherCourseTableDashboard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course", "Section", "Students"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(TeacherCourseTableDashboard);

        TeacherPortalDashboardName.setEditable(false);

        jButton17.setBackground(new java.awt.Color(153, 204, 255));
        jButton17.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton17.setForeground(new java.awt.Color(0, 0, 0));
        jButton17.setText("Course Details");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setBackground(new java.awt.Color(51, 153, 255));
        jButton18.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton18.setText("Attendance");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Teacher Name");

        javax.swing.GroupLayout TeacherDashboardLayout = new javax.swing.GroupLayout(TeacherDashboard);
        TeacherDashboard.setLayout(TeacherDashboardLayout);
        TeacherDashboardLayout.setHorizontalGroup(
            TeacherDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TeacherDashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TeacherDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TeacherDashboardLayout.createSequentialGroup()
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TeacherDashboardLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addGroup(TeacherDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TeacherDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                                .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TeacherPortalDashboardName))
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46))))
        );
        TeacherDashboardLayout.setVerticalGroup(
            TeacherDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TeacherDashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(TeacherDashboardLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel14)
                .addGap(1, 1, 1)
                .addComponent(TeacherPortalDashboardName, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TeacherPortal.addTab("Dashboard", TeacherDashboard);

        TeacherAttendance.setBackground(new java.awt.Color(255, 255, 255));

        jButton19.setBackground(new java.awt.Color(255, 102, 102));
        jButton19.setText("back");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        TeacherAttendanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "ID", "Attendance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(TeacherAttendanceTable);
        if (TeacherAttendanceTable.getColumnModel().getColumnCount() > 0) {
            TeacherAttendanceTable.getColumnModel().getColumn(2).setMinWidth(100);
            TeacherAttendanceTable.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        jButton20.setBackground(new java.awt.Color(102, 255, 102));
        jButton20.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton20.setForeground(new java.awt.Color(0, 0, 0));
        jButton20.setText("Present");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setBackground(new java.awt.Color(255, 102, 102));
        jButton21.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton21.setForeground(new java.awt.Color(0, 0, 0));
        jButton21.setText("Absent");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        TeacherAttendanceCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Course" }));

        TeacherAttendanceSection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Section" }));
        TeacherAttendanceSection.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                TeacherAttendanceSectionPopupMenuWillBecomeVisible(evt);
            }
        });

        jButton22.setBackground(new java.awt.Color(204, 204, 255));
        jButton22.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton22.setForeground(new java.awt.Color(0, 0, 0));
        jButton22.setText("Create");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setBackground(new java.awt.Color(153, 255, 153));
        jButton23.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton23.setForeground(new java.awt.Color(0, 0, 0));
        jButton23.setText("Confirm");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        TeacherAttendanceDate.setEditable(false);

        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Date");

        jButton46.setText("next");
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton46ActionPerformed(evt);
            }
        });

        jButton47.setText("previous");
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TeacherAttendanceLayout = new javax.swing.GroupLayout(TeacherAttendance);
        TeacherAttendance.setLayout(TeacherAttendanceLayout);
        TeacherAttendanceLayout.setHorizontalGroup(
            TeacherAttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TeacherAttendanceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TeacherAttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(TeacherAttendanceLayout.createSequentialGroup()
                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton47, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton46, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TeacherAttendanceLayout.createSequentialGroup()
                        .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TeacherAttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TeacherAttendanceSection, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TeacherAttendanceDate)
                    .addComponent(TeacherAttendanceCourse, 0, 343, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        TeacherAttendanceLayout.setVerticalGroup(
            TeacherAttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TeacherAttendanceLayout.createSequentialGroup()
                .addGroup(TeacherAttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TeacherAttendanceLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TeacherAttendanceLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(TeacherAttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton46)
                            .addComponent(jButton47))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(TeacherAttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TeacherAttendanceLayout.createSequentialGroup()
                        .addComponent(TeacherAttendanceCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TeacherAttendanceSection, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TeacherAttendanceDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))
                    .addGroup(TeacherAttendanceLayout.createSequentialGroup()
                        .addGroup(TeacherAttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(TeacherAttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        TeacherPortal.addTab("Attendance", TeacherAttendance);

        TeacherCourseDrop.setBackground(new java.awt.Color(255, 255, 255));

        jButton24.setBackground(new java.awt.Color(255, 102, 102));
        jButton24.setText("back");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        TeacherCourseTableCourseTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course", "Section", "Students"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(TeacherCourseTableCourseTab);

        jButton25.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton25.setForeground(new java.awt.Color(255, 51, 51));
        jButton25.setText("Drop");
        jButton25.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 51, 51), 3, true));
        jButton25.setContentAreaFilled(false);
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        TeacherCourseCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Course" }));

        TeacherCourseSection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Section" }));
        TeacherCourseSection.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                TeacherCourseSectionPopupMenuWillBecomeVisible(evt);
            }
        });

        jButton26.setBackground(new java.awt.Color(102, 153, 255));
        jButton26.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton26.setForeground(new java.awt.Color(0, 0, 0));
        jButton26.setText("Add");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TeacherCourseDropLayout = new javax.swing.GroupLayout(TeacherCourseDrop);
        TeacherCourseDrop.setLayout(TeacherCourseDropLayout);
        TeacherCourseDropLayout.setHorizontalGroup(
            TeacherCourseDropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TeacherCourseDropLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TeacherCourseDropLayout.createSequentialGroup()
                .addGroup(TeacherCourseDropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(TeacherCourseDropLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TeacherCourseDropLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(TeacherCourseDropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TeacherCourseCourse, 0, 345, Short.MAX_VALUE)
                            .addComponent(TeacherCourseSection, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        TeacherCourseDropLayout.setVerticalGroup(
            TeacherCourseDropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TeacherCourseDropLayout.createSequentialGroup()
                .addGroup(TeacherCourseDropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TeacherCourseDropLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TeacherCourseDropLayout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(TeacherCourseCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TeacherCourseSection, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        TeacherPortal.addTab("Course", TeacherCourseDrop);

        PortalTab.addTab("tab2", TeacherPortal);

        AdminPortal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdminPortalMouseClicked(evt);
            }
        });

        AdminDashboard.setBackground(new java.awt.Color(255, 255, 255));

        jButton28.setBackground(new java.awt.Color(255, 102, 102));
        jButton28.setText("logout");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        AdminDashboardTotalCourses.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        AdminDashboardTotalCourses.setForeground(new java.awt.Color(0, 51, 153));
        AdminDashboardTotalCourses.setText("19");

        jLabel17.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("TOTAL COURSES");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AdminDashboardTotalCourses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AdminDashboardTotalCourses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        AdminDashboardTotalStudents.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        AdminDashboardTotalStudents.setForeground(new java.awt.Color(0, 51, 153));
        AdminDashboardTotalStudents.setText("19");

        jLabel19.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("TOTAL STUDENTS");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AdminDashboardTotalStudents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AdminDashboardTotalStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton29.setBackground(new java.awt.Color(204, 0, 255));
        jButton29.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton29.setForeground(new java.awt.Color(255, 255, 255));
        jButton29.setText("Manage Courses");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jButton30.setBackground(new java.awt.Color(153, 255, 204));
        jButton30.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton30.setForeground(new java.awt.Color(0, 0, 0));
        jButton30.setText("Manage Students");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jButton31.setBackground(new java.awt.Color(255, 153, 102));
        jButton31.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton31.setForeground(new java.awt.Color(0, 0, 0));
        jButton31.setText("Manage Teachers");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel20.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("TOTAL TEACHERS");

        AdminDashboardTotalTeachers.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        AdminDashboardTotalTeachers.setForeground(new java.awt.Color(0, 51, 153));
        AdminDashboardTotalTeachers.setText("19");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                    .addComponent(AdminDashboardTotalTeachers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AdminDashboardTotalTeachers, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton45.setBackground(new java.awt.Color(153, 153, 255));
        jButton45.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton45.setForeground(new java.awt.Color(0, 0, 0));
        jButton45.setText("Enrollment Requests");
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));

        AdminDashboardTotalRequests.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        AdminDashboardTotalRequests.setForeground(new java.awt.Color(0, 51, 153));
        AdminDashboardTotalRequests.setText("19");

        jLabel25.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("PENDING REQUESTS");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AdminDashboardTotalRequests, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(AdminDashboardTotalRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel23.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("GRAPHICS");
        jLabel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout AdminDashboardLayout = new javax.swing.GroupLayout(AdminDashboard);
        AdminDashboard.setLayout(AdminDashboardLayout);
        AdminDashboardLayout.setHorizontalGroup(
            AdminDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminDashboardLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(AdminDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                    .addComponent(jButton31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                    .addComponent(jButton45, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdminDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(AdminDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AdminDashboardLayout.createSequentialGroup()
                        .addGroup(AdminDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton28, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        AdminDashboardLayout.setVerticalGroup(
            AdminDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdminDashboardLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(AdminDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AdminDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AdminDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(AdminDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(AdminDashboardLayout.createSequentialGroup()
                        .addComponent(jButton45, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        AdminPortal.addTab("Dashboard", AdminDashboard);

        AdminEnrollment.setBackground(new java.awt.Color(255, 255, 255));

        jButton32.setBackground(new java.awt.Color(255, 102, 102));
        jButton32.setText("back");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        AdminEnrollmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Name", "ID", "Course", "Section"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(AdminEnrollmentTable);

        jButton33.setBackground(new java.awt.Color(102, 255, 102));
        jButton33.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton33.setForeground(new java.awt.Color(0, 0, 0));
        jButton33.setText("Accept");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        jButton34.setBackground(new java.awt.Color(255, 51, 51));
        jButton34.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton34.setText("Decline");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Student Name");

        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Student ID");

        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Course");

        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Section");

        javax.swing.GroupLayout AdminEnrollmentLayout = new javax.swing.GroupLayout(AdminEnrollment);
        AdminEnrollment.setLayout(AdminEnrollmentLayout);
        AdminEnrollmentLayout.setHorizontalGroup(
            AdminEnrollmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminEnrollmentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AdminEnrollmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AdminEnrollmentLayout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AdminEnrollmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AdminEnrollmentStudentName)
                            .addGroup(AdminEnrollmentLayout.createSequentialGroup()
                                .addGroup(AdminEnrollmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(AdminEnrollmentLayout.createSequentialGroup()
                                .addGroup(AdminEnrollmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(AdminEnrollmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(AdminEnrollmentStudentID)
                            .addGroup(AdminEnrollmentLayout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(182, 182, 182)))))
                .addGap(12, 12, 12))
        );
        AdminEnrollmentLayout.setVerticalGroup(
            AdminEnrollmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdminEnrollmentLayout.createSequentialGroup()
                .addGroup(AdminEnrollmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AdminEnrollmentLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AdminEnrollmentLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AdminEnrollmentStudentName, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18)
                        .addGap(4, 4, 4)
                        .addComponent(AdminEnrollmentStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(AdminEnrollmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))
                        .addGap(4, 4, 4)
                        .addGroup(AdminEnrollmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(156, 156, 156)
                        .addGroup(AdminEnrollmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton33, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(jButton34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        AdminPortal.addTab("Enrollment", AdminEnrollment);

        AdminStudentDashboard.setBackground(new java.awt.Color(255, 255, 255));

        jButton35.setBackground(new java.awt.Color(255, 102, 102));
        jButton35.setText("back");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        AdminStudentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "ID", "Number", "Age", "Email", "Password"
            }
        ));
        jScrollPane9.setViewportView(AdminStudentTable);

        jButton36.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton36.setForeground(new java.awt.Color(255, 0, 0));
        jButton36.setText("Remove");
        jButton36.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 3, true));
        jButton36.setContentAreaFilled(false);
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        jButton37.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton37.setForeground(new java.awt.Color(102, 102, 255));
        jButton37.setText("Reset");
        jButton37.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 3, true));
        jButton37.setContentAreaFilled(false);
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AdminStudentDashboardLayout = new javax.swing.GroupLayout(AdminStudentDashboard);
        AdminStudentDashboard.setLayout(AdminStudentDashboardLayout);
        AdminStudentDashboardLayout.setHorizontalGroup(
            AdminStudentDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdminStudentDashboardLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(AdminStudentDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(AdminStudentDashboardLayout.createSequentialGroup()
                        .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
        AdminStudentDashboardLayout.setVerticalGroup(
            AdminStudentDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminStudentDashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AdminStudentDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AdminStudentDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        AdminPortal.addTab("Students", AdminStudentDashboard);

        AdminTeacherDashboard.setBackground(new java.awt.Color(255, 255, 255));

        AdminTeacherTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "ID", "Number", "Age", "Email", "Password"
            }
        ));
        jScrollPane10.setViewportView(AdminTeacherTable);

        jButton38.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton38.setForeground(new java.awt.Color(102, 102, 255));
        jButton38.setText("Reset");
        jButton38.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 3, true));
        jButton38.setContentAreaFilled(false);
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        jButton39.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton39.setForeground(new java.awt.Color(255, 0, 0));
        jButton39.setText("Remove");
        jButton39.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 3, true));
        jButton39.setContentAreaFilled(false);
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        jButton40.setBackground(new java.awt.Color(255, 51, 51));
        jButton40.setText("back");
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AdminTeacherDashboardLayout = new javax.swing.GroupLayout(AdminTeacherDashboard);
        AdminTeacherDashboard.setLayout(AdminTeacherDashboardLayout);
        AdminTeacherDashboardLayout.setHorizontalGroup(
            AdminTeacherDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminTeacherDashboardLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(AdminTeacherDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AdminTeacherDashboardLayout.createSequentialGroup()
                        .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(376, 376, 376)
                        .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        AdminTeacherDashboardLayout.setVerticalGroup(
            AdminTeacherDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminTeacherDashboardLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AdminTeacherDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AdminTeacherDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        AdminPortal.addTab("Teachers", AdminTeacherDashboard);

        AdminCourses.setBackground(new java.awt.Color(255, 255, 255));

        AdminCourseInfoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course", "Sections", "Teacher", "Students"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane11.setViewportView(AdminCourseInfoTable);

        AdminCourseSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Course" }));
        AdminCourseSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminCourseSelectActionPerformed(evt);
            }
        });

        AdminSectionSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Section" }));
        AdminSectionSelect.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                AdminSectionSelectPopupMenuWillBecomeVisible(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 51, 51));
        jButton4.setText("Delete Section");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton27.setForeground(new java.awt.Color(255, 0, 0));
        jButton27.setText("Delete Course");
        jButton27.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true));
        jButton27.setContentAreaFilled(false);
        jButton27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        AdminNewCourseName.setText("Course Name");

        AdminNewSectionName.setText("Section Name");

        jButton41.setBackground(new java.awt.Color(102, 255, 102));
        jButton41.setForeground(new java.awt.Color(0, 0, 0));
        jButton41.setText("Add Section");
        jButton41.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        jButton42.setBackground(new java.awt.Color(51, 255, 51));
        jButton42.setForeground(new java.awt.Color(0, 255, 0));
        jButton42.setText("Add Course");
        jButton42.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 0), 2, true));
        jButton42.setContentAreaFilled(false);
        jButton42.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        jButton43.setBackground(new java.awt.Color(255, 102, 102));
        jButton43.setText("back");
        jButton43.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });

        jButton44.setBackground(new java.awt.Color(0, 102, 102));
        jButton44.setForeground(new java.awt.Color(255, 255, 255));
        jButton44.setText("search");
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });

        AdminCourseSearch.setText("search course");

        javax.swing.GroupLayout AdminCoursesLayout = new javax.swing.GroupLayout(AdminCourses);
        AdminCourses.setLayout(AdminCoursesLayout);
        AdminCoursesLayout.setHorizontalGroup(
            AdminCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdminCoursesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AdminCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(AdminCoursesLayout.createSequentialGroup()
                        .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AdminCourseSearch))
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(AdminCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AdminCoursesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AdminCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AdminCourseSelect, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AdminSectionSelect, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AdminNewCourseName)
                            .addComponent(AdminNewSectionName)
                            .addGroup(AdminCoursesLayout.createSequentialGroup()
                                .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(AdminCoursesLayout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdminCoursesLayout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        AdminCoursesLayout.setVerticalGroup(
            AdminCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminCoursesLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(AdminCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AdminCoursesLayout.createSequentialGroup()
                        .addComponent(AdminCourseSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AdminSectionSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AdminCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AdminNewCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AdminNewSectionName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AdminCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)))
                .addGroup(AdminCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AdminCoursesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AdminCoursesLayout.createSequentialGroup()
                        .addGroup(AdminCoursesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton44)
                            .addComponent(AdminCourseSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        AdminPortal.addTab("Courses", AdminCourses);

        PortalTab.addTab("tab3", AdminPortal);

        MainTab.addTab("tab2", PortalTab);

        getContentPane().add(MainTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -63, -1, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CredentialsTab.setSelectedIndex(1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        LoadTeacherRegisterTab();
        
        CredentialsTab.setSelectedIndex(2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
         CredentialsTab.setSelectedIndex(0);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        CredentialsTab.setSelectedIndex(0);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        LoadLoginTab();
        
        MainTab.setSelectedIndex(0);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        LoadStudentPortalCourseRegister();
        
        StudentPortal.setSelectedIndex(1);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        LoadStudentPortalAttendance();
        
        StudentPortal.setSelectedIndex(2);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        LoadStudentPortalDashboard();
        
        StudentPortal.setSelectedIndex(0);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        LoadStudentPortalDashboard();
        
        StudentPortal.setSelectedIndex(0);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!LoginEmail.getText().isBlank() && !LoginPassword.getText().isBlank()){
            int main_index = 0, portal_index = 0;
            
            String email = LoginEmail.getText();
            String password = LoginPassword.getText();
            
            String accType = Database.loginCheck(email, password);
            
            if (accType.equalsIgnoreCase("student")){
                main_index = 1;
                portal_index = 0;
                
                student = Database.studentLogin(email, password);
                
                LoadStudentPortalDashboard();
            }
            if (accType.equalsIgnoreCase("teacher")){
                main_index = 1;
                portal_index = 1;
                
                teacher = Database.loginTeacher(email, password);
                
                LoadTeacherPortalDashboard();
            }
            if (accType.equalsIgnoreCase("admin")){
                main_index = 1;
                portal_index = 2;
                
                Debug.showMessage("logged in as ADMIN");
                
                LoadAdminPortalDashboard();
            }
            
            PortalTab.setSelectedIndex(portal_index);
            MainTab.setSelectedIndex(main_index);
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        LoadTeacherPortalAttendance();
        
        TeacherPortal.setSelectedIndex(1);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        LoadTeacherPortalCourse();
        
        TeacherPortal.setSelectedIndex(2);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        LoadTeacherPortalDashboard();
        
        TeacherPortal.setSelectedIndex(0);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        LoadTeacherPortalDashboard();
        
        TeacherPortal.setSelectedIndex(0);
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        LoadAdminPortalCourses();
        
        AdminPortal.setSelectedIndex(4);
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        LoadAdminPortalStudents();
        
        AdminPortal.setSelectedIndex(2);
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        LoadAdminPortalTeachers();
        
        AdminPortal.setSelectedIndex(3);
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        LoadLoginTab();
        
        MainTab.setSelectedIndex(0);
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        AdminPortal.setSelectedIndex(0);
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        AdminPortal.setSelectedIndex(0);
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        AdminPortal.setSelectedIndex(0);
    }//GEN-LAST:event_jButton40ActionPerformed

    private void registersbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registersbuttonActionPerformed
        if (Functions.IntegerVerify(RegisterStudentAge.getText()) && 
            !RegisterStudentName.getText().isBlank() && !RegisterStudentPassword.getText().isBlank() &&
            !RegisterStudentNumber.getText().isBlank())
        {
            
            String name = RegisterStudentName.getText();
            String password = RegisterStudentPassword.getText();
            int age = Integer.parseInt(RegisterStudentAge.getText());
            String number = RegisterStudentNumber.getText();
            
            Student s = new Student(name, number, age, password);
            Database.RegisterStudent(s);
            
            RegisterStudentEmailConfirm.setText(s.getAccount().getEmail());
            RegisterStudentPasswordConfirm.setText(password);
            RegisterStudentIDConfirm.setText(s.getID());
            
            Debug.showMessage(s.getAccount().getAccountType());
        }
        else{
            Debug.showMessage("Enter valid info");
        }
    }//GEN-LAST:event_registersbuttonActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (!RegisterTeacherName.getText().isBlank() && !RegisterTeacherPassword.getText().isBlank() && 
            Functions.IntegerVerify(RegisterTeacherAge.getText()) && !RegisterTeacherNumber.getText().isBlank() &&
            (RegisterTeacherCourse.getSelectedIndex() != 0) )
        {
            String name = RegisterTeacherName.getText();
            String password = RegisterTeacherPassword.getText();
            String number = RegisterTeacherNumber.getText();
            int age = Integer.parseInt(RegisterTeacherAge.getText());
            Course c = Database.getCourseByName(RegisterTeacherCourse.getSelectedItem().toString());
            
            Teacher t = new Teacher(name, number, age, password);
            
            Database.RegisterTeacher(t, RegisterTeacherCourse.getSelectedItem().toString());
            
            RegisterTeacherEmailConfirm.setText(t.getAccount().getEmail());
            RegisterTeacherPasswordConfirm.setText(password);
            RegisterTeacherIDConfirm.setText(t.getID());
            RegisterTeacherCourseConfirm.setText(c.getName() + " | " + c.getTeachersSection(t).getName());
            
        }
        else
        { Debug.showMessage("Enter valid info"); }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        if (!AdminNewCourseName.getText().isBlank() && !AdminNewSectionName.getText().isBlank() && !AdminNewSectionName.getText().equalsIgnoreCase("section name")){
            
            String courseName = AdminNewCourseName.getText();
            String sectionName = AdminNewSectionName.getText();
            
            if (Database.getCourseByName(courseName) != null){
                Database.getCourseByName(courseName).addSection(new Section(sectionName));
                
                Debug.showMessage("Section added in " + courseName);
            }
            else{
                Debug.showMessage("course not found");
            }
        }
        else
        {
            Debug.showMessage("invalid info");
        }
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        if (!AdminNewCourseName.getText().isBlank()){
            
            String courseName = AdminNewCourseName.getText();
            String sectionName = AdminNewSectionName.getText();
            
            Course c = null;
            
            if (Database.getCourseByName(courseName) == null && !courseName.equalsIgnoreCase("course name")){
                c = new Course(courseName);
                
                if (!sectionName.isBlank() && !sectionName.equalsIgnoreCase("section name")){
                    c.addSection(new Section(sectionName));
                    Database.addCourse(c);
                    
                    Debug.showMessage(courseName + " added with section " + sectionName);
                }
                else
                {
                    Database.addCourse(c);
                    Debug.showMessage(courseName + " added in course list");
                }
            }
            else{
                Debug.showMessage("course not found");
            }
        }
        else
        {
            Debug.showMessage("invalid info");
        }
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        AdminPortal.setSelectedIndex(0);
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        Database.removeCourse(AdminCourseSelect.getSelectedItem().toString());
    }//GEN-LAST:event_jButton27ActionPerformed

    private void AdminCourseSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminCourseSelectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdminCourseSelectActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Database.getCourseByName(AdminCourseSelect.getSelectedItem().toString()).removeSection(AdminSectionSelect.getSelectedItem().toString());
                
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
        LoadAdminPortalRequests();
        
        AdminPortal.setSelectedIndex(1);
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if (StudentCourseRegisterCourse.getSelectedIndex() != 0 && StudentCourseRegisterSection.getSelectedIndex() != 0)
        {
            String courseName = StudentCourseRegisterCourse.getSelectedItem().toString();
            String sectionName = StudentCourseRegisterSection.getSelectedItem().toString();
            
            Request r = new Request(student, Database.getCourseByName(courseName), Database.getCourseByName(courseName).getSectionByName(sectionName));
            Database.AddRequest(r);
            
            ReloadStudentPendingEnrollmentTable();
       }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        LoadLoginTab();
        
        MainTab.setSelectedIndex(0);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        
        
        if ( (TeacherAttendanceCourse.getSelectedIndex() != 0) || (TeacherAttendanceSection.getSelectedIndex() != 0) )
        {   
            
            if (Database.getCourseByName(TeacherAttendanceCourse.getSelectedItem().toString()).getSectionByName(TeacherAttendanceSection.getSelectedItem().toString()).getAttendanceByDate("" + java.time.LocalDate.now()) == null){
                attendance = new Attendance();
                TeacherAttendanceDate.setText(attendance.getDate());

                ReloadTeacherAttendanceTable();
            }
        }
        else
        {
            Debug.showMessage("Select course and section first");
        }
        
        
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        int index = TeacherAttendanceTable.getSelectedRow();
        
        if (index != -1){
            attendance.markPresent(Database.getCourseByName(TeacherAttendanceCourse.getSelectedItem().toString()).getSectionByName(TeacherAttendanceSection.getSelectedItem().toString()).getStudentList().get(index));
        }   
        
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        int index = TeacherAttendanceTable.getSelectedRow();
        DefaultTableModel table = (DefaultTableModel) TeacherCourseTableDashboard.getModel();
        
        if (index != -1){
            attendance.markAbsent((String) table.getValueAt(index, 1));
        }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        String courseName = TeacherAttendanceCourse.getSelectedItem().toString();
        String sectionName = TeacherAttendanceSection.getSelectedItem().toString();
        
        if (TeacherAttendanceCourse.getSelectedIndex() != 0 && TeacherAttendanceSection.getSelectedIndex() != 0)
        {
            Database.getCourseByName(courseName).getSectionByName(sectionName).saveAttendance(attendance);
            attendance = null;
            Debug.showMessage("Attendance saved");
        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void TeacherAttendanceSectionPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_TeacherAttendanceSectionPopupMenuWillBecomeVisible
        TeacherAttendanceSection.removeAllItems();
        TeacherAttendanceSection.addItem("Select Section");
        
        if (TeacherAttendanceCourse.getSelectedIndex() != 0){
            for (Section s : Database.getCourseByName(TeacherAttendanceCourse.getSelectedItem().toString()).getSectionList()){
                TeacherAttendanceSection.addItem(s.getName());
            } 
        }
        
    }//GEN-LAST:event_TeacherAttendanceSectionPopupMenuWillBecomeVisible

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed

        DefaultTableModel table = (DefaultTableModel) AdminEnrollmentTable.getModel();
        String studentID = (String) table.getValueAt(AdminEnrollmentTable.getSelectedRow(), 1);
        String courseName = (String) table.getValueAt(AdminEnrollmentTable.getSelectedRow(), 2);
        String sectionName = (String) table.getValueAt(AdminEnrollmentTable.getSelectedRow(), 3);
        
        Database.AcceptEnrollment(new Request(Database.getStudentByID(studentID), Database.getCourseByName(courseName), Database.getCourseByName(courseName).getSectionByName(sectionName)));
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        DefaultTableModel table = (DefaultTableModel) AdminEnrollmentTable.getModel();
        String studentID = (String) table.getValueAt(AdminEnrollmentTable.getSelectedRow(), 1);
        String courseName = (String) table.getValueAt(AdminEnrollmentTable.getSelectedRow(), 2);
        String sectionName = (String) table.getValueAt(AdminEnrollmentTable.getSelectedRow(), 3);
        
        Database.RejectEnrollment(new Request(Database.getStudentByID(studentID), Database.getCourseByName(courseName), Database.getCourseByName(courseName).getSectionByName(sectionName)));
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        DefaultTableModel table = (DefaultTableModel) AdminStudentTable.getModel();
        String id = (String) table.getValueAt(AdminStudentTable.getSelectedRow(), 1);
        
        Database.RemoveStudent(id);
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        DefaultTableModel table = (DefaultTableModel) AdminStudentTable.getModel();
        String id = (String) table.getValueAt(AdminStudentTable.getSelectedRow(), 1);
        
        Database.ResetStudent(id);
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        
        DefaultTableModel table = (DefaultTableModel) AdminTeacherTable.getModel();
        String id = (String) table.getValueAt(AdminTeacherTable.getSelectedRow(), 1);
        
        Database.ResetTeacher(id);
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        DefaultTableModel table = (DefaultTableModel) AdminTeacherTable.getModel();
        String id = (String) table.getValueAt(AdminTeacherTable.getSelectedRow(), 1);
        
        Database.DeleteTeacher(id);
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        ReloadAdminCourseTable(Database.getCourseByName(AdminCourseSearch.getText())); 
    }//GEN-LAST:event_jButton44ActionPerformed

    private void AdminPortalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminPortalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_AdminPortalMouseClicked

    private void AdminSectionSelectPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_AdminSectionSelectPopupMenuWillBecomeVisible
        
        if (AdminCourseSelect.getSelectedIndex() != 0){
            AdminSectionSelect.removeAllItems();
            AdminSectionSelect.addItem("Select Section");
            for (Section s : Database.getCourseByName(AdminCourseSelect.getSelectedItem().toString()).getSectionList()){
                AdminSectionSelect.addItem(s.getName());
            }
            
        }
    }//GEN-LAST:event_AdminSectionSelectPopupMenuWillBecomeVisible

    private void StudentCourseRegisterSectionPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_StudentCourseRegisterSectionPopupMenuWillBecomeVisible
        if (StudentCourseRegisterCourse.getSelectedIndex() != 0){
            StudentCourseRegisterSection.removeAllItems();
            StudentCourseRegisterSection.addItem("Select Section");
            for (Section s : Database.getCourseByName(StudentCourseRegisterCourse.getSelectedItem().toString()).getSectionList()){
                StudentCourseRegisterSection.addItem(s.getName());
            }
        }
    }//GEN-LAST:event_StudentCourseRegisterSectionPopupMenuWillBecomeVisible

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        String oourseName = TeacherCourseCourse.getSelectedItem().toString();
        String sectionName = TeacherCourseSection.getSelectedItem().toString();
        
        if (!oourseName.isBlank() || !sectionName.isBlank()){
            Database.getCourseByName(oourseName).getSectionByName(sectionName).setTeacher(teacher);
        }
        else
        {   Debug.showMessage("Select Course First"); }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        DefaultTableModel table = (DefaultTableModel) TeacherCourseTableCourseTab.getModel();
        String courseName = (String) table.getValueAt(TeacherCourseTableCourseTab.getSelectedRow(), 0);
        String sectionName = (String) table.getValueAt(TeacherCourseTableCourseTab.getSelectedRow(), 1);
        
        
        Database.getCourseByName(courseName).getSectionByName(sectionName).removeTeacher(teacher.getID());
    }//GEN-LAST:event_jButton25ActionPerformed

    private void TeacherCourseSectionPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_TeacherCourseSectionPopupMenuWillBecomeVisible
        if (TeacherCourseCourse.getSelectedIndex() != 0){
            TeacherCourseSection.removeAllItems();
            TeacherCourseSection.addItem("Select Section");
            for (Section s : Database.getCourseByName(TeacherCourseCourse.getSelectedItem().toString()).getSectionList()){
                TeacherCourseSection.addItem(s.getName());
            }
        }
    }//GEN-LAST:event_TeacherCourseSectionPopupMenuWillBecomeVisible

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        if ( (TeacherAttendanceCourse.getSelectedIndex() != 0) || (TeacherAttendanceSection.getSelectedIndex() != 0) ){

            String dateToday = "" + java.time.LocalDate.now();
            
            if (TeacherAttendanceDate.getText().isBlank()){
                TeacherAttendanceDate.setText(dateToday);
                
                ReloadTeacherAttendanceTable(dateToday);
            }
            else if (TeacherAttendanceDate.getText().equalsIgnoreCase(dateToday)){}
            else
            {   
                LocalDate yesDate = LocalDate.parse(TeacherAttendanceDate.getText());
                ReloadTeacherAttendanceTable("" + yesDate.minusDays(1));
            }
            
        }
        else
        {
            Debug.showMessage("Select course and section first");
        }
    }//GEN-LAST:event_jButton47ActionPerformed

    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed
        if ( (TeacherAttendanceCourse.getSelectedIndex() != 0) || (TeacherAttendanceSection.getSelectedIndex() != 0) )
        {   
            Course course = Database.getCourseByName(TeacherAttendanceCourse.getSelectedItem().toString());
            Section section = course.getSectionByName(TeacherAttendanceSection.getSelectedItem().toString());
            
            if (TeacherAttendanceDate.getText().isBlank()){
                TeacherAttendanceDate.setText("" + java.time.LocalDate.now());
                
                ReloadTeacherAttendanceTable(TeacherAttendanceDate.getText());
            }
            else if (TeacherAttendanceDate.getText().equalsIgnoreCase("" + java.time.LocalDate.now())){
                ReloadTeacherAttendanceTable(TeacherAttendanceDate.getText());
            }
            else
            {
                LocalDate yesDate = LocalDate.parse(TeacherAttendanceDate.getText());
                ReloadTeacherAttendanceTable("" + yesDate.plusDays(1));
            }
            
        }
        else
        {
            Debug.showMessage("Select course and section first");
        }
    }//GEN-LAST:event_jButton46ActionPerformed

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
    private javax.swing.JTable AdminCourseInfoTable;
    private javax.swing.JTextField AdminCourseSearch;
    private javax.swing.JComboBox<String> AdminCourseSelect;
    private javax.swing.JPanel AdminCourses;
    private javax.swing.JPanel AdminDashboard;
    private javax.swing.JLabel AdminDashboardTotalCourses;
    private javax.swing.JLabel AdminDashboardTotalRequests;
    private javax.swing.JLabel AdminDashboardTotalStudents;
    private javax.swing.JLabel AdminDashboardTotalTeachers;
    private javax.swing.JPanel AdminEnrollment;
    private javax.swing.JTextField AdminEnrollmentStudentID;
    private javax.swing.JTextField AdminEnrollmentStudentName;
    private javax.swing.JTable AdminEnrollmentTable;
    private javax.swing.JTextField AdminNewCourseName;
    private javax.swing.JTextField AdminNewSectionName;
    private javax.swing.JTabbedPane AdminPortal;
    private javax.swing.JComboBox<String> AdminSectionSelect;
    private javax.swing.JPanel AdminStudentDashboard;
    private javax.swing.JTable AdminStudentTable;
    private javax.swing.JPanel AdminTeacherDashboard;
    private javax.swing.JTable AdminTeacherTable;
    private javax.swing.JTabbedPane CredentialsTab;
    private javax.swing.JPanel Login;
    private javax.swing.JLabel LoginBack;
    private javax.swing.JTextField LoginEmail;
    private javax.swing.JPasswordField LoginPassword;
    private javax.swing.JTabbedPane MainTab;
    private javax.swing.JTabbedPane PortalTab;
    private javax.swing.JTextField RegisterStudentAge;
    private javax.swing.JTextField RegisterStudentEmailConfirm;
    private javax.swing.JTextField RegisterStudentIDConfirm;
    private javax.swing.JTextField RegisterStudentName;
    private javax.swing.JTextField RegisterStudentNumber;
    private javax.swing.JTextField RegisterStudentPassword;
    private javax.swing.JTextField RegisterStudentPasswordConfirm;
    private javax.swing.JTextField RegisterTeacherAge;
    private javax.swing.JComboBox<String> RegisterTeacherCourse;
    private javax.swing.JTextField RegisterTeacherCourseConfirm;
    private javax.swing.JTextField RegisterTeacherEmailConfirm;
    private javax.swing.JTextField RegisterTeacherIDConfirm;
    private javax.swing.JTextField RegisterTeacherName;
    private javax.swing.JTextField RegisterTeacherNumber;
    private javax.swing.JTextField RegisterTeacherPassword;
    private javax.swing.JTextField RegisterTeacherPasswordConfirm;
    private javax.swing.JTextField StudenetDashboardName;
    private javax.swing.JPanel StudentAttendance;
    private javax.swing.JPanel StudentCourseRegister;
    private javax.swing.JComboBox<String> StudentCourseRegisterCourse;
    private javax.swing.JTable StudentCourseRegisterCourseDetailTable;
    private javax.swing.JTable StudentCourseRegisterRequestTable;
    private javax.swing.JComboBox<String> StudentCourseRegisterSection;
    private javax.swing.JPanel StudentDashboard;
    private javax.swing.JTable StudentDashboardCourseTable;
    private javax.swing.JTextField StudentDashboardID;
    private javax.swing.JTabbedPane StudentPortal;
    private javax.swing.JPanel StudentRegister;
    private javax.swing.JPanel TeacherAttendance;
    private javax.swing.JComboBox<String> TeacherAttendanceCourse;
    private javax.swing.JTextField TeacherAttendanceDate;
    private javax.swing.JComboBox<String> TeacherAttendanceSection;
    private javax.swing.JTable TeacherAttendanceTable;
    private javax.swing.JComboBox<String> TeacherCourseCourse;
    private javax.swing.JPanel TeacherCourseDrop;
    private javax.swing.JComboBox<String> TeacherCourseSection;
    private javax.swing.JTable TeacherCourseTableCourseTab;
    private javax.swing.JTable TeacherCourseTableDashboard;
    private javax.swing.JPanel TeacherDashboard;
    private javax.swing.JTabbedPane TeacherPortal;
    private javax.swing.JTextField TeacherPortalDashboardName;
    private javax.swing.JPanel TeacherRegister;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JButton registersbutton;
    // End of variables declaration//GEN-END:variables
}
