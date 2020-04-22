package scrum;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import oru.inf.InfDB;
import javax.swing.JOptionPane;
import oru.inf.InfException;


public class LoggInScreen extends javax.swing.JFrame {

        private InfDB idb;
        
        
        public LoggInScreen(InfDB idb) {
        initComponents();
        this.idb = idb;
        JUserName.requestFocus();
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

        JbtnLoggIn.setText("Log in");
        JbtnLoggIn.setName("JbtnLoggIn"); // NOI18N
        JbtnLoggIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnLoggInActionPerformed(evt);
            }
        });

        JlblInformatik.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JlblInformatik.setText("Informatik");
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
        JPassWord.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JPassWordKeyPressed(evt);
            }
        });

        JlblEmail.setText("Email");
        JlblEmail.setName("JlblEmail"); // NOI18N

        JlblPassword.setText("Password");
        JlblPassword.setName("JlblPassword"); // NOI18N

        JbtnRegistrera.setText("Create an account");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(JUserName)
                                .addComponent(JbtnLoggIn, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JlblEmail))
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JlblPassword)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(JPassWord)
                                .addComponent(JbtnRegistrera, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(JlblInformatik)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(JlblInformatik)
                .addGap(18, 18, 18)
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
        setLocationRelativeTo(null);
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
        ArrayList <String> emails = new ArrayList();
        boolean exists = false;
        
        if(email.isEmpty()|| pw.isEmpty()){
        JOptionPane.showMessageDialog(null, "Please enter email and password");
        JUserName.requestFocus();
        }
        else{
        try{
        if(Validation.emailValidator(email, JUserName)){
         emails = idb.fetchColumn("SELECT EMAIL FROM USER1");
         for(String e : emails){
            if(e.equals(email))
            {  
                exists = true;
                break;
            }
            }
            if(exists == true){
                
              String password = idb.fetchSingle("SELECT USER_PASSWORD from USER1 where EMAIL = '"+email+"'");
                 if(pw.equals(password))
                 {
                    String checkAdmin = idb.fetchSingle("SELECT ADMINSTATUS from USER1 where EMAIL = '"+email+"'");
                    String userID = UserIDParse.ReturnIDFromEmail(email, idb);
                    new UserPanel(idb,userID,checkAdmin).setVisible(true);
                    dispose();
                 }
                 else{
                     JOptionPane.showMessageDialog(null, "This password doesn't match the entered email");
                     JPassWord.requestFocus();  
                 }
            }
            else{
                JOptionPane.showMessageDialog(null, "This email isn't registered");
                JUserName.requestFocus();
            }
            }
         }
         
         catch(InfException e){
          JOptionPane.showMessageDialog(null, "Wrong email and password");
          System.out.println(e.getMessage());  
          JUserName.requestFocus();
         }
        
        }
    }//GEN-LAST:event_JbtnLoggInActionPerformed

    private void JbtnRegistreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnRegistreraActionPerformed
        new CreateAccount(idb).setVisible(true);
        dispose();
    }//GEN-LAST:event_JbtnRegistreraActionPerformed

    private void JPassWordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JPassWordKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)        
        JbtnLoggIn.doClick();
    }//GEN-LAST:event_JPassWordKeyPressed


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
