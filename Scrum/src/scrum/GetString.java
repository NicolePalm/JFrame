/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrum;

import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author nicol
 */
public class GetString {
    public static String hamtaFalt(JTextField falt){
    String text = falt.getText();
    return text;
}

//klassmetod där texten som finns i box som skickas med som parameter extraheras och returneras i textvariabeln
public static String hamtaComboBox(JComboBox box){
    
    String text = box.getSelectedItem().toString();
    return text;
}

//klassmetod där texten som finns i losenord som skickas med som parameter extraheras och returneras i textvariabeln
public static String hamtaLosenord(JPasswordField losenord){
    
    String text = losenord.getText();
    return text;
}
}
