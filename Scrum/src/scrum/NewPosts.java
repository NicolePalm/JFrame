package scrum;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.time.Instant.now;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import oru.inf.InfDB;
import oru.inf.InfException;

public class NewPosts extends javax.swing.JFrame {

    private InfDB idb;
    private int currentUser;
    private File currentFile;
        
        public NewPosts(InfDB idb, int id) {
        initComponents();
        new FillComboBoxFromDb(idb).fillComboboxCategories(jCategories, "Jobb");
        this.idb = idb;
        this.currentUser = id;  
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
        jButton1 = new javax.swing.JButton();

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

        jButton1.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTitle)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jType, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jNewCategory)
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlblTitle)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jFile)
                        .addGap(40, 40, 40)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCreatePost)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jlblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNewCategory))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCreatePost)
                    .addComponent(jFile)
                    .addComponent(jButton1))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTitleActionPerformed

    private void jCreatePostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCreatePostActionPerformed
        String title = jTitle.getText();
        String content = jText.getText();
        String category = jCategories.getSelectedItem().toString();
        String sqlCategoryID = "SELECT CATEGORY_ID FROM CATEGORY WHERE CATEGORYNAME = '"+category+"'";
        
        String tiden = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        LocalDate currentDate = LocalDate.now();
        System.out.print(currentDate);
        
        try {
            String categoryID = idb.fetchSingle(sqlCategoryID);
            String filePath = GetCurrentFile();
            String id = idb.getAutoIncrement("POST","POST_ID");
            String insertPost = "INSERT INTO POST (POST_ID,TITLE,CONTENT,SEARCHPATH,POSTDATE,POSTTIME,POSTER_ID,CATEGORY_ID) VALUES ("+id+",'"+title+"','"+content+"','"+filePath+"','"+currentDate+"','"+tiden+"',"+currentUser+","+categoryID+")";
            idb.insert(insertPost);
            JOptionPane.showMessageDialog(null, "Nytt inlägg skapat!");
            
            dispose();
        } catch (InfException ex) {
            Logger.getLogger(NewPosts.class.getName()).log(Level.SEVERE, null, ex);
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
    fileChooser.setFileFilter(new FileNameExtensionFilter("*.jpg", "jpg"));
    if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
        this.currentFile = fileChooser.getSelectedFile();
    }
    else {
        System.out.println("No file choosen!");
    }   
        
        
    

    }//GEN-LAST:event_jFileActionPerformed
    private String GetCurrentFile()
    {
        String userID = Integer.toString(currentUser);
        String filename= LocalTime.now().format(DateTimeFormatter.ofPattern("HH-mm-ss")) + userID;
        String filePath = "c://JFrame/Scrum/files/"+filename+".jpg";
        try {
            BufferedImage image = ImageIO.read(currentFile);
            ImageIO.write((BufferedImage)image, "jpg", new File(filePath));
        } catch (IOException ex) {
            System.out.println("Failed to save image!");
        
    } 
    return filePath;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jCategories;
    private javax.swing.JButton jCreatePost;
    private javax.swing.JButton jFile;
    private javax.swing.JButton jNewCategory;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jText;
    private javax.swing.JTextField jTitle;
    private javax.swing.JComboBox<String> jType;
    private javax.swing.JLabel jlblTitle;
    // End of variables declaration//GEN-END:variables
}
