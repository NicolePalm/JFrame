/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author nicol
 */
public class HandleMeetingRequests extends javax.swing.JFrame {

    private InfDB idb;
    private final String currentUser;
    private String selectedMeeting;
    
    
    public HandleMeetingRequests(InfDB idb, int userID) {
        initComponents();
        this.currentUser = Integer.toString(userID);
        this.idb = idb;
        FillRequestList();
        FillAcceptedList();
        SetDefaultValues();
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

        jPanel1 = new javax.swing.JPanel();
        jbtnBack = new javax.swing.JButton();
        jlblMeetingRequests = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlRequests = new javax.swing.JList<>();
        jlblRequested = new javax.swing.JLabel();
        jlblRoom = new javax.swing.JLabel();
        jlblTime = new javax.swing.JLabel();
        jlblDate = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtxtADescription = new javax.swing.JTextArea();
        jbtnAccept = new javax.swing.JButton();
        jbtnDecline = new javax.swing.JButton();
        jlblDescription = new javax.swing.JLabel();
        jlblAcceptedMeeting = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jlAccepted = new javax.swing.JList<>();
        jlblMeetingRequests1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jbtnBack.setText("Back");
        jbtnBack.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBackActionPerformed(evt);
            }
        });

        jlblMeetingRequests.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jlblMeetingRequests.setForeground(new java.awt.Color(255, 255, 255));
        jlblMeetingRequests.setText("Meeting request");

        jlRequests.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlRequestsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jlRequests);

        jlblRequested.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jlblRequested.setForeground(new java.awt.Color(255, 255, 255));
        jlblRequested.setText("Requested by:");

        jlblRoom.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jlblRoom.setForeground(new java.awt.Color(255, 255, 255));
        jlblRoom.setText("Room:");

        jlblTime.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jlblTime.setForeground(new java.awt.Color(255, 255, 255));
        jlblTime.setText("Time:");

        jlblDate.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jlblDate.setForeground(new java.awt.Color(255, 255, 255));
        jlblDate.setText("Date:");

        jtxtADescription.setEditable(false);
        jtxtADescription.setColumns(20);
        jtxtADescription.setRows(5);
        jScrollPane2.setViewportView(jtxtADescription);

        jbtnAccept.setText("Accept");
        jbtnAccept.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAcceptActionPerformed(evt);
            }
        });

        jbtnDecline.setText("Decline");
        jbtnDecline.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnDecline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeclineActionPerformed(evt);
            }
        });

        jlblDescription.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jlblDescription.setForeground(new java.awt.Color(255, 255, 255));
        jlblDescription.setText("Description");

        jlblAcceptedMeeting.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jlblAcceptedMeeting.setForeground(new java.awt.Color(255, 255, 255));
        jlblAcceptedMeeting.setText("Accepted meetings");

        jlAccepted.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlAcceptedMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jlAccepted);

        jlblMeetingRequests1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jlblMeetingRequests1.setForeground(new java.awt.Color(255, 255, 255));
        jlblMeetingRequests1.setText("Meeting requests");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblMeetingRequests1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnBack)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                                    .addComponent(jlblAcceptedMeeting, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jlblRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbtnAccept)
                                        .addGap(42, 42, 42)
                                        .addComponent(jbtnDecline))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jlblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlblRequested, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                .addGap(68, 68, 68)
                                .addComponent(jlblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlblMeetingRequests)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlblMeetingRequests)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblRequested)
                            .addComponent(jlblDate))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblRoom)
                            .addComponent(jbtnAccept)
                            .addComponent(jbtnDecline))
                        .addGap(27, 27, 27)
                        .addComponent(jlblDescription)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(jlblAcceptedMeeting)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbtnBack)
                        .addGap(30, 30, 30)
                        .addComponent(jlblMeetingRequests1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
    private javax.swing.JLabel jlblMeetingRequests1;
    private javax.swing.JLabel jlblRequested;
    private javax.swing.JLabel jlblRoom;
    private javax.swing.JLabel jlblTime;
    private javax.swing.JTextArea jtxtADescription;
    // End of variables declaration//GEN-END:variables
}
