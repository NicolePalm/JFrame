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
        jPanel1 = new javax.swing.JPanel();
        jBackButton = new javax.swing.JButton();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jShowMeetings = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jEditMeeting = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jMeetingList = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jDescription = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jAttendants = new javax.swing.JList<>();
        jCountWords = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jNotes = new javax.swing.JTextArea();
        jSaveNote = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        jLabel3.setText("Meeting description");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jBackButton.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jBackButton.setText("Back");
        jBackButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBackButtonActionPerformed(evt);
            }
        });

        jCalendar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCalendar1MouseClicked(evt);
            }
        });

        jShowMeetings.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jShowMeetings.setText("Show meetings");
        jShowMeetings.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jShowMeetings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jShowMeetingsActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Calendar");

        jEditMeeting.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jEditMeeting.setText("Edit meeting");
        jEditMeeting.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jEditMeeting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditMeetingActionPerformed(evt);
            }
        });

        jMeetingList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMeetingListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jMeetingList);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Meeting description");

        jDescription.setEditable(false);
        jDescription.setColumns(20);
        jDescription.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jDescription.setRows(5);
        jScrollPane4.setViewportView(jDescription);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Attendants");

        jAttendants.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane3.setViewportView(jAttendants);

        jCountWords.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jCountWords.setForeground(new java.awt.Color(255, 255, 255));
        jCountWords.setText("Personal note ");

        jNotes.setColumns(20);
        jNotes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jNotes.setRows(5);
        jNotes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jNotesKeyTyped(evt);
            }
        });
        jScrollPane5.setViewportView(jNotes);

        jSaveNote.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jSaveNote.setText("Save Note");
        jSaveNote.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSaveNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSaveNoteActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Meetings on selected date");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jEditMeeting, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jShowMeetings, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSaveNote, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)))
                    .addComponent(jBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(23, 23, 23))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCountWords)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addContainerGap()))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBackButton)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jCountWords)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 39, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jShowMeetings)
                        .addGap(26, 26, 26)
                        .addComponent(jSaveNote)
                        .addGap(26, 26, 26)
                        .addComponent(jEditMeeting))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        savedNote = true;
        }
        else{
            savedNote= false;
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
            if(time.equals("00:00:00")){
                time= "";
            }
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
        jNotes.setText("");
        jCountWords.setText("Personal note");
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
            String creater = idb.fetchSingle("SELECT MEETINGCREATER_ID FROM MEETING WHERE MEETING_ID = '" + selectedMeeting + "'");
            findNote();
            if(admin.equals("1") || currentUser.equals(creater)){
            jEditMeeting.setVisible(true);
        }
            else{
                jEditMeeting.setVisible(false);
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
        savedNote = false;
     
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jMeetingList;
    private javax.swing.JTextArea jNotes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jSaveNote;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton jShowMeetings;
    // End of variables declaration//GEN-END:variables
}
