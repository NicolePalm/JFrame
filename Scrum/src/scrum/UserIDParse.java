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
    public static int ReturnIDFromEmail(String email, InfDB idb){
        int parsedID = 0;
        try{
        String sqlID = "SELECT USER_ID from USER1 where EMAIL = '"+email+"'";
        String checkID = idb.fetchSingle(sqlID);
        System.out.print(checkID);
        parsedID = Integer.parseInt(checkID);
        
        }
        catch(InfException idFail){
          JOptionPane.showMessageDialog(null, "Ej giltig email!");
          System.out.println(idFail.getMessage()); 
        }
        return parsedID; 
    }  
}