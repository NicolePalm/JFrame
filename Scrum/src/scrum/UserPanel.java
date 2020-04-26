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
        LatestPosts();
        if(admin.equals("0")){
        jUsers.setVisible(false);
        
        }
    }
    
    
    
    
    
    
    public void LatestPosts(){
        
    String title = "";
        String date = "";
        String time = "";
        int i = 1;
        DefaultListModel listModel = new DefaultListModel();
         ArrayList <String> publishedId = new ArrayList();
         try{
         publishedId = idb.fetchColumn("SELECT POST_ID FROM POST WHERE POSTSTATUS = 1 ORDER BY postdate DESC, posttime DESC");
         if(PendingRequests.ContainsAllNulls(publishedId) == false){
             for(String id : publishedId){
                 if(i < 6){
                 title = idb.fetchSingle("SELECT TITLE FROM POST WHERE POST_ID = '" + id + "'");
                 date = idb.fetchSingle("SELECT POSTDATE FROM POST WHERE POST_ID = '" + id + "'");
                 time = idb.fetchSingle("SELECT POSTTIME FROM POST WHERE POST_ID = '" + id + "'");
                 listModel.addElement(id + " | " + title + " | " + date + " | " + time);
                 i++;
                 }
             }
         }

        postList.setModel(listModel);
        }

        catch (NumberFormatException | InfException e) {
            System.out.println("Error");
            JOptionPane.showMessageDialog(null, "No posts in this category");
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
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jUsers = new javax.swing.JButton();
        categoryCbx = new javax.swing.JComboBox<>();
        jUnderKategori = new javax.swing.JComboBox<>();
        jseconddate = new com.toedter.calendar.JDateChooser();
        jfirstdate = new com.toedter.calendar.JDateChooser();
        jPendingRequests = new javax.swing.JLabel();
        jLatestPosts = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        postList = new javax.swing.JList<>();
        btnUpPersonalInfo = new javax.swing.JButton();
        jShowRequests = new javax.swing.JButton();
        btnCreateMeeting = new javax.swing.JButton();
        jShowCalendar = new javax.swing.JButton();
        jNewPost = new javax.swing.JButton();
        jShowMyPosts = new javax.swing.JButton();
        jSearch = new javax.swing.JButton();
        jSearchField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jButton2.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButton2.setText("Log out");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButton1.setText("Update");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jUsers.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jUsers.setText("Manage users");
        jUsers.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUsersActionPerformed(evt);
            }
        });

        categoryCbx.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        categoryCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Formal", "Informal" }));
        categoryCbx.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        categoryCbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryCbxActionPerformed(evt);
            }
        });

        jUnderKategori.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jUnderKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jUnderKategori.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
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

        jPendingRequests.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jPendingRequests.setForeground(new java.awt.Color(255, 255, 255));
        jPendingRequests.setText("Pending requests");

        jLatestPosts.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLatestPosts.setForeground(new java.awt.Color(255, 255, 255));
        jLatestPosts.setText("Latest posts");

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

        btnUpPersonalInfo.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnUpPersonalInfo.setText("Update personal details");
        btnUpPersonalInfo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUpPersonalInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpPersonalInfoActionPerformed(evt);
            }
        });

        jShowRequests.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jShowRequests.setText("Meeting requests");
        jShowRequests.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jShowRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jShowRequestsActionPerformed(evt);
            }
        });

        btnCreateMeeting.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCreateMeeting.setText("Create meeting");
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

        jNewPost.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jNewPost.setText("New post");
        jNewPost.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jNewPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNewPostActionPerformed(evt);
            }
        });

        jShowMyPosts.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jShowMyPosts.setText("My posts");
        jShowMyPosts.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jShowMyPosts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jShowMyPostsActionPerformed(evt);
            }
        });

        jSearch.setText("Search ");
        jSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jNewPost, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(jShowMyPosts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(137, 137, 137)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jShowRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCreateMeeting, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnUpPersonalInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                            .addComponent(jShowCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(68, 68, 68)
                                .addComponent(jUsers))
                            .addComponent(jPendingRequests))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(categoryCbx, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jUnderKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jseconddate, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jfirstdate, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLatestPosts)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSearch)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jUsers)
                        .addComponent(categoryCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jUnderKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jfirstdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jseconddate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPendingRequests)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLatestPosts, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSearchField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jShowMyPosts)
                    .addComponent(btnUpPersonalInfo)
                    .addComponent(jShowRequests))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNewPost)
                    .addComponent(jShowCalendar)
                    .addComponent(btnCreateMeeting))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSearchActionPerformed
        String title = "";
        
        String searchQuery = jSearchField.getText();
        String date = "";
        String time = "";
        int i = 1;
        DefaultListModel listModel = new DefaultListModel();
         ArrayList <String> publishedId = new ArrayList();
         try{
         publishedId = idb.fetchColumn("SELECT POST_ID FROM POST WHERE POSTSTATUS = 1 ORDER BY postdate DESC, posttime DESC");
         if(PendingRequests.ContainsAllNulls(publishedId) == false){
             for(String id : publishedId){
                 
                 title = idb.fetchSingle("SELECT TITLE FROM POST WHERE POST_ID = '" + id + "'");
                 if(title.contains(searchQuery)){
                 date = idb.fetchSingle("SELECT POSTDATE FROM POST WHERE POST_ID = '" + id + "'");
                 time = idb.fetchSingle("SELECT POSTTIME FROM POST WHERE POST_ID = '" + id + "'");
                 listModel.addElement(id + " | " + title + " | " + date + " | " + time);
                 }
             }
         }

        postList.setModel(listModel);
        }

        catch (NumberFormatException | InfException e) {
            System.out.println("Error");
            JOptionPane.showMessageDialog(null, "No posts in this category");
        }
    
    }//GEN-LAST:event_jSearchActionPerformed
 
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jPendingRequests;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jSearch;
    private javax.swing.JTextField jSearchField;
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
