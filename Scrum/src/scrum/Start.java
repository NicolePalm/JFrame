package scrum;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author nicol
 */
public class Start {
    private static InfDB idb;
    
     public static void main (String[] args)
    {
    
    try{

          //File db = new File ("Scrumdb.FDB");
          //String path = db.getAbsolutePath();
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
