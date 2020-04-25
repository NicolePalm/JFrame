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

        lblTitel = new javax.swing.JLabel();
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
        jBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitel.setText("Update user info");

        lblEmail.setText("Email:");

        lblFirstname.setText("Firstname:");

        lblLastname.setText("Lastname:");

        tfLastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfLastnameActionPerformed(evt);
            }
        });

        lblPassword.setText("Password:");

        jLabel1.setText("Confirm password:");

        btnChangeInfo.setText("Update info");
        btnChangeInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeInfoActionPerformed(evt);
            }
        });

        jBack.setText("Back");
        jBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBack)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pfConfirmPassword)
                            .addComponent(jLabel1)
                            .addComponent(pfPassword)
                            .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfLastname)
                            .addComponent(lblLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfFirstname)
                            .addComponent(lblFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfEmail)
                            .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChangeInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblTitel))
                .addGap(0, 96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitel)
                    .addComponent(jBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addGap(18, 18, 18)
                .addComponent(btnChangeInfo)
                .addGap(0, 25, Short.MAX_VALUE))
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
                if(Validation.validEmail(email, currentEmail, emails)&& Validation.inmatningFnuttar(email) && Validation.inmatningFnuttar(firstname) && Validation.inmatningFnuttar(lastname) && Validation.inmatningFnuttar(password) && Validation.inmatningFnuttar(confirmPassword))
              {
                    if(password.equals(confirmPassword)) {
                        if(password.length() <= 25){
                        String updateSql = "UPDATE USER1 SET EMAIL ='"+email+"', FIRSTNAME = '"+firstname+"', LASTNAME = '"+lastname+"', USER_PASSWORD = '"+password+"' WHERE USER_ID ='"+currentUser+"'";
                        idb.update(updateSql);
                        JOptionPane.showMessageDialog(null, "User info changed");
                        fillTf();
                        
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
