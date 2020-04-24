
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
    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTime3 = new javax.swing.JComboBox<>();
        jTime2 = new javax.swing.JComboBox<>();
        jTime4 = new javax.swing.JComboBox<>();
        jTime1 = new javax.swing.JComboBox<>();
        jConfirm = new javax.swing.JButton();
        jTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTime3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No time selected", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00" }));

        jTime2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No time selected", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00" }));

        jTime4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No time selected", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00" }));

        jTime1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No time selected", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00" }));

        jConfirm.setText("Confirm");
        jConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConfirmActionPerformed(evt);
            }
        });

        jTitle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTitle.setText("Please select up to four diffrent meetingtimes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTime3, 0, 124, Short.MAX_VALUE)
                            .addComponent(jTime1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTime2, 0, 123, Short.MAX_VALUE)
                            .addComponent(jTime4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jTitle))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jTitle)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTime2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTime1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTime4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTime3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jConfirm)
                .addContainerGap(25, Short.MAX_VALUE))
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

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jConfirm;
    private javax.swing.JComboBox<String> jTime1;
    private javax.swing.JComboBox<String> jTime2;
    private javax.swing.JComboBox<String> jTime3;
    private javax.swing.JComboBox<String> jTime4;
    private javax.swing.JLabel jTitle;
    // End of variables declaration//GEN-END:variables
}
