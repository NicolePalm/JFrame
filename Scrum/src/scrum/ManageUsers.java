/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import oru.inf.InfDB;
import oru.inf.InfException;


public class ManageUsers extends javax.swing.JFrame {
    private InfDB idb;
    private String currentUser;
    private String userToEdit;
    private String adminStatus;
  
    public ManageUsers(InfDB idb, String user, String status) {
        initComponents();
        this.idb = idb;
        this.currentUser = user;
        this.adminStatus = status;
        fillCombobox();
        jMakeAdmin.setVisible(false);
        jDeleteUser.setVisible(false);
        jUnAdmin.setVisible(false);
        jUserInfo.setLineWrap(true);

    }
 
    
public void fillCombobox(){
        
ArrayList <String> getEmails = new ArrayList();
try{        
getEmails = idb.fetchColumn("select EMAIL from USER1 where USER_ID <> '"+currentUser+"'");

for(String emails : getEmails){
    jUserList.addItem(emails);
}
 
}
catch(Exception e){
System.out.println(e);
}
}    

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jUserList = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jUserInfo = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jDeleteUser = new javax.swing.JButton();
        jMakeAdmin = new javax.swing.JButton();
        jHome = new javax.swing.JButton();
        jSelectUser = new javax.swing.JButton();
        jUnAdmin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jUserList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUserListMouseClicked(evt);
            }
        });

        jUserInfo.setEditable(false);
        jUserInfo.setColumns(20);
        jUserInfo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jUserInfo.setRows(5);
        jScrollPane1.setViewportView(jUserInfo);

        jLabel1.setText("Manage users");

        jDeleteUser.setText("Delete User");

        jMakeAdmin.setText("Make admin");

        jHome.setText("Back");

        jSelectUser.setText("Select user");
        jSelectUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSelectUserActionPerformed(evt);
            }
        });

        jUnAdmin.setText("Remove admin status");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jHome)
                                .addGap(127, 127, 127)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jUserList, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSelectUser, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 71, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jUnAdmin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jMakeAdmin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDeleteUser)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jHome))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jUserList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSelectUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jDeleteUser)
                    .addComponent(jMakeAdmin)
                    .addComponent(jUnAdmin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jUserListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUserListMouseClicked
       
    }//GEN-LAST:event_jUserListMouseClicked

    private void jSelectUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSelectUserActionPerformed
        userToEdit = jUserList.getSelectedItem().toString();
            String firstName;
            String lastName;
            String passWord;
            String adminStatus;
            jUserInfo.setText("");
            
        
        try {
            firstName = idb.fetchSingle("SELECT FIRSTNAME FROM USER1 WHERE EMAIL ='"+userToEdit+"'");
            lastName = idb.fetchSingle("SELECT LASTNAME FROM USER1 WHERE EMAIL ='"+userToEdit+"'");
            passWord = idb.fetchSingle("SELECT USER_PASSWORD FROM USER1 WHERE EMAIL ='"+userToEdit+"'");
            adminStatus = idb.fetchSingle("SELECT ADMINSTATUS FROM USER1 WHERE EMAIL ='"+userToEdit+"'");
            jMakeAdmin.setVisible(true);
            jDeleteUser.setVisible(true);
            jUnAdmin.setVisible(false);
            
            if(adminStatus.equals("1")){
            jDeleteUser.setVisible(false);
            jMakeAdmin.setVisible(false);
            jUnAdmin.setVisible(true);
            adminStatus = "User is an admin";
            }
            else{
            adminStatus = "User is not an admin";
            }
            
            jUserInfo.append("Name : "+firstName+" "+lastName);
            jUserInfo.append("\n");
            
            jUserInfo.append("Email : "+userToEdit);
            jUserInfo.append("\n");
            
            jUserInfo.append("Password : "+passWord);
            jUserInfo.append("\n");
            
            jUserInfo.append(adminStatus);
            jUserInfo.append("\n");
            
            
        } catch (InfException ex) {
            Logger.getLogger(ManageUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
        
    }//GEN-LAST:event_jSelectUserActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jDeleteUser;
    private javax.swing.JButton jHome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jMakeAdmin;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jSelectUser;
    private javax.swing.JButton jUnAdmin;
    private javax.swing.JTextArea jUserInfo;
    private javax.swing.JComboBox<String> jUserList;
    // End of variables declaration//GEN-END:variables
}
