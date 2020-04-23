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
public class UserIDParse {
    public UserIDParse(InfDB idb){
        
    }
    public static String ReturnIDFromEmail(String email, InfDB idb){
        String checkID = "";
        try{
        String sqlID = "SELECT USER_ID from USER1 where EMAIL = '"+email+"'";
        checkID = idb.fetchSingle(sqlID);
        
        }
        catch(InfException idFail){
          JOptionPane.showMessageDialog(null, "Ej giltig email!");
          System.out.println(idFail.getMessage()); 
        }
        return checkID; 
    }  
}
