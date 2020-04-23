
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
            String time = idb.fetchSingle("SELECT MEETINGTIME FROM MEETING WHERE MEETING_ID = '" + request + "'");
            String date = idb.fetchSingle("SELECT MEETINGDATE FROM MEETING WHERE MEETING_ID = '" + request + "'");
            String createrid = idb.fetchSingle("SELECT MEETINGCREATER_ID FROM MEETING WHERE MEETING_ID = '" + request + "'");
            String createrEmail = idb.fetchSingle("SELECT EMAIL FROM USER1 WHERE USER_ID = '" + createrid + "'");
            String meetingInfo = createrEmail + " " + time + " " + date;
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
        String email = requestInfo[0];
        String time = requestInfo[1];
        String date = requestInfo[2];
        
        try{
            String userId = idb.fetchSingle("SELECT user_id FROM USER1 WHERE email = '" + email + "'");
            String firstName = idb.fetchSingle("SELECT firstname FROM USER1 WHERE user_id = '" + userId + "'");
            String lastName = idb.fetchSingle("SELECT lastname FROM USER1 WHERE user_id = '" + userId + "'");
            String meeting = idb.fetchSingle("SELECT meeting_id FROM MEETING WHERE meetingcreater_id = '" + userId + "' AND meetingdate = '" + date + "' AND meetingtime = '" + time + "'");
            String room = idb.fetchSingle("SELECT roomname FROM meeting WHERE meeting_id = '" + meeting + "'");
            String description = idb.fetchSingle("SELECT description FROM meeting WHERE meeting_id = '" + meeting + "'");
            jlblRequested.setText("Requested by: " + firstName + " " + lastName);
            jlblRoom.setText("Room: " + room);
            jlblDate.setText("Date: " + date);
            jlblTime.setText("Time: " + time);
            jtxtADescription.setText(description);
            this.selectedMeeting = meeting;
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
            String time = idb.fetchSingle("SELECT MEETINGTIME FROM MEETING WHERE MEETING_ID = '" + request + "'");
            String date = idb.fetchSingle("SELECT MEETINGDATE FROM MEETING WHERE MEETING_ID = '" + request + "'");
            String createrid = idb.fetchSingle("SELECT MEETINGCREATER_ID FROM MEETING WHERE MEETING_ID = '" + request + "'");
            String createrEmail = idb.fetchSingle("SELECT EMAIL FROM USER1 WHERE USER_ID = '" + createrid + "'");
            String meetingInfo = createrEmail + " " + time + " " + date;
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
        String email = requestInfo[0];
        String time = requestInfo[1];
        String date = requestInfo[2];
        
        try{
            String userId = idb.fetchSingle("SELECT user_id FROM USER1 WHERE email = '" + email + "'");
            String firstName = idb.fetchSingle("SELECT firstname FROM USER1 WHERE user_id = '" + userId + "'");
            String lastName = idb.fetchSingle("SELECT lastname FROM USER1 WHERE user_id = '" + userId + "'");
            String meeting = idb.fetchSingle("SELECT meeting_id FROM MEETING WHERE meetingcreater_id = '" + userId + "' AND meetingdate = '" + date + "' AND meetingtime = '" + time + "'");
            String room = idb.fetchSingle("SELECT roomname FROM meeting WHERE meeting_id = '" + meeting + "'");
            String description = idb.fetchSingle("SELECT description FROM meeting WHERE meeting_id = '" + meeting + "'");
            jlblRequested.setText("Requested by: " + firstName + " " + lastName);
            jlblRoom.setText("Room: " + room);
            jlblDate.setText("Date: " + date);
            jlblTime.setText("Time: " + time);
            jtxtADescription.setText(description);
            this.selectedMeeting = meeting;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jlRequests = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtxtADescription = new javax.swing.JTextArea();
        jlblTime = new javax.swing.JLabel();
        jlblRoom = new javax.swing.JLabel();
        jlblRequested = new javax.swing.JLabel();
        jbtnAccept = new javax.swing.JButton();
        jbtnDecline = new javax.swing.JButton();
        jlblDescription = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jlAccepted = new javax.swing.JList<>();
        jlblMeetingRequests = new javax.swing.JLabel();
        jlblAcceptedMeeting = new javax.swing.JLabel();
        jlblDate = new javax.swing.JLabel();
        jbtnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlRequests.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlRequestsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jlRequests);

        jtxtADescription.setEditable(false);
        jtxtADescription.setColumns(20);
        jtxtADescription.setRows(5);
        jScrollPane2.setViewportView(jtxtADescription);

        jlblTime.setText("Time:");

        jlblRoom.setText("Room:");

        jlblRequested.setText("Requested by:");

        jbtnAccept.setText("Accept");
        jbtnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAcceptActionPerformed(evt);
            }
        });

        jbtnDecline.setText("Decline");
        jbtnDecline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeclineActionPerformed(evt);
            }
        });

        jlblDescription.setText("Description");

        jlAccepted.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlAcceptedMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jlAccepted);

        jlblMeetingRequests.setText("Meetingrequests");

        jlblAcceptedMeeting.setText("Accepted meetings");

        jlblDate.setText("Date:");

        jbtnBack.setText("Back");
        jbtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlblAcceptedMeeting, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 222, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlblMeetingRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(28, 28, 28)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jlblRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jlblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jbtnAccept)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnDecline))
                    .addComponent(jScrollPane2)
                    .addComponent(jlblRequested, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlblRequested)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblRoom)
                    .addComponent(jlblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblDate)
                    .addComponent(jlblMeetingRequests))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlblAcceptedMeeting)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlblDescription)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jbtnAccept)
                                    .addComponent(jbtnDecline))
                                .addGap(14, 14, 14)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
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

        try{
            idb.update("UPDATE meetingrequest SET status = 1 WHERE receiver_id = '" + currentUser + "' AND meeting_id = '" + selectedMeeting + "'");
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
