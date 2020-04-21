package scrum;
import java.sql.SQLException;
import oru.inf.InfDB;


import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oru.inf.InfException;

 //@author Danie
 
/**
 *
 * @author Danie
 */
public class LoggInScreen extends javax.swing.JFrame {

        private InfDB idb;
        
        public LoggInScreen(InfDB idb) {
        initComponents();
        this.idb = idb;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JbtnLoggIn = new javax.swing.JButton();
        JlblInformatik = new javax.swing.JLabel();
        JUserName = new javax.swing.JTextField();
        JPassWord = new javax.swing.JPasswordField();
        JlblEmail = new javax.swing.JLabel();
        JlblPassword = new javax.swing.JLabel();
        JbtnRegistrera = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("JLoggIn"); // NOI18N

        JbtnLoggIn.setText("Logga in");
        JbtnLoggIn.setName("JbtnLoggIn"); // NOI18N
        JbtnLoggIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnLoggInActionPerformed(evt);
            }
        });

        JlblInformatik.setText("Inlogging för Informatiks kommunikationssystem");
        JlblInformatik.setName("JlblInloggning"); // NOI18N

        JUserName.setName("JEmail"); // NOI18N
        JUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JUserNameActionPerformed(evt);
            }
        });

        JPassWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPassWordActionPerformed(evt);
            }
        });

        JlblEmail.setText("Email");
        JlblEmail.setName("JlblEmail"); // NOI18N

        JlblPassword.setText("Lösenord");
        JlblPassword.setName("JlblPassword"); // NOI18N

        JbtnRegistrera.setText("Registrera dig");
        JbtnRegistrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnRegistreraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(JlblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JlblPassword)
                .addGap(157, 157, 157))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(101, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JlblInformatik)
                        .addGap(171, 171, 171))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(JUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(JbtnLoggIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JPassWord, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(JbtnRegistrera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(98, 98, 98))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(JlblInformatik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JlblEmail)
                    .addComponent(JlblPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JPassWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JbtnLoggIn)
                    .addComponent(JbtnRegistrera))
                .addGap(69, 69, 69))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JUserNameActionPerformed

    private void JPassWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPassWordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPassWordActionPerformed

    private void JbtnLoggInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnLoggInActionPerformed
     
        String email = JUserName.getText();
        String pw = JPassWord.getText();
        
        if(email.isEmpty()|| pw.isEmpty()){
        JOptionPane.showMessageDialog(null, "Ange email och lösenord!");
        JUserName.requestFocus();
        }
        else{
        try{
         String checkPW = "SELECT USER_PASSWORD from USER1 where EMAIL = '"+email+"'";
         String checkAdmin = "SELECT ADMINSTATUS from USER1 where EMAIL = '"+email+"'";
         
         try{
         String svarPW = idb.fetchSingle(checkPW);
         String svarAdmin = idb.fetchSingle(checkAdmin);
         int userID = UserIDParse.ReturnIDFromEmail(email, idb);
         if(svarPW.equals(pw)){
            
                 new UserPanel(idb,userID,svarAdmin).setVisible(true);
                 dispose();
             
         }
         }
         catch(NumberFormatException e){
          JOptionPane.showMessageDialog(null, "Fel inloggningsuppgifter!");
          System.out.println(e.getMessage());  
          JUserName.requestFocus();
         }
         }
         catch(InfException loginFail){
         JOptionPane.showMessageDialog(null, "Ange email och lösenord!");
         System.out.println(loginFail.getMessage());    
         }
         }
    }//GEN-LAST:event_JbtnLoggInActionPerformed

    private void JbtnRegistreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnRegistreraActionPerformed
        new CreateAccount(idb).setVisible(true);
        dispose();
    }//GEN-LAST:event_JbtnRegistreraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField JPassWord;
    private javax.swing.JTextField JUserName;
    private javax.swing.JButton JbtnLoggIn;
    private javax.swing.JButton JbtnRegistrera;
    private javax.swing.JLabel JlblEmail;
    private javax.swing.JLabel JlblInformatik;
    private javax.swing.JLabel JlblPassword;
    // End of variables declaration//GEN-END:variables
}
