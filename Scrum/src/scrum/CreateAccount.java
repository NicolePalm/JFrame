/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.ArrayList;

/**
 *
 * @author Danie
 */
public class CreateAccount extends javax.swing.JFrame {

        private InfDB idb;
        
        public CreateAccount(InfDB idb) {
        initComponents();
        this.idb = idb;
        
    }
        public void RegistreraDig() {
            
            String Firstname = GetString.hamtaFalt(JFirstname);
            String Lastname = GetString.hamtaFalt(JLastname);
            String Email = GetString.hamtaFalt(JEmail);
            String Password = GetString.hamtaLosenord(JPassword);
            String PasswordIgen = GetString.hamtaLosenord(JPasswordIgen);
            boolean emptyFields = false;
            
            if(Firstname.isEmpty() || Lastname.isEmpty() || Email.isEmpty() || Password.isEmpty() || PasswordIgen.isEmpty()){
                JOptionPane.showMessageDialog(null, "Var vänlig och fyll i alla fält!");
                emptyFields = true;
            }
            
            if(emptyFields == false){
            boolean InvalidEmail = validEmail(Email);
            
            if(Password.equals(PasswordIgen) && InvalidEmail == false){ 
            boolean test = NewUser.InsertNewUser(Firstname, Lastname, Email, Password,idb);
            
            if(test = true){
            JOptionPane.showMessageDialog(null, "Välkommen "+Firstname+"!");
            int userID = UserIDParse.ReturnIDFromEmail(Email, idb);
            new UserPanel(idb,userID).setVisible(true);
            dispose();
            }
           }
            else{ 
            JOptionPane.showMessageDialog(null, "Lösenord matchar inte eller email redan tagen");
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

        JlblRegistering.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        JlblRegistering.setForeground(new java.awt.Color(255, 255, 255));
        JlblRegistering.setText("Registrering");
        JlblRegistering.setName("JlblRegistering"); // NOI18N

        JlblFirstname.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        JlblFirstname.setForeground(new java.awt.Color(255, 255, 255));
        JlblFirstname.setText("Förnamn");
        JlblFirstname.setName("JlblFirstname"); // NOI18N

        JFirstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JFirstnameActionPerformed(evt);
            }
        });

        JlblLastname.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        JlblLastname.setForeground(new java.awt.Color(255, 255, 255));
        JlblLastname.setText("Efternamn");
        JlblLastname.setName("JlblLastname"); // NOI18N

        JLastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JLastnameActionPerformed(evt);
            }
        });

        JlblEmail.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        JlblEmail.setForeground(new java.awt.Color(255, 255, 255));
        JlblEmail.setText("Email adress");
        JlblEmail.setName("JlblEmail"); // NOI18N

        JlblPassword.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        JlblPassword.setForeground(new java.awt.Color(255, 255, 255));
        JlblPassword.setText("Lösenord");
        JlblPassword.setName("JlblPassword"); // NOI18N

        JlblPasswordIgen.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        JlblPasswordIgen.setForeground(new java.awt.Color(255, 255, 255));
        JlblPasswordIgen.setText("Upprepa lösenord");
        JlblPasswordIgen.setName("JlblPasswordIgen"); // NOI18N

        JPasswordIgen.setName("JPasswordIgen"); // NOI18N

        JbtnRegistreraDig.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        JbtnRegistreraDig.setText("Registrera dig");
        JbtnRegistreraDig.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 124, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(JLastname, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JFirstname, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JEmail, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JPassword, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JPasswordIgen, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JlblRegistering, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                .addGap(139, 139, 139))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(JlblFirstname))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(JlblLastname))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(JlblEmail))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(JlblPassword))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(JlblPasswordIgen))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(JbtnRegistreraDig)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(JlblRegistering)
                .addGap(23, 23, 23)
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
                .addGap(27, 27, 27)
                .addComponent(JbtnRegistreraDig)
                .addGap(0, 38, Short.MAX_VALUE))
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

