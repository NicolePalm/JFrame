/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.DefaultListModel;
import oru.inf.InfDB;
import oru.inf.InfException;


public class Calendar extends javax.swing.JFrame {
    private InfDB idb;
    private final String currentUser;

    public Calendar(InfDB idb, int userID) {
        initComponents();
        this.idb = idb;
        this.currentUser = Integer.toString(userID);
        SetMeetingListDefault();
        
    }
    
    private void SetMeetingListDefault(){
        DefaultListModel demoList = new DefaultListModel();
        demoList.addElement("No meetings on selected day!");
        jMeetingList.setModel(demoList);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDatePickerUtil1 = new org.jdatepicker.util.JDatePickerUtil();
        jDatePickerUtil2 = new org.jdatepicker.util.JDatePickerUtil();
        jDatePickerUtil3 = new org.jdatepicker.util.JDatePickerUtil();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jMeetingList = new javax.swing.JList<>();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jShowMeetings = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jAttendants = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jBackButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jDescription = new javax.swing.JTextArea();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        jLabel3.setText("Meeting description");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMeetingList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMeetingListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jMeetingList);

        jCalendar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCalendar1MouseClicked(evt);
            }
        });

        jShowMeetings.setText("Show meetings");
        jShowMeetings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jShowMeetingsActionPerformed(evt);
            }
        });

        jLabel1.setText("Meetings on selected date");

        jLabel2.setText("Attendants");

        jScrollPane3.setViewportView(jAttendants);

        jLabel4.setText("Meeting description");

        jBackButton.setText("Back");
        jBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBackButtonActionPerformed(evt);
            }
        });

        jDescription.setEditable(false);
        jDescription.setColumns(20);
        jDescription.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jDescription.setRows(5);
        jScrollPane4.setViewportView(jDescription);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jShowMeetings))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBackButton)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBackButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jShowMeetings))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(jScrollPane4))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCalendar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCalendar1MouseClicked
       
    }//GEN-LAST:event_jCalendar1MouseClicked

    private void jShowMeetingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jShowMeetingsActionPerformed
       Date datum =  jCalendar1.getDate();
       String currentDate = ConvertDate(datum);
       
        ArrayList<String> meetings = new ArrayList();
        DefaultListModel demoList = new DefaultListModel();
        try{
        meetings = idb.fetchColumn("SELECT MEETING_ID FROM MEETING WHERE MEETINGDATE ='"+currentDate+"'");
        }
        catch(InfException e){
            System.out.println(e.getMessage());
        }
        if(PendingRequests.ContainsAllNulls(meetings)==false){
        try{ 
        for(String meeting : meetings){
            String time = idb.fetchSingle("SELECT MEETINGTIME FROM MEETING WHERE MEETING_ID = '" +meeting+ "'");
            String roomName = idb.fetchSingle("SELECT ROOMNAME FROM MEETING WHERE MEETING_ID = '" +meeting+ "'");
            String meetingCreater = idb.fetchSingle("SELECT MEETINGCREATER_ID FROM MEETING WHERE MEETING_ID ='"+meeting+"'");
            String firstName = idb.fetchSingle("SELECT FIRSTNAME FROM USER1 WHERE USER_ID = '" +meetingCreater+ "'");
            String lastName = idb.fetchSingle("SELECT LASTNAME FROM USER1 WHERE USER_ID = '" +meetingCreater+ "'");
            String meetingInfo = "Meeting nr: "+meeting+" "+"Created by: "+firstName+" "+lastName+" "+" "+time+" In room: "+roomName;
            demoList.addElement(meetingInfo);
        }
        }
        catch(InfException e){
                System.out.println(e.getMessage());
        }
        }
        else{
            demoList.addElement("No meetings on selected day!");
        }
        jMeetingList.setModel(demoList);
    
       
    }//GEN-LAST:event_jShowMeetingsActionPerformed

    private void jBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackButtonActionPerformed
        ReturnToHome.CreateHomeScreen(idb, currentUser);
        dispose();
    }//GEN-LAST:event_jBackButtonActionPerformed

    private void jMeetingListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMeetingListMouseClicked
        SelectMeeting();
    }//GEN-LAST:event_jMeetingListMouseClicked

    public void SelectMeeting(){
        String value = jMeetingList.getSelectedValue();
        ArrayList<String> attendants = new ArrayList();
        DefaultListModel demoList = new DefaultListModel();
        
        if(!value.equals("No meetings on selected day!")){
        String[] requestInfo = value.split(" ");
        String meetingID = requestInfo[2];
        System.out.print(meetingID);
        
        try{
            attendants = idb.fetchColumn("SELECT RECEIVER_ID FROM MEETINGREQUEST WHERE MEETING_ID = '"+meetingID+"' AND status = 1");
            
            for(String attending : attendants){
            String firstName = idb.fetchSingle("SELECT firstname FROM USER1 WHERE user_id = '" + attending + "'");
            String lastName = idb.fetchSingle("SELECT lastname FROM USER1 WHERE user_id = '" + attending + "'");
            String fullName = firstName+ " "+ lastName;
            demoList.addElement(fullName);
            }
            String description = idb.fetchSingle("SELECT description FROM meeting WHERE meeting_id = '" + meetingID + "'");
            jAttendants.setModel(demoList);
            jDescription.setText(description);

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
    
        jDescription.setText("");
        
    }
    public static String ConvertDate(Date selectedDate){
    
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.ENGLISH);
        String date = simpleDateFormat.format(selectedDate);
        return date;
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> jAttendants;
    private javax.swing.JButton jBackButton;
    private com.toedter.calendar.JCalendar jCalendar1;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil1;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil2;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil3;
    private javax.swing.JTextArea jDescription;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jMeetingList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton jShowMeetings;
    // End of variables declaration//GEN-END:variables
}
