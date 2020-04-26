package scrum;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.ArrayList;

public class CreateAccount extends javax.swing.JFrame {

        private InfDB idb;
        
        public CreateAccount(InfDB idb) {
        initComponents();
        this.idb = idb;
        JFirstname.requestFocus();
        
    }
        public void RegistreraDig() {
            
            String Firstname = GetString.hamtaFalt(JFirstname);
            String Lastname = GetString.hamtaFalt(JLastname);
            String Email = GetString.hamtaFalt(JEmail);
            String Password = GetString.hamtaLosenord(JPassword);
            String PasswordIgen = GetString.hamtaLosenord(JPasswordIgen);
            boolean emptyFields = false;
            
            if(Firstname.isEmpty() || Lastname.isEmpty() || Email.isEmpty() || Password.isEmpty() || PasswordIgen.isEmpty()){
                JOptionPane.showMessageDialog(null, "Don't leave any field blank");
                emptyFields = true;
            }
            
            if(emptyFields == false){
            if(Email.length() <= 30){
            boolean InvalidEmail = validEmail(Email);
            if(Validation.emailValidator(Email, JEmail) && Validation.inmatningFnuttar(Email) && Validation.inmatningFnuttar(Firstname) && Validation.inmatningFnuttar(Lastname) && Validation.inmatningFnuttar(Password)) {
            if(InvalidEmail == false){
                if(Firstname.length() <= 20 && Lastname.length() <= 20){
                if(Password.equals(PasswordIgen)){
                    if(Password.length() <= 25){
            boolean test = NewUser.InsertNewUser(Firstname, Lastname, Email, Password,idb);
            
            if(test = true){
            JOptionPane.showMessageDialog(null, "Welcome "+Firstname+"!");
            String userID = UserIDParse.ReturnIDFromEmail(Email, idb);
            new UserPanel(idb,userID,"0").setVisible(true);
            dispose();
            }
                }
            else{
                    JOptionPane.showMessageDialog(null, "Password can only be 25 characters");
                    JPassword.requestFocus();
           }
            }
            else{
                   JOptionPane.showMessageDialog(null, "The password doesn't match");
                   JPassword.requestFocus();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Name can only be 20 characters");
            }
            }
           
            else{ 
            JOptionPane.showMessageDialog(null, "The email is already registered");
            JEmail.requestFocus();
            }  
            }
            
            }
            else{
                JOptionPane.showMessageDialog(null, "Email can only be 30 characters");
                JEmail.requestFocus();
            }
        }
        }
        
        
        
        public boolean validEmail(String Email){
            boolean InvalidEmail = false;
            try{
            ArrayList<String> emails = new ArrayList<String>();
            emails = idb.fetchColumn("select EMAIL from USER1");
            for(String mails : emails){
            if(mails.equals(Email)){
            InvalidEmail = true;
            return InvalidEmail;
            }
            }
            }
            catch(InfException regFail){
            System.out.println(regFail.getMessage()); 
            }
            return InvalidEmail;
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        JlblRegistering = new javax.swing.JLabel();
        JlblFirstname = new javax.swing.JLabel();
        JFirstname = new javax.swing.JTextField();
        JlblLastname = new javax.swing.JLabel();
        JLastname = new javax.swing.JTextField();
        JlblEmail = new javax.swing.JLabel();
        JEmail = new javax.swing.JTextField();
        JlblPassword = new javax.swing.JLabel();
        JPassword = new javax.swing.JPasswordField();
        JlblPasswordIgen = new javax.swing.JLabel();
        JPasswordIgen = new javax.swing.JPasswordField();
        JbtnRegistreraDig = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("JRegistrera"); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        btnBack.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnBack.setText("Back");
        btnBack.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        JlblRegistering.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        JlblRegistering.setForeground(new java.awt.Color(255, 255, 255));
        JlblRegistering.setText("Create account");
        JlblRegistering.setName("JlblRegistering"); // NOI18N

        JlblFirstname.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        JlblFirstname.setForeground(new java.awt.Color(255, 255, 255));
        JlblFirstname.setText("Firstname");
        JlblFirstname.setName("JlblFirstname"); // NOI18N

        JFirstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JFirstnameActionPerformed(evt);
            }
        });

        JlblLastname.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        JlblLastname.setForeground(new java.awt.Color(255, 255, 255));
        JlblLastname.setText("Lastname");
        JlblLastname.setName("JlblLastname"); // NOI18N

        JLastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JLastnameActionPerformed(evt);
            }
        });

        JlblEmail.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        JlblEmail.setForeground(new java.awt.Color(255, 255, 255));
        JlblEmail.setText("Email address");
        JlblEmail.setName("JlblEmail"); // NOI18N

        JlblPassword.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        JlblPassword.setForeground(new java.awt.Color(255, 255, 255));
        JlblPassword.setText("Password");
        JlblPassword.setName("JlblPassword"); // NOI18N

        JlblPasswordIgen.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        JlblPasswordIgen.setForeground(new java.awt.Color(255, 255, 255));
        JlblPasswordIgen.setText("Confirm password");
        JlblPasswordIgen.setName("JlblPasswordIgen"); // NOI18N

        JPasswordIgen.setName("JPasswordIgen"); // NOI18N

        JbtnRegistreraDig.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        JbtnRegistreraDig.setText("Create account");
        JbtnRegistreraDig.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JbtnRegistreraDig.setName("JbtnRegistreraDig"); // NOI18N
        JbtnRegistreraDig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnRegistreraDigActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(JlblPassword)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JPasswordIgen, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JFirstname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JlblFirstname, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(JlblLastname, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(65, 65, 65)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 148, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JlblRegistering)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JbtnRegistreraDig, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(JlblEmail)
                        .addGap(191, 191, 191))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(JlblPasswordIgen)
                        .addGap(177, 177, 177))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JlblRegistering, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addComponent(JlblFirstname)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JlblLastname)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JlblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JlblPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JlblPasswordIgen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPasswordIgen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(JbtnRegistreraDig)
                .addGap(0, 49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JFirstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JFirstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JFirstnameActionPerformed

    private void JLastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JLastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JLastnameActionPerformed

    private void JbtnRegistreraDigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnRegistreraDigActionPerformed
        RegistreraDig();
    }//GEN-LAST:event_JbtnRegistreraDigActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new LoggInScreen(idb).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JEmail;
    private javax.swing.JTextField JFirstname;
    private javax.swing.JTextField JLastname;
    private javax.swing.JPasswordField JPassword;
    private javax.swing.JPasswordField JPasswordIgen;
    private javax.swing.JButton JbtnRegistreraDig;
    private javax.swing.JLabel JlblEmail;
    private javax.swing.JLabel JlblFirstname;
    private javax.swing.JLabel JlblLastname;
    private javax.swing.JLabel JlblPassword;
    private javax.swing.JLabel JlblPasswordIgen;
    private javax.swing.JLabel JlblRegistering;
    private javax.swing.JButton btnBack;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

