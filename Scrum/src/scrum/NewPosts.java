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
    private final int currentUser;
    private File currentFile;
    private String currentExt;
        
        public NewPosts(InfDB idb, int id) {
        initComponents();
        new FillComboBoxFromDb(idb).fillComboboxCategories(jCategories, "Jobb");
        this.idb = idb;
        this.currentUser = id;
        jTitle.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileName = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jHome = new javax.swing.JButton();
        jlblTitle = new javax.swing.JLabel();
        jTitle = new javax.swing.JTextField();
        jType = new javax.swing.JComboBox<>();
        jCategories = new javax.swing.JComboBox<>();
        jNewCategory = new javax.swing.JButton();
        jFile = new javax.swing.JButton();
        jCreatePost = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jText = new javax.swing.JTextArea();
        jlblTitle1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jHome.setText("Home");
        jHome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHomeActionPerformed(evt);
            }
        });

        jlblTitle.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jlblTitle.setForeground(new java.awt.Color(255, 255, 255));
        jlblTitle.setText("Title");

        jTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTitleActionPerformed(evt);
            }
        });

        jType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jobb", "Fritid" }));
        jType.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTypeActionPerformed(evt);
            }
        });

        jCategories.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jNewCategory.setText("Skapa ny kategori");
        jNewCategory.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jNewCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNewCategoryActionPerformed(evt);
            }
        });

        jFile.setText("Open file...");
        jFile.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileActionPerformed(evt);
            }
        });

        jCreatePost.setText("Skapa inlägg");
        jCreatePost.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jCreatePost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCreatePostActionPerformed(evt);
            }
        });

        jText.setColumns(20);
        jText.setRows(5);
        jScrollPane1.setViewportView(jText);

        jlblTitle1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jlblTitle1.setForeground(new java.awt.Color(255, 255, 255));
        jlblTitle1.setText("New Post");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jType, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(jNewCategory))
                    .addComponent(jTitle)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCreatePost))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jHome)
                                .addGap(51, 51, 51)
                                .addComponent(jlblTitle1))
                            .addComponent(jlblTitle))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jHome)
                    .addComponent(jlblTitle1))
                .addGap(18, 18, 18)
                .addComponent(jlblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNewCategory))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCreatePost)
                    .addComponent(jFile))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFileName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFileName))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTitleActionPerformed

    private void jCreatePostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCreatePostActionPerformed
        String title = jTitle.getText();
        String content = jText.getText();
        if(title.isEmpty() || content.isEmpty()){
            JOptionPane.showMessageDialog(null, "Fyll i både titel och text!");
            jTitle.requestFocus();
        }
        else{
        String category = jCategories.getSelectedItem().toString();
        String sqlCategoryID = "SELECT CATEGORY_ID FROM CATEGORY WHERE CATEGORYNAME = '"+category+"'";
        String tiden = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        LocalDate currentDate = LocalDate.now();
        
        try {
            String categoryID = idb.fetchSingle(sqlCategoryID);
            
            String id = idb.getAutoIncrement("POST","POST_ID");
            
            if(currentFile == null){
                String insertPost = "INSERT INTO POST (POST_ID,TITLE,CONTENT,SEARCHPATH,POSTDATE,POSTTIME,POSTER_ID,CATEGORY_ID) VALUES ("+id+",'"+title+"','"+content+"','default','"+currentDate+"','"+tiden+"',"+currentUser+","+categoryID+")";
                idb.insert(insertPost);
            }
            else{
            String filePath = GetCurrentFile();    
            String insertPost = "INSERT INTO POST (POST_ID,TITLE,CONTENT,SEARCHPATH,POSTDATE,POSTTIME,POSTER_ID,CATEGORY_ID) VALUES ("+id+",'"+title+"','"+content+"','"+filePath+"','"+currentDate+"','"+tiden+"',"+currentUser+","+categoryID+")";
            idb.insert(insertPost);
            }
            
            JOptionPane.showMessageDialog(null, "Nytt inlägg skapat!");
            
            dispose();
        } catch (InfException ex) {
            Logger.getLogger(NewPosts.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    }
    else {
        System.out.println("No file choosen!");
    }     
    }//GEN-LAST:event_jFileActionPerformed

    private void jHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHomeActionPerformed

        dispose();
    }//GEN-LAST:event_jHomeActionPerformed
    
    private String GetCurrentFile() 
    {
        
        String fileName = currentFile.getAbsolutePath();
        this.currentExt = HandleFiles.getExtensionByApacheCommonLib(fileName);
        String userID = Integer.toString(currentUser);
        String filename= LocalTime.now().format(DateTimeFormatter.ofPattern("HH-mm-ss")) + userID;
        String filePath = "c://JFrame/Scrum/files/"+filename+"."+currentExt;
    
        if(currentExt.equals("png") || currentExt.equals("jpg")){
            HandleFiles.SaveImage(currentFile, currentExt, filePath);
        } 
        else if(currentExt.equals("txt")){
            try{
            ArrayList<String> lines = HandleFiles.ReadFile(currentFile);
            HandleFiles.SaveFile(lines, filePath);
            }
            catch(IOException e){
                
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jText;
    private javax.swing.JTextField jTitle;
    private javax.swing.JComboBox<String> jType;
    private javax.swing.JLabel jlblTitle;
    private javax.swing.JLabel jlblTitle1;
    // End of variables declaration//GEN-END:variables
}





