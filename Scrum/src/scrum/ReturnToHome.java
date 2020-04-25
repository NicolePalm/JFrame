package scrum;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oru.inf.InfDB;
import oru.inf.InfException;
import javax.swing.JOptionPane;

/**
 *
 * @author Danie
 */
public class ReturnToHome{
   
    public static void CreateHomeScreen(InfDB idb, String currentUser){
    
    String checkAdmin = "SELECT ADMINSTATUS from USER1 where USER_ID = '"+currentUser+"'";
       try {
           
           String svarAdmin = idb.fetchSingle(checkAdmin);
       
                 new UserPanel(idb,currentUser,svarAdmin).setVisible(true);

           
       } catch (InfException ex) {
           Logger.getLogger(ReturnToHome.class.getName()).log(Level.SEVERE, null, ex);
       }
}
     public static void CreateCalendar(InfDB idb, String currentUser){
    
    String checkAdmin = "SELECT ADMINSTATUS from USER1 where USER_ID = '"+currentUser+"'";
       try {
           
           String svarAdmin = idb.fetchSingle(checkAdmin);
       
                 new Calendar(idb,currentUser,svarAdmin).setVisible(true);

           
       } catch (InfException ex) {
           Logger.getLogger(ReturnToHome.class.getName()).log(Level.SEVERE, null, ex);
       }
}
 
}
