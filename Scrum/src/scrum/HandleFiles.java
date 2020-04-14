package scrum;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.io.FilenameUtils;

public class HandleFiles {
    
    public static void SaveImage(File currentFile, String currentExt, String filePath){
        try {
            BufferedImage image = ImageIO.read(currentFile);
            ImageIO.write((BufferedImage)image, currentExt, new File(filePath));
            }
        catch(IOException ex) {
            System.out.println("Failed to save image!");
            ex.getMessage();
            } 
        } 
    
    public static ArrayList<String> ReadFile(File currentFile) throws IOException{
            ArrayList <String> lines = new ArrayList();
            String st; 
        try{
            BufferedReader br = new BufferedReader(new FileReader(currentFile)); 
            while ((st = br.readLine()) != null){
            lines.add(st);
        }
        }
        catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return lines;
        }

    
    public static void SaveFile(ArrayList<String> lines, String filePath) throws IOException{
        try (FileWriter writer = new FileWriter(filePath)) {
            for(String str: lines) {
                writer.write(str + System.lineSeparator());
            }
        }
    }
    public static String getExtensionByApacheCommonLib(String filename) {
    return FilenameUtils.getExtension(filename);
    }
    
    public static void FileExtensions(JFileChooser fileChooser){
    FileFilter txt = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
    FileFilter jpg = new FileNameExtensionFilter("JPG file (.jpg)", "jpg");
    FileFilter png = new FileNameExtensionFilter("PNG file (.png)", "png");
    
    fileChooser.addChoosableFileFilter(txt);
    fileChooser.addChoosableFileFilter(jpg);
    fileChooser.addChoosableFileFilter(png);
    fileChooser.setAcceptAllFileFilterUsed(false);
    }
    }
    
