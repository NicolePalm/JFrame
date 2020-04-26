
package scrum;

import oru.inf.InfDB;
import oru.inf.InfException;

public class SelectTimeForMeeting extends javax.swing.JFrame {

    private InfDB idb;
    private String currentMeeting;
    
    public SelectTimeForMeeting(InfDB idb, String id) {
        initComponents();
        this.idb = idb;
        this.currentMeeting = id;
        jTime2.setVisible(false);
        jTime3.setVisible(false);
        jTime4.setVisible(false);
    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTitle = new javax.swing.JLabel();
        jTime1 = new javax.swing.JComboBox<>();
        jTime2 = new javax.swing.JComboBox<>();
        jTime3 = new javax.swing.JComboBox<>();
        jTime4 = new javax.swing.JComboBox<>();
        jConfirm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jTitle.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jTitle.setForeground(new java.awt.Color(255, 255, 255));
        jTitle.setText("Select Meeting Time");

        jTime1.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jTime1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No time selected", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00" }));
        jTime1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTime1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jTime1ItemStateChanged(evt);
            }
        });

        jTime2.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jTime2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No time selected", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00" }));
        jTime2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTime2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jTime2ItemStateChanged(evt);
            }
        });

        jTime3.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jTime3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No time selected", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00" }));
        jTime3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTime3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jTime3ItemStateChanged(evt);
            }
        });

        jTime4.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jTime4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No time selected", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00" }));
        jTime4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jConfirm.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jConfirm.setText("Confirm");
        jConfirm.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jTitle)
                .addGap(0, 64, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTime1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTime3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTime4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTime2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(94, 94, 94))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTitle)
                .addGap(38, 38, 38)
                .addComponent(jTime1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTime2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTime3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTime4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jConfirm)
                .addContainerGap(46, Short.MAX_VALUE))
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

    private void jConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConfirmActionPerformed
        String time1 = jTime1.getSelectedItem().toString();
        String time2 = jTime2.getSelectedItem().toString();
        String time3 = jTime3.getSelectedItem().toString();
        String time4 = jTime4.getSelectedItem().toString();
        String date = java.time.LocalDate.now().toString();
        if(time1.equals("No time selected") && time2.equals("No time selected") && time3.equals("No time selected") && time4.equals("No time selected"))
        {
            jTitle.setText("Select at least one time");
        }
        else{
            
            if(time1.equals("No time selected")){
               time1 = "00:00"; 
               
            }
            if(time2.equals("No time selected")){
               time2 = "00:00"; 
               
            }
            if(time3.equals("No time selected")){
               time3 = "00:00"; 
        
            }
            if(time4.equals("No time selected")){
               time4 = "00:00"; 
            }
            
            try{
                System.out.println(time1);
                System.out.println(time2);
               System.out.println(time3);
                System.out.println(time4);
                idb.insert("insert into MEETINGTIME (meeting_id, time_1, vote_1, time_2, vote_2, time_3, vote_3, time_4, vote_4, creation_date) values ('" + currentMeeting + "', '" + time1 + "', 0, '" + time2 + "', 0, '" + time3 + "', 0, '" + time4 + "', 0, '" + date +"')");
                dispose();
            }
            catch(InfException e){
                
            }
            
        }
    }//GEN-LAST:event_jConfirmActionPerformed

    private void jTime1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jTime1ItemStateChanged
        String value = jTime1.getSelectedItem().toString();
        if(!value.equals("No time selected")){
            jTime2.setVisible(true);
        }
    }//GEN-LAST:event_jTime1ItemStateChanged

    private void jTime2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jTime2ItemStateChanged
        String value = jTime2.getSelectedItem().toString();
        if(!value.equals("No time selected")){
            jTime3.setVisible(true);
        }
    }//GEN-LAST:event_jTime2ItemStateChanged

    private void jTime3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jTime3ItemStateChanged
        String value = jTime3.getSelectedItem().toString();
        if(!value.equals("No time selected")){
            jTime4.setVisible(true);
        }
    }//GEN-LAST:event_jTime3ItemStateChanged

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jConfirm;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jTime1;
    private javax.swing.JComboBox<String> jTime2;
    private javax.swing.JComboBox<String> jTime3;
    private javax.swing.JComboBox<String> jTime4;
    private javax.swing.JLabel jTitle;
    // End of variables declaration//GEN-END:variables
}
