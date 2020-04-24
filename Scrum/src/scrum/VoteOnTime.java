
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

        jTime1 = new javax.swing.JLabel();
        jTime3 = new javax.swing.JLabel();
        jVote1 = new javax.swing.JButton();
        jVote3 = new javax.swing.JButton();
        jTime2 = new javax.swing.JLabel();
        jTime4 = new javax.swing.JLabel();
        jVote2 = new javax.swing.JButton();
        jVote4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTime1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTime1.setText("Time1");

        jTime3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTime3.setText("Time3");

        jVote1.setText("Vote");
        jVote1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVote1ActionPerformed(evt);
            }
        });

        jVote3.setText("Vote");
        jVote3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVote3ActionPerformed(evt);
            }
        });

        jTime2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTime2.setText("Time2");

        jTime4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTime4.setText("Time4");

        jVote2.setText("Vote");
        jVote2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVote2ActionPerformed(evt);
            }
        });

        jVote4.setText("Vote");
        jVote4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVote4ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Vote for the time most suitable to you");

        jButton1.setText("No suitable time");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTime1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jVote1))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jTime3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jVote3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTime4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jVote4)
                                        .addGap(1, 1, 1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTime2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jVote2))))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTime1)
                    .addComponent(jVote1)
                    .addComponent(jVote2)
                    .addComponent(jTime2))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jVote3)
                    .addComponent(jVote4)
                    .addComponent(jTime3)
                    .addComponent(jTime4))
                .addGap(37, 37, 37))
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
