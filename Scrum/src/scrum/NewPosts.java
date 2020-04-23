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
import org.apache.commons.io.FilenameUtils;

public class NewPosts extends javax.swing.JFrame {

    private InfDB idb;
    private final String currentUser;
    private File currentFile;
    private String currentExt;
    private String currentPost;

    public NewPosts(InfDB idb, String id) {
        initComponents();
        new FillComboBoxFromDb(idb).fillComboboxCategories(jCategories, "Jobb");
        this.idb = idb;
        this.currentUser = id;
        jTitle.requestFocus();
        jValue.setVisible(false);
        jSetPublish.doClick();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jType = new javax.swing.JComboBox<>();
        jCategories = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jText = new javax.swing.JTextArea();
        jNewCategory = new javax.swing.JButton();
        jTitle = new javax.swing.JTextField();
        jlblTitle = new javax.swing.JLabel();
        jCreatePost = new javax.swing.JButton();
        jFile = new javax.swing.JButton();
        jFileName = new javax.swing.JLabel();
        jHome = new javax.swing.JButton();
        jSetPublish = new javax.swing.JCheckBox();
        jValue = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jobb", "Fritid" }));
        jType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTypeActionPerformed(evt);
            }
        });

        jText.setColumns(20);
        jText.setRows(5);
        jScrollPane1.setViewportView(jText);

        jNewCategory.setText("Skapa ny kategori");
        jNewCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNewCategoryActionPerformed(evt);
            }
        });

        jTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTitleActionPerformed(evt);
            }
        });

        jlblTitle.setText("Title");

        jCreatePost.setText("Skapa inlägg");
        jCreatePost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCreatePostActionPerformed(evt);
            }
        });

        jFile.setText("Open file...");
        jFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileActionPerformed(evt);
            }
        });

        jHome.setText("Home");
        jHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHomeActionPerformed(evt);
            }
        });

        jSetPublish.setText("Publish");
        jSetPublish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSetPublishActionPerformed(evt);
            }
        });

        jValue.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jHome)
                        .addGap(37, 37, 37)
                        .addComponent(jValue, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlblTitle)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jFile)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFileName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jCreatePost))
                            .addComponent(jScrollPane1)
                            .addComponent(jTitle)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jType, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSetPublish)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addComponent(jNewCategory)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jlblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNewCategory)
                    .addComponent(jSetPublish))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCreatePost)
                        .addComponent(jFile))
                    .addComponent(jFileName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
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
            jTitle.setText(title);
            jText.setText(content);
            jValue.setText("1");
            this.currentPost = postId;
            jType.setSelectedItem(categoryType);
            jCategories.setSelectedItem(categoryName);

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
            JOptionPane.showMessageDialog(null, "Fyll i både titel och text!");
            jTitle.requestFocus();
        } else {
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
    }

    private void CreatePost() {
        String title = jTitle.getText();
        String content = jText.getText();
        int publishStatus = GetCheckBoxStatus();

        if (title.isEmpty() || content.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fyll i både titel och text!");
            jTitle.requestFocus();
        } else {
            String category = jCategories.getSelectedItem().toString();
            String sqlCategoryID = "SELECT CATEGORY_ID FROM CATEGORY WHERE CATEGORYNAME = '" + category + "'";
            String tiden = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            LocalDate currentDate = LocalDate.now();

            try {
                String categoryID = idb.fetchSingle(sqlCategoryID);

                String id = idb.getAutoIncrement("POST", "POST_ID");

                if (currentFile == null) {
                    String insertPost = "INSERT INTO POST (POST_ID,TITLE,CONTENT,SEARCHPATH,POSTDATE,POSTTIME,POSTER_ID,CATEGORY_ID,POSTSTATUS) VALUES (" + id + ",'" + title + "','" + content + "','default','" + currentDate + "','" + tiden + "'," + currentUser + "," + categoryID + "," + publishStatus + ")";
                    idb.insert(insertPost);
                } else {
                    String filePath = GetCurrentFile();
                    String insertPost = "INSERT INTO POST (POST_ID,TITLE,CONTENT,SEARCHPATH,POSTDATE,POSTTIME,POSTER_ID,CATEGORY_ID, POSTSTATUS) VALUES (" + id + ",'" + title + "','" + content + "','" + filePath + "','" + currentDate + "','" + tiden + "'," + currentUser + "," + categoryID + "," + publishStatus + ")";
                    idb.insert(insertPost);
                }

                JOptionPane.showMessageDialog(null, "Nytt inlägg skapat!");

                dispose();
            } catch (InfException ex) {
                Logger.getLogger(NewPosts.class.getName()).log(Level.SEVERE, null, ex);
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

    private void jTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTypeActionPerformed
        jCategories.removeAllItems();
        String type = jType.getSelectedItem().toString();
        new FillComboBoxFromDb(idb).fillComboboxCategories(jCategories, type);
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

        dispose();
    }//GEN-LAST:event_jHomeActionPerformed

    private void jSetPublishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSetPublishActionPerformed

    }//GEN-LAST:event_jSetPublishActionPerformed

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
    private javax.swing.JButton jCreatePost;
    private javax.swing.JButton jFile;
    private javax.swing.JLabel jFileName;
    private javax.swing.JButton jHome;
    private javax.swing.JButton jNewCategory;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox jSetPublish;
    private javax.swing.JTextArea jText;
    private javax.swing.JTextField jTitle;
    private javax.swing.JComboBox<String> jType;
    private javax.swing.JLabel jValue;
    private javax.swing.JLabel jlblTitle;
    // End of variables declaration//GEN-END:variables
}
