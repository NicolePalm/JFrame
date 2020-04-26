package scrum;

import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JComboBox;


public class FillComboBoxFromDb {
    private InfDB idb;
    public FillComboBoxFromDb(InfDB idb){
        this.idb = idb;
    }
public void fillComboboxCategories(JComboBox box, String type){
        
ArrayList <HashMap<String,String>> categories = new ArrayList();
ArrayList <String> getCategories = new ArrayList();
try{        
categories = idb.fetchRows("select CATEGORYNAME, CATEGORYTYPE from CATEGORY");

for(HashMap <String, String> categories_ : categories){ 
if(categories_.get("CATEGORYTYPE").equals(type)){
    getCategories.add(categories_.get("CATEGORYNAME"));
}  
}
for(String typeCategories : getCategories){
    box.addItem(typeCategories);
}
}
catch(InfException e){
System.out.println(e);
}
}
}
