/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author marvi
 */
public class CreateMeeting extends javax.swing.JFrame {

    private InfDB idb;
    private int currentUser;
    private boolean editorMode;

    /**
     * Creates new form CreateMeeting
     */
    public CreateMeeting(InfDB idb, int id, boolean edit) {
        initComponents();
        this.idb = idb;
        this.currentUser = id;
        FillReciver();
        this.editorMode = edit;
    }

    public void CreateMeeting() {
        if(Validation.checkIfDateNull(jDateChooser)==false){
        Date dateChoosed = jDateChooser.getDate();
        String date = Calendar.ConvertDate(dateChoosed);
        if(!Validation.CheckDateTwo(date) && Validation.checkTime(tfTime) && Validation.taHarVarde(taReciver) && Validation.tfHarVarde(tfDescription) && Validation.tfHarVarde(tfRoom)){
        try {
            int creator = currentUser;
            String description = tfDescription.getText();
            String time = tfTime.getText();
            String room = tfRoom.getText();
            String mID = idb.getAutoIncrement("MEETING", "MEETING_ID");
            String sql = "insert into MEETING values(" + idb.getAutoIncrement("MEETING", "MEETING_ID") + "," + creator + ",'" + description + "','" + date + "','" + time + "','" + room + "')";
            String checkDateTimeSql = "Select MEETING_ID FROM MEETING WHERE MEETINGDATE = '"+date+"' and MEETINGTIME = '"+time+"' and MEETINGCREATER_ID = "+currentUser+";";
            
            String checkDateTime = idb.fetchSingle(checkDateTimeSql);
            if(checkDateTime == null) {
                idb.insert(sql);
           
                String reciver = taReciver.getText();
                String[] splited = reciver.split("\\s+");
                    for(int i=0;i<splited.length;i++){
                        String sqlQ = "SELECT USER_ID FROM USER1 WHERE EMAIL ='" +splited[i]+"'";
                        String reciverID = idb.fetchSingle(sqlQ);
                        System.out.println(reciverID);
                        String sqlInsert = "INSERT INTO MEETINGREQUEST VALUES ("+mID+","+reciverID+", 0)";
                        idb.insert(sqlInsert);
                        System.out.println((i+1)+"."+splited[i]);
                    }
                String sqlInsertSelf = "INSERT INTO MEETINGREQUEST VALUES ("+mID+","+currentUser+", 1)";
                idb.insert(sqlInsertSelf);    
            JOptionPane.showMessageDialog(null, "Mötet har lagts till"); 
            }
            else {
                JOptionPane.showMessageDialog(null, "Du har redan lagt till ett möte den tiden och dagen");
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
    
    public void RecreateMeeting(String meeting, String meetingCreator){
 
            String creator = meetingCreator;
            String meetingID = meeting;
            String description;
            String time;
            String room;
            String date_;
            Date date;
            
        try {
            description = idb.fetchSingle("SELECT DESCRIPTION FROM MEETING WHERE MEETING_ID ='"+meetingID+"'");
            time = idb.fetchSingle("SELECT MEETINGTIME FROM MEETING WHERE MEETING_ID ='"+meetingID+"'");
            room = idb.fetchSingle("SELECT ROOMNAME FROM MEETING WHERE MEETING_ID ='"+meetingID+"'");
            date_ = idb.fetchSingle("SELECT DATE FROM MEETING WHERE MEETING_ID ='"+meetingID+"'");
            date = new SimpleDateFormat("yyyy-mm-dd").parse(date_);

            tfDescription.setText(description);
            tfTime.setText(time);
            tfRoom.setText(room);
            jDateChooser.setDate(date);
            
        } catch (InfException | ParseException ex) {
            Logger.getLogger(CreateMeeting.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    
    
    }

    

    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        lblRubrik = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        tfDescription = new javax.swing.JTextField();
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
        jButton2 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblRubrik.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblRubrik.setText("Skapa möte");

        lblDescription.setText("Beskrivning:");

        lblRoom.setText("Rum:");

        lblDate.setText("Datum:");

        lblTime.setText("Tid:");

        tfTime.setText("15:00");

        btnCreateMeeting.setText("Skapa");
        btnCreateMeeting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateMeetingActionPerformed(evt);
            }
        });

        lblReciever.setText("Mottagare:");

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

        btnResetReciver.setText("Återställ");
        btnResetReciver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetReciverActionPerformed(evt);
            }
        });

        btnAddReciver.setText("Lägg till");
        btnAddReciver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddReciverActionPerformed(evt);
            }
        });

        jButton2.setText("Delete meeting");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblRubrik, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                .addComponent(tfRoom)
                                .addComponent(lblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblReciever, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTime, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(jDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbReciver, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnResetReciver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddReciver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
                    .addComponent(btnCreateMeeting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblRubrik, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescription)
                    .addComponent(lblDate))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRoom)
                            .addComponent(lblTime))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblReciever)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbReciver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnResetReciver)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAddReciver)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(btnCreateMeeting))
                    .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateMeetingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateMeetingActionPerformed
        CreateMeeting();
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
        String texten = taReciver.getText().trim();

        if (!texten.equals("")) {
            taReciver.append("\n");
            taReciver.append(selectedName);
            System.out.println("HEj2");
        } else {
            taReciver.append(selectedName);
            System.out.println("HEj1");
        }
        cbReciver.removeItem(selectedName);
    }//GEN-LAST:event_btnAddReciverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddReciver;
    private javax.swing.JButton btnCreateMeeting;
    private javax.swing.JButton btnResetReciver;
    private javax.swing.JComboBox<String> cbReciver;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblReciever;
    private javax.swing.JLabel lblRoom;
    private javax.swing.JLabel lblRubrik;
    private javax.swing.JLabel lblTime;
    private javax.swing.JTextArea taReciver;
    private javax.swing.JTextField tfDescription;
    private javax.swing.JTextField tfRoom;
    private javax.swing.JTextField tfTime;
    // End of variables declaration//GEN-END:variables
}
