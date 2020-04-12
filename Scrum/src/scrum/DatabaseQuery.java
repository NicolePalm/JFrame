/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum;

import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Danie
 */
public class DatabaseQuery {
    
    private static InfDB idb;
     
    public DatabaseQuery (InfDB idb){
    this.idb = idb;
    }
    
    
    public static boolean InsertNewUser (String firstname, String lastname, String email, String password){
    
        boolean success = false;
        try{        
            String sql = "INSERT INTO User1 (user_id, firstname,lastname,email,user_password, adminstatus, blocknotifications) VALUES "
                    + "(1,'" + firstname + "','" + lastname + "','" + email + "','" + password + "',0,0)";
            idb.insert(sql);
            System.out.println("Lyckades");
            success = true; 
            }
            catch(InfException e){
                JOptionPane.showMessageDialog(null, "Något blev fel!");
                System.out.println(e.getMessage());
            }
        return success;
    }
}
