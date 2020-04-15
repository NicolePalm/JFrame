/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import static java.util.Collections.list;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author nicol
 */
public class HandleMeetingRequests extends javax.swing.JFrame {

    private InfDB idb;
    private final String currentUser;
    
    
    public HandleMeetingRequests(InfDB idb, int userID) {
        initComponents();
        this.currentUser = Integer.toString(userID);
        this.idb = idb;
        FillRequestList();
        SelectMeeting();
    }
 
    public void FillRequestList(){
        ArrayList<String> requests = new ArrayList();
        DefaultListModel demoList = new DefaultListModel();
        try{
        requests = idb.fetchColumn("SELECT MEETING_ID FROM MEETINGREQUEST WHERE RECEIVER_ID = '" + currentUser + "'");
        }
        catch(InfException e){
            System.out.println(e.getMessage());
        }
        if(ContainsAllNulls(requests)==false){
        try{ 
        for(String request : requests){
            String time = idb.fetchSingle("SELECT MEETINGTIME FROM MEETING WHERE MEETING_ID = '" + request + "'");
            String date = idb.fetchSingle("SELECT MEETINGDATE FROM MEETING WHERE MEETING_ID = '" + request + "'");
            String createrid = idb.fetchSingle("SELECT MEETINGCREATER_ID FROM MEETING WHERE MEETING_ID = '" + request + "'");
            String createrFirstname = idb.fetchSingle("SELECT FIRSTNAME FROM USER1 WHERE USER_ID = '" + createrid + "'");
            String createrLastname = idb.fetchSingle("SELECT LASTNAME FROM USER1 WHERE USER_ID = '" + createrid + "'");
            String meetingInfo = createrFirstname + " " + createrLastname + " " + time + " " + date;
            demoList.addElement(meetingInfo);
        }
        jlRequests.setModel(demoList);
        }
        catch(InfException e){
                System.out.println(e.getMessage());
        }
        }
    }
    
    public Boolean ContainsAllNulls(ArrayList arrList)
    {
    if(arrList != null)
    {
    if (!arrList.stream().noneMatch((a) -> (a != null))) {
            return false;
    }
    }
    return true;
    }
    
    
    public void SelectMeeting(){
        int index = jlRequests.getSelectedIndex();
        String indexet = Integer.toString(index);
        String value = jlRequests.getSelectedValue();
        String myString = String.valueOf(jlRequests.getSelectedValue());
        System.out.println(myString);
        System.out.println(value);
    }
    
    
     MouseListener mouseListener = new MouseAdapter() {
      public void mouseClicked(MouseEvent mouseEvent) {
        JList jlRequests = (JList) mouseEvent.getSource();
        if (mouseEvent.getClickCount() == 1) {
          int index = jlRequests.locationToIndex(mouseEvent.getPoint());
          if (index >= 0) {
            Object o = jlRequests.getModel().getElementAt(index);
            System.out.println("Double-clicked on: " + o.toString());
          }
        }
      }
    };
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jlRequests = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtxtADescription = new javax.swing.JTextArea();
        jlblTime = new javax.swing.JLabel();
        jlblRoom = new javax.swing.JLabel();
        jlblRequested = new javax.swing.JLabel();
        jbtnAccept = new javax.swing.JButton();
        jbtnDecline = new javax.swing.JButton();
        jlblDescription = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jlAccepted = new javax.swing.JList<>();
        jlblMeetingRequests = new javax.swing.JLabel();
        jlblAcceptedMeeting = new javax.swing.JLabel();
        jlblDate = new javax.swing.JLabel();
        jbtnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jlRequests);

        jtxtADescription.setEditable(false);
        jtxtADescription.setColumns(20);
        jtxtADescription.setRows(5);
        jScrollPane2.setViewportView(jtxtADescription);

        jlblTime.setText("Time:");

        jlblRoom.setText("Room:");

        jlblRequested.setText("Requested by:");

        jbtnAccept.setText("Accept");

        jbtnDecline.setText("Decline");

        jlblDescription.setText("Description");

        jlAccepted.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jlAccepted);

        jlblMeetingRequests.setText("Meetingrequests");

        jlblAcceptedMeeting.setText("Accepted meetings");

        jlblDate.setText("Date:");

        jbtnBack.setText("Back");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(jbtnAccept)
                        .addGap(72, 72, 72)
                        .addComponent(jbtnDecline)
                        .addGap(84, 84, 84))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlblAcceptedMeeting, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlblMeetingRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3))
                                .addGap(28, 28, 28)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlblRequested, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlblRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jlblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jlblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlblRequested)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblRoom)
                    .addComponent(jlblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblDate)
                    .addComponent(jlblMeetingRequests))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlblAcceptedMeeting)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jlblDescription)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtnAccept)
                            .addComponent(jbtnDecline))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbtnAccept;
    private javax.swing.JButton jbtnBack;
    private javax.swing.JButton jbtnDecline;
    private javax.swing.JList<String> jlAccepted;
    private javax.swing.JList<String> jlRequests;
    private javax.swing.JLabel jlblAcceptedMeeting;
    private javax.swing.JLabel jlblDate;
    private javax.swing.JLabel jlblDescription;
    private javax.swing.JLabel jlblMeetingRequests;
    private javax.swing.JLabel jlblRequested;
    private javax.swing.JLabel jlblRoom;
    private javax.swing.JLabel jlblTime;
    private javax.swing.JTextArea jtxtADescription;
    // End of variables declaration//GEN-END:variables
}
