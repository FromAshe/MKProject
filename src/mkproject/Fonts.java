/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkproject;

import mkproject.resources.Refference;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Ashenafi
 */
public class Fonts {
    private static ArrayList<Fonts> fontList = new ArrayList<Fonts>();
    public static String fontPath;
    public static Font font;
    private static InputStream myStream;
    
    public Fonts(String filePath){
        Fonts.fontPath = Refference.FONT_LOCATION + filePath;
        
        
        registerFont();
    }
    boolean registerFont;
    private void registerFont(){
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        
        try{
            myStream = new BufferedInputStream(
                        new FileInputStream(fontPath));
            
            font = Font.createFont(Font.TRUETYPE_FONT, myStream).deriveFont(Font.PLAIN, 22f);
             registerFont = ge.registerFont(font);
            
             //new File(fontPath)
        }
        catch(FontFormatException | IOException e){
            
            System.out.println(e.getMessage());
            
        }
    }
    
    public static void addFont(Fonts font){
        fontList.add(font);
    }
}
