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
        post();
    }
    
    
        public void post () {
        try {

            String category = categoryCbx.getSelectedItem().toString();
            int categoryId;

            System.out.println(category);


            String postQuery = "SELECT post_id, title, postdate, posttime, post.category_id FROM post, category \n" +
                                "WHERE post.CATEGORY_ID = category.CATEGORY_ID AND categorytype = '" + category + "' ORDER BY postdate DESC, posttime DESC";
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

        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jNewPost = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        postList = new javax.swing.JList<>();
        categoryCbx = new javax.swing.JComboBox<>();
        btnCreateMeeting = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

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
        postList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
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

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(categoryCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jNewPost)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCreateMeeting, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(191, 191, 191)))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(categoryCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNewPost)
                    .addComponent(btnCreateMeeting))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jNewPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNewPostActionPerformed
        new NewPosts(idb,currentUser).setVisible(true);
    }//GEN-LAST:event_jNewPostActionPerformed

    private void categoryCbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryCbxActionPerformed
        post();
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


    
    
    
    private void postListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_postListMouseEntered
        postList.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_postListMouseEntered

    private void btnCreateMeetingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateMeetingActionPerformed
        new CreateMeeting(idb,currentUser).setVisible(true);
    }//GEN-LAST:event_btnCreateMeetingActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateMeeting;
    private javax.swing.JComboBox<String> categoryCbx;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton jNewPost;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> postList;
    // End of variables declaration//GEN-END:variables
}
