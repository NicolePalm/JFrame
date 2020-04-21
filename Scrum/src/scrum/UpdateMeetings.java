
package scrum;

import java.time.LocalDate;
import java.util.ArrayList;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author nicol
 */
public class UpdateMeetings {
    private InfDB idb;
    private String currentUser;
    
     public UpdateMeetings(InfDB idb, String id) {
        this.idb = idb;
        this.currentUser = id;
    }
     
     public void deletePassedMeetings(){
         String currentDate = LocalDate.now().toString();
         try{
         ArrayList<String> passedMeetings = idb.fetchColumn("SELECT meeting_id FROM meeting WHERE meetingdate < '" + currentDate + "'");
         if(PendingRequests.ContainsAllNulls(passedMeetings)==false){
         for(String passedMeeting : passedMeetings){
             idb.delete("DELETE FROM meetingrequest WHERE meeting_id = '" + passedMeeting + "'");
             idb.delete("DELETE FROM meeting WHERE meeting_id = '" + passedMeeting + "'");
         }
         }
         }
         catch(InfException e){
         System.out.println(e.getMessage());
         }
     }
}
