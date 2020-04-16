package scrum;


import com.toedter.calendar.JDateChooser;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author marvi
 */
public class Validation {
    
    
    public static boolean CheckDateTwo(String toCheck) {
        boolean passedDate = true;
        String currentDate = LocalDate.now().toString();
        if(toCheck.compareTo(currentDate) > 0){
            JOptionPane.showMessageDialog(null, "This date has already passed");
            passedDate = false;
        }
        return passedDate; 
    }
    
    public static boolean checkIfDateNull(JDateChooser dateToCheck){
         
         boolean resultat = false;
         
         if(dateToCheck.getDate()==null){ 
             JOptionPane.showMessageDialog(null, "Select a date");
             resultat = true;
             dateToCheck.requestFocus();
         }
         return resultat;
     }
    
    public static boolean checkTime(JTextField toCheck) {
        boolean result = true;
        String expression = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
        Pattern p = Pattern.compile(expression);
        Matcher m = p.matcher(toCheck.getText());
            if(!m.matches())
            {
                JOptionPane.showMessageDialog(null, "Tiden måste vara i formatet 00:00");
                toCheck.requestFocus();
                result = false;
            }             
      
            return result;
    }


    public static boolean taHarVarde(JTextArea rutaAttKolla)
    {
        boolean resultat = true;
        
        if(rutaAttKolla.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Mottagningsrutan är tom!");
            resultat = false;
            rutaAttKolla.requestFocus();
        }       
        
        return resultat;
    }
    
    public static boolean tfHarVarde(JTextField rutaAttKolla)
    {
        boolean resultat = true;
        
        if(rutaAttKolla.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Beskrivning eller rum är tomt");
            resultat = false;
            rutaAttKolla.requestFocus();
        }       
        
        return resultat;
    }
}
