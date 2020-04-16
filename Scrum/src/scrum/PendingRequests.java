/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oru.inf.InfDB;
import oru.inf.InfException;


/**
 *
 * @author Danie
 */
public class PendingRequests {

    
   public static String currentRequests(InfDB idb, int currentUser){
        
        int pendingRequests = 0;
        ArrayList<String> requests = new ArrayList();
        
        try {
            requests = idb.fetchColumn("SELECT MEETING_ID FROM MEETINGREQUEST WHERE RECEIVER_ID = " + currentUser + " AND status = 0");
        } catch (InfException ex) {
            Logger.getLogger(HandleMeetingRequests.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        if(ContainsAllNulls(requests)==false){
             pendingRequests = requests.size();
        }
        String pendingRequests_ = Integer.toString(pendingRequests);
        return pendingRequests_;
        
    }
   public static Boolean ContainsAllNulls(ArrayList arrList)
    {
    if(arrList != null)
    {
    if (!arrList.stream().noneMatch((a) -> (a != null))) {
            return false;
    }
    }
    return true;
    }
}
