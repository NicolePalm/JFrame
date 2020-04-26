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
        tfDescription.requestFocus();
        jDelete.setVisible(false);
        taReciver.setLineWrap(true);
        tfDescription.setLineWrap(true);
        jCounterDes.setVisible(false);
        jCounterRoom.setVisible(false);

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
        String description = tfDescription.getText();
        String room = tfRoom.getText();
        if(Validation.checkIfDateNull(jDateChooser)==false){
        Date dateChoosed = jDateChooser.getDate();
        String date = Calendar.ConvertDate(dateChoosed);
        if(!Validation.CheckDateTwo(date) && Validation.taHarVarde(taReciver) && Validation.descriptionValues(tfDescription) && Validation.tfHarVarde(tfRoom, "Enter a room where the meeting will take place")){
         if (description.length() + 1 <= 250) {
             if(room.length() + 1 <= 30){
            try {
            String creator = currentUser;
            String mID = idb.getAutoIncrement("MEETING", "MEETING_ID");
            String sql = "insert into MEETING values(" + idb.getAutoIncrement("MEETING", "MEETING_ID") + "," + creator + ",'" + description + "','" + date + "','00:00','" + room + "')";
            String ifTableEmptySql = "insert into MEETING values(1,"+ creator + ",'" + description + "','" + date + "','00:00','" + room + "')";
            String emptyTableSql = "SELECT FIRST 1 MEETING_ID FROM MEETING";
            String checkIfEmpty = idb.fetchSingle(emptyTableSql);
            
            if(checkIfEmpty == null) { 
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
                    tfDescription.setText("");
                    tfRoom.setText("");
                    taReciver.setText("");
                    FillReciver();
                    tfDescription.requestFocus();
                    new SelectTimeForMeeting(idb, "1").setVisible(true);
                    
              
            }
            else {
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
                    tfDescription.setText("");
                    tfRoom.setText("");
                    taReciver.setText("");
                    FillReciver();
                    tfDescription.requestFocus();
                    new SelectTimeForMeeting(idb, mID).setVisible(true);
               
                }
            }
            catch (InfException e) {

            System.out.println(e.getMessage());
        }  
        }
         else{
             jCounterRoom.setVisible(true);
             jCounterRoom.setText("Too many characters");
         }
         }
         else{
             jCounterDes.setText("Too long description");
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
            Date date = dateFormat.parse(date_);;

            tfDescription.setText(description);
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
        String description = tfDescription.getText();;
        String room = tfRoom.getText();
        if(!Validation.CheckDateTwo(date) && Validation.taHarVarde(taReciver) && Validation.descriptionValues(tfDescription) && Validation.tfHarVarde(tfRoom, "Enter a room where the meeting will take place")){
        if (description.length() + 1 <= 250) {
            if(room.length() + 1 <= 30){
            try{
                idb.update("UPDATE MEETING SET description = '" + description + "', meetingdate = '" + date + "', roomname = '" + room + "' WHERE meeting_id = '" + meetingToEdit + "'");
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
        else{
            jCounterRoom.setVisible(true);
            jCounterRoom.setText("Too many characters");
        }
        }
        else{
            jCounterDes.setText("Too long description");
        }
        }
    }
    }

    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        lblRubrik = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        jCounterDes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfDescription = new javax.swing.JTextArea();
        lblDate = new javax.swing.JLabel();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        lblRoom = new javax.swing.JLabel();
        jCounterRoom = new javax.swing.JLabel();
        tfRoom = new javax.swing.JTextField();
        lblReciever = new javax.swing.JLabel();
        cbReciver = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        taReciver = new javax.swing.JTextArea();
        btnAddReciver = new javax.swing.JButton();
        btnResetReciver = new javax.swing.JButton();
        jDelete = new javax.swing.JButton();
        btnCreateMeeting = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        btnBack.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnBack.setText("Back");
        btnBack.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblRubrik.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lblRubrik.setForeground(new java.awt.Color(255, 255, 255));
        lblRubrik.setText("Create meeting");

        lblDescription.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblDescription.setForeground(new java.awt.Color(255, 255, 255));
        lblDescription.setText("Description:");

        jCounterDes.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jCounterDes.setForeground(new java.awt.Color(255, 255, 255));
        jCounterDes.setText("counter");

        tfDescription.setColumns(20);
        tfDescription.setRows(5);
        tfDescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfDescriptionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tfDescription);

        lblDate.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        lblDate.setText("Date:");

        lblRoom.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblRoom.setForeground(new java.awt.Color(255, 255, 255));
        lblRoom.setText("Room:");

        jCounterRoom.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jCounterRoom.setForeground(new java.awt.Color(255, 255, 255));
        jCounterRoom.setText("counter");

        tfRoom.setMaximumSize(new java.awt.Dimension(30, 2147483647));
        tfRoom.setName(""); // NOI18N
        tfRoom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfRoomKeyTyped(evt);
            }
        });

        lblReciever.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblReciever.setForeground(new java.awt.Color(255, 255, 255));
        lblReciever.setText("Receiver:");

        cbReciver.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        cbReciver.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbReciver.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cbReciver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbReciverMouseClicked(evt);
            }
        });

        taReciver.setEditable(false);
        taReciver.setColumns(20);
        taReciver.setRows(5);
        jScrollPane3.setViewportView(taReciver);

        btnAddReciver.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnAddReciver.setText("Add receiver");
        btnAddReciver.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAddReciver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddReciverActionPerformed(evt);
            }
        });

        btnResetReciver.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnResetReciver.setText("Reset receiver");
        btnResetReciver.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnResetReciver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetReciverActionPerformed(evt);
            }
        });

        jDelete.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jDelete.setText("Delete meeting");
        jDelete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteActionPerformed(evt);
            }
        });

        btnCreateMeeting.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        btnCreateMeeting.setText("Create");
        btnCreateMeeting.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCreateMeeting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateMeetingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAddReciver, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnResetReciver, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addComponent(jScrollPane3)
                                .addGap(13, 13, 13))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCounterRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jDateChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                .addComponent(cbReciver, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(lblRubrik))
                            .addComponent(lblReciever, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(179, 179, 179)
                                    .addComponent(jCounterDes, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(tfRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(btnCreateMeeting, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRubrik, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCounterDes)
                    .addComponent(lblDescription))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDate)
                    .addComponent(lblRoom)
                    .addComponent(jCounterRoom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfRoom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblReciever)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbReciver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddReciver)
                        .addGap(18, 18, 18)
                        .addComponent(btnResetReciver)
                        .addGap(18, 18, 18)
                        .addComponent(jDelete))
                    .addComponent(jScrollPane3))
                .addGap(18, 18, 18)
                .addComponent(btnCreateMeeting)
                .addContainerGap(37, Short.MAX_VALUE))
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
            idb.delete("DELETE FROM MEETINGTIME WHERE MEETING_ID = '" + meetingToEdit + "'");
            idb.delete("DELETE FROM MEETING WHERE MEETING_ID = '" + meetingToEdit + "'");
            idb.delete("DELETE FROM MEETINGNOTES WHERE MEETINGID = '" + meetingToEdit + "'");
            dispose();
            new Calendar(idb, currentUser, "1").setVisible(true);
        }
        catch(InfException e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jDeleteActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        if(editorMode == false){
        ReturnToHome.CreateHomeScreen(idb, currentUser);
        dispose();
        }
        else{
            ReturnToHome.CreateCalendar(idb, currentUser);
            dispose();
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void tfDescriptionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDescriptionKeyTyped
        int countChar = tfDescription.getText().length() + 1;
        jCounterDes.setText(countChar + "/250");
        jCounterDes.setVisible(true);
    }//GEN-LAST:event_tfDescriptionKeyTyped

    private void tfRoomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfRoomKeyTyped

    }//GEN-LAST:event_tfRoomKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddReciver;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateMeeting;
    private javax.swing.JButton btnResetReciver;
    private javax.swing.JComboBox<String> cbReciver;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jCounterDes;
    private javax.swing.JLabel jCounterRoom;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JButton jDelete;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblReciever;
    private javax.swing.JLabel lblRoom;
    private javax.swing.JLabel lblRubrik;
    private javax.swing.JTextArea taReciver;
    private javax.swing.JTextArea tfDescription;
    private javax.swing.JTextField tfRoom;
    // End of variables declaration//GEN-END:variables
}
