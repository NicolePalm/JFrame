package scrum;

import java.util.ArrayList;
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
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPublishedPosts = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jUnPublishedPosts = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jButton1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButton1.setText("Back");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("My published posts");

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

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("My unpublished posts");

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

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Double click to unpublish post");

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Double click to edit");

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("My Posts");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(840, 840, 840)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(25, Short.MAX_VALUE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       ReturnToHome.CreateHomeScreen(idb, currentUser);
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JList<String> jPublishedPosts;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> jUnPublishedPosts;
    // End of variables declaration//GEN-END:variables
}
