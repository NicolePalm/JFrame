package scrum;
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
          idb = new InfDB("C:\\JFrame\\db\\Scrumdb.fdb");
          System.out.println("Conncention");
          new LoggInScreen(idb).setVisible(true);
        }
        
        catch(InfException ettUndantag) {
        JOptionPane.showMessageDialog(null, "Något gick visst fel!");
        System.out.println("Internt felmeddelande: " + ettUndantag.getMessage());
        }
    }
}
