
package scrum;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import oru.inf.InfDB;
import oru.inf.InfException;


public class UpdateMeetings {
    private InfDB idb;
    private String currentUser;
    
     public UpdateMeetings(InfDB idb, String id) {
        this.idb = idb;
        this.currentUser = id;
    }
     
     public void setMeetingTimes(){
         
         try{
         LocalDateTime dt = LocalDateTime.now();
         
         ArrayList <HashMap<String, String>> meetings = idb.fetchRows("SELECT MEETING_ID, CREATION_DATE FROM MEETINGTIME");
         if (!PendingRequests.ContainsAllNulls(meetings)) {
         for(HashMap <String, String> meeting : meetings){
              String meetingId = meeting.get("MEETING_ID");
              String date = meeting.get("CREATION_DATE");
              Date creationDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
              LocalDateTime test = LocalDateTime.ofInstant(creationDate.toInstant(), ZoneId.systemDefault());
              LocalDateTime creation = test.plusDays(2);
              
              if(dt.isEqual(creation) || dt.isAfter(creation)){
                  int index = MostVotes(meetingId);
                  String voteIndex = Integer.toString(index);
                  String sql = "SELECT TIME_" + voteIndex + " FROM MEETINGTIME WHERE MEETING_ID = '" + meetingId + "'";
                  String time = idb.fetchSingle(sql);
                  idb.update("UPDATE MEETING SET MEETINGTIME = '" + time + "' WHERE MEETING_ID = '" + meetingId + "'");

                }
            }
         
            }
         }
         
         catch(InfException e){
         System.out.println(e.getMessage());
         } catch (ParseException ex) {
            Logger.getLogger(UpdateMeetings.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
    
     
     private int MostVotes(String meetingId){
              
              ArrayList <Integer> list = new ArrayList();
              int position = 0;
              try{
              String vote1 = idb.fetchSingle("SELECT VOTE_1 FROM MEETINGTIME WHERE MEETING_ID = '" + meetingId + "'");
              String vote2 = idb.fetchSingle("SELECT VOTE_2 FROM MEETINGTIME WHERE MEETING_ID = '" + meetingId + "'");
              String vote3 = idb.fetchSingle("SELECT VOTE_3 FROM MEETINGTIME WHERE MEETING_ID = '" + meetingId + "'");
              String vote4 = idb.fetchSingle("SELECT VOTE_4 FROM MEETINGTIME WHERE MEETING_ID = '" + meetingId + "'");
              int vote_1 = Integer.parseInt(vote1);
              int vote_2 = Integer.parseInt(vote2);
              int vote_3 = Integer.parseInt(vote3);
              int vote_4 = Integer.parseInt(vote4);
              
              list.add(vote_1);
              list.add(vote_2);
              list.add(vote_3);
              list.add(vote_4);
              int max = 0;
              int counter = 0;
              
              
              for(int vote : list){
                  counter ++;
                  if(vote > max){
                      max = vote;
                      position = counter;
                  }
              }
              
              
             }
              catch(InfException e){
                  
              }
              
             return position;
     }
     
     
     public void timesSelected(){
        ArrayList<String> meetingId = new ArrayList();
        ArrayList<String> meetingTimeId = new ArrayList();
        try{
        meetingId = idb.fetchColumn("SELECT MEETING_ID FROM MEETING");
        meetingTimeId = idb.fetchColumn("SELECT MEETING_ID FROM MEETINGTIME");
        
        if(PendingRequests.ContainsAllNulls(meetingId) == false){
            if(PendingRequests.ContainsAllNulls(meetingTimeId) == false){
        for(String id : meetingId){
             String time = idb.fetchSingle("SELECT MEETINGTIME FROM MEETING WHERE MEETING_ID = '" + id + "'");
            if(!meetingTimeId.contains(id) && time.equals("00:00:00")){
                idb.delete("DELETE FROM MEETING WHERE MEETING_ID = '" + id + "'");
            } 
        }
        }
        }
        }

        catch(InfException e){
        System.out.println(e.getMessage());   
        }

    }
}
