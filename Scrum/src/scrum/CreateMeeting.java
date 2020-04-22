package scrum;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;


public class CreateMeeting extends javax.swing.JFrame {

    private InfDB idb;
    private String currentUser;
    private boolean editorMode;
    private String meetingToEdit;

    
    public CreateMeeting(InfDB idb, String id, boolean edit) {
        initComponents();
        this.idb = idb;
        this.currentUser = id;
        FillReciver();
        this.editorMode = edit;
        jDelete.setVisible(false);
        taReciver.setLineWrap(true);
        tfDescription.setLineWrap(true);

    }

    public void EnterEditorMode(String meetingId){
        if(editorMode == true){
        jDelete.setVisible(true);
        btnCreateMeeting.setText("Update meeting");
        this.meetingToEdit = meetingId;
        }
    }
  
    //NYA VERSIONEN
    public void CreateMeeting() {
        if(Validation.checkIfDateNull(jDateChooser)==false){
        Date dateChoosed = jDateChooser.getDate();
        String date = Calendar.ConvertDate(dateChoosed);
        if(!Validation.CheckDateTwo(date) && Validation.checkTime(tfTime) && Validation.taHarVarde(taReciver) && Validation.descriptionValues(tfDescription) && Validation.tfHarVarde(tfRoom)){
        try {
            String creator = currentUser;
            String description = tfDescription.getText();
            String time = tfTime.getText();
            String room = tfRoom.getText();
            String mID = idb.getAutoIncrement("MEETING", "MEETING_ID");
            String sql = "insert into MEETING values(" + idb.getAutoIncrement("MEETING", "MEETING_ID") + "," + creator + ",'" + description + "','" + date + "','" + time + "','" + room + "')";
            String ifTableEmptySql = "insert into MEETING values(1,"+ creator + ",'" + description + "','" + date + "','" + time + "','" + room + "')";
            String checkDateTimeSql = "Select MEETING_ID FROM MEETING WHERE MEETINGDATE = '"+date+"' and MEETINGTIME = '"+time+"' and MEETINGCREATER_ID = "+currentUser+";";
            String emptyTableSql = "SELECT FIRST 1 MEETING_ID FROM MEETING";
            String checkIfEmpty = idb.fetchSingle(emptyTableSql);
            String checkDateTime = idb.fetchSingle(checkDateTimeSql);
            
            if(checkIfEmpty == null) { 
                if(checkDateTime == null) {
                    idb.insert(ifTableEmptySql);
           
                    String reciver = taReciver.getText();
                    String[] splited = reciver.split("\\s+");
                    for(int i=0;i<splited.length;i++){
                        String sqlQ = "SELECT USER_ID FROM USER1 WHERE EMAIL ='" +splited[i]+"'";
                        String reciverID = idb.fetchSingle(sqlQ);
                        String sqlInsert = "INSERT INTO MEETINGREQUEST VALUES (1,"+reciverID+", 0)";
                        idb.insert(sqlInsert);
                    }
                    String sqlInsertSelf = "INSERT INTO MEETINGREQUEST VALUES (1,"+currentUser+", 1)";
                    idb.insert(sqlInsertSelf);    
                    JOptionPane.showMessageDialog(null, "The meeting has been created"); 
                }
            }
            else {
                if(checkDateTime == null) {
                    idb.insert(sql);
           
                    String reciver = taReciver.getText();
                    String[] splited = reciver.split("\\s+");
                    for(int i=0;i<splited.length;i++){
                        String sqlQ = "SELECT USER_ID FROM USER1 WHERE EMAIL ='" +splited[i]+"'";
                        String reciverID = idb.fetchSingle(sqlQ);
                        String sqlInsert = "INSERT INTO MEETINGREQUEST VALUES ("+mID+","+reciverID+", 0)";
                        idb.insert(sqlInsert);
                    }
                    String sqlInsertSelf = "INSERT INTO MEETINGREQUEST VALUES ("+mID+","+currentUser+", 1)";
                    idb.insert(sqlInsertSelf);    
                    JOptionPane.showMessageDialog(null, "The meeting has been created"); 
                }
                else {
                    JOptionPane.showMessageDialog(null, "You have already added a meeting on exactly that day and time");
                }
            }
            
        } catch (InfException e) {

            System.out.println(e.getMessage());
        }
        
        }
        }
    }
    

    public void FillReciver() {
        cbReciver.removeAllItems();
        String sqlFraga = "SELECT EMAIL from User1";
        String sqlMail = "SELECT EMAIL from User1 where User_ID = '" + currentUser + "'";

        try {
            String userEmail = idb.fetchSingle(sqlMail);
            ArrayList<String> names = idb.fetchColumn(sqlFraga);

            if (names != null) {
                for (String n : names) {
                    if(!n.equals(userEmail)){
                        cbReciver.addItem(n);
                    }
                }
            }
        } catch (InfException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void RecreateMeeting(String email){
            String creator;
            String description;
            String time;
            String room;
            String date_;

            
        try {
            creator =idb.fetchSingle("SELECT USER_ID from USER1 where EMAIL = '"+email+"'");
            description = idb.fetchSingle("SELECT DESCRIPTION FROM MEETING WHERE MEETING_ID ='"+meetingToEdit+"'");
            time = idb.fetchSingle("SELECT MEETINGTIME FROM MEETING WHERE MEETING_ID ='"+meetingToEdit+"'");
            room = idb.fetchSingle("SELECT ROOMNAME FROM MEETING WHERE MEETING_ID ='"+meetingToEdit+"'");
            date_ = idb.fetchSingle("SELECT MEETINGDATE FROM MEETING WHERE MEETING_ID ='"+meetingToEdit+"'");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(date_);
            String timeFormat = time.substring(0,5);

            tfDescription.setText(description);
            tfTime.setText(timeFormat);
            tfRoom.setText(room);
            jDateChooser.setDate(date);
            FillRecieverToMeeting();
            
        } catch (InfException | ParseException ex) {
            Logger.getLogger(CreateMeeting.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    private void FillRecieverToMeeting(){
        ArrayList <String> recieverId = new ArrayList();
        ArrayList <String> recieverEmail = new ArrayList();
        
        try{
            recieverId = idb.fetchColumn("SELECT RECEIVER_ID FROM MEETINGREQUEST WHERE MEETING_ID = '" + meetingToEdit + "'");
            recieverId.remove(currentUser);
            for(String id : recieverId){
                String email = idb.fetchSingle("SELECT EMAIL FROM USER1 WHERE USER_ID = '" + id + "'");
                recieverEmail.add(email);
                }
                for(String e : recieverEmail){
                taReciver.append(e);
                taReciver.append("\n");
                cbReciver.removeItem(e);
            }
        }
        catch(InfException e){
            System.out.println(e.getMessage());
        }
    }

    public void UpdateMeeting(){
        if(Validation.checkIfDateNull(jDateChooser)==false){
        Date dateChoosed = jDateChooser.getDate();
        String date = Calendar.ConvertDate(dateChoosed);
        if(!Validation.CheckDateTwo(date) && Validation.checkTime(tfTime) && Validation.taHarVarde(taReciver) && Validation.descriptionValues(tfDescription) && Validation.tfHarVarde(tfRoom)){
        
            try{
                String description = tfDescription.getText();
                String time = tfTime.getText();
                String room = tfRoom.getText();
                idb.update("UPDATE MEETING SET description = '" + description + "', meetingdate = '" + date + "', meetingtime = '" + time + "', roomname = '" + room + "' WHERE meeting_id = '" + meetingToEdit + "'");
                String creator = idb.fetchSingle("SELECT MEETINGCREATER_ID FROM MEETING WHERE MEETING_ID = '" + meetingToEdit + "'");
                idb.delete("DELETE FROM MEETINGREQUEST WHERE RECEIVER_ID NOT IN ('" + creator + "') AND MEETING_ID = '" + meetingToEdit + "'");
                
                String reciver = taReciver.getText();
                String[] splited = reciver.split("\\s+");
                    for(int i=0;i<splited.length;i++){
                        String sqlQ = "SELECT USER_ID FROM USER1 WHERE EMAIL ='" +splited[i]+"'";
                        String reciverID = idb.fetchSingle(sqlQ);
                        System.out.println(reciverID);
                        idb.insert("INSERT INTO MEETINGREQUEST VALUES ("+meetingToEdit+","+reciverID+", 0)");
                    }
                dispose();
                new Calendar(idb, currentUser, "1").setVisible(true);
            }
            catch(InfException e){
                System.out.println(e.getMessage());
            }
         }
    }
    }

    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        lblRubrik = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        tfRoom = new javax.swing.JTextField();
        lblRoom = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        tfTime = new javax.swing.JTextField();
        btnCreateMeeting = new javax.swing.JButton();
        lblReciever = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        taReciver = new javax.swing.JTextArea();
        cbReciver = new javax.swing.JComboBox<>();
        btnResetReciver = new javax.swing.JButton();
        btnAddReciver = new javax.swing.JButton();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jDelete = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfDescription = new javax.swing.JTextArea();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblRubrik.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblRubrik.setText("Create meeting");

        lblDescription.setText("Description:");

        lblRoom.setText("Room:");

        lblDate.setText("Date:");

        lblTime.setText("Time:");

        tfTime.setText("15:00");
        tfTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTimeActionPerformed(evt);
            }
        });

        btnCreateMeeting.setText("Create");
        btnCreateMeeting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateMeetingActionPerformed(evt);
            }
        });

        lblReciever.setText("Receiver:");

        taReciver.setEditable(false);
        taReciver.setColumns(20);
        taReciver.setRows(5);
        jScrollPane3.setViewportView(taReciver);

        cbReciver.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbReciver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbReciverMouseClicked(evt);
            }
        });

        btnResetReciver.setText("Reset receiver");
        btnResetReciver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetReciverActionPerformed(evt);
            }
        });

        btnAddReciver.setText("Add receiver");
        btnAddReciver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddReciverActionPerformed(evt);
            }
        });

        jDelete.setText("Delete meeting");
        jDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteActionPerformed(evt);
            }
        });

        btnBack.setText("Back");

        tfDescription.setColumns(20);
        tfDescription.setRows(5);
        jScrollPane1.setViewportView(tfDescription);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCreateMeeting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblReciever, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1)
                            .addComponent(cbReciver, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnResetReciver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddReciver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfTime)
                            .addComponent(lblDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(tfRoom)
                            .addComponent(lblRoom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addGap(63, 63, 63)
                .addComponent(lblRubrik)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRubrik, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDate)
                    .addComponent(lblDescription))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTime)
                        .addGap(3, 3, 3)
                        .addComponent(tfTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblRoom)
                        .addGap(3, 3, 3)
                        .addComponent(tfRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(lblReciever)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbReciver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddReciver)
                        .addGap(18, 18, 18)
                        .addComponent(btnResetReciver)
                        .addGap(18, 18, 18)
                        .addComponent(jDelete))
                    .addComponent(jScrollPane3))
                .addGap(41, 41, 41)
                .addComponent(btnCreateMeeting)
                .addGap(27, 27, 27))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateMeetingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateMeetingActionPerformed
        if(editorMode == true){
        UpdateMeeting();
        }
        else{
        CreateMeeting();
        }
    }//GEN-LAST:event_btnCreateMeetingActionPerformed

    private void cbReciverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbReciverMouseClicked
        
    }//GEN-LAST:event_cbReciverMouseClicked

    private void btnResetReciverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetReciverActionPerformed
        taReciver.setText("");
        FillReciver();
    }//GEN-LAST:event_btnResetReciverActionPerformed

    private void btnAddReciverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddReciverActionPerformed
        String selectedName;
        selectedName = (String) cbReciver.getSelectedItem();

            taReciver.append(selectedName);
            taReciver.append("\n");
            cbReciver.removeItem(selectedName);
    }//GEN-LAST:event_btnAddReciverActionPerformed

    private void jDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteActionPerformed
        try{
            idb.delete("DELETE FROM MEETINGREQUEST WHERE MEETING_ID = '" + meetingToEdit + "'");
            idb.delete("DELETE FROM MEETING WHERE MEETING_ID = '" + meetingToEdit + "'");
            idb.delete("DELETE FROM MEETINGNOTES WHERE MEETINGID = '" + meetingToEdit + "'");
            dispose();
            new Calendar(idb, currentUser, "1").setVisible(true);
        }
        catch(InfException e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jDeleteActionPerformed

    private void tfTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTimeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddReciver;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateMeeting;
    private javax.swing.JButton btnResetReciver;
    private javax.swing.JComboBox<String> cbReciver;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JButton jDelete;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblReciever;
    private javax.swing.JLabel lblRoom;
    private javax.swing.JLabel lblRubrik;
    private javax.swing.JLabel lblTime;
    private javax.swing.JTextArea taReciver;
    private javax.swing.JTextArea tfDescription;
    private javax.swing.JTextField tfRoom;
    private javax.swing.JTextField tfTime;
    // End of variables declaration//GEN-END:variables
}
