/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkproject.resources;

import mkproject.resources.Refference;
import java.awt.GraphicsEnvironment;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.text.Font;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;


/**
 *
 * @author Ashenafi
 */
public class Fontfx {
    private static ArrayList<Fontfx> fontList = new ArrayList<Fontfx>();
    public static String fontPath;
    public static Font font;
    private static InputStream myStream;
    
    public Fontfx(String fontFile){
        Fontfx.fontPath = Refference.FONT_LOCATION + fontFile;
        
        registerFont();
    }
    
    private void registerFont(){
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        
        try{
            myStream = new BufferedInputStream(
                        new FileInputStream(fontPath));
            
            font = Font.loadFont(myStream, 20);
            
            //ge.registerFont(font);
            
        }
        catch(FileNotFoundException e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
    public static void addFont(Fontfx font){
        fontList.add(font);
    }
}
