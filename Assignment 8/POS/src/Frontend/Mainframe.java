
package Frontend;


import Backend.Account;
import Backend.Customer;
import Backend.Database;
import Backend.Errors;
import Backend.Product;
import Backend.Sale;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Junaid Sultan
 */

public class Mainframe extends javax.swing.JFrame {

    public Mainframe() {
        Database.TestCustomers();
        Database.TestProducts();
        
//        Dr. Minday :)
        
        initComponents();
    }
    
    Sale sale = null;
    
    public void LoadAnalyticsMenu(){
        TotalProductsSoldText.setText("" + Backend.Analytics.totalSales);
        TotalProfitText.setText("" + Backend.Analytics.totalProfit);
        TotalRegularCustomersText.setText("" + Backend.Analytics.totalRegularCustomer());
        MostSellingProductText.setText(Backend.Analytics.mostSellingProduct());
    }
    
    public void LoadProductMenu(){
        ResetProductFields();
        
        RefreshProductTable();
        
    }
    
    public void LoadCustomerMenu(){
        ResetCustomerFields();
        
        RefreshCustomerTable();
    }
    
    public void LoadSalesMenu(){
        RefreshSalesTable();
        ResetSalesFields();
        
        for (Product p : Database.getProductList()){
            if (p.getStock() > 0){
                SelectProductComboBox.addItem(p.getName());
            }
        }
        
        for (Customer c : Database.getCustomerList()){
            SelectCustomerComboBox.addItem(c.getName());
        }
    }
    
    //---------------------------------------------------------
    
    public void RefreshProductTable(){
        DefaultTableModel table = (DefaultTableModel) ProductTable.getModel();
        
        if (ProductTable.getRowCount() > 0){
            
            int elements = ProductTable.getRowCount() - 1;
            for (int x = elements; x >= 0; x--){
                table.removeRow(x);
            }
        }
        
        for (Product p : Database.getProductList()){
            String[] data = {p.getName(), p.getCatagory(), "" + p.getRetailPrice(), "" + p.getWholesalePrice(), "" + p.getStock(), p.getId()};
            table.addRow(data);
        }
    }
    
    public void RefreshCustomerTable(){
        DefaultTableModel table = (DefaultTableModel) CustomerTable.getModel();
        
        if (CustomerTable.getRowCount() > 0){
            
            int elements = CustomerTable.getRowCount() - 1;
            for (int x = elements; x >= 0; x--){
                table.removeRow(x);
            }
        }
        
        for (Customer c : Database.getCustomerList()){
            String[] data = {c.getName(), c.getAddress(), c.getCustomerType(), "" + c.getTotalSpent()};
            table.addRow(data);
        }
    }
    
    
    public void RefreshSalesTable(){
        DefaultTableModel table = (DefaultTableModel) SaleTable.getModel();
        
        if (SaleTable.getRowCount() > 0){
            
            int elements = SaleTable.getRowCount() - 1;
            for (int x = elements; x >= 0; x--){
                table.removeRow(x);
            }
        }
        
        for (Sale s : Database.getTransactionHistory()){
            double profit = s.calculateProfit(s.getCart(), s.getCustomer());
            String customer = s.getCustomer().getName();
            String date = s.getPurchaseDate();
            String productInfo = "";
            
            for (Product p : s.getCart()){
                productInfo += p.getName() + " (" + p.getQuantitySelected() + ") ";
                productInfo += ", ";
            }
            
            String[] data = {productInfo, "" + profit, customer, date};
            table.addRow(data);
        }
    }
    
    
    //---------------------------------------------------------
    
    public void ResetProductFields(){
        ProductSearchField.setText("product id");
        ProductNameField.setText("name");
        ProductIDField.setText("id");
        ProductCatagoryField.setText("catagory");
        ProductRetailPriceField.setText("retail price");
        ProductWholeSalePriceField.setText("wholesale price");
        ProductStockField.setText("stock");
    }
    
    public void ResetCustomerFields(){
        CustomerSearchNameField.setText("customer name");
        CustomerNameField.setText("name");
        CustomerAdressField.setText("address");
        CustomerTypeComboBox.setSelectedIndex(0);
        CustomerCustomDiscount.setText("custom discount");
    }
    
    public void ResetSalesFields(){
        SelectProductComboBox.setSelectedIndex(0);
        SelectCustomerComboBox.setSelectedIndex(0);
        ProductQuantityField.setText("quantity");
        
        TotalAmountField.setText("");
        DiscountField.setText("");
        ProfitField.setText("");
    }
    //---------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainTab = new javax.swing.JTabbedPane();
        LoginTab = new javax.swing.JTabbedPane();
        LoginPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        LoginEmail = new javax.swing.JTextField();
        LoginPassword = new javax.swing.JPasswordField();
        LoginButton = new javax.swing.JButton();
        LoginSignupButon = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BackgroundLogin = new javax.swing.JLabel();
        SingupPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        SignupEmail = new javax.swing.JTextField();
        SignupPassword = new javax.swing.JPasswordField();
        SignupPassword1 = new javax.swing.JPasswordField();
        SignupButton = new javax.swing.JButton();
        LoginSignupButon1 = new javax.swing.JLabel();
        BackgroundSignup = new javax.swing.JLabel();
        Manager = new javax.swing.JPanel();
        ManagerTab = new javax.swing.JTabbedPane();
        Analytics = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TotalProductsSoldText = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        MostSellingProductText = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        TotalProfitText = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        TotalRegularCustomersText = new javax.swing.JLabel();
        Products = new javax.swing.JPanel();
        ProductTablePanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ProductTable = new javax.swing.JTable();
        RefreshProduct = new javax.swing.JButton();
        SearchProduct = new javax.swing.JButton();
        DeleteProduct = new javax.swing.JButton();
        ProductNameField = new javax.swing.JTextField();
        ProductCatagoryField = new javax.swing.JTextField();
        ProductIDField = new javax.swing.JTextField();
        ProductRetailPriceField = new javax.swing.JTextField();
        ProductWholeSalePriceField = new javax.swing.JTextField();
        ProductStockField = new javax.swing.JTextField();
        UpdateProduct = new javax.swing.JButton();
        ProductSearchField = new javax.swing.JTextField();
        AddProduct = new javax.swing.JButton();
        Customer = new javax.swing.JPanel();
        ProductTablePanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        CustomerTable = new javax.swing.JTable();
        RefreshCustomer = new javax.swing.JButton();
        SearchCustomer = new javax.swing.JButton();
        DeleteCustomer = new javax.swing.JButton();
        CustomerNameField = new javax.swing.JTextField();
        CustomerAdressField = new javax.swing.JTextField();
        UpdateCustomer = new javax.swing.JButton();
        CustomerSearchNameField = new javax.swing.JTextField();
        AddCustomer = new javax.swing.JButton();
        CustomerTypeComboBox = new javax.swing.JComboBox<>();
        CustomerCustomDiscount = new javax.swing.JTextField();
        Sales = new javax.swing.JPanel();
        ProductTablePanel2 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        SaleTable = new javax.swing.JTable();
        RefreshSale = new javax.swing.JButton();
        SelectProductComboBox = new javax.swing.JComboBox<>();
        SelectCustomerComboBox = new javax.swing.JComboBox<>();
        ProductQuantityField = new javax.swing.JTextField();
        TotalAmountField = new javax.swing.JTextField();
        ProfitField = new javax.swing.JTextField();
        PurchaseButton = new javax.swing.JToggleButton();
        CancelSaleButton = new javax.swing.JToggleButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        DiscountField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        CalculateButton = new javax.swing.JToggleButton();
        AddToCartButton = new javax.swing.JButton();
        ManagerSidePanel3 = new javax.swing.JPanel();
        ManagerSidePanel2 = new javax.swing.JPanel();
        AnalyticsButton = new javax.swing.JButton();
        ProductButton = new javax.swing.JButton();
        CustomerButton = new javax.swing.JButton();
        SaleButton = new javax.swing.JButton();
        SaleButton1 = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LoginPanel.setBackground(new java.awt.Color(255, 255, 255));
        LoginPanel.setMaximumSize(new java.awt.Dimension(927, 640));
        LoginPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Password");
        LoginPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 130, -1));

        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Email");
        LoginPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 130, -1));

        LoginEmail.setBackground(new java.awt.Color(51, 51, 51));
        LoginEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LoginEmail.setForeground(new java.awt.Color(204, 204, 204));
        LoginEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        LoginEmail.setOpaque(true);
        LoginPanel.add(LoginEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 450, 40));

        LoginPassword.setBackground(new java.awt.Color(51, 51, 51));
        LoginPassword.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LoginPassword.setForeground(new java.awt.Color(204, 204, 204));
        LoginPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        LoginPanel.add(LoginPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 450, 40));

        LoginButton.setBackground(new java.awt.Color(153, 153, 153));
        LoginButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LoginButton.setText("Login");
        LoginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LoginButton.setFocusable(false);
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        LoginPanel.add(LoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, 450, 40));

        LoginSignupButon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LoginSignupButon.setForeground(new java.awt.Color(204, 204, 204));
        LoginSignupButon.setText("Sign up here");
        LoginSignupButon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LoginSignupButon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginSignupButonMouseClicked(evt);
            }
        });
        LoginPanel.add(LoginSignupButon, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 380, 80, -1));

        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Don't have an account?");
        LoginPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 380, 130, -1));

        BackgroundLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graphics/login.png"))); // NOI18N
        LoginPanel.add(BackgroundLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 0, 930, 640));

        LoginTab.addTab("tab1", LoginPanel);

        SingupPanel.setBackground(new java.awt.Color(255, 255, 255));
        SingupPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Email");
        SingupPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 130, -1));

        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Password");
        SingupPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 130, -1));

        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Confirm Password");
        SingupPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 130, -1));

        SignupEmail.setBackground(new java.awt.Color(51, 51, 51));
        SignupEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SignupEmail.setForeground(new java.awt.Color(204, 204, 204));
        SignupEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        SignupEmail.setOpaque(true);
        SingupPanel.add(SignupEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 450, 40));

        SignupPassword.setBackground(new java.awt.Color(51, 51, 51));
        SignupPassword.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SignupPassword.setForeground(new java.awt.Color(204, 204, 204));
        SignupPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        SingupPanel.add(SignupPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 450, 40));

        SignupPassword1.setBackground(new java.awt.Color(51, 51, 51));
        SignupPassword1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SignupPassword1.setForeground(new java.awt.Color(204, 204, 204));
        SignupPassword1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        SingupPanel.add(SignupPassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 450, 40));

        SignupButton.setBackground(new java.awt.Color(153, 153, 153));
        SignupButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SignupButton.setText("Confirm");
        SignupButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SignupButton.setFocusable(false);
        SignupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignupButtonActionPerformed(evt);
            }
        });
        SingupPanel.add(SignupButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 420, 450, 40));

        LoginSignupButon1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LoginSignupButon1.setForeground(new java.awt.Color(204, 204, 204));
        LoginSignupButon1.setText("Back");
        LoginSignupButon1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LoginSignupButon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginSignupButon1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LoginSignupButon1MousePressed(evt);
            }
        });
        SingupPanel.add(LoginSignupButon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 540, 40, -1));

        BackgroundSignup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graphics/login.png"))); // NOI18N
        SingupPanel.add(BackgroundSignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 0, 930, 640));

        LoginTab.addTab("tab2", SingupPanel);

        MainTab.addTab("tab1", LoginTab);

        Manager.setMaximumSize(new java.awt.Dimension(927, 640));
        Manager.setMinimumSize(new java.awt.Dimension(927, 640));
        Manager.setPreferredSize(new java.awt.Dimension(927, 640));
        Manager.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Analytics.setBackground(new java.awt.Color(255, 255, 255));
        Analytics.setOpaque(false);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0, 200));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Total Products Sold");

        TotalProductsSoldText.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TotalProductsSoldText.setForeground(new java.awt.Color(255, 255, 255));
        TotalProductsSoldText.setText("1514");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(TotalProductsSoldText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TotalProductsSoldText, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0, 200));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Most Selling Product");

        MostSellingProductText.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        MostSellingProductText.setForeground(new java.awt.Color(255, 255, 255));
        MostSellingProductText.setText("Ice Cream Sandwich");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(MostSellingProductText, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MostSellingProductText, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 0, 200));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Total Profit");

        TotalProfitText.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TotalProfitText.setForeground(new java.awt.Color(255, 255, 255));
        TotalProfitText.setText("$ 273890432");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addComponent(TotalProfitText, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(TotalProfitText, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 0, 0, 200));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Total Regular Customers");

        TotalRegularCustomersText.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TotalRegularCustomersText.setForeground(new java.awt.Color(255, 255, 255));
        TotalRegularCustomersText.setText("12");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 9, Short.MAX_VALUE)
                        .addComponent(TotalRegularCustomersText, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(TotalRegularCustomersText, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AnalyticsLayout = new javax.swing.GroupLayout(Analytics);
        Analytics.setLayout(AnalyticsLayout);
        AnalyticsLayout.setHorizontalGroup(
            AnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AnalyticsLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(AnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(AnalyticsLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(AnalyticsLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        AnalyticsLayout.setVerticalGroup(
            AnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AnalyticsLayout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addGroup(AnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AnalyticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(223, Short.MAX_VALUE))
        );

        ManagerTab.addTab("tab1", Analytics);

        Products.setBackground(new java.awt.Color(255, 255, 255));
        Products.setOpaque(false);

        ProductTablePanel.setOpaque(false);

        ProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Catagory", "Retail", "Wholesale", "Stock", "ID"
            }
        ));
        ProductTable.setShowGrid(true);
        jScrollPane2.setViewportView(ProductTable);

        RefreshProduct.setBackground(new java.awt.Color(51, 51, 51));
        RefreshProduct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RefreshProduct.setForeground(new java.awt.Color(255, 255, 255));
        RefreshProduct.setText("Refresh");
        RefreshProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshProductActionPerformed(evt);
            }
        });

        SearchProduct.setBackground(new java.awt.Color(204, 255, 255));
        SearchProduct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SearchProduct.setForeground(new java.awt.Color(0, 0, 0));
        SearchProduct.setText("search");
        SearchProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchProductActionPerformed(evt);
            }
        });

        DeleteProduct.setBackground(new java.awt.Color(255, 51, 51));
        DeleteProduct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DeleteProduct.setForeground(new java.awt.Color(255, 255, 255));
        DeleteProduct.setText("Delete");
        DeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteProductActionPerformed(evt);
            }
        });

        ProductNameField.setText("name");
        ProductNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ProductNameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ProductNameFieldFocusLost(evt);
            }
        });

        ProductCatagoryField.setText("catagory");
        ProductCatagoryField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ProductCatagoryFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ProductCatagoryFieldFocusLost(evt);
            }
        });
        ProductCatagoryField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductCatagoryFieldActionPerformed(evt);
            }
        });

        ProductIDField.setText("id");
        ProductIDField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ProductIDFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ProductIDFieldFocusLost(evt);
            }
        });

        ProductRetailPriceField.setText("retail price");
        ProductRetailPriceField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ProductRetailPriceFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ProductRetailPriceFieldFocusLost(evt);
            }
        });
        ProductRetailPriceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductRetailPriceFieldActionPerformed(evt);
            }
        });

        ProductWholeSalePriceField.setText("wholesale price");
        ProductWholeSalePriceField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ProductWholeSalePriceFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ProductWholeSalePriceFieldFocusLost(evt);
            }
        });
        ProductWholeSalePriceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductWholeSalePriceFieldActionPerformed(evt);
            }
        });

        ProductStockField.setText("stock");
        ProductStockField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ProductStockFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ProductStockFieldFocusLost(evt);
            }
        });
        ProductStockField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductStockFieldActionPerformed(evt);
            }
        });

        UpdateProduct.setBackground(new java.awt.Color(153, 153, 255));
        UpdateProduct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        UpdateProduct.setForeground(new java.awt.Color(0, 0, 0));
        UpdateProduct.setText("Update");
        UpdateProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateProductActionPerformed(evt);
            }
        });

        ProductSearchField.setText("product id");
        ProductSearchField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ProductSearchFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ProductSearchFieldFocusLost(evt);
            }
        });
        ProductSearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductSearchFieldActionPerformed(evt);
            }
        });

        AddProduct.setBackground(new java.awt.Color(102, 255, 102));
        AddProduct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AddProduct.setForeground(new java.awt.Color(0, 0, 0));
        AddProduct.setText("Add");
        AddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddProductActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ProductTablePanelLayout = new javax.swing.GroupLayout(ProductTablePanel);
        ProductTablePanel.setLayout(ProductTablePanelLayout);
        ProductTablePanelLayout.setHorizontalGroup(
            ProductTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductTablePanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(ProductTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RefreshProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ProductTablePanelLayout.createSequentialGroup()
                        .addGroup(ProductTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(ProductTablePanelLayout.createSequentialGroup()
                                .addComponent(ProductSearchField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ProductTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductTablePanelLayout.createSequentialGroup()
                                .addGroup(ProductTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductTablePanelLayout.createSequentialGroup()
                                        .addComponent(ProductRetailPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ProductWholeSalePriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(UpdateProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ProductStockField, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(AddProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
                                    .addComponent(DeleteProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ProductNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ProductIDField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                                    .addComponent(ProductCatagoryField, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ProductTablePanelLayout.setVerticalGroup(
            ProductTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductTablePanelLayout.createSequentialGroup()
                .addGroup(ProductTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ProductTablePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ProductTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SearchProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                            .addComponent(ProductSearchField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(ProductTablePanelLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(ProductNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ProductIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ProductCatagoryField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addGroup(ProductTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ProductRetailPriceField, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                            .addComponent(ProductWholeSalePriceField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ProductStockField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(UpdateProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(AddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RefreshProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout ProductsLayout = new javax.swing.GroupLayout(Products);
        Products.setLayout(ProductsLayout);
        ProductsLayout.setHorizontalGroup(
            ProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ProductTablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        ProductsLayout.setVerticalGroup(
            ProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductsLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(ProductTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ManagerTab.addTab("tab2", Products);

        Customer.setBackground(new java.awt.Color(255, 255, 255));
        Customer.setOpaque(false);

        ProductTablePanel3.setOpaque(false);

        CustomerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Address", "Type", "Total Spent"
            }
        ));
        CustomerTable.setShowGrid(true);
        jScrollPane3.setViewportView(CustomerTable);

        RefreshCustomer.setBackground(new java.awt.Color(51, 51, 51));
        RefreshCustomer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RefreshCustomer.setForeground(new java.awt.Color(255, 255, 255));
        RefreshCustomer.setText("Refresh");
        RefreshCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshCustomerActionPerformed(evt);
            }
        });

        SearchCustomer.setBackground(new java.awt.Color(204, 255, 255));
        SearchCustomer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SearchCustomer.setForeground(new java.awt.Color(0, 0, 0));
        SearchCustomer.setText("search");
        SearchCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchCustomerActionPerformed(evt);
            }
        });

        DeleteCustomer.setBackground(new java.awt.Color(255, 51, 51));
        DeleteCustomer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DeleteCustomer.setForeground(new java.awt.Color(255, 255, 255));
        DeleteCustomer.setText("Delete");
        DeleteCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteCustomerActionPerformed(evt);
            }
        });

        CustomerNameField.setText("name");
        CustomerNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CustomerNameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                CustomerNameFieldFocusLost(evt);
            }
        });

        CustomerAdressField.setText("address");
        CustomerAdressField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CustomerAdressFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                CustomerAdressFieldFocusLost(evt);
            }
        });
        CustomerAdressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerAdressFieldActionPerformed(evt);
            }
        });

        UpdateCustomer.setBackground(new java.awt.Color(153, 153, 255));
        UpdateCustomer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        UpdateCustomer.setForeground(new java.awt.Color(0, 0, 0));
        UpdateCustomer.setText("Update");
        UpdateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateCustomerActionPerformed(evt);
            }
        });

        CustomerSearchNameField.setText("customer name");
        CustomerSearchNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CustomerSearchNameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                CustomerSearchNameFieldFocusLost(evt);
            }
        });

        AddCustomer.setBackground(new java.awt.Color(102, 255, 102));
        AddCustomer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AddCustomer.setForeground(new java.awt.Color(0, 0, 0));
        AddCustomer.setText("Add");
        AddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCustomerActionPerformed(evt);
            }
        });

        CustomerTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Customer Type", "Normal", "Regular", "Premium" }));

        CustomerCustomDiscount.setText("Custom Discount");
        CustomerCustomDiscount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CustomerCustomDiscountFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                CustomerCustomDiscountFocusLost(evt);
            }
        });
        CustomerCustomDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerCustomDiscountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ProductTablePanel3Layout = new javax.swing.GroupLayout(ProductTablePanel3);
        ProductTablePanel3.setLayout(ProductTablePanel3Layout);
        ProductTablePanel3Layout.setHorizontalGroup(
            ProductTablePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductTablePanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(ProductTablePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProductTablePanel3Layout.createSequentialGroup()
                        .addGroup(ProductTablePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(ProductTablePanel3Layout.createSequentialGroup()
                                .addComponent(CustomerSearchNameField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ProductTablePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ProductTablePanel3Layout.createSequentialGroup()
                                .addComponent(CustomerAdressField)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductTablePanel3Layout.createSequentialGroup()
                                .addComponent(CustomerNameField)
                                .addContainerGap())
                            .addGroup(ProductTablePanel3Layout.createSequentialGroup()
                                .addGroup(ProductTablePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(UpdateCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(AddCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                                    .addComponent(DeleteCustomer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductTablePanel3Layout.createSequentialGroup()
                                .addGroup(ProductTablePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(CustomerCustomDiscount)
                                    .addComponent(CustomerTypeComboBox, 0, 263, Short.MAX_VALUE))
                                .addGap(10, 10, 10))))
                    .addGroup(ProductTablePanel3Layout.createSequentialGroup()
                        .addComponent(RefreshCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        ProductTablePanel3Layout.setVerticalGroup(
            ProductTablePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductTablePanel3Layout.createSequentialGroup()
                .addGroup(ProductTablePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ProductTablePanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ProductTablePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SearchCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                            .addComponent(CustomerSearchNameField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE))
                    .addGroup(ProductTablePanel3Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(CustomerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CustomerAdressField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(CustomerTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CustomerCustomDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(UpdateCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RefreshCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout CustomerLayout = new javax.swing.GroupLayout(Customer);
        Customer.setLayout(CustomerLayout);
        CustomerLayout.setHorizontalGroup(
            CustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ProductTablePanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        CustomerLayout.setVerticalGroup(
            CustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CustomerLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(ProductTablePanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ManagerTab.addTab("tab3", Customer);

        Sales.setBackground(new java.awt.Color(255, 255, 255));
        Sales.setOpaque(false);

        ProductTablePanel2.setOpaque(false);

        SaleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Products Sold", "Profit", "Customer", "Date"
            }
        ));
        SaleTable.setShowGrid(true);
        jScrollPane6.setViewportView(SaleTable);

        RefreshSale.setBackground(new java.awt.Color(51, 51, 51));
        RefreshSale.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RefreshSale.setForeground(new java.awt.Color(255, 255, 255));
        RefreshSale.setText("Refresh");
        RefreshSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshSaleActionPerformed(evt);
            }
        });

        SelectProductComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " Select Product" }));

        SelectCustomerComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " Select Customer" }));

        ProductQuantityField.setText("quantity");

        TotalAmountField.setEditable(false);

        ProfitField.setEditable(false);
        ProfitField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfitFieldActionPerformed(evt);
            }
        });

        PurchaseButton.setBackground(new java.awt.Color(102, 255, 102));
        PurchaseButton.setForeground(new java.awt.Color(0, 0, 0));
        PurchaseButton.setText("Purchase");
        PurchaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PurchaseButtonActionPerformed(evt);
            }
        });

        CancelSaleButton.setBackground(new java.awt.Color(255, 51, 51));
        CancelSaleButton.setText("Cancel");

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("total amount");

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("profit");

        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("discount");

        CalculateButton.setBackground(new java.awt.Color(204, 255, 255));
        CalculateButton.setForeground(new java.awt.Color(0, 0, 0));
        CalculateButton.setText("Calculate");
        CalculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculateButtonActionPerformed(evt);
            }
        });

        AddToCartButton.setText("Add");
        AddToCartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddToCartButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ProductTablePanel2Layout = new javax.swing.GroupLayout(ProductTablePanel2);
        ProductTablePanel2.setLayout(ProductTablePanel2Layout);
        ProductTablePanel2Layout.setHorizontalGroup(
            ProductTablePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductTablePanel2Layout.createSequentialGroup()
                .addGap(0, 30, Short.MAX_VALUE)
                .addGroup(ProductTablePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RefreshSale, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ProductTablePanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(ProductTablePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SelectProductComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SelectCustomerComboBox, 0, 267, Short.MAX_VALUE)
                            .addComponent(ProductQuantityField)
                            .addComponent(PurchaseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CancelSaleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(ProductTablePanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ProductTablePanel2Layout.createSequentialGroup()
                                .addComponent(TotalAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DiscountField))
                            .addComponent(ProfitField)
                            .addComponent(CalculateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AddToCartButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
        );
        ProductTablePanel2Layout.setVerticalGroup(
            ProductTablePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductTablePanel2Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(ProductTablePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ProductTablePanel2Layout.createSequentialGroup()
                        .addComponent(SelectProductComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ProductQuantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AddToCartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SelectCustomerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(ProductTablePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ProductTablePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DiscountField)
                            .addComponent(TotalAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ProfitField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CalculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PurchaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CancelSaleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RefreshSale, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout SalesLayout = new javax.swing.GroupLayout(Sales);
        Sales.setLayout(SalesLayout);
        SalesLayout.setHorizontalGroup(
            SalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ProductTablePanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        SalesLayout.setVerticalGroup(
            SalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalesLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(ProductTablePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ManagerTab.addTab("tab4", Sales);

        Manager.add(ManagerTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, -35, 790, 700));

        ManagerSidePanel3.setBackground(new java.awt.Color(204, 204, 204));
        ManagerSidePanel3.setFocusable(false);

        javax.swing.GroupLayout ManagerSidePanel3Layout = new javax.swing.GroupLayout(ManagerSidePanel3);
        ManagerSidePanel3.setLayout(ManagerSidePanel3Layout);
        ManagerSidePanel3Layout.setHorizontalGroup(
            ManagerSidePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        ManagerSidePanel3Layout.setVerticalGroup(
            ManagerSidePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );

        Manager.add(ManagerSidePanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 10, 680));

        ManagerSidePanel2.setBackground(new java.awt.Color(51, 51, 51));

        AnalyticsButton.setBackground(new java.awt.Color(51, 51, 51));
        AnalyticsButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AnalyticsButton.setForeground(new java.awt.Color(255, 255, 255));
        AnalyticsButton.setText("Analytics");
        AnalyticsButton.setFocusable(false);
        AnalyticsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalyticsButtonActionPerformed(evt);
            }
        });

        ProductButton.setBackground(new java.awt.Color(51, 51, 51));
        ProductButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ProductButton.setForeground(new java.awt.Color(255, 255, 255));
        ProductButton.setText("Products");
        ProductButton.setFocusable(false);
        ProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductButtonActionPerformed(evt);
            }
        });

        CustomerButton.setBackground(new java.awt.Color(51, 51, 51));
        CustomerButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CustomerButton.setForeground(new java.awt.Color(255, 255, 255));
        CustomerButton.setText("Customers");
        CustomerButton.setFocusable(false);
        CustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerButtonActionPerformed(evt);
            }
        });

        SaleButton.setBackground(new java.awt.Color(51, 51, 51));
        SaleButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SaleButton.setForeground(new java.awt.Color(255, 255, 255));
        SaleButton.setText("Sales");
        SaleButton.setFocusable(false);
        SaleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaleButtonActionPerformed(evt);
            }
        });

        SaleButton1.setBackground(new java.awt.Color(255, 51, 51));
        SaleButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SaleButton1.setForeground(new java.awt.Color(255, 255, 255));
        SaleButton1.setText("Logout");
        SaleButton1.setFocusable(false);
        SaleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ManagerSidePanel2Layout = new javax.swing.GroupLayout(ManagerSidePanel2);
        ManagerSidePanel2.setLayout(ManagerSidePanel2Layout);
        ManagerSidePanel2Layout.setHorizontalGroup(
            ManagerSidePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AnalyticsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ProductButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CustomerButton, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(SaleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(SaleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ManagerSidePanel2Layout.setVerticalGroup(
            ManagerSidePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ManagerSidePanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(AnalyticsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CustomerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SaleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SaleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        Manager.add(ManagerSidePanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 680));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Graphics/manager.png"))); // NOI18N
        Background.setText("jLabel3");
        Manager.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 670));

        MainTab.addTab("tab2", Manager);

        getContentPane().add(MainTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -72, -1, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginSignupButon1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginSignupButon1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginSignupButon1MousePressed

    private void LoginSignupButon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginSignupButon1MouseClicked
        LoginTab.setSelectedIndex(0);
    }//GEN-LAST:event_LoginSignupButon1MouseClicked

    private void LoginSignupButonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginSignupButonMouseClicked
        LoginTab.setSelectedIndex(1);
    }//GEN-LAST:event_LoginSignupButonMouseClicked

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        String email = LoginEmail.getText();
        String pass = LoginPassword.getText();
        
        if (Database.login(new Account(email, pass)) != null){
            LoadAnalyticsMenu();
            Errors.showMessage("Login Successful !");
            MainTab.setSelectedIndex(1);
        }
        else{
            Errors.showMessage("Account doesnt exist");
        }
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void AnalyticsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnalyticsButtonActionPerformed
        ManagerTab.setSelectedIndex(0);
        LoadAnalyticsMenu();
    }//GEN-LAST:event_AnalyticsButtonActionPerformed

    private void ProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductButtonActionPerformed
        LoadProductMenu();
        ManagerTab.setSelectedIndex(1);
    }//GEN-LAST:event_ProductButtonActionPerformed

    private void CustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerButtonActionPerformed
        LoadCustomerMenu();
        ManagerTab.setSelectedIndex(2);
    }//GEN-LAST:event_CustomerButtonActionPerformed

    private void SaleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaleButtonActionPerformed
        ManagerTab.setSelectedIndex(3);
        LoadSalesMenu();
    }//GEN-LAST:event_SaleButtonActionPerformed

    private void SaleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaleButton1ActionPerformed
        MainTab.setSelectedIndex(0);
    }//GEN-LAST:event_SaleButton1ActionPerformed

    private void ProductCatagoryFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductCatagoryFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductCatagoryFieldActionPerformed

    private void ProductRetailPriceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductRetailPriceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductRetailPriceFieldActionPerformed

    private void ProductWholeSalePriceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductWholeSalePriceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductWholeSalePriceFieldActionPerformed

    private void ProductStockFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductStockFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductStockFieldActionPerformed

    private void ProductNameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ProductNameFieldFocusGained
        if (ProductNameField.getText().trim().equalsIgnoreCase("name")){
            ProductNameField.setText("");
        }
    }//GEN-LAST:event_ProductNameFieldFocusGained

    private void ProductNameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ProductNameFieldFocusLost
        if (ProductNameField.getText().isBlank()){
            ProductNameField.setText("name");
        }
    }//GEN-LAST:event_ProductNameFieldFocusLost

    private void ProductIDFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ProductIDFieldFocusGained
        if (ProductIDField.getText().trim().equalsIgnoreCase("id")){
            ProductIDField.setText("");
        }
    }//GEN-LAST:event_ProductIDFieldFocusGained

    private void ProductIDFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ProductIDFieldFocusLost
        if (ProductIDField.getText().isBlank()){
            ProductIDField.setText("id");
        }
    }//GEN-LAST:event_ProductIDFieldFocusLost

    private void ProductCatagoryFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ProductCatagoryFieldFocusGained
        if (ProductCatagoryField.getText().trim().equalsIgnoreCase("catagory")){
            ProductCatagoryField.setText("");
        }
    }//GEN-LAST:event_ProductCatagoryFieldFocusGained

    private void ProductCatagoryFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ProductCatagoryFieldFocusLost
        if (ProductCatagoryField.getText().isBlank()){
            ProductCatagoryField.setText("catagory");
        }
    }//GEN-LAST:event_ProductCatagoryFieldFocusLost

    private void ProductRetailPriceFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ProductRetailPriceFieldFocusGained
        if (ProductRetailPriceField.getText().trim().equalsIgnoreCase("retail price")){
            ProductRetailPriceField.setText("");
        }
    }//GEN-LAST:event_ProductRetailPriceFieldFocusGained

    private void ProductRetailPriceFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ProductRetailPriceFieldFocusLost
        if (ProductRetailPriceField.getText().isBlank()){
            ProductRetailPriceField.setText("retail price");
        }
    }//GEN-LAST:event_ProductRetailPriceFieldFocusLost

    private void ProductWholeSalePriceFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ProductWholeSalePriceFieldFocusGained
        if (ProductWholeSalePriceField.getText().trim().equalsIgnoreCase("wholesale price")){
            ProductWholeSalePriceField.setText("");
        }
    }//GEN-LAST:event_ProductWholeSalePriceFieldFocusGained

    private void ProductWholeSalePriceFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ProductWholeSalePriceFieldFocusLost
        if (ProductWholeSalePriceField.getText().isBlank()){
            ProductWholeSalePriceField.setText("wholesale price");
        }
    }//GEN-LAST:event_ProductWholeSalePriceFieldFocusLost

    private void ProductStockFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ProductStockFieldFocusGained
        if (ProductStockField.getText().trim().equalsIgnoreCase("stock")){
            ProductStockField.setText("");
        }
    }//GEN-LAST:event_ProductStockFieldFocusGained

    private void ProductStockFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ProductStockFieldFocusLost
        if (ProductStockField.getText().isBlank()){
            ProductStockField.setText("stock");
        }
    }//GEN-LAST:event_ProductStockFieldFocusLost

    private void ProductSearchFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ProductSearchFieldFocusGained
        if (ProductSearchField.getText().trim().equalsIgnoreCase("product id")){
            ProductSearchField.setText("");
        }
    }//GEN-LAST:event_ProductSearchFieldFocusGained

    private void ProductSearchFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ProductSearchFieldFocusLost
        if (ProductSearchField.getText().isBlank()){
            ProductSearchField.setText("product id");
        }
    }//GEN-LAST:event_ProductSearchFieldFocusLost

    private void CustomerNameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CustomerNameFieldFocusGained
        if (CustomerNameField.getText().trim().equalsIgnoreCase("name")){
            CustomerNameField.setText("");
        }
    }//GEN-LAST:event_CustomerNameFieldFocusGained

    private void CustomerNameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CustomerNameFieldFocusLost
        if (CustomerNameField.getText().isBlank()){
            CustomerNameField.setText("name");
        }
    }//GEN-LAST:event_CustomerNameFieldFocusLost

    private void CustomerAdressFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CustomerAdressFieldFocusGained
        if (CustomerAdressField.getText().trim().equalsIgnoreCase("address")){
            CustomerAdressField.setText("");
        }
    }//GEN-LAST:event_CustomerAdressFieldFocusGained

    private void CustomerAdressFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CustomerAdressFieldFocusLost
        if (CustomerAdressField.getText().isBlank()){
            CustomerAdressField.setText("address");
        }
    }//GEN-LAST:event_CustomerAdressFieldFocusLost

    private void CustomerAdressFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerAdressFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerAdressFieldActionPerformed

    private void CustomerSearchNameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CustomerSearchNameFieldFocusGained
        if (CustomerSearchNameField.getText().trim().equalsIgnoreCase("customer name")){
            CustomerSearchNameField.setText("");
        }
    }//GEN-LAST:event_CustomerSearchNameFieldFocusGained

    private void CustomerSearchNameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CustomerSearchNameFieldFocusLost
        if (CustomerSearchNameField.getText().isBlank()){
            CustomerSearchNameField.setText("customer name");
        }
    }//GEN-LAST:event_CustomerSearchNameFieldFocusLost

    private void CustomerCustomDiscountFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CustomerCustomDiscountFocusGained
        if (CustomerCustomDiscount.getText().trim().equalsIgnoreCase("custom discount")){
            CustomerCustomDiscount.setText("");
        }
    }//GEN-LAST:event_CustomerCustomDiscountFocusGained

    private void CustomerCustomDiscountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CustomerCustomDiscountFocusLost
        if (CustomerCustomDiscount.getText().isBlank()){
            CustomerCustomDiscount.setText("custom discount");
        }
    }//GEN-LAST:event_CustomerCustomDiscountFocusLost

    private void CustomerCustomDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerCustomDiscountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerCustomDiscountActionPerformed

    private void AddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProductActionPerformed
        String name = ProductNameField.getText();
        String id = ProductIDField.getText();
        String catagory = ProductCatagoryField.getText();
        double retail = Double.parseDouble(ProductRetailPriceField.getText());
        double wholesale = Double.parseDouble(ProductWholeSalePriceField.getText());
        int stock = Integer.parseInt(ProductStockField.getText());
        
        Product p = new Product(name, catagory, retail, wholesale, stock);
        p.setID(id);
        
        Database.addProduct(p);
        
        Errors.showMessage("Product Added Successfully !");
        
        ResetProductFields();
        RefreshProductTable();
    }//GEN-LAST:event_AddProductActionPerformed

    private void AddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCustomerActionPerformed
        String name = CustomerNameField.getText();
        String address = CustomerAdressField.getText();
        String type = CustomerTypeComboBox.getSelectedItem().toString();
        int discount = 0;
        
        boolean check = true;
        if (!CustomerCustomDiscount.getText().equalsIgnoreCase("custom discount")){
            
            try {
                discount = Integer.parseInt(CustomerCustomDiscount.getText());
            }
            catch (Exception e){
                Errors.showMessage("Invalid Discount Input");
                check = false;
                discount = -1;
            }
        }
        
        if (discount != -1 && !CustomerCustomDiscount.getText().equalsIgnoreCase("custom discount")){
            Database.addCustomer(new Customer(name, address, type, discount));
        }
        else if (CustomerCustomDiscount.getText().equalsIgnoreCase("custom discount")){
            Database.addCustomer(new Customer(name, address, type));
        }
        
        if (check){
            Errors.showMessage("Customer Added !");
            ResetCustomerFields();
            RefreshCustomerTable();
        }
        
    }//GEN-LAST:event_AddCustomerActionPerformed

    private void ProductSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductSearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductSearchFieldActionPerformed

    private void SearchProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchProductActionPerformed
        String id = ProductSearchField.getText();
        boolean check = false;
        
        for (Product p : Database.getProductList()){
            if (p.getId().equalsIgnoreCase(id)){
                Errors.showMessage("Product Found !");
                check = true;
                
                ProductNameField.setText(p.getName());
                ProductIDField.setText(id);
                ProductCatagoryField.setText(p.getCatagory());
                ProductWholeSalePriceField.setText("" + p.getWholesalePrice());
                ProductRetailPriceField.setText("" + p.getRetailPrice());
                ProductStockField.setText("" + p.getStock());
                
                break;
            }
        }
        
        if (!check){
            Errors.showMessage("Product not found");
        }
    }//GEN-LAST:event_SearchProductActionPerformed

    private void UpdateProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateProductActionPerformed
        String name = ProductNameField.getText();
        String id = ProductIDField.getText();
        String catagory = ProductCatagoryField.getText();
        double retail = Double.parseDouble(ProductRetailPriceField.getText());
        double wholesale = Double.parseDouble(ProductWholeSalePriceField.getText());
        int stock = Integer.parseInt(ProductStockField.getText());
        
        Product p = new Product(name, catagory, retail, wholesale, stock);
        p.setID(id);
        
        Database.updateProduct(name, p);
        
        RefreshProductTable();
        ResetProductFields();
    }//GEN-LAST:event_UpdateProductActionPerformed

    private void DeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteProductActionPerformed
        String name = ProductNameField.getText();
        String id = ProductIDField.getText();
        
        Database.removeProduct(name, id);
        
        RefreshProductTable();
        ResetProductFields();
    }//GEN-LAST:event_DeleteProductActionPerformed

    private void RefreshProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshProductActionPerformed
        RefreshProductTable();
        ResetProductFields();
    }//GEN-LAST:event_RefreshProductActionPerformed

    private void SearchCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchCustomerActionPerformed
        String name = CustomerSearchNameField.getText();
        boolean check = false; 
        
        for (Customer c : Database.getCustomerList()){
            if (c.getName().equalsIgnoreCase(name)){
                check = true;
                Errors.showMessage("Customer found !");
                
                CustomerNameField.setText(name);
                CustomerAdressField.setText(c.getAddress());
                
                int index = 0;
                if (c.getCustomerType().equalsIgnoreCase("regular")){
                    index = 2;
                }
                else if (c.getCustomerType().equalsIgnoreCase("normal")){
                    index = 1;
                }
                else if (c.getCustomerType().equalsIgnoreCase("premium")){
                    index = 3;
                }
                
                CustomerTypeComboBox.setSelectedIndex(index);
                CustomerCustomDiscount.setText("" + c.getDiscount());
                break;
            }
        }
        
        if (!check){
            Errors.showMessage("Customer not found !");
        }
    }//GEN-LAST:event_SearchCustomerActionPerformed

    private void UpdateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateCustomerActionPerformed
        String name = CustomerNameField.getText();
        String address = CustomerAdressField.getText();
        String type = CustomerTypeComboBox.getSelectedItem().toString();
        int discount = 0;
        
        boolean check = true;
        if (!CustomerCustomDiscount.getText().equalsIgnoreCase("custom discount")){
            
            try {
                discount = Integer.parseInt(CustomerCustomDiscount.getText());
            }
            catch (Exception e){
                Errors.showMessage("Invalid Discount Input");
                check = false;
                discount = -1;
            }
        }
        
        if (check){
            Customer c = null;
            if (discount != -1 && !CustomerCustomDiscount.getText().equalsIgnoreCase("custom discount")){
                c = new Customer(name, address, type, discount);
            }
            else if (CustomerCustomDiscount.getText().equalsIgnoreCase("custom discount")){
                c = new Customer(name, address, type);
            }

            Database.updateCustomer(name, c);
            
            RefreshCustomerTable();
            ResetCustomerFields();
        }
    }//GEN-LAST:event_UpdateCustomerActionPerformed

    private void DeleteCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteCustomerActionPerformed
        String name = CustomerNameField.getText();
        
        Database.removeCustomer(name);
        
        RefreshCustomerTable();
        ResetCustomerFields();
    }//GEN-LAST:event_DeleteCustomerActionPerformed

    private void RefreshCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshCustomerActionPerformed
        RefreshCustomerTable();
        ResetCustomerFields();
    }//GEN-LAST:event_RefreshCustomerActionPerformed

    private void RefreshSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshSaleActionPerformed
        LoadSalesMenu();
    }//GEN-LAST:event_RefreshSaleActionPerformed

    private void ProfitFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfitFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProfitFieldActionPerformed

    private void CalculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculateButtonActionPerformed
        if (sale == null){
            sale = new Sale();
        }
        if (sale.getCustomer() == null){
            if (SelectCustomerComboBox.getSelectedIndex() == 0){
                Errors.showMessage("Select a customer !");
            }
            else{
                sale.setCustomer(Database.findCustomerByName(SelectCustomerComboBox.getSelectedItem().toString()));
            }
        }
        
        
        
        TotalAmountField.setText("" + sale.calculateUndiscountedBill());
        DiscountField.setText("" + sale.calculateDiscount(sale.calculateUndiscountedBill(), sale.getCustomer()));
        ProfitField.setText("" + sale.calculateProfit(sale.getCart(), sale.getCustomer()));
    }//GEN-LAST:event_CalculateButtonActionPerformed

    private void AddToCartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddToCartButtonActionPerformed
        if (sale == null){
            sale = new Sale();
        }
        if (sale.getCustomer() == null){
            if (SelectCustomerComboBox.getSelectedIndex() == 0){
                Errors.showMessage("Select a customer !");
            }
            else{
                sale.setCustomer(Database.findCustomerByName(SelectCustomerComboBox.getSelectedItem().toString()));
            }
        }
        
        Product p = null;
        try{
            
            p = Database.findProductByName(SelectProductComboBox.getSelectedItem().toString());
        }
        catch(Exception e){
            Errors.showMessage("Error in sale");
        }
        
        int quantity = 0;
        boolean check = true;
        
        try{
            quantity = Integer.parseInt(ProductQuantityField.getText());
        }
        catch(NumberFormatException e){
            check = false;
        }
        
        
        if (check && (quantity > 0) && (quantity <= p.getStock()) ){
            p.setQuantitySelected(quantity);
            sale.addToCart(p);
            
            Errors.showMessage("Product added !");
        }
        else if (quantity <= 0){
            Errors.showMessage("Invalid Product Quantity");
        }
        else if (!(quantity <= p.getStock())){
            Errors.showMessage("Required amount not available");
        }
        else{
            Errors.showMessage("Error Occured! Try again");
        }
    }//GEN-LAST:event_AddToCartButtonActionPerformed

    private void PurchaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PurchaseButtonActionPerformed
        sale.purchase(sale.getCart(), sale.getCustomer());
        
        Backend.Analytics.totalProfit += sale.calculateProfit(sale.getCart(), sale.getCustomer());
        Backend.Analytics.totalSales += sale.getCart().size();
        
        Customer c = sale.getCustomer();
        c.setTotalSpent(c.getTotalSpent() + sale.getTotalBill());
        Database.updateCustomer(sale.getCustomer().getName(), c);
        
        Errors.showMessage("Purchase Successful !");
        Database.addSale(sale);
        sale = null;
    }//GEN-LAST:event_PurchaseButtonActionPerformed

    private void SignupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignupButtonActionPerformed
        String email = SignupEmail.getText();
        String pass = SignupPassword.getText();
        String passConfirm = SignupPassword1.getText();
        
        if (Account.isValidEmail(email) && (pass.equalsIgnoreCase(passConfirm))){
            Database.signUp(new Account(email, pass));
            Errors.showMessage("Account Registered");
        }
    }//GEN-LAST:event_SignupButtonActionPerformed
    
    
    
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
    private javax.swing.JButton AddCustomer;
    private javax.swing.JButton AddProduct;
    private javax.swing.JButton AddToCartButton;
    private javax.swing.JPanel Analytics;
    private javax.swing.JButton AnalyticsButton;
    private javax.swing.JLabel Background;
    private javax.swing.JLabel BackgroundLogin;
    private javax.swing.JLabel BackgroundSignup;
    private javax.swing.JToggleButton CalculateButton;
    private javax.swing.JToggleButton CancelSaleButton;
    private javax.swing.JPanel Customer;
    private javax.swing.JTextField CustomerAdressField;
    private javax.swing.JButton CustomerButton;
    private javax.swing.JTextField CustomerCustomDiscount;
    private javax.swing.JTextField CustomerNameField;
    private javax.swing.JTextField CustomerSearchNameField;
    private javax.swing.JTable CustomerTable;
    private javax.swing.JComboBox<String> CustomerTypeComboBox;
    private javax.swing.JButton DeleteCustomer;
    private javax.swing.JButton DeleteProduct;
    private javax.swing.JTextField DiscountField;
    private javax.swing.JButton LoginButton;
    private javax.swing.JTextField LoginEmail;
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JPasswordField LoginPassword;
    private javax.swing.JLabel LoginSignupButon;
    private javax.swing.JLabel LoginSignupButon1;
    private javax.swing.JTabbedPane LoginTab;
    private javax.swing.JTabbedPane MainTab;
    private javax.swing.JPanel Manager;
    private javax.swing.JPanel ManagerSidePanel2;
    private javax.swing.JPanel ManagerSidePanel3;
    private javax.swing.JTabbedPane ManagerTab;
    private javax.swing.JLabel MostSellingProductText;
    private javax.swing.JButton ProductButton;
    private javax.swing.JTextField ProductCatagoryField;
    private javax.swing.JTextField ProductIDField;
    private javax.swing.JTextField ProductNameField;
    private javax.swing.JTextField ProductQuantityField;
    private javax.swing.JTextField ProductRetailPriceField;
    private javax.swing.JTextField ProductSearchField;
    private javax.swing.JTextField ProductStockField;
    private javax.swing.JTable ProductTable;
    private javax.swing.JPanel ProductTablePanel;
    private javax.swing.JPanel ProductTablePanel2;
    private javax.swing.JPanel ProductTablePanel3;
    private javax.swing.JTextField ProductWholeSalePriceField;
    private javax.swing.JPanel Products;
    private javax.swing.JTextField ProfitField;
    private javax.swing.JToggleButton PurchaseButton;
    private javax.swing.JButton RefreshCustomer;
    private javax.swing.JButton RefreshProduct;
    private javax.swing.JButton RefreshSale;
    private javax.swing.JButton SaleButton;
    private javax.swing.JButton SaleButton1;
    private javax.swing.JTable SaleTable;
    private javax.swing.JPanel Sales;
    private javax.swing.JButton SearchCustomer;
    private javax.swing.JButton SearchProduct;
    private javax.swing.JComboBox<String> SelectCustomerComboBox;
    private javax.swing.JComboBox<String> SelectProductComboBox;
    private javax.swing.JButton SignupButton;
    private javax.swing.JTextField SignupEmail;
    private javax.swing.JPasswordField SignupPassword;
    private javax.swing.JPasswordField SignupPassword1;
    private javax.swing.JPanel SingupPanel;
    private javax.swing.JTextField TotalAmountField;
    private javax.swing.JLabel TotalProductsSoldText;
    private javax.swing.JLabel TotalProfitText;
    private javax.swing.JLabel TotalRegularCustomersText;
    private javax.swing.JButton UpdateCustomer;
    private javax.swing.JButton UpdateProduct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    // End of variables declaration//GEN-END:variables
}
