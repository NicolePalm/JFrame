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
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

public class ViewFullPost extends javax.swing.JFrame {

    private InfDB idb;
    private final String currentUser;
    private final String currentPost;

    public ViewFullPost(InfDB idb, String currentUser, String currentPost) {
        initComponents();
        this.idb = idb;
        this.currentUser = currentUser;
        this.currentPost = currentPost;
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
        controlAdminStatus();

    }

    private void controlAdminStatus() {

        int currentUs = Integer.parseInt(currentUser);
        try {
            String fraga = "Select adminstatus from user1 where user_id =" + currentUs + ";";
            String svar = idb.fetchSingle(fraga);
            if (svar.equals("1")) {
                btnRemove.setVisible(true);
                btnEdit.setVisible(true);
                btnComment.setVisible(true);
                
            } else {
                btnRemove.setVisible(false);
                btnEdit.setVisible(false);
                btnComment.setVisible(false);
            }

        } catch (InfException e) {
            System.out.print("Error");
        }
    }

    public String GetPostTitle() {
        String title = "";
        try {
            title = idb.fetchSingle("SELECT TITLE FROM POST WHERE POST_ID ='" + currentPost + "'");

        } catch (InfException ex) {
            Logger.getLogger(ViewFullPost.class.getName()).log(Level.SEVERE, null, ex);
        }
        return title;
    }

    public String GetPostDate() {
        String date = "";
        String time = "";
        String dateandtime = "";
        try {
            time = idb.fetchSingle("SELECT POSTTIME FROM POST WHERE POST_ID ='" + currentPost + "'");
            date = idb.fetchSingle("SELECT POSTDATE FROM POST WHERE POST_ID ='" + currentPost + "'");
            dateandtime = time + "  " + date;

        } catch (InfException ex) {
            Logger.getLogger(ViewFullPost.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dateandtime;
    }

    public String GetPostContent() {
        String content = "";
        try {
            content = idb.fetchSingle("SELECT CONTENT FROM POST WHERE POST_ID ='" + currentPost + "'");

        } catch (InfException ex) {
            Logger.getLogger(ViewFullPost.class.getName()).log(Level.SEVERE, null, ex);
        }
        return content;
    }

    public String GetPosterName() {
        String firstName = "";
        String lastName = "";
        String posterID = "";
        String fullName = "";
        try {
            posterID = idb.fetchSingle("SELECT POSTER_ID FROM POST WHERE POST_ID ='" + currentPost + "'");
            firstName = idb.fetchSingle("SELECT FIRSTNAME FROM USER1 WHERE USER_ID =" + posterID);
            lastName = idb.fetchSingle("SELECT LASTNAME FROM USER1 WHERE USER_ID =" + posterID);
            fullName = firstName + " " + lastName;

        } catch (InfException ex) {
            Logger.getLogger(ViewFullPost.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fullName;
    }

    public void UsePostFile() {
        String filePath = "";
        String fileExt = "";
        try {
            filePath = idb.fetchSingle("SELECT SEARCHPATH FROM POST WHERE POST_ID ='" + currentPost + "'");
            fileExt = HandleFiles.getExtensionByApacheCommonLib(filePath);

        } catch (InfException ex) {
            Logger.getLogger(ViewFullPost.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            if (fileExt.equals("jpg") || fileExt.equals("png")) {
                BufferedImage myPicture = ImageIO.read(new File(filePath));
                Image dimg = myPicture.getScaledInstance(jPicture.getWidth(), jPicture.getHeight(), Image.SCALE_SMOOTH);
                jPicture.setIcon(new ImageIcon(dimg));
            } else if (fileExt.equals("txt")) {
                SetDefaultPicture();
                jFile.setText(filePath);
                jDownload.setVisible(true);
            } else {
                SetDefaultPicture();
            }
        } catch (IOException ex) {
            Logger.getLogger(ViewFullPost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void SetDefaultPicture() {
        BufferedImage myPicture;
        try {
            myPicture = ImageIO.read(new File("c://JFrame/Scrum/oru.png"));
            jPicture.setIcon(new ImageIcon(myPicture));
        } catch (IOException ex) {
            Logger.getLogger(ViewFullPost.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void ShowComments() {
        try {
            ArrayList<HashMap<String, String>> comments = idb.fetchRows("SELECT COMMENTER_ID, COMMENT FROM COMMENT WHERE POST_ID = '" + currentPost + "'");
            if (!PendingRequests.ContainsAllNulls(comments)) {
                for (HashMap<String, String> comment : comments) {
                    String commenter = comment.get("COMMENTER_ID");
                    String postedComment = comment.get("COMMENT");
                    String date = idb.fetchSingle("SELECT COMMENTDATE FROM COMMENT WHERE COMMENTER_ID = '" + commenter + "' AND POST_ID = '" + currentPost + "' AND COMMENT = '" + postedComment + "'");
                    String firstName = idb.fetchSingle("SELECT FIRSTNAME FROM USER1 WHERE USER_ID = '" + commenter + "'");
                    String lastName = idb.fetchSingle("SELECT LASTNAME FROM USER1 WHERE USER_ID = '" + commenter + "'");
                    jViewComments.append(postedComment + "\n" + "-" + firstName + " " + lastName + " " + date + "\n" + "\n");
                }
            } else {
                // jViewComments.setText("No comments yet");
            }
        } catch (InfException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void ShowNewComment() {
        String comment = jComment.getText();
        LocalDate currentDate = LocalDate.now();
        try {
            String firstName = idb.fetchSingle("SELECT FIRSTNAME FROM USER1 WHERE USER_ID = '" + currentUser + "'");
            String lastName = idb.fetchSingle("SELECT LASTNAME FROM USER1 WHERE USER_ID = '" + currentUser + "'");
            jViewComments.append(comment + "\n" + "-" + firstName + " " + lastName + " " + currentDate + "\n" + "\n");
        } catch (InfException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jToUserPanel = new javax.swing.JButton();
        jPicture = new javax.swing.JLabel();
        jTitle = new javax.swing.JLabel();
        jAuthor = new javax.swing.JLabel();
        jpostDate = new javax.swing.JLabel();
        btnComment = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jViewComments = new javax.swing.JTextArea();
        btnRemove = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jDownload = new javax.swing.JButton();
        jFile = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPostBody = new javax.swing.JTextArea();
        jLeaveComment = new javax.swing.JLabel();
        jSend = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jComment = new javax.swing.JTextArea();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jToUserPanel.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jToUserPanel.setText("Back");
        jToUserPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToUserPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToUserPanelActionPerformed(evt);
            }
        });

        jTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTitle.setForeground(new java.awt.Color(255, 255, 255));
        jTitle.setText("Title : The post");

        jAuthor.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jAuthor.setForeground(new java.awt.Color(255, 255, 255));
        jAuthor.setText("Author :");

        jpostDate.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jpostDate.setForeground(new java.awt.Color(255, 255, 255));
        jpostDate.setText("Date");

        btnComment.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnComment.setText("Delete comments");
        btnComment.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCommentActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Comments");

        jViewComments.setEditable(false);
        jViewComments.setColumns(20);
        jViewComments.setRows(5);
        jScrollPane3.setViewportView(jViewComments);

        btnRemove.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnRemove.setText("Remove post");
        btnRemove.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnEdit.setText("Edit post");
        btnEdit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jDownload.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jDownload.setText("Download file");
        jDownload.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDownloadActionPerformed(evt);
            }
        });

        jFile.setForeground(new java.awt.Color(255, 255, 255));

        jPostBody.setEditable(false);
        jPostBody.setColumns(20);
        jPostBody.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPostBody.setRows(5);
        jScrollPane2.setViewportView(jPostBody);

        jLeaveComment.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLeaveComment.setForeground(new java.awt.Color(255, 255, 255));
        jLeaveComment.setText("Please leave a comment");

        jSend.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jSend.setText("Send");
        jSend.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSendActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jToUserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jAuthor)
                                            .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jpostDate)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jDownload, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jFile, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(jLeaveComment, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSend, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnComment))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToUserPanel)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(btnComment))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jSend)
                                    .addComponent(jLeaveComment))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jAuthor)
                                .addGap(18, 18, 18)
                                .addComponent(jpostDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnEdit)
                                    .addComponent(btnRemove))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 265, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDownload)
                    .addComponent(jFile, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jToUserPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToUserPanelActionPerformed
        ReturnToHome.CreateHomeScreen(idb, currentUser);
        dispose();
    }//GEN-LAST:event_jToUserPanelActionPerformed

    private void jDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDownloadActionPerformed
        String filePath = "";

        try {
            filePath = idb.fetchSingle("SELECT SEARCHPATH FROM POST WHERE POST_ID ='" + currentPost + "'");
        } catch (InfException e) {
            System.out.println(e.getMessage());
        }

        try {
            File currentFile = new File(filePath);
            ArrayList<String> lines = HandleFiles.ReadFile(currentFile);
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                String newPath = fileChooser.getSelectedFile().getAbsolutePath();
                newPath = newPath + "/" + jTitle.getText() + "-AttachedFile.txt";
                HandleFiles.SaveFile(lines, newPath);
                jFile.setText("File saved");
            } else {
                System.out.println("No file choosen!");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jDownloadActionPerformed

    private void jSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSendActionPerformed
        String comment = jComment.getText();
        LocalDate currentDate = LocalDate.now();
        if (comment != null && !comment.equals("")) {
            if (comment.length() + 1 <= 250) {

                try {
                    String autoId = "";
                    String fraga = "select first 1 comment_id from comment";
                    String svar = idb.fetchSingle(fraga);
                    if (svar != null) {
                        autoId = idb.getAutoIncrement("COMMENT", "COMMENT_ID");
                    } else {
                        autoId = "1";
                    }

                    idb.insert("INSERT INTO Comment VALUES ('" + currentUser + "', '" + currentPost + "','" + currentDate + "', '" + comment + "', '" + autoId + "')");
                    ShowNewComment();
                    jComment.setText("");
                    jLeaveComment.setText("Thanks for commenting");
                } catch (InfException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                jLeaveComment.setText("Too many characters!");
            }
        } else {
            jLeaveComment.setText("Can't publish an empty comment!");
        }
    }//GEN-LAST:event_jSendActionPerformed

    private void jCommentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCommentKeyTyped
        int countChar = jComment.getText().length() + 1;
        jLeaveComment.setText(countChar + "/250");
    }//GEN-LAST:event_jCommentKeyTyped

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        int janej = JOptionPane.showConfirmDialog(null, "Are you sure?");
        if (janej == 0) {
            try {
                String fraga = "Delete from post where post_id = " + currentPost + ";";

                idb.delete(fraga);
                System.out.print("Deleted");
                ReturnToHome.CreateHomeScreen(idb, currentUser);
                dispose();
            } catch (InfException e) {
                System.out.print("Delete Failed");
            }
        } else {
            System.out.print("Cancel");
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int userId = Integer.parseInt(currentUser);
        NewPosts posts = new NewPosts(idb, currentUser);
        posts.setVisible(true);
        posts.RecreatePost(currentPost);
        dispose();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnCommentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCommentActionPerformed
        EditComments comments = new EditComments(idb, currentUser, currentPost);
        comments.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCommentActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComment;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRemove;
    private javax.swing.JLabel jAuthor;
    private javax.swing.JButton jButton1;
    private javax.swing.JTextArea jComment;
    private javax.swing.JButton jDownload;
    private javax.swing.JLabel jFile;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLeaveComment;
    private javax.swing.JPanel jPanel1;
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
