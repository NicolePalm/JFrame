/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.*;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;
/**
 *
 * @author Danie
 */
public class UserPanel extends javax.swing.JFrame {
    private int currentUser;
    private InfDB idb;
    
    
    public UserPanel(InfDB idb, int id) {
        this.idb = idb;
        this.currentUser = id;
        initComponents();
        updateMeeting();
        SetRequests();
        uppdateraUnderKategori();
    }
    
    
        public void post () {
        try {

            String category = categoryCbx.getSelectedItem().toString();
            int categoryId;

            System.out.println(category);
 
            String valt = jUnderKategori.getSelectedItem().toString();
            String fraga = "select category_id from category where categoryname = '" + valt + "'";
            String svaret; 
            svaret = idb.fetchSingle(fraga);
            int sver = Integer.parseInt(svaret);

            System.out.println(1);
            String postQuery = "SELECT post_id, title, postdate, posttime, post.category_id FROM post, category \n" +
                                "WHERE post.CATEGORY_ID = category.CATEGORY_ID AND categorytype = '" + category + "' and post.CATEGORY_ID = " + sver + " ORDER BY postdate DESC, posttime DESC";
           
            ArrayList<HashMap<String, String>> posts = idb.fetchRows(postQuery);
            String queryId;
            String queryTitle;
            String queryContent;
            String querySearchpath;
            String queryDate;
            String queryTime;
            DefaultListModel listModel = new DefaultListModel();

            for (HashMap<String, String> post : posts){
                queryId = post.get("POST_ID");
                queryTitle = post.get("TITLE");
                queryContent = post.get("CONTENT");
                querySearchpath = post.get("SEARCHPATH");
                queryDate = post.get("POSTDATE");
                queryTime = post.get("POSTTIME");

                //System.out.println(queryTitle);
                //System.out.println(queryContent);
                //System.out.println(querySearchpath);
                //System.out.println(queryDate);
                //System.out.println("----------------");

                listModel.addElement(queryId + " | " + queryTitle + " | " + queryDate + " | " + queryTime);

            }

        postList.setModel(listModel);
        }

        catch (Exception e) {
            System.out.println("Error");
JOptionPane.showMessageDialog(null, "Oops!\nSer ut som att det inte finns inlägg under denna kategori!");
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateComponentFormatter1 = new org.jdatepicker.impl.DateComponentFormatter();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jUnderKategori = new javax.swing.JComboBox<>();
        categoryCbx = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        postList = new javax.swing.JList<>();
        jNewPost = new javax.swing.JButton();
        btnCreateMeeting = new javax.swing.JButton();
        jShowCalendar = new javax.swing.JButton();
        jShowRequests = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User Panel");

        jButton1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButton1.setText("Uppdatera");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jUnderKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jUnderKategori.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jUnderKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUnderKategoriMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jUnderKategoriMouseReleased(evt);
            }
        });
        jUnderKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUnderKategoriActionPerformed(evt);
            }
        });

        categoryCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jobb", "Fritid" }));
        categoryCbx.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        categoryCbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryCbxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Senaste Inlägg");

        postList.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        postList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        postList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                postListMouseEntered(evt);
            }
        });
        postList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                postListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(postList);

        jNewPost.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jNewPost.setText("Skriv nytt inlägg");
        jNewPost.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jNewPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNewPostActionPerformed(evt);
            }
        });

        btnCreateMeeting.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCreateMeeting.setText("Skapa nytt möte");
        btnCreateMeeting.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCreateMeeting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateMeetingActionPerformed(evt);
            }
        });

        jShowCalendar.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jShowCalendar.setText("Calendar");
        jShowCalendar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jShowCalendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jShowCalendarActionPerformed(evt);
            }
        });

        jShowRequests.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jShowRequests.setText("Show meeting requests");
        jShowRequests.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jShowRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jShowRequestsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jShowCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCreateMeeting, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jShowRequests, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jNewPost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(150, 150, 150))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)))
                        .addComponent(jUnderKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoryCbx, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jUnderKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jNewPost)
                        .addGap(18, 18, 18)
                        .addComponent(btnCreateMeeting)
                        .addGap(18, 18, 18)
                        .addComponent(jShowCalendar)
                        .addGap(18, 18, 18)
                        .addComponent(jShowRequests))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
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
    }// </editor-fold>//GEN-END:initComponents

    private void jNewPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNewPostActionPerformed
        new NewPosts(idb,currentUser).setVisible(true);
    }//GEN-LAST:event_jNewPostActionPerformed

    private void categoryCbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryCbxActionPerformed
uppdateraUnderKategori();       
    }//GEN-LAST:event_categoryCbxActionPerformed

    private void postListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_postListValueChanged
        try {
        String listItem = postList.getSelectedValue();
        //System.out.println(listItem);
        String[] post_id = listItem.split(" ");
        String pId = "";
        
        for (String id : post_id){
            pId = id;
            System.out.println(pId);
            break;
        }
        int postId = Integer.parseInt(pId);
        
        //System.out.println(postId + 100);
        
        new ViewFullPost(idb, currentUser, postId).setVisible(true);
        
        dispose();
        }
        
        catch (Exception e) {
            System.out.println("Nåt sket sig");
        
        }
    }//GEN-LAST:event_postListValueChanged


                                        

    
    
    public void uppdateraUnderKategori(){
     jUnderKategori.removeAllItems();
        String type = categoryCbx.getSelectedItem().toString();
        new FillComboBoxFromDb(idb).fillComboboxCategories(jUnderKategori, type);       
    }
    private void updateMeeting(){
        UpdateMeetings update = new UpdateMeetings(idb, currentUser);
        update.deletePassedMeetings();
    }
    
    
    
    private void postListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_postListMouseEntered
        postList.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_postListMouseEntered

    private void btnCreateMeetingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateMeetingActionPerformed
        new CreateMeeting(idb,currentUser).setVisible(true);
    }//GEN-LAST:event_btnCreateMeetingActionPerformed

    private void jUnderKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUnderKategoriActionPerformed
         // TODO add your handling code here:
    }//GEN-LAST:event_jUnderKategoriActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
post(); 
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jUnderKategoriMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUnderKategoriMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jUnderKategoriMouseReleased

    private void jUnderKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUnderKategoriMouseClicked
post();        // TODO add your handling code here:
    }//GEN-LAST:event_jUnderKategoriMouseClicked

    private void jShowRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jShowRequestsActionPerformed
       new HandleMeetingRequests(idb, currentUser).setVisible(true);
    }//GEN-LAST:event_jShowRequestsActionPerformed

    private void jShowCalendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jShowCalendarActionPerformed
        new Calendar(idb, currentUser).setVisible(true);
    }//GEN-LAST:event_jShowCalendarActionPerformed
 
    public void SetRequests(){
    
     String currentRequests = PendingRequests.currentRequests(idb, currentUser);
     jPendingRequests.setText("Current pending requests: "+currentRequests);
    
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateMeeting;
    private javax.swing.JComboBox<String> categoryCbx;
    private org.jdatepicker.impl.DateComponentFormatter dateComponentFormatter1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jNewPost;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jShowCalendar;
    private javax.swing.JButton jShowRequests;
    private javax.swing.JComboBox<String> jUnderKategori;
    private javax.swing.JList<String> postList;
    // End of variables declaration//GEN-END:variables
}
