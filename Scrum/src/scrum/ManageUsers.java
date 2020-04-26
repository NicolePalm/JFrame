/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum;

import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
  
 jUserList.removeAllItems();
    
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

        jPanel1 = new javax.swing.JPanel();
        jHome = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jUserList = new javax.swing.JComboBox<>();
        jUnAdmin = new javax.swing.JButton();
        jMakeAdmin = new javax.swing.JButton();
        jDeleteUser = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jUserInfo = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(68, 68, 121));

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jHome.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jHome.setText("Back");
        jHome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHomeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Manage Users");

        jUserList.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jUserList.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jUserList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jUserListItemStateChanged(evt);
            }
        });
        jUserList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUserListMouseClicked(evt);
            }
        });

        jUnAdmin.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jUnAdmin.setText("Remove admin status");
        jUnAdmin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jUnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUnAdminActionPerformed(evt);
            }
        });

        jMakeAdmin.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jMakeAdmin.setText("Make admin");
        jMakeAdmin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMakeAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMakeAdminActionPerformed(evt);
            }
        });

        jDeleteUser.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jDeleteUser.setText("Delete User");
        jDeleteUser.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteUserActionPerformed(evt);
            }
        });

        jUserInfo.setEditable(false);
        jUserInfo.setColumns(20);
        jUserInfo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jUserInfo.setRows(5);
        jScrollPane1.setViewportView(jUserInfo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jHome, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jUnAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jMakeAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDeleteUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jUserList, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 54, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jHome))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jUserList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jUnAdmin)
                    .addComponent(jMakeAdmin)
                    .addComponent(jDeleteUser))
                .addGap(0, 47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jUserListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUserListMouseClicked
       
    }//GEN-LAST:event_jUserListMouseClicked

    private void jUnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUnAdminActionPerformed
        try {
            idb.update("UPDATE USER1 SET ADMINSTATUS = 0 WHERE EMAIL = '"+userToEdit+"'");
            jUserInfo.setText("User is no longer admin");
            jMakeAdmin.setVisible(true);
            jDeleteUser.setVisible(true);
            jUnAdmin.setVisible(false);
            
        } catch (InfException ex) {
            Logger.getLogger(ManageUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jUnAdminActionPerformed

    private void jMakeAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMakeAdminActionPerformed
       try {
            idb.update("UPDATE USER1 SET ADMINSTATUS = 1 WHERE EMAIL = '"+userToEdit+"'");
            jUserInfo.setText("User is now admin");
            jDeleteUser.setVisible(false);
            jMakeAdmin.setVisible(false);
            jUnAdmin.setVisible(true);
            
        } catch (InfException ex) {
            Logger.getLogger(ManageUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMakeAdminActionPerformed

    private void jDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteUserActionPerformed
        try {
            String id = idb.fetchSingle("SELECT USER_ID FROM USER1 WHERE EMAIL ='"+userToEdit+"'");
            idb.delete("DELETE FROM COMMENT WHERE COMMENTER_ID ='"+id+"'");
            idb.delete("DELETE FROM POST WHERE POSTER_ID ='"+id+"'");
            idb.delete("DELETE FROM MEETINGNOTES WHERE USERID ='"+id+"'");
            idb.delete("DELETE FROM MEETINGREQUEST WHERE RECEIVER_ID ='"+id+"'");
            idb.delete("DELETE FROM MEETING WHERE MEETINGCREATER_ID ='"+id+"'");
            idb.delete("DELETE FROM USER1 WHERE USER_ID ='"+id+"'");
            jUserInfo.setText("User has been deleted!");
            
            jMakeAdmin.setVisible(false);
            jDeleteUser.setVisible(false);
            jUnAdmin.setVisible(false);
            fillCombobox();

            userToEdit = "";
            
        } catch (InfException ex) {
            Logger.getLogger(ManageUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jDeleteUserActionPerformed

    private void jHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHomeActionPerformed
       ReturnToHome.CreateHomeScreen(idb, currentUser);
       dispose();
    }//GEN-LAST:event_jHomeActionPerformed

    private void jUserListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jUserListItemStateChanged
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
        
       
    }//GEN-LAST:event_jUserListItemStateChanged

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jDeleteUser;
    private javax.swing.JButton jHome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jMakeAdmin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jUnAdmin;
    private javax.swing.JTextArea jUserInfo;
    private javax.swing.JComboBox<String> jUserList;
    // End of variables declaration//GEN-END:variables
}

