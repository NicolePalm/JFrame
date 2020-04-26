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

        jPanel1 = new javax.swing.JPanel();
        JlblInformatik = new javax.swing.JLabel();
        JlblPassword = new javax.swing.JLabel();
        JlblEmail = new javax.swing.JLabel();
        JUserName = new javax.swing.JTextField();
        JPassWord = new javax.swing.JPasswordField();
        JbtnLoggIn = new javax.swing.JButton();
        JbtnRegistrera = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("JLoggIn"); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        JlblInformatik.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        JlblInformatik.setForeground(new java.awt.Color(255, 255, 255));
        JlblInformatik.setText("Informatics system");
        JlblInformatik.setName("JlblInloggning"); // NOI18N

        JlblPassword.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        JlblPassword.setForeground(new java.awt.Color(255, 255, 255));
        JlblPassword.setText("Password");
        JlblPassword.setName("JlblPassword"); // NOI18N

        JlblEmail.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        JlblEmail.setForeground(new java.awt.Color(255, 255, 255));
        JlblEmail.setText("Email");
        JlblEmail.setName("JlblEmail"); // NOI18N

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

        JbtnLoggIn.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        JbtnLoggIn.setText("Log in");
        JbtnLoggIn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JbtnLoggIn.setName("JbtnLoggIn"); // NOI18N
        JbtnLoggIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnLoggInActionPerformed(evt);
            }
        });

        JbtnRegistrera.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        JbtnRegistrera.setText("Create an account");
        JbtnRegistrera.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JbtnRegistrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnRegistreraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 93, Short.MAX_VALUE)
                .addComponent(JlblInformatik)
                .addGap(90, 90, 90))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(JPassWord, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(JUserName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(JbtnLoggIn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JbtnRegistrera, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(JlblPassword))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(JlblEmail)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(JlblInformatik)
                .addGap(18, 18, 18)
                .addComponent(JlblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JlblPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPassWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(JbtnLoggIn)
                .addGap(18, 18, 18)
                .addComponent(JbtnRegistrera)
                .addContainerGap(44, Short.MAX_VALUE))
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
        if(Validation.inmatningFnuttar(email) && Validation.inmatningFnuttar(pw)){
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
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
