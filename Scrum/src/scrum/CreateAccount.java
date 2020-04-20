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
        JFirstname = new javax.swing.JTextField();
        JLastname = new javax.swing.JTextField();
        JEmail = new javax.swing.JTextField();
        JPassword = new javax.swing.JPasswordField();
        JlblFirstname = new javax.swing.JLabel();
        JlblLastname = new javax.swing.JLabel();
        JlblEmail = new javax.swing.JLabel();
        JlblPassword = new javax.swing.JLabel();
        JbtnRegistreraDig = new javax.swing.JButton();
        JPasswordIgen = new javax.swing.JPasswordField();
        JlblPasswordIgen = new javax.swing.JLabel();
        JlblRegistering = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("JRegistrera"); // NOI18N

        JFirstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JFirstnameActionPerformed(evt);
            }
        });

        JLastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JLastnameActionPerformed(evt);
            }
        });

        JPassword.setActionCommand("<Not Set>");

        JlblFirstname.setText("Förnamn");
        JlblFirstname.setName("JlblFirstname"); // NOI18N

        JlblLastname.setText("Efternamn");
        JlblLastname.setName("JlblLastname"); // NOI18N

        JlblEmail.setText("Email adress");
        JlblEmail.setName("JlblEmail"); // NOI18N

        JlblPassword.setText("Lösenord");
        JlblPassword.setName("JlblPassword"); // NOI18N

        JbtnRegistreraDig.setText("Registrera dig");
        JbtnRegistreraDig.setName("JbtnRegistreraDig"); // NOI18N
        JbtnRegistreraDig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnRegistreraDigActionPerformed(evt);
            }
        });

        JPasswordIgen.setName("JPasswordIgen"); // NOI18N

        JlblPasswordIgen.setText("Upprepa lösenord");
        JlblPasswordIgen.setName("JlblPasswordIgen"); // NOI18N

        JlblRegistering.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JlblRegistering.setText("Registrering");
        JlblRegistering.setName("JlblRegistering"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JlblPasswordIgen)
                            .addComponent(JlblEmail)
                            .addComponent(JlblPassword)
                            .addComponent(JlblLastname)
                            .addComponent(JlblFirstname)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(JPassword)
                                    .addComponent(JEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLastname, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JFirstname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JPasswordIgen))
                                .addGap(33, 33, 33)
                                .addComponent(JbtnRegistreraDig))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JlblRegistering, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JlblRegistering, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(30, 30, 30)
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
                .addGap(21, 21, 21)
                .addComponent(JlblPasswordIgen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JPasswordIgen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JbtnRegistreraDig))
                .addGap(28, 28, 28))
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
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

