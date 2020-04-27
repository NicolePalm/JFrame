package scrum;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

public class NewPosts extends javax.swing.JFrame {

    private InfDB idb;
    private final String currentUser;
    private File currentFile;
    private String currentExt;
    private String currentPost;

    public NewPosts(InfDB idb, String id) {
        initComponents();
        new FillComboBoxFromDb(idb).fillComboboxCategories(jCategories, "Formal");
        this.idb = idb;
        this.currentUser = id;
        jTitle.requestFocus();
        jValue.setVisible(false);
        jSetPublish.doClick();
        jText.setLineWrap(true);
        updateCategories();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jHome = new javax.swing.JButton();
        jValue = new javax.swing.JLabel();
        jlblTitle = new javax.swing.JLabel();
        jTitle = new javax.swing.JTextField();
        jType = new javax.swing.JComboBox<>();
        jCategories = new javax.swing.JComboBox<>();
        jSetPublish = new javax.swing.JCheckBox();
        jNewCategory = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jText = new javax.swing.JTextArea();
        jCounter = new javax.swing.JLabel();
        jCreatePost = new javax.swing.JButton();
        jFile = new javax.swing.JButton();
        jFileName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Create post");

        jHome.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jHome.setText("Back");
        jHome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHomeActionPerformed(evt);
            }
        });

        jValue.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jValue.setForeground(new java.awt.Color(255, 255, 255));
        jValue.setText("value");

        jlblTitle.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jlblTitle.setForeground(new java.awt.Color(255, 255, 255));
        jlblTitle.setText("Title");

        jTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTitleActionPerformed(evt);
            }
        });

        jType.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Formal", "Informal" }));
        jType.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTypeActionPerformed(evt);
            }
        });

        jCategories.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jSetPublish.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jSetPublish.setText("Publish");
        jSetPublish.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSetPublish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSetPublishActionPerformed(evt);
            }
        });

        jNewCategory.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jNewCategory.setText("Create new category");
        jNewCategory.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jNewCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNewCategoryActionPerformed(evt);
            }
        });

        jText.setColumns(20);
        jText.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jText.setRows(5);
        jText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jText);

        jCounter.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jCounter.setForeground(new java.awt.Color(255, 255, 255));
        jCounter.setText("0/750");

        jCreatePost.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jCreatePost.setText("Create post");
        jCreatePost.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jCreatePost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCreatePostActionPerformed(evt);
            }
        });

        jFile.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jFile.setText("Open file...");
        jFile.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileActionPerformed(evt);
            }
        });

        jFileName.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jHome, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jlblTitle)
                                .addGap(56, 56, 56)
                                .addComponent(jValue, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jType, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSetPublish)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jNewCategory))
                            .addComponent(jCounter)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jFile)
                                .addGap(18, 18, 18)
                                .addComponent(jFileName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jCreatePost))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTitle, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jHome)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jValue, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jlblTitle)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSetPublish)
                        .addComponent(jNewCategory))
                    .addComponent(jCategories))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCounter)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCreatePost)
                    .addComponent(jFile)
                    .addComponent(jFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
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

    private void jTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTitleActionPerformed

    private int GetCheckBoxStatus() {
        boolean boxStatus = jSetPublish.isSelected();
        int boxStatusInt = 0;
        if (boxStatus == true) {
            boxStatusInt = 1;
        }
        return boxStatusInt;
    }
    
   

    public void RecreatePost(String postId) {
        String content;
        String categoryId;
        String categoryName;
        String categoryType;
        String title;
        String file;
        try {
            content = idb.fetchSingle("SELECT CONTENT FROM POST WHERE POST_ID ='" + postId + "'");
            categoryId = idb.fetchSingle("SELECT CATEGORY_ID FROM POST WHERE POST_ID ='" + postId + "'");
            categoryName = idb.fetchSingle("SELECT CATEGORYNAME FROM CATEGORY WHERE CATEGORY_ID = '" + categoryId + "'");
            categoryType = idb.fetchSingle("SELECT CATEGORYTYPE FROM CATEGORY WHERE CATEGORY_ID = '" + categoryId + "'");
            title = idb.fetchSingle("SELECT TITLE FROM POST WHERE POST_ID ='" + postId + "'");
            file = idb.fetchSingle("SELECT SEARCHPATH FROM POST WHERE POST_ID = '" + postId + "'");
            int contentLenght = content.length();
            jTitle.setText(title);
            jText.setText(content);
            jValue.setText("1");
            this.currentPost = postId;
            jType.setSelectedItem(categoryType);
            jCategories.setSelectedItem(categoryName);
            jCounter.setText(contentLenght + "/750");

            if (!file.equals("default")) {
                jFileName.setText(file);
            }
        } catch (InfException e) {
            System.out.println(e.getMessage());
        }

    }

    private void UpdatePost() {
        String title = jTitle.getText();
        String content = jText.getText();
        int publishStatus = GetCheckBoxStatus();
        System.out.println(jSetPublish.isSelected());
        System.out.println(publishStatus);
        String filePath = "default";
        String fileName = jFileName.getText();

        if (title.isEmpty() || content.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter both title and text!");
            jTitle.requestFocus();
        } else {
            if(title.length() + 1 <= 100){
                if(content.length() + 1 <=750){
            String category = jCategories.getSelectedItem().toString();
            String sqlCategoryID = "SELECT CATEGORY_ID FROM CATEGORY WHERE CATEGORYNAME = '" + category + "'";
            String tiden = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            LocalDate currentDate = LocalDate.now();
            if (currentFile == null) {
                if (!fileName.equals("")) {
                    filePath = fileName;
                }
            } else {
                filePath = GetCurrentFile();
                jFileName.setText(filePath);
            }

            try {
                String categoryID = idb.fetchSingle(sqlCategoryID);
                idb.update("UPDATE POST SET TITLE = '" + title + "', CONTENT= '" + content + "', SEARCHPATH = '" + filePath + "', POSTDATE = '" + currentDate + "', POSTTIME = '" + tiden + "', CATEGORY_ID = " + categoryID + ", POSTSTATUS = " + publishStatus + " WHERE POST_ID = '" + currentPost + "'");
                JOptionPane.showMessageDialog(null, "The post is updated!");
                dispose();
            } catch (InfException e) {
                System.out.println(e.getMessage());
            }
            }
                else{
                 JOptionPane.showMessageDialog(null, "Too long text");
                 jText.requestFocus();  
        }
        }
          else{
                 JOptionPane.showMessageDialog(null, "Too long title");
                 jTitle.requestFocus();   
        }

        }
    }

    private void CreatePost() {
        String title = jTitle.getText();
        String content = jText.getText();
        int publishStatus = GetCheckBoxStatus();

        if (title.isEmpty() || content.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter both title and text!");
            jTitle.requestFocus();
        } else {
            if(title.length() + 1 <= 100){
                if(content.length() + 1 <=750){
            String category = jCategories.getSelectedItem().toString();
            String sqlCategoryID = "SELECT CATEGORY_ID FROM CATEGORY WHERE CATEGORYNAME = '" + category + "'";
            String tiden = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            LocalDate currentDate = LocalDate.now();

            try {
                String categoryID = idb.fetchSingle(sqlCategoryID);

                String id = idb.getAutoIncrement("POST", "POST_ID");
                if(Validation.inmatningFnuttar(content) && Validation.inmatningFnuttar(title)){
                if (currentFile == null) {
                    String insertPost = "INSERT INTO POST (POST_ID,TITLE,CONTENT,SEARCHPATH,POSTDATE,POSTTIME,POSTER_ID,CATEGORY_ID,POSTSTATUS) VALUES (" + id + ",'" + title + "','" + content + "','default','" + currentDate + "','" + tiden + "'," + currentUser + "," + categoryID + "," + publishStatus + ")";
                    idb.insert(insertPost);
                } else {
                    String filePath = GetCurrentFile();
                    String insertPost = "INSERT INTO POST (POST_ID,TITLE,CONTENT,SEARCHPATH,POSTDATE,POSTTIME,POSTER_ID,CATEGORY_ID, POSTSTATUS) VALUES (" + id + ",'" + title + "','" + content + "','" + filePath + "','" + currentDate + "','" + tiden + "'," + currentUser + "," + categoryID + "," + publishStatus + ")";
                    idb.insert(insertPost);
                }

                JOptionPane.showMessageDialog(null, "New post created");
                ReturnToHome.CreateHomeScreen(idb, currentUser);
                dispose();

 
                }
            } catch (InfException ex) {
                Logger.getLogger(NewPosts.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
                else{
                 JOptionPane.showMessageDialog(null, "Too long text");
                 jText.requestFocus();  
        }
        }
          else{
                 JOptionPane.showMessageDialog(null, "Too long title");
                 jTitle.requestFocus();   
        }
        }
    }

    private void jCreatePostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCreatePostActionPerformed

        if (jValue.getText().equals("1")) {
            UpdatePost();
            new ViewFullPost(idb, currentUser, currentPost).setVisible(true);
        } else {
            CreatePost();
        }
    }//GEN-LAST:event_jCreatePostActionPerformed

    private void updateCategories(){
       jCategories.removeAllItems();
        String type = jType.getSelectedItem().toString();
         if (type.equals("Formal")){
        new FillComboBoxFromDb(idb).fillComboboxCategories(jCategories, "Formal");   
        }else{
        new FillComboBoxFromDb(idb).fillComboboxCategories(jCategories, "Informal");  
        }
     
    }
    private void jTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTypeActionPerformed
      updateCategories();
     
    }//GEN-LAST:event_jTypeActionPerformed

    private void jNewCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNewCategoryActionPerformed
        new CreateNewCategory(idb).setVisible(true);
    }//GEN-LAST:event_jNewCategoryActionPerformed

    private void jFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        HandleFiles.FileExtensions(fileChooser);

        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            this.currentFile = fileChooser.getSelectedFile();
            String fileName = currentFile.getAbsolutePath();
            this.jFileName.setText(fileName);
        } else {
            System.out.println("No file choosen!");
        }
    }//GEN-LAST:event_jFileActionPerformed

    private void jHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHomeActionPerformed
        ReturnToHome.CreateHomeScreen(idb, currentUser);
        dispose();
    }//GEN-LAST:event_jHomeActionPerformed

    private void jSetPublishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSetPublishActionPerformed

    }//GEN-LAST:event_jSetPublishActionPerformed

    private void jTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextKeyTyped
        int countChar = jText.getText().length() + 1;
        jCounter.setText(countChar + "/750");
    }//GEN-LAST:event_jTextKeyTyped

    private String GetCurrentFile() {

        String fileName = currentFile.getAbsolutePath();
        this.currentExt = HandleFiles.getExtensionByApacheCommonLib(fileName);
        String filename = LocalTime.now().format(DateTimeFormatter.ofPattern("HH-mm-ss")) + currentUser;
        String filePath = "c://JFrame/Scrum/files/" + filename + "." + currentExt;

        if (currentExt.equals("png") || currentExt.equals("jpg")) {
            HandleFiles.SaveImage(currentFile, currentExt, filePath);
        } else if (currentExt.equals("txt")) {
            try {
                ArrayList<String> lines = HandleFiles.ReadFile(currentFile);
                HandleFiles.SaveFile(lines, filePath);
            } catch (IOException e) {

            }
        }
        return filePath;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jCategories;
    private javax.swing.JLabel jCounter;
    private javax.swing.JButton jCreatePost;
    private javax.swing.JButton jFile;
    private javax.swing.JLabel jFileName;
    private javax.swing.JButton jHome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jNewCategory;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox jSetPublish;
    private javax.swing.JTextArea jText;
    private javax.swing.JTextField jTitle;
    private javax.swing.JComboBox<String> jType;
    private javax.swing.JLabel jValue;
    private javax.swing.JLabel jlblTitle;
    // End of variables declaration//GEN-END:variables
}
