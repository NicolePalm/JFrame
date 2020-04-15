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
           
           int currentUser_ = Integer.parseInt(currentUser);
           String svarAdmin = idb.fetchSingle(checkAdmin);
           int admin = Integer.parseInt(svarAdmin);
           if(admin == 1){
               new AdminPanel(idb,currentUser_).setVisible(true);
             }
             else{
                 new UserPanel(idb,currentUser_).setVisible(true);
             }
           
       } catch (InfException ex) {
           Logger.getLogger(ReturnToHome.class.getName()).log(Level.SEVERE, null, ex);
       }
}
 
}
