/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    
    
    
    public static boolean checkDate(JTextField tfCheck) {
        boolean result = true;
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        // Input to be parsed should strictly follow the defined date format
        // above.
        format.setLenient(false);

        String date = tfCheck.getText();
        try {
            format.parse(date);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Datumet " + date + " är inte giltigt " +
                ((SimpleDateFormat) format).toPattern() + " enligt mönstret.");
            result = false;
        }
        return result;
    }
    
    public static boolean checkTime(JTextField toCheck) {
        boolean result = true;
        String expression = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
        Pattern p = Pattern.compile(expression);
        Matcher m = p.matcher(toCheck.getText());
            if(!m.matches())
            {
                JOptionPane.showMessageDialog(null, "Tiden måste vara i formatet 00:00");
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
