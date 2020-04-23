package scrum;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import oru.inf.InfDB;
import oru.inf.InfException;


public class Calendar extends javax.swing.JFrame {
    private InfDB idb;
    private final String currentUser;
    private String selectedMeeting;
    private boolean savedNote;
    private String admin;

    
        public Calendar(InfDB idb, String userID, String admin) {
        initComponents();
        this.idb = idb;
        this.currentUser = userID;
        SetMeetingListDefault();
        this.savedNote = false;
        this.admin = admin;
        jNotes.setLineWrap(true);
        jEditMeeting.setVisible(false);
        
    }
    
    //sets the defaultvalues in jMeetingList
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
        jScrollPane5 = new javax.swing.JScrollPane();
        jNotes = new javax.swing.JTextArea();
        jCountWords = new javax.swing.JLabel();
        jSaveNote = new javax.swing.JButton();
        jEditMeeting = new javax.swing.JButton();

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

        jNotes.setColumns(20);
        jNotes.setRows(5);
        jNotes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jNotesKeyTyped(evt);
            }
        });
        jScrollPane5.setViewportView(jNotes);

        jCountWords.setText("Personal note ");

        jSaveNote.setText("Save Note");
        jSaveNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSaveNoteActionPerformed(evt);
            }
        });

        jEditMeeting.setText("Edit meeting");
        jEditMeeting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditMeetingActionPerformed(evt);
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
                        .addComponent(jBackButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jShowMeetings)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jEditMeeting)
                        .addGap(20, 20, 20)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCountWords)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSaveNote))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBackButton)
                        .addGap(18, 18, 18)
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jShowMeetings))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jCountWords)
                            .addComponent(jSaveNote)
                            .addComponent(jEditMeeting))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(jScrollPane4)
                            .addComponent(jScrollPane5))))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jCalendar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCalendar1MouseClicked
       
    }//GEN-LAST:event_jCalendar1MouseClicked
    
    //finds the current user's personal note for a specific meeting, if one exists
    private void findNote(){
    
        ArrayList<String> notes = new ArrayList();
        try {
            notes = idb.fetchColumn("SELECT NOTE FROM MEETINGNOTES WHERE MEETINGID ='"+selectedMeeting+"' AND USERID ='"+currentUser+"'");
        } catch (InfException ex) {
            Logger.getLogger(Calendar.class.getName()).log(Level.SEVERE, null, ex);
        }

        if(PendingRequests.ContainsAllNulls(notes)==false){
        jNotes.setText(notes.get(0));
        System.out.print(notes.get(0));
        savedNote = true;
        }
        
    }
    
    //finds all meetings on a specific day, picked from the Calendar
    private void jShowMeetingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jShowMeetingsActionPerformed
       SetDefaultValues();
       jEditMeeting.setVisible(false);
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
            String email = idb.fetchSingle("SELECT EMAIL FROM USER1 WHERE USER_ID = '" +meetingCreater+ "'");
            String meetingInfo = "Meeting nr: "+meeting+" "+"Created by: "+ email + " " + time+" In room: " + roomName;
            demoList.addElement(meetingInfo);
        }
        }
        catch(InfException e){
                System.out.println(e.getMessage());
        }
        }
        else{
            demoList.addElement("No meetings on selected day!");
            SetDefaultValues();
        }
        jMeetingList.setModel(demoList);
    }//GEN-LAST:event_jShowMeetingsActionPerformed
    
    //returns to userpanel
    private void jBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackButtonActionPerformed
        ReturnToHome.CreateHomeScreen(idb, currentUser);
        dispose();
    }//GEN-LAST:event_jBackButtonActionPerformed
    
    //calls another method when jMeetingList is clicked
    private void jMeetingListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMeetingListMouseClicked
        SelectMeeting();
    }//GEN-LAST:event_jMeetingListMouseClicked

    private void jSaveNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSaveNoteActionPerformed
        if(selectedMeeting != null && !selectedMeeting.equals("")){
        
             String note = jNotes.getText();
             int noteLength = note.length();
             if(noteLength >0 && noteLength <= 250){
             
                 try{
                     
                 if(savedNote == false){
                 idb.insert("INSERT INTO MEETINGNOTES (MEETINGID, USERID, NOTE)VALUES('"+selectedMeeting+"','"+currentUser+"','"+note+"')"); 
                 jCountWords.setText("Note saved!");
                 }
                 else{
                 idb.update("UPDATE MEETINGNOTES SET NOTE ='"+note+"' WHERE MEETINGID ='"+selectedMeeting+"' AND USERID ='"+currentUser+"'");    
                 jCountWords.setText("Note saved!");
                 }
                 }
                 catch(InfException e){
                 System.out.println(e.getMessage());
                 }
             }
             else{
                 jCountWords.setText("1-250 characters");
             }
        }
    }//GEN-LAST:event_jSaveNoteActionPerformed

    //counts the characters in the textarea jNotes and displays it in a label jCountWords
    private void jNotesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jNotesKeyTyped
        int countChar = jNotes.getText().length() + 1;
        jCountWords.setText(countChar + "/250");
    }//GEN-LAST:event_jNotesKeyTyped
    
    //opens the create meeting-panel, if the user's admin equals "1"
    private void jEditMeetingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditMeetingActionPerformed
        if(selectedMeeting != null || !selectedMeeting.equals("")){
        String value = jMeetingList.getSelectedValue();
        String[] meetingInfo = value.split(" ");
        String email = meetingInfo[5];
        
        CreateMeeting createMeeting = new CreateMeeting(idb, currentUser, true);
        createMeeting.setVisible(true);
        dispose();
        createMeeting.EnterEditorMode(selectedMeeting);
        createMeeting.RecreateMeeting(email);
      }
    }//GEN-LAST:event_jEditMeetingActionPerformed
    
   
    //selects meeting, and finds its description, attendants and personal note
    public void SelectMeeting(){
        String value = jMeetingList.getSelectedValue();
        ArrayList<String> attendants = new ArrayList();
        DefaultListModel demoList = new DefaultListModel();
        
        if(!value.equals("No meetings on selected day!")){
        String[] requestInfo = value.split(" ");
        this.selectedMeeting = requestInfo[2];

        
        try{
            attendants = idb.fetchColumn("SELECT RECEIVER_ID FROM MEETINGREQUEST WHERE MEETING_ID = '"+selectedMeeting+"' AND status = 1");
            
            for(String attending : attendants){
            String firstName = idb.fetchSingle("SELECT firstname FROM USER1 WHERE user_id = '" + attending + "'");
            String lastName = idb.fetchSingle("SELECT lastname FROM USER1 WHERE user_id = '" + attending + "'");
            String fullName = firstName+ " "+ lastName;
            demoList.addElement(fullName);
            }
            String description = idb.fetchSingle("SELECT description FROM meeting WHERE meeting_id = '" + selectedMeeting + "'");
            jAttendants.setModel(demoList);
            jDescription.setText(description);
            findNote();
            if(admin.equals("1")){
            jEditMeeting.setVisible(true);
        }

        }
        catch(InfException e){
            System.out.println(e.getMessage());
        } 
    }
        else{
            SetDefaultValues();
        }
    }
    
    //sets the defaultvalues, so that the lists and textareas are blank
    public void SetDefaultValues(){
        DefaultListModel demoList = new DefaultListModel();
        demoList.addElement("");
               
        this.selectedMeeting=null;
        this.savedNote = false;
        jDescription.setText("");
        jNotes.setText("");
        jAttendants.setModel(demoList);
        jCountWords.setText("Personal note");
     
    }
    
    //converts the selected date from the Calender to a String in a specific format
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
    private javax.swing.JLabel jCountWords;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil1;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil2;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil3;
    private javax.swing.JTextArea jDescription;
    private javax.swing.JButton jEditMeeting;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jMeetingList;
    private javax.swing.JTextArea jNotes;
    private javax.swing.JButton jSaveNote;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton jShowMeetings;
    // End of variables declaration//GEN-END:variables
}
