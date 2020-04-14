/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum;
import java.util.ArrayList;
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
      try{
            int creator = currentUser;
            String description = tfDescription.getText();
            String date = tfDate.getText();
            String time = tfTime.getText();
            String room = tfRoom.getText();
            String sql = "insert into MEETING values("+idb.getAutoIncrement("MEETING","MEETING_ID")+","+creator+",'"+description+"','"+date+"','"+time+"','"+room+"')";
            
            idb.insert(sql);
            JOptionPane.showMessageDialog(null, "Mötet har lagts till");
            }
      catch(InfException e){
            
            System.out.println(e.getMessage());    
            }
  
  }
  
  public void FillReciver() {
      cbReciver.removeAllItems();
      String sqlFraga = "SELECT EMAIL from User1";
        
        try {
            ArrayList<String> names = idb.fetchColumn(sqlFraga);
            
            if(names != null) {
                for(String n : names) {
                    cbReciver.addItem(n);
                }
            }
        }
        catch(InfException e) {
            System.out.println(e.getMessage());
        }
  }
  
  public void MeetingRequest() {
      
      
      
  }
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRubrik = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        tfDescription = new javax.swing.JTextField();
        tfRoom = new javax.swing.JTextField();
        lblRoom = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        tfDate = new javax.swing.JTextField();
        lblTime = new javax.swing.JLabel();
        tfTime = new javax.swing.JTextField();
        btnCreateMeeting = new javax.swing.JButton();
        lblReciever = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        taReciver = new javax.swing.JTextArea();
        cbReciver = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblRubrik.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblRubrik.setText("Skapa möte");

        lblDescription.setText("Beskrivning:");

        lblRoom.setText("Rum:");

        lblDate.setText("Datum:");

        tfDate.setText("DD/MM/YY");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblRubrik, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                .addComponent(tfRoom)
                                .addComponent(lblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblReciever, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCreateMeeting, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDate, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTime)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbReciver, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(207, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblRubrik, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescription)
                    .addComponent(lblDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbReciver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                        .addComponent(btnCreateMeeting)
                        .addGap(72, 72, 72))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateMeetingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateMeetingActionPerformed
          CreateMeeting();
    }//GEN-LAST:event_btnCreateMeetingActionPerformed

    private void cbReciverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbReciverMouseClicked
        System.out.println("Hallå");
        String selectedName;
        selectedName = (String) cbReciver.getSelectedItem();
        String texten = taReciver.getText().trim();
        
        if(!texten.equals("")) {
            taReciver.append("\n");
            taReciver.append(selectedName);
            System.out.println("HEj2");
        }
        else {
            taReciver.append(selectedName);
            System.out.println("HEj1");
        }
    }//GEN-LAST:event_cbReciverMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateMeeting;
    private javax.swing.JComboBox<String> cbReciver;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblReciever;
    private javax.swing.JLabel lblRoom;
    private javax.swing.JLabel lblRubrik;
    private javax.swing.JLabel lblTime;
    private javax.swing.JTextArea taReciver;
    private javax.swing.JTextField tfDate;
    private javax.swing.JTextField tfDescription;
    private javax.swing.JTextField tfRoom;
    private javax.swing.JTextField tfTime;
    // End of variables declaration//GEN-END:variables
}
