package scrum;


import com.toedter.calendar.JDateChooser;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Validation {
    
    
    public static boolean CheckDateTwo(String toCheck) {
        boolean passedDate = true;
        String currentDate = LocalDate.now().toString();
        if(toCheck.compareTo(currentDate) >= 0){
            passedDate = false;
        }
        else{
         JOptionPane.showMessageDialog(null, "This date has already passed");
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
                JOptionPane.showMessageDialog(null, "Time must be in the format HH:MM");
                toCheck.requestFocus();
                result = false;
            }             
      
            return result;
    }


    public static boolean taHarVarde(JTextArea rutaAttKolla)
    {
        boolean resultat = true;
        
        if(rutaAttKolla.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Must add at least one reciever");
            resultat = false;
            rutaAttKolla.requestFocus();
        }       
        
        return resultat;
    }
    
      public static boolean descriptionValues(JTextArea rutaAttKolla)
    {
        boolean resultat = true;
        
        if(rutaAttKolla.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter a description of the meeting");
            resultat = false;
            rutaAttKolla.requestFocus();
        }       
        
        return resultat;
    }
    
    public static boolean tfHarVarde(JTextField rutaAttKolla, String message)
    {
        boolean resultat = true;
        
        if(rutaAttKolla.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, message);
            resultat = false;
            rutaAttKolla.requestFocus();
        }       
        
        return resultat;
    }
    
    static public boolean inmatningFnuttar(String inmatning){
        if(inmatning.contains("'") || inmatning.contains("\"")){
            JOptionPane.showMessageDialog(null, "No fnutts!");
            return false;
        }
        return true;
    }
    
    public static boolean emailValidator(String email) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
 
        Pattern pattern = Pattern.compile(regex);
        
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches() == false) {
            JOptionPane.showMessageDialog(null, "Invalid email!");
        }
        return matcher.matches();
    }
    
     public static boolean emailValidator(String email, JTextField field) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
 
        Pattern pattern = Pattern.compile(regex);
        
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches() == false) {
            JOptionPane.showMessageDialog(null, "Please enter a valid email");
            field.requestFocus();
        }
        return matcher.matches();
    }
    
    public static boolean validEmail(String email, String currentEmail, ArrayList<String> emails){
            boolean result = true;
            
                for(String m : emails) {
                    if(m.equals(currentEmail)) {
                        emails.remove(m);
                        break;
                    }
                }
                for(String mail : emails){
                    if(email.equals(mail)){
                        result = false;
                        JOptionPane.showMessageDialog(null, "That email is already registred");
                        break;
                    } 
                }
           
            return result;
        }
}
