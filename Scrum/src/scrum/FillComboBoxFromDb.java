package scrum;

import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.ArrayList;
import javax.swing.JComboBox;


public class FillComboBoxFromDb {
    private InfDB idb;
    public FillComboBoxFromDb(InfDB idb){
        this.idb = idb;
    }
public void fyllBoxElevhem(JComboBox box){
        
ArrayList <String> categories = new ArrayList(); 
try{        
String enRad = ""; //Deklarering av lokal String variabel
categories = idb.fetchColumn("select CATEGORYNAME from CATEGORY");

for(String categories_ : categories){ 
enRad = categories_; 
box.addItem(enRad); 
}
}
catch(Exception e){
System.out.println(e);
}
}
}
