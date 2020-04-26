package scrum;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

public class UpdatePersonalInfo extends javax.swing.JFrame {

    private InfDB idb;
    private String currentUser;
    
    public UpdatePersonalInfo(InfDB idb, String id) {
        initComponents();
        this.idb = idb;
        this.currentUser = id;
        fillTf(); 
    }

   public void fillTf() {
        try{
            String emailSql = "SELECT EMAIL FROM USER1 WHERE USER_ID = '" +currentUser+"'";
            String email = idb.fetchSingle(emailSql);
            tfEmail.setText(email);
            
            String firstnameSql = "SELECT FIRSTNAME FROM USER1 WHERE USER_ID = '" +currentUser+"'";
            tfFirstname.setText(idb.fetchSingle(firstnameSql));
            
            String lastnameSql = "SELECT LASTNAME FROM USER1 WHERE USER_ID = '" +currentUser+"'";
            tfLastname.setText(idb.fetchSingle(lastnameSql));
        }
        catch(InfException e) {
            System.out.println(e);
        }
        
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitel = new javax.swing.JLabel();
        jBack = new javax.swing.JButton();
        lblEmail = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        lblFirstname = new javax.swing.JLabel();
        tfFirstname = new javax.swing.JTextField();
        lblLastname = new javax.swing.JLabel();
        tfLastname = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        pfPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        pfConfirmPassword = new javax.swing.JPasswordField();
        btnChangeInfo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        lblTitel.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lblTitel.setForeground(new java.awt.Color(255, 255, 255));
        lblTitel.setText("Update user info");

        jBack.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jBack.setText("Back");
        jBack.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBackActionPerformed(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("Email:");

        lblFirstname.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblFirstname.setForeground(new java.awt.Color(255, 255, 255));
        lblFirstname.setText("Firstname:");

        lblLastname.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblLastname.setForeground(new java.awt.Color(255, 255, 255));
        lblLastname.setText("Lastname:");

        tfLastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLastnameActionPerformed(evt);
            }
        });

        lblPassword.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword.setText("Password:");

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Confirm password:");

        btnChangeInfo.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnChangeInfo.setText("Update");
        btnChangeInfo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnChangeInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblFirstname)
                        .addGap(154, 154, 154))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(127, 127, 127))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jBack, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pfConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitel)
                    .addComponent(tfFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnChangeInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitel)
                        .addGap(18, 18, 18)
                        .addComponent(lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblFirstname)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblLastname)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pfConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnChangeInfo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBack)))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfLastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfLastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLastnameActionPerformed

    private void btnChangeInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeInfoActionPerformed

        if(Validation.tfHarVarde(tfEmail, "Enter your email") && Validation.tfHarVarde(pfPassword, "Enter your password") && Validation.tfHarVarde(tfFirstname, "Enter your firstname") && Validation.tfHarVarde(tfLastname, "Enter your lastname") && Validation.tfHarVarde(pfConfirmPassword, "Confirm your password")) {
            try {
                ArrayList<String> emails;
                emails = idb.fetchColumn("select EMAIL from USER1");
                String currentEmailSql = "SELECT EMAIL FROM USER1 WHERE USER_ID = '"+currentUser+"'";
                String currentEmail = idb.fetchSingle(currentEmailSql);

                String email = tfEmail.getText();
                String firstname = tfFirstname.getText();
                String lastname = tfLastname.getText();
                String password = pfPassword.getText();
                String confirmPassword = pfConfirmPassword.getText();
                 if(email.length() <= 30){
                     if(firstname.length() <= 20 && lastname.length() <= 20){
                if(Validation.validEmail(email, currentEmail, emails)&& email.contains("@")&& email.contains(".")&& Validation.inmatningFnuttar(email) && Validation.inmatningFnuttar(firstname) && Validation.inmatningFnuttar(lastname) && Validation.inmatningFnuttar(password) && Validation.inmatningFnuttar(confirmPassword))
              {
                    if(password.equals(confirmPassword)) {
                        if(password.length() <= 25){
                        String updateSql = "UPDATE USER1 SET EMAIL ='"+email+"', FIRSTNAME = '"+firstname+"', LASTNAME = '"+lastname+"', USER_PASSWORD = '"+password+"' WHERE USER_ID ='"+currentUser+"'";
                        idb.update(updateSql);
                        JOptionPane.showMessageDialog(null, "User info changed");
                        ReturnToHome.CreateHomeScreen(idb, currentUser);
                        
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Password can only be 25 characters");
                        pfPassword.requestFocus();
                    }
                    }
                    
                    else{
                        JOptionPane.showMessageDialog(null, "Passwords does not match");
                        pfConfirmPassword.requestFocus();
                    }
               }
                else{
                    JOptionPane.showMessageDialog(null, "Not valid email adress");
                }
            }
                     else{
                     JOptionPane.showMessageDialog(null, "Name can only be 20 characters");
                 }
                 }
               
                 else{
                     JOptionPane.showMessageDialog(null, "Email can only be 30 characters");
                     tfEmail.requestFocus();
                 }

            }
            catch(InfException e) {
                System.out.println(e);
            }
       
        }
        fillTf();
    }//GEN-LAST:event_btnChangeInfoActionPerformed

    private void jBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackActionPerformed
        ReturnToHome.CreateHomeScreen(idb, currentUser);
        dispose();
    }//GEN-LAST:event_jBackActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangeInfo;
    private javax.swing.JButton jBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFirstname;
    private javax.swing.JLabel lblLastname;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTitel;
    private javax.swing.JPasswordField pfConfirmPassword;
    private javax.swing.JPasswordField pfPassword;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfFirstname;
    private javax.swing.JTextField tfLastname;
    // End of variables declaration//GEN-END:variables
}
