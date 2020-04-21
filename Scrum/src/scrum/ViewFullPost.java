package scrum;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
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
        jComment.setLineWrap(true);
        jPostBody.setLineWrap(true);
        jViewComments.setLineWrap(true);
        ShowComments();
        
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
        public void ShowComments(){
            try{
            ArrayList <HashMap <String, String>> comments = idb.fetchRows("SELECT COMMENTER_ID, COMMENT FROM COMMENT WHERE POST_ID = '" + currentPost + "'");
            if(!PendingRequests.ContainsAllNulls(comments)){
            for(HashMap <String, String> comment : comments){
            String commenter = comment.get("COMMENTER_ID");
            String postedComment = comment.get("COMMENT");
            String date = idb.fetchSingle("SELECT COMMENTDATE FROM COMMENT WHERE COMMENTER_ID = '" + commenter + "' AND POST_ID = '" + currentPost + "' AND COMMENT = '" + postedComment +"'");
            String firstName = idb.fetchSingle("SELECT FIRSTNAME FROM USER1 WHERE USER_ID = '" + commenter + "'");
            String lastName = idb.fetchSingle("SELECT LASTNAME FROM USER1 WHERE USER_ID = '" + commenter + "'");
            jViewComments.append(postedComment + "\n" + "-" + firstName + " " + lastName + " " + date + "\n" + "\n");
            }
            }
            else{
           // jViewComments.setText("No comments yet");
            }
            }
            catch (InfException ex) {
            System.out.println(ex.getMessage());
        }
        }
        
        public void ShowNewComment(){
            String comment = jComment.getText();
            LocalDate currentDate = LocalDate.now();
            try{
            String firstName = idb.fetchSingle("SELECT FIRSTNAME FROM USER1 WHERE USER_ID = '" + currentUser + "'");
            String lastName = idb.fetchSingle("SELECT LASTNAME FROM USER1 WHERE USER_ID = '" + currentUser + "'");
            jViewComments.append(comment + "\n" + "-" + firstName + " " + lastName + " " + currentDate + "\n" + "\n");
            }
            catch(InfException ex){
                System.out.println(ex.getMessage());
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
        jDownload = new javax.swing.JButton();
        jFile = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jComment = new javax.swing.JTextArea();
        jLeaveComment = new javax.swing.JLabel();
        jSend = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jViewComments = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTitle.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jTitle.setText("Title : The post");

        jAuthor.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jAuthor.setText("Author :");

        jPostBody.setEditable(false);
        jPostBody.setColumns(20);
        jPostBody.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
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

        jDownload.setText("Download file");
        jDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDownloadActionPerformed(evt);
            }
        });

        jComment.setColumns(20);
        jComment.setRows(5);
        jComment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCommentKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jComment);

        jLeaveComment.setText("Please leave a comment");

        jSend.setText("Send");
        jSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSendActionPerformed(evt);
            }
        });

        jViewComments.setEditable(false);
        jViewComments.setColumns(20);
        jViewComments.setRows(5);
        jScrollPane3.setViewportView(jViewComments);

        jLabel2.setText("Comments");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jFile, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jDownload))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToUserPanel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jAuthor)
                                    .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jpostDate))))
                        .addGap(0, 21, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane3)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLeaveComment, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jSend)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jToUserPanel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTitle)
                                .addGap(18, 18, 18)
                                .addComponent(jAuthor)
                                .addGap(27, 27, 27)
                                .addComponent(jpostDate)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFile, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDownload))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLeaveComment)
                            .addComponent(jSend))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 19, Short.MAX_VALUE))
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

    private void jSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSendActionPerformed
         String comment = jComment.getText();
        LocalDate currentDate = LocalDate.now();
        if(comment != null && !comment.equals("")){
            if(comment.length()+1 <= 250){
        try{
            idb.insert("INSERT INTO Comment (COMMENTER_ID, POST_ID, COMMENTDATE, COMMENT) VALUES ('" + currentUser + "', '" + currentPost + "','" + currentDate + "', '" + comment + "')");
            ShowNewComment();
            jComment.setText("");
            jLeaveComment.setText("Thanks for commenting");
        }
        catch(InfException e){
            System.out.println(e.getMessage());
        }
        }
            else{
                jLeaveComment.setText("Too many characters!");
            }
      }
         else{
                jLeaveComment.setText("Can't publish an empty comment!");
            }
    }//GEN-LAST:event_jSendActionPerformed

    private void jCommentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCommentKeyTyped
        int countChar = jComment.getText().length() + 1;
        jLeaveComment.setText(countChar + "/250");
    }//GEN-LAST:event_jCommentKeyTyped
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jAuthor;
    private javax.swing.JTextArea jComment;
    private javax.swing.JButton jDownload;
    private javax.swing.JLabel jFile;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLeaveComment;
    private javax.swing.JLabel jPicture;
    private javax.swing.JTextArea jPostBody;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jSend;
    private javax.swing.JLabel jTitle;
    private javax.swing.JButton jToUserPanel;
    private javax.swing.JTextArea jViewComments;
    private javax.swing.JLabel jpostDate;
    // End of variables declaration//GEN-END:variables
}
