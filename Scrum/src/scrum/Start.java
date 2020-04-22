package scrum;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

public class Start {
    private static InfDB idb;
    
     public static void main (String[] args)
    {
    
    try{
          idb = new InfDB("C:\\db\\Scrumdb.fdb");
          System.out.println("Connection");
          new LoggInScreen(idb).setVisible(true);
        }
        
        catch(InfException ettUndantag) {
        JOptionPane.showMessageDialog(null, "Något gick visst fel!");
        System.out.println("Internt felmeddelande: " + ettUndantag.getMessage());
        }
    }
}
