package scrum;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import oru.inf.InfDB;
import oru.inf.InfException;

public class ViewFullPost extends javax.swing.JFrame {
    private InfDB idb;
    private final String currentUser;
    private final String currentPost;
    
    public ViewFullPost(InfDB idb, int userID, int postID) {
        initComponents();
        this.currentPost = Integer.toString(postID);
        this.currentUser = Integer.toString(userID);
        this.idb = idb;
        jDownload.setVisible(false);
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
                jFile.setText(filePath);
                jDownload.setVisible(true);
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

        jPanel1 = new javax.swing.JPanel();
        jToUserPanel = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPostBody = new javax.swing.JTextArea();
        jTitle = new javax.swing.JLabel();
        jAuthor = new javax.swing.JLabel();
        jpostDate = new javax.swing.JLabel();
        jDownload = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jToUserPanel.setText("Back");
        jToUserPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToUserPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToUserPanelActionPerformed(evt);
            }
        });

        jPostBody.setEditable(false);
        jPostBody.setColumns(20);
        jPostBody.setRows(5);
        jScrollPane2.setViewportView(jPostBody);

        jTitle.setBackground(new java.awt.Color(255, 255, 255));
        jTitle.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jTitle.setForeground(new java.awt.Color(255, 255, 255));
        jTitle.setText("Title : The post");

        jAuthor.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jAuthor.setForeground(new java.awt.Color(255, 255, 255));
        jAuthor.setText("Author :");

        jpostDate.setBackground(new java.awt.Color(255, 255, 255));
        jpostDate.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jpostDate.setForeground(new java.awt.Color(255, 255, 255));
        jpostDate.setText("Date");

        jDownload.setText("Download file");
        jDownload.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDownloadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jToUserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jAuthor)
                            .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpostDate))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDownload, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTitle)
                    .addComponent(jToUserPanel))
                .addGap(18, 18, 18)
                .addComponent(jAuthor)
                .addGap(18, 18, 18)
                .addComponent(jpostDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jDownload)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToUserPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToUserPanelActionPerformed
        ReturnToHome.CreateHomeScreen(idb, currentUser);
        dispose();
    }//GEN-LAST:event_jToUserPanelActionPerformed

    private void jDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDownloadActionPerformed
    String filePath = "";
    
    try{
    filePath = idb.fetchSingle("SELECT SEARCHPATH FROM POST WHERE POST_ID ='"+currentPost+"'");
    }
    catch(InfException e){
        System.out.println(e.getMessage());
    }
    
    try{    
        File currentFile = new File(filePath);
        ArrayList<String> lines = HandleFiles.ReadFile(currentFile);
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
        String newPath = fileChooser.getSelectedFile().getAbsolutePath();
        newPath = newPath + "/" + jTitle.getText() + "-AttachedFile.txt";
        HandleFiles.SaveFile(lines, newPath);
        jFile.setText("File saved");
        }
    else{
        System.out.println("No file choosen!");
    }    
    }
    catch(IOException e){
        System.out.println(e.getMessage());
    }   
    }//GEN-LAST:event_jDownloadActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jAuthor;
    private javax.swing.JButton jDownload;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextArea jPostBody;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jTitle;
    private javax.swing.JButton jToUserPanel;
    private javax.swing.JLabel jpostDate;
    // End of variables declaration//GEN-END:variables
}
