/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
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

    /**
     * Creates new form CreateMeeting
     */
    public CreateMeeting(InfDB idb, int id) {
        initComponents();
        this.idb = idb;
        this.currentUser = id;
        FillReciver();
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

    

    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblRubrik = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        tfDescription = new javax.swing.JTextField();
        lblRoom = new javax.swing.JLabel();
        tfRoom = new javax.swing.JTextField();
        lblReciever = new javax.swing.JLabel();
        cbReciver = new javax.swing.JComboBox<>();
        btnAddReciver = new javax.swing.JButton();
        btnResetReciver = new javax.swing.JButton();
        btnCreateMeeting = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        taReciver = new javax.swing.JTextArea();
        lblDate = new javax.swing.JLabel();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        lblTime = new javax.swing.JLabel();
        tfTime = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        lblRubrik.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lblRubrik.setForeground(new java.awt.Color(255, 255, 255));
        lblRubrik.setText("Skapa möte");

        lblDescription.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblDescription.setForeground(new java.awt.Color(255, 255, 255));
        lblDescription.setText("Beskrivning:");

        lblRoom.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblRoom.setForeground(new java.awt.Color(255, 255, 255));
        lblRoom.setText("Rum:");

        lblReciever.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblReciever.setForeground(new java.awt.Color(255, 255, 255));
        lblReciever.setText("Mottagare:");

        cbReciver.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbReciver.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cbReciver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbReciverMouseClicked(evt);
            }
        });

        btnAddReciver.setText("Lägg till");
        btnAddReciver.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAddReciver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddReciverActionPerformed(evt);
            }
        });

        btnResetReciver.setText("Återställ");
        btnResetReciver.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnResetReciver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetReciverActionPerformed(evt);
            }
        });

        btnCreateMeeting.setText("Skapa");
        btnCreateMeeting.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCreateMeeting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateMeetingActionPerformed(evt);
            }
        });

        taReciver.setEditable(false);
        taReciver.setColumns(20);
        taReciver.setRows(5);
        jScrollPane3.setViewportView(taReciver);

        lblDate.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        lblDate.setText("Datum:");

        lblTime.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 255, 255));
        lblTime.setText("Tid:");

        tfTime.setText("15:00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(352, 352, 352))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbReciver, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAddReciver, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnResetReciver, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblReciever, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(151, 151, 151)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblRubrik)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfTime, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap(62, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(279, 279, 279)
                .addComponent(btnCreateMeeting, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblRubrik, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lblDescription)
                .addGap(18, 18, 18)
                .addComponent(tfDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRoom)
                    .addComponent(lblDate)
                    .addComponent(lblTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(lblReciever))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbReciver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddReciver)
                        .addGap(18, 18, 18)
                        .addComponent(btnResetReciver))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(btnCreateMeeting)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JPanel jPanel1;
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
