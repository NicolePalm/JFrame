package scrum;
import java.awt.Cursor;
import java.text.SimpleDateFormat;
import javax.swing.*;
import oru.inf.InfDB;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import oru.inf.InfException;
import static scrum.Calendar.ConvertDate;

public class UserPanel extends javax.swing.JFrame {
    private final String currentUser;
    private InfDB idb;
    private final String admin;
    
    
    public UserPanel(InfDB idb, String id, String status) {
        this.idb = idb;
        this.currentUser = id;
        this.admin = status;
        initComponents();
        updateMeeting();
        SetRequests();
        uppdateraUnderKategori();
        sokDatum();
        if(admin.equals("0")){
        jUsers.setVisible(false);
        }
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
            DefaultListModel listModel = new DefaultListModel();
            
           // String postQuery = "SELECT post_id, title, postdate, posttime, post.category_id FROM post, category \n"
                //    + "WHERE post.CATEGORY_ID = category.CATEGORY_ID AND categorytype = '"+category+"' and post.CATEGORY_ID = "+sver+" AND POSTSTATUS = 1 AND POSTDATE BETWEEN '"+second+"' and '"+first+"' ORDER BY postdate DESC, posttime DESC";
            
//            ArrayList<HashMap<String, String>> posts = idb.fetchRows(postQuery);
//            String queryId;
//            String queryTitle;
//            String queryContent;
//            String querySearchpath;
//            String queryDate;
//            String queryTime;
//            DefaultListModel listModel = new DefaultListModel();
//
//            for (HashMap<String, String> post : posts){
//                queryId = post.get("POST_ID");
//                queryTitle = post.get("TITLE");
//                queryContent = post.get("CONTENT");
//                querySearchpath = post.get("SEARCHPATH");
//                queryDate = post.get("POSTDATE");
//                queryTime = post.get("POSTTIME");
//                listModel.addElement(queryId + " | " + queryTitle + " | " + queryDate + " | " + queryTime);
//
//            }

        String title = "";
        String date = "";
        String time = "";
         ArrayList <String> publishedId = new ArrayList();
         publishedId = idb.fetchColumn("SELECT POST_ID FROM POST WHERE CATEGORY_ID = '" + svaret + "' AND POSTSTATUS = 1 AND POSTDATE BETWEEN '" + second + "' and '"+ first +"' ORDER BY postdate DESC, posttime DESC");
         if(PendingRequests.ContainsAllNulls(publishedId) == false){
             for(String id : publishedId){
                 title = idb.fetchSingle("SELECT TITLE FROM POST WHERE POST_ID = '" + id + "'");
                 date = idb.fetchSingle("SELECT POSTDATE FROM POST WHERE POST_ID = '" + id + "'");
                 time = idb.fetchSingle("SELECT POSTTIME FROM POST WHERE POST_ID = '" + id + "'");
                 listModel.addElement(id + " | " + title + " | " + date + " | " + time);
             }
         }

        postList.setModel(listModel);
        }

        catch (NumberFormatException | InfException e) {
            System.out.println("Error");
            JOptionPane.showMessageDialog(null, "No posts in this category");
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateComponentFormatter1 = new org.jdatepicker.impl.DateComponentFormatter();
        jLatestPosts = new javax.swing.JLabel();
        jNewPost = new javax.swing.JButton();
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
        jUsers = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        postList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLatestPosts.setText("Latest posts");

        jNewPost.setText("New post");
        jNewPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNewPostActionPerformed(evt);
            }
        });

        categoryCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Formal", "Informal" }));
        categoryCbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryCbxActionPerformed(evt);
            }
        });

        btnCreateMeeting.setText("Create meeting");
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

        jButton1.setText("Update");
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

        jShowRequests.setText("Meetingrequests");
        jShowRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jShowRequestsActionPerformed(evt);
            }
        });

        jPendingRequests.setText("Pending requests");

        jShowMyPosts.setText("My posts");
        jShowMyPosts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jShowMyPostsActionPerformed(evt);
            }
        });

        btnUpPersonalInfo.setText("Update personal details");
        btnUpPersonalInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpPersonalInfoActionPerformed(evt);
            }
        });

        jUsers.setText("Manage users");
        jUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUsersActionPerformed(evt);
            }
        });

        jButton2.setText("Log out");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

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
        jScrollPane1.setViewportView(postList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLatestPosts)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPendingRequests)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jUsers))
                                    .addComponent(jButton2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(categoryCbx, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jUnderKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jseconddate, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jfirstdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jShowMyPosts)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jNewPost)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jShowCalendar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCreateMeeting, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jShowRequests, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUpPersonalInfo)))
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPendingRequests)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(categoryCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jUsers)))
                            .addComponent(jfirstdate, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jseconddate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jUnderKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLatestPosts)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpPersonalInfo)
                    .addComponent(jShowMyPosts)
                    .addComponent(jNewPost)
                    .addComponent(btnCreateMeeting)
                    .addComponent(jShowCalendar)
                    .addComponent(jShowRequests))
                .addGap(22, 22, 22))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jNewPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNewPostActionPerformed
        new NewPosts(idb,currentUser).setVisible(true);
        dispose();
    }//GEN-LAST:event_jNewPostActionPerformed

    private void categoryCbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryCbxActionPerformed
        uppdateraUnderKategori();       
    }//GEN-LAST:event_categoryCbxActionPerformed

    public void uppdateraUnderKategori(){
     jUnderKategori.removeAllItems();
        String type = categoryCbx.getSelectedItem().toString();
        new FillComboBoxFromDb(idb).fillComboboxCategories(jUnderKategori, type);       
    }
    
    public void updateMeeting(){
        UpdateMeetings update = new UpdateMeetings(idb, currentUser);
        update.setMeetingTimes();
        update.timesSelected();
    }
    
    
    
    private void btnCreateMeetingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateMeetingActionPerformed
        new CreateMeeting(idb,currentUser, false).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCreateMeetingActionPerformed

    private void jUnderKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUnderKategoriActionPerformed
 
    }//GEN-LAST:event_jUnderKategoriActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    post(); 

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jUnderKategoriMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUnderKategoriMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jUnderKategoriMouseReleased

    private void jUnderKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUnderKategoriMouseClicked
    //post();  
    }//GEN-LAST:event_jUnderKategoriMouseClicked

    private void jShowRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jShowRequestsActionPerformed
       new HandleMeetingRequests(idb, currentUser).setVisible(true);
       dispose();
    }//GEN-LAST:event_jShowRequestsActionPerformed

    private void jShowCalendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jShowCalendarActionPerformed
        new Calendar(idb, currentUser, admin).setVisible(true);
        dispose();
    }//GEN-LAST:event_jShowCalendarActionPerformed

    private void jShowMyPostsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jShowMyPostsActionPerformed
        new MyPosts(idb, currentUser).setVisible(true);
        dispose();
    }//GEN-LAST:event_jShowMyPostsActionPerformed

    private void btnUpPersonalInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpPersonalInfoActionPerformed
        new UpdatePersonalInfo(idb, currentUser).setVisible(true);
        dispose();
    }//GEN-LAST:event_btnUpPersonalInfoActionPerformed

    private void jUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUsersActionPerformed
      new ManageUsers(idb, currentUser, admin).setVisible(true);
      dispose();
    }//GEN-LAST:event_jUsersActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new LoggInScreen(idb).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void postListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_postListValueChanged
        try {
        String listItem = postList.getSelectedValue();
        String[] post_id = listItem.split(" ");
        String pId = "";
        
        for (String id : post_id){
            pId = id;
            break;
        }
        int postId = Integer.parseInt(pId);
        
        new ViewFullPost(idb, currentUser, pId).setVisible(true);
        
        dispose();
        }
        
        catch (Exception e) {
            System.out.println("Nåt sket sig");
        
        }
    }//GEN-LAST:event_postListValueChanged

    private void postListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_postListMouseEntered
        postList.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_postListMouseEntered
 
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
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLatestPosts;
    private javax.swing.JButton jNewPost;
    private javax.swing.JLabel jPendingRequests;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jShowCalendar;
    private javax.swing.JButton jShowMyPosts;
    private javax.swing.JButton jShowRequests;
    private javax.swing.JComboBox<String> jUnderKategori;
    private javax.swing.JButton jUsers;
    private com.toedter.calendar.JDateChooser jfirstdate;
    private com.toedter.calendar.JDateChooser jseconddate;
    private javax.swing.JList<String> postList;
    // End of variables declaration//GEN-END:variables
}
