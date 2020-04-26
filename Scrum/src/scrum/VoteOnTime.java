
package scrum;

import oru.inf.InfDB;
import oru.inf.InfException;

public class VoteOnTime extends javax.swing.JFrame {
    
    private InfDB idb;
    private String currentMeeting;
    private String currentUser;
    
    public VoteOnTime(InfDB idb, String id, String userId) {
        initComponents();
        this.idb = idb;
        this.currentMeeting = id;
        this.currentUser = userId;
        SetTime();
    }

    private void SetTime(){
        
        String time1 = "";
        String time2 = "";
        String time3 = "";
        String time4 = "";
        try{
        time1 = idb.fetchSingle("SELECT TIME_1 FROM MEETINGTIME WHERE MEETING_ID = '" + currentMeeting + "'");
        time1 = time1.substring(0, 5);
        time2 = idb.fetchSingle("SELECT TIME_2 FROM MEETINGTIME WHERE MEETING_ID = '" + currentMeeting + "'");
        time2 = time2.substring(0, 5);
        time3 = idb.fetchSingle("SELECT TIME_3 FROM MEETINGTIME WHERE MEETING_ID = '" + currentMeeting + "'");
        time3 = time3.substring(0, 5);
        time4 = idb.fetchSingle("SELECT TIME_4 FROM MEETINGTIME WHERE MEETING_ID = '" + currentMeeting + "'");
        time4 = time4.substring(0, 5);
        }
        catch(InfException e){
            
        }
        if(time1.equals("00:00")){
            jTime1.setVisible(false);
            jVote1.setVisible(false);        
        }
        if(time2.equals("00:00")){
            jTime2.setVisible(false);
            jVote2.setVisible(false);
        }
        if(time3.equals("00:00")){
            jTime3.setVisible(false);
            jVote3.setVisible(false);
        }
        if(time4.equals("00:00")){
            jTime4.setVisible(false);
            jVote4.setVisible(false);
        }
        
        jTime1.setText(time1);
        jTime2.setText(time2);
        jTime3.setText(time3);
        jTime4.setText(time4);
        
    }
    
    
    private void Vote(String number){
         String column = "VOTE_" + number;
         try{
         String vote = idb.fetchSingle("SELECT " + column + " FROM MEETINGTIME WHERE MEETING_ID = '" + currentMeeting + "'");
         int addVote = Integer.parseInt(vote);
         addVote ++;
         vote = Integer.toString(addVote);
         String update = "UPDATE MEETINGTIME SET " + column + " = '" + vote + "' WHERE MEETING_ID = '" + currentMeeting + "'";
         idb.update(update);
         dispose();
         }
         catch(InfException e){
             
         }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTime1 = new javax.swing.JLabel();
        jVote1 = new javax.swing.JButton();
        jTime2 = new javax.swing.JLabel();
        jVote2 = new javax.swing.JButton();
        jTime3 = new javax.swing.JLabel();
        jVote3 = new javax.swing.JButton();
        jTime4 = new javax.swing.JLabel();
        jVote4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jButton1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jButton1.setText("No suitable time");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Vote for the time most suitable to you");

        jTime1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jTime1.setForeground(new java.awt.Color(255, 255, 255));
        jTime1.setText("Time 1");

        jVote1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jVote1.setText("Vote");
        jVote1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jVote1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVote1ActionPerformed(evt);
            }
        });

        jTime2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jTime2.setForeground(new java.awt.Color(255, 255, 255));
        jTime2.setText("Time 2");

        jVote2.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jVote2.setText("Vote");
        jVote2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jVote2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVote2ActionPerformed(evt);
            }
        });

        jTime3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jTime3.setForeground(new java.awt.Color(255, 255, 255));
        jTime3.setText("Time 3");

        jVote3.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jVote3.setText("Vote");
        jVote3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jVote3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVote3ActionPerformed(evt);
            }
        });

        jTime4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jTime4.setForeground(new java.awt.Color(255, 255, 255));
        jTime4.setText("Time 4");

        jVote4.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jVote4.setText("Vote");
        jVote4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jVote4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVote4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTime1)
                            .addComponent(jTime3))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jVote1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jVote3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTime4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTime2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jVote2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jVote4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTime1)
                            .addComponent(jVote1)
                            .addComponent(jVote2)
                            .addComponent(jTime2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jVote4)
                            .addComponent(jTime4)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTime3)
                        .addComponent(jVote3)))
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addContainerGap(32, Short.MAX_VALUE))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jVote1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVote1ActionPerformed
        Vote("1");
    }//GEN-LAST:event_jVote1ActionPerformed

    private void jVote2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVote2ActionPerformed
        Vote("2");
    }//GEN-LAST:event_jVote2ActionPerformed

    private void jVote3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVote3ActionPerformed
        Vote("3");
    }//GEN-LAST:event_jVote3ActionPerformed

    private void jVote4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVote4ActionPerformed
        Vote("4");
    }//GEN-LAST:event_jVote4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
        idb.delete("DELETE FROM meetingrequest WHERE meeting_id = '" + currentMeeting + "' AND receiver_id = '" + currentUser + "'");
        }
        catch(InfException e){
            
        }
        dispose();
        new HandleMeetingRequests(idb, currentUser).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jTime1;
    private javax.swing.JLabel jTime2;
    private javax.swing.JLabel jTime3;
    private javax.swing.JLabel jTime4;
    private javax.swing.JButton jVote1;
    private javax.swing.JButton jVote2;
    private javax.swing.JButton jVote3;
    private javax.swing.JButton jVote4;
    // End of variables declaration//GEN-END:variables
}
