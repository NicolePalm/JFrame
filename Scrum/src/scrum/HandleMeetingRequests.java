
package scrum;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import oru.inf.InfDB;
import oru.inf.InfException;


public class HandleMeetingRequests extends javax.swing.JFrame {

    private InfDB idb;
    private final String currentUser;
    private String selectedMeeting;
    
    
    public HandleMeetingRequests(InfDB idb, String userID) {
        initComponents();
        this.currentUser = userID;
        this.idb = idb;
        FillRequestList();
        FillAcceptedList();
        SetDefaultValues();
        jtxtADescription.setLineWrap(true);
    }
 
    
    
    public void FillRequestList(){
        ArrayList<String> requests = new ArrayList();
        DefaultListModel demoList = new DefaultListModel();
        try{
        requests = idb.fetchColumn("SELECT MEETING_ID FROM MEETINGREQUEST WHERE RECEIVER_ID = '" + currentUser + "' AND status = 0");
        }
        catch(InfException e){
            System.out.println(e.getMessage());
        }
        if(PendingRequests.ContainsAllNulls(requests)==false){
        try{ 
        for(String request : requests){
            String date = idb.fetchSingle("SELECT MEETINGDATE FROM MEETING WHERE MEETING_ID = '" + request + "'");
            String createrid = idb.fetchSingle("SELECT MEETINGCREATER_ID FROM MEETING WHERE MEETING_ID = '" + request + "'");
            String createrEmail = idb.fetchSingle("SELECT EMAIL FROM USER1 WHERE USER_ID = '" + createrid + "'");
            String meetingInfo = "Meeting: " + request + " - " + createrEmail + " " + date;
            demoList.addElement(meetingInfo);
        }
        }
        catch(InfException e){
                System.out.println(e.getMessage());
        }
        }
        else{
            demoList.addElement("No meetingrequests");
        }
        jlRequests.setModel(demoList);
    }
   
    
    
    
    
    public void SelectMeeting(){
        String value = jlRequests.getSelectedValue();
        if(!value.equals("No meetingrequests")){
        String[] requestInfo = value.split(" ");
        String id = requestInfo[1];
        
        try{
            String userId = idb.fetchSingle("SELECT MEETINGCREATER_ID FROM MEETING WHERE MEETING_ID = '" + id + "'");
            String firstName = idb.fetchSingle("SELECT firstname FROM USER1 WHERE user_id = '" + userId + "'");
            String lastName = idb.fetchSingle("SELECT lastname FROM USER1 WHERE user_id = '" + userId + "'");
            String room = idb.fetchSingle("SELECT roomname FROM meeting WHERE meeting_id = '" + id + "'");
            String description = idb.fetchSingle("SELECT description FROM meeting WHERE meeting_id = '" + id + "'");
            String date = idb.fetchSingle("SELECT meetingdate FROM meeting WHERE meeting_id = '" + id + "'");
            String time = idb.fetchSingle("SELECT meetingtime FROM meeting WHERE meeting_id = '" + id + "'");
            time = time.substring(0, 5);
            jlblRequested.setText("Requested by: " + firstName + " " + lastName);
            jlblRoom.setText("Room: " + room);
            jlblDate.setText("Date: " + date);
            if(!time.equals("00:00")){
            jlblTime.setText("Time: " + time);
            }
            else{
                jlblTime.setText("Time not selected yet");
            }
            jtxtADescription.setText(description);
            this.selectedMeeting = id;
        }
        catch(InfException e){
            System.out.println(e.getMessage());
        } 
    }
        else{
            this.selectedMeeting = "";
            SetDefaultValues();
        }
    }
    
    public void FillAcceptedList(){
        ArrayList<String> acceptedRequests = new ArrayList();
        DefaultListModel demoList = new DefaultListModel();
        try{
        acceptedRequests = idb.fetchColumn("SELECT MEETING_ID FROM MEETINGREQUEST WHERE RECEIVER_ID = '" + currentUser + "' AND STATUS = 1");
        }
        catch(InfException e){
            System.out.println(e.getMessage());
        }
        if(PendingRequests.ContainsAllNulls(acceptedRequests)==false){
        try{ 
        for(String request : acceptedRequests){
            String date = idb.fetchSingle("SELECT MEETINGDATE FROM MEETING WHERE MEETING_ID = '" + request + "'");
            String createrid = idb.fetchSingle("SELECT MEETINGCREATER_ID FROM MEETING WHERE MEETING_ID = '" + request + "'");
            String createrEmail = idb.fetchSingle("SELECT EMAIL FROM USER1 WHERE USER_ID = '" + createrid + "'");
            String meetingInfo = "Meeting: " + request + " - " + createrEmail + " " + date;
            demoList.addElement(meetingInfo);
        }
        }
        catch(InfException e){
                System.out.println(e.getMessage());
        }
        }
        else{
            demoList.addElement("No accepted meetings");
        }
        jlAccepted.setModel(demoList);
    }
    
    public void SelectAcceptedMeeting(){
        String value = jlAccepted.getSelectedValue();
        if(!value.equals("No accepted meetings")){
        String[] requestInfo = value.split(" ");
        String id = requestInfo[1];
        
        try{
            String userId = idb.fetchSingle("SELECT MEETINGCREATER_ID FROM MEETING WHERE MEETING_ID = '" + id + "'");
            String firstName = idb.fetchSingle("SELECT firstname FROM USER1 WHERE user_id = '" + userId + "'");
            String lastName = idb.fetchSingle("SELECT lastname FROM USER1 WHERE user_id = '" + userId + "'");
            String room = idb.fetchSingle("SELECT roomname FROM meeting WHERE meeting_id = '" + id + "'");
            String description = idb.fetchSingle("SELECT description FROM meeting WHERE meeting_id = '" + id + "'");
            String date = idb.fetchSingle("SELECT meetingdate FROM meeting WHERE meeting_id = '" + id + "'");
            String time = idb.fetchSingle("SELECT meetingtime FROM meeting WHERE meeting_id = '" + id + "'");
            time = time.substring(0, 5);
            jlblRequested.setText("Requested by: " + firstName + " " + lastName);
            jlblRoom.setText("Room: " + room);
            jlblDate.setText("Date: " + date);
            if(time.equals("00:00")){
                jlblTime.setText("Time not selected yet");
            }
            else{
            jlblTime.setText("Time: " + time);
            }
            jtxtADescription.setText(description);
            this.selectedMeeting = id;
        }
        catch(InfException e){
            System.out.println(e.getMessage());
        }
    }
        else{
            SetDefaultValues();
            
        }
    }
    
    public void SetDefaultValues(){
        this.selectedMeeting = "";
        jlblRequested.setText("Requested by: ");
        jlblRoom.setText("Room: ");
        jlblDate.setText("Date: ");
        jlblTime.setText("Time: ");
        jtxtADescription.setText("");
        jbtnAccept.setVisible(false);
        jbtnDecline.setVisible(false);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbtnBack = new javax.swing.JButton();
        jlblRequested = new javax.swing.JLabel();
        jlblRoom = new javax.swing.JLabel();
        jlblTime = new javax.swing.JLabel();
        jlblDate = new javax.swing.JLabel();
        jlblMeetingRequests = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlRequests = new javax.swing.JList<>();
        jlblAcceptedMeeting = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jlAccepted = new javax.swing.JList<>();
        jbtnAccept = new javax.swing.JButton();
        jbtnDecline = new javax.swing.JButton();
        jlblDescription = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtxtADescription = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jbtnBack.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jbtnBack.setText("Back");
        jbtnBack.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBackActionPerformed(evt);
            }
        });

        jlblRequested.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlblRequested.setForeground(new java.awt.Color(255, 255, 255));
        jlblRequested.setText("Requested by:");

        jlblRoom.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlblRoom.setForeground(new java.awt.Color(255, 255, 255));
        jlblRoom.setText("Room:");

        jlblTime.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlblTime.setForeground(new java.awt.Color(255, 255, 255));
        jlblTime.setText("Time:");

        jlblDate.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlblDate.setForeground(new java.awt.Color(255, 255, 255));
        jlblDate.setText("Date:");

        jlblMeetingRequests.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlblMeetingRequests.setForeground(new java.awt.Color(255, 255, 255));
        jlblMeetingRequests.setText("Meetingrequests");

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Meeting Requests");

        jlRequests.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlRequestsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jlRequests);

        jlblAcceptedMeeting.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlblAcceptedMeeting.setForeground(new java.awt.Color(255, 255, 255));
        jlblAcceptedMeeting.setText("Accepted meetings");

        jlAccepted.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlAcceptedMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jlAccepted);

        jbtnAccept.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jbtnAccept.setText("Accept");
        jbtnAccept.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAcceptActionPerformed(evt);
            }
        });

        jbtnDecline.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jbtnDecline.setText("Decline");
        jbtnDecline.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnDecline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeclineActionPerformed(evt);
            }
        });

        jlblDescription.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlblDescription.setForeground(new java.awt.Color(255, 255, 255));
        jlblDescription.setText("Description");

        jtxtADescription.setEditable(false);
        jtxtADescription.setColumns(20);
        jtxtADescription.setRows(5);
        jScrollPane2.setViewportView(jtxtADescription);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlblMeetingRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jlblRequested, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jlblRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jlblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(122, 122, 122)
                                            .addComponent(jlblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jlblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(63, 63, 63)
                                            .addComponent(jbtnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jbtnDecline, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblAcceptedMeeting, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jbtnBack))
                .addGap(5, 5, 5)
                .addComponent(jlblMeetingRequests)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlblRoom)
                            .addComponent(jlblRequested))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlblDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlblDescription))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jbtnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbtnDecline)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 17, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlblAcceptedMeeting)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap(51, Short.MAX_VALUE))
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

    private void jlRequestsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlRequestsMouseClicked
        jbtnAccept.setVisible(true);
        jbtnDecline.setVisible(true);
        SelectMeeting();
    }//GEN-LAST:event_jlRequestsMouseClicked

    private void jbtnDeclineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeclineActionPerformed
        try{
        idb.delete("DELETE FROM meetingrequest WHERE meeting_id = '" + selectedMeeting + "' AND receiver_id = '" + currentUser + "'");
        SetDefaultValues();
        this.selectedMeeting = "";
        }
        catch(InfException e){
            
        }
        SetDefaultValues();
        FillRequestList();
    }//GEN-LAST:event_jbtnDeclineActionPerformed

    private void jbtnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAcceptActionPerformed
        String meetingTime = jlblTime.getText();
        String time = "Time not selected yet";
        System.out.println(meetingTime);
        System.out.println(time);
        try{
            idb.update("UPDATE meetingrequest SET status = 1 WHERE receiver_id = '" + currentUser + "' AND meeting_id = '" + selectedMeeting + "'");
            if(meetingTime.equals(time)){
            new VoteOnTime(idb, selectedMeeting, currentUser).setVisible(true);
           }
        }
        catch(InfException e){
        
        }
        SetDefaultValues();
        FillAcceptedList();
        FillRequestList();
       

    }//GEN-LAST:event_jbtnAcceptActionPerformed

    private void jlAcceptedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAcceptedMouseClicked
        jbtnAccept.setVisible(false);
        jbtnDecline.setVisible(false);
        SelectAcceptedMeeting();
    }//GEN-LAST:event_jlAcceptedMouseClicked

    private void jbtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBackActionPerformed
        ReturnToHome.CreateHomeScreen(idb, currentUser);
        dispose();
    }//GEN-LAST:event_jbtnBackActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbtnAccept;
    private javax.swing.JButton jbtnBack;
    private javax.swing.JButton jbtnDecline;
    private javax.swing.JList<String> jlAccepted;
    private javax.swing.JList<String> jlRequests;
    private javax.swing.JLabel jlblAcceptedMeeting;
    private javax.swing.JLabel jlblDate;
    private javax.swing.JLabel jlblDescription;
    private javax.swing.JLabel jlblMeetingRequests;
    private javax.swing.JLabel jlblRequested;
    private javax.swing.JLabel jlblRoom;
    private javax.swing.JLabel jlblTime;
    private javax.swing.JTextArea jtxtADescription;
    // End of variables declaration//GEN-END:variables
}
