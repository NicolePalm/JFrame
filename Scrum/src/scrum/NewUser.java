
package scrum;

import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

public class NewUser {
    
     
    public NewUser (InfDB idb){

    }
    
    
    public static boolean InsertNewUser (String firstname, String lastname, String email, String password, InfDB idb){
    
        boolean success = false;
        try{    

            String id = idb.getAutoIncrement("USER1","USER_ID");
            String sql = "INSERT INTO User1 (user_id, firstname,lastname,email,user_password, adminstatus, blocknotifications) VALUES ("+ id +",'"+ firstname + "','" + lastname + "','" + email + "','" + password + "',0,0)";

            idb.insert(sql);
            success = true; 
            }
            catch(InfException e){
                JOptionPane.showMessageDialog(null, "Något blev fel!");
                System.out.println(e.getMessage());
            }
        return success;
    }
}
