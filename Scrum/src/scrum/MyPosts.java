package scrum;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import oru.inf.InfDB;
import oru.inf.InfException;

public class MyPosts extends javax.swing.JFrame {
    private InfDB idb;
    private final String currentUser;
    
    public MyPosts(InfDB idb, String userID) {
        initComponents();
        this.idb = idb;
        this.currentUser = userID;
        fillLists(jPublishedPosts, 1);
        fillLists(jUnPublishedPosts, 0);
    }
    
    
    public void fillLists (JList theList, int publishStatus){
        ArrayList<String> posts = new ArrayList();
        DefaultListModel demoList = new DefaultListModel();
        try{
        posts = idb.fetchColumn("SELECT POST_ID FROM POST WHERE POSTER_ID ='" + currentUser +"' AND POSTSTATUS = '" + publishStatus + "'");
        }
        catch(InfException e){
            System.out.println(e.getMessage());
        }
        if(PendingRequests.ContainsAllNulls(posts)==false){
        try{ 
        for(String post : posts){
            String time = idb.fetchSingle("SELECT POSTTIME FROM POST WHERE POST_ID = '" + post + "'");
            String date = idb.fetchSingle("SELECT POSTDATE FROM POST WHERE POST_ID = '" + post + "'");
            String title = idb.fetchSingle("SELECT TITLE FROM POST WHERE POST_ID = '" + post + "'");
            String postInfo = "Post nr: "+ post+" "+ "Title: " + title +" - "+time+" "+ date;
            demoList.addElement(postInfo);
        }
        }
        catch(InfException e){
                System.out.println(e.getMessage());
        }
        }
        else{
            demoList.addElement("No posts!");
        }
        theList.setModel(demoList);
    }
    
    public String GetPostId(String selectedPost){
        String[] post = selectedPost.split(" ");
        String id = post[2];
        return id;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jUnPublishedPosts = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPublishedPosts = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jUnPublishedPosts.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jUnPublishedPosts.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jUnPublishedPosts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUnPublishedPostsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jUnPublishedPosts);

        jPublishedPosts.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jPublishedPosts.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jPublishedPosts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPublishedPostsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jPublishedPosts);

        jButton1.setText("Home");

        jLabel1.setText("My published posts");

        jLabel3.setText("My unpublished posts");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPublishedPostsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPublishedPostsMouseClicked
        String value = jPublishedPosts.getSelectedValue();
        if(!value.equals("No posts!")){
        String id = GetPostId(jPublishedPosts.getSelectedValue());
        try{
            idb.update("UPDATE POST SET POSTSTATUS = 0 WHERE POST_ID = '" + id + "'");
            fillLists(jPublishedPosts, 1);
            fillLists(jUnPublishedPosts, 0);
        }
        catch(InfException e){
            System.out.println(e.getMessage());
        }
        }
    }//GEN-LAST:event_jPublishedPostsMouseClicked

    private void jUnPublishedPostsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUnPublishedPostsMouseClicked
        String selectedValue= jUnPublishedPosts.getSelectedValue();
        if(!selectedValue.equals("No posts!")){
        String postToEdit = jUnPublishedPosts.getSelectedValue();
        String [] value = postToEdit.split(" ");
        NewPosts posts = new NewPosts(idb, currentUser);
        posts.setVisible(true);
        posts.RecreatePost(value[2]);
        dispose();
        }
    }//GEN-LAST:event_jUnPublishedPostsMouseClicked

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jPublishedPosts;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> jUnPublishedPosts;
    // End of variables declaration//GEN-END:variables
}
