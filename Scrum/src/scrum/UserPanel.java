/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum;
import java.awt.Color;
import java.awt.Cursor;
import java.text.SimpleDateFormat;
import javax.swing.*;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import static scrum.Calendar.ConvertDate;
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
        sokDatum();
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

           Date firsta = jfirstdate.getDate();
           Date seconda = jseconddate.getDate();
           
            String second = ConvertDate(seconda);
            String first = ConvertDate(firsta);
            
             System.out.println(first);
             System.out.println(second);
            String postQuery = "SELECT post_id, title, postdate, posttime, post.category_id FROM post, category \n"
                    + "WHERE post.CATEGORY_ID = category.CATEGORY_ID AND categorytype = '"+category+"' and post.CATEGORY_ID = "+sver+" AND POSTSTATUS = 1 AND POSTDATE BETWEEN '"+second+"' and '"+first+"' ORDER BY postdate DESC, posttime DESC";
                    
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jNewPost = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        postList = new javax.swing.JList<>();
        categoryCbx = new javax.swing.JComboBox<>();
        btnCreateMeeting = new javax.swing.JButton();
        jUnderKategori = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jShowCalendar = new javax.swing.JButton();
        jShowRequests = new javax.swing.JButton();
        jPendingRequests = new javax.swing.JLabel();
        jseconddate = new com.toedter.calendar.JDateChooser();
        jfirstdate = new com.toedter.calendar.JDateChooser();
        jShowMyPosts = new javax.swing.JButton();
        btnUpPersonalInfo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("User Panel");

        jLabel2.setText("Senaste Inlägg");

        jNewPost.setText("Skriv nytt inlägg");
        jNewPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNewPostActionPerformed(evt);
            }
        });

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

        categoryCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jobb", "Fritid" }));
        categoryCbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryCbxActionPerformed(evt);
            }
        });

        btnCreateMeeting.setText("Skapa nytt möte");
        btnCreateMeeting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateMeetingActionPerformed(evt);
            }
        });

        jUnderKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
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

        jButton1.setText("Uppdatera");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jShowCalendar.setText("Calendar");
        jShowCalendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jShowCalendarActionPerformed(evt);
            }
        });

        jShowRequests.setText("Show meeting requests");
        jShowRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jShowRequestsActionPerformed(evt);
            }
        });

        jPendingRequests.setText("jLabel3");

        jShowMyPosts.setText("Show my post");
        jShowMyPosts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jShowMyPostsActionPerformed(evt);
            }
        });

        btnUpPersonalInfo.setText("Update info");
        btnUpPersonalInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpPersonalInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPendingRequests)
                        .addGap(268, 268, 268)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jNewPost)
                        .addGap(26, 26, 26)
                        .addComponent(btnCreateMeeting, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jShowCalendar)
                        .addGap(18, 18, 18)
                        .addComponent(jShowRequests)
                        .addGap(18, 18, 18)
                        .addComponent(jShowMyPosts)
                        .addGap(24, 24, 24)
                        .addComponent(btnUpPersonalInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jUnderKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(categoryCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jseconddate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jfirstdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jPendingRequests))
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(categoryCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jUnderKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jseconddate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jfirstdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNewPost)
                    .addComponent(btnCreateMeeting)
                    .addComponent(jShowCalendar)
                    .addComponent(jShowRequests)
                    .addComponent(jShowMyPosts)
                    .addComponent(btnUpPersonalInfo))
                .addContainerGap())
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

    private void jShowMyPostsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jShowMyPostsActionPerformed
        new MyPosts(idb, currentUser).setVisible(true);
    }//GEN-LAST:event_jShowMyPostsActionPerformed

    private void btnUpPersonalInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpPersonalInfoActionPerformed
        new UpdatePersonalInfo(idb, currentUser).setVisible(true);
    }//GEN-LAST:event_btnUpPersonalInfoActionPerformed
 
    public void SetRequests(){
    
     String currentRequests = PendingRequests.currentRequests(idb, currentUser);
     jPendingRequests.setText("Current pending requests: "+currentRequests);
    
    }
    

    private void sokDatum(){
    
                 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd");
Date date = new Date();
System.out.println(dateFormat.format(date));
jfirstdate.setDate(date);
Date dat = new Date();
dat.setDate(-40);
System.out.println(dateFormat.format(dat));
jseconddate.setDate(dat);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateMeeting;
    private javax.swing.JButton btnUpPersonalInfo;
    private javax.swing.JComboBox<String> categoryCbx;
    private org.jdatepicker.impl.DateComponentFormatter dateComponentFormatter1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jNewPost;
    private javax.swing.JLabel jPendingRequests;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jShowCalendar;
    private javax.swing.JButton jShowMyPosts;
    private javax.swing.JButton jShowRequests;
    private javax.swing.JComboBox<String> jUnderKategori;
    private com.toedter.calendar.JDateChooser jfirstdate;
    private com.toedter.calendar.JDateChooser jseconddate;
    private javax.swing.JList<String> postList;
    // End of variables declaration//GEN-END:variables
}
