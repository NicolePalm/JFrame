/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Danie
 */
public class ViewFullPost extends javax.swing.JFrame {
    private InfDB idb;
    private final String currentUser;
    private final String currentPost;
    
    public ViewFullPost(InfDB idb, int userID, int postID) {
        initComponents();
        this.currentPost = Integer.toString(postID);
        this.currentUser = Integer.toString(userID);
        this.idb = idb;
        this.jTitle.setText(GetPostTitle());
        this.jpostDate.setText(GetPostDate());
        this.jAuthor.setText(GetPosterName());
        this.jPostBody.setText(GetPostContent());
        UsePostFile();
        
    }
public String GetPostTitle(){
        String title = "";
        try {
            title = idb.fetchSingle("SELECT TITLE FROM POST WHERE POST_ID ='"+currentPost+"'");
            
        } catch (InfException ex) {
            Logger.getLogger(ViewFullPost.class.getName()).log(Level.SEVERE, null, ex);
        }
        return title;
}
public String GetPostDate(){
        String date = "";
        String time = "";
        String dateandtime = "";
        try {
            time = idb.fetchSingle("SELECT POSTTIME FROM POST WHERE POST_ID ='"+currentPost+"'");
            date = idb.fetchSingle("SELECT POSTDATE FROM POST WHERE POST_ID ='"+currentPost+"'");
            dateandtime = time+ "  "+date;
            
        } catch (InfException ex) {
            Logger.getLogger(ViewFullPost.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dateandtime;
}
public String GetPostContent(){
        String content = "";
        try {
            content = idb.fetchSingle("SELECT CONTENT FROM POST WHERE POST_ID ='"+currentPost+"'");
            
        } catch (InfException ex) {
            Logger.getLogger(ViewFullPost.class.getName()).log(Level.SEVERE, null, ex);
        }
        return content;
}
public String GetPosterName(){
        String firstName = "";
        String lastName = "";
        String posterID = "";
        String fullName = "";
        try {
            posterID = idb.fetchSingle("SELECT POSTER_ID FROM POST WHERE POST_ID ='"+currentPost+"'");
            firstName = idb.fetchSingle("SELECT FIRSTNAME FROM USER1 WHERE USER_ID ="+posterID);
            lastName = idb.fetchSingle("SELECT LASTNAME FROM USER1 WHERE USER_ID ="+posterID);
            fullName = firstName +" "+lastName;
            

            
        } catch (InfException ex) {
            Logger.getLogger(ViewFullPost.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fullName;
}

public void UsePostFile(){
    String filePath = "";
    String fileExt = "";
        try {
            filePath = idb.fetchSingle("SELECT SEARCHPATH FROM POST WHERE POST_ID ='"+currentPost+"'");
            fileExt = HandleFiles.getExtensionByApacheCommonLib(filePath);
   
        } catch (InfException ex) {
            Logger.getLogger(ViewFullPost.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try{
        if(fileExt.equals("jpg") || fileExt.equals("png")){
                BufferedImage myPicture = ImageIO.read(new File(filePath));
                Image dimg = myPicture.getScaledInstance(jPicture.getWidth(), jPicture.getHeight(),Image.SCALE_SMOOTH);
                jPicture.setIcon (new ImageIcon(dimg));
            }
            else if(fileExt.equals("txt")){
                SetDefaultPicture();
            }
            else{
                SetDefaultPicture();
            }
        }
        catch(IOException ex){
            Logger.getLogger(ViewFullPost.class.getName()).log(Level.SEVERE, null, ex);
        }
}
public void SetDefaultPicture(){
    BufferedImage myPicture;
        try {
            myPicture = ImageIO.read(new File("c://JFrame/Scrum/oru.png"));
            jPicture.setIcon (new ImageIcon(myPicture));
        } catch (IOException ex) {
            Logger.getLogger(ViewFullPost.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTitle = new javax.swing.JLabel();
        jAuthor = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPostBody = new javax.swing.JTextArea();
        jpostDate = new javax.swing.JLabel();
        jToUserPanel = new javax.swing.JButton();
        jPicture = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTitle.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jTitle.setText("Title : The post");

        jAuthor.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jAuthor.setText("Author : blalalba hihohohaha");

        jPostBody.setEditable(false);
        jPostBody.setColumns(20);
        jPostBody.setRows(5);
        jScrollPane2.setViewportView(jPostBody);

        jpostDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jpostDate.setText("Date");

        jToUserPanel.setText("Back");
        jToUserPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToUserPanelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToUserPanel)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jAuthor)
                            .addComponent(jpostDate))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToUserPanel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTitle)
                        .addGap(34, 34, 34)
                        .addComponent(jAuthor)
                        .addGap(37, 37, 37)
                        .addComponent(jpostDate))
                    .addComponent(jPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToUserPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToUserPanelActionPerformed
        ReturnToHome.CreateHomeScreen(idb, currentUser);
        dispose();
    }//GEN-LAST:event_jToUserPanelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jAuthor;
    private javax.swing.JLabel jPicture;
    private javax.swing.JTextArea jPostBody;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jTitle;
    private javax.swing.JButton jToUserPanel;
    private javax.swing.JLabel jpostDate;
    // End of variables declaration//GEN-END:variables
}
