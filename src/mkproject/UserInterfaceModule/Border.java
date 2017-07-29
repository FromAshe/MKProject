/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkproject.UserInterfaceModule;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Ashenafi
 */

public class Border extends BorderPane{
   public  int borderHeight;
    public int borderWidth;
    private static Border instance = null;
    
    private Border(){
        
    }
    
    public static Border getBorderPaneInstance(){
        if(instance == null){
            instance = new Border();
        }
        return instance;
    }
    
    public BorderPane setBorderProperty(){
        instance.setPadding(new Insets(10, 50, 50, 50));
        instance.setId("bp");  
        return instance;
    }
    
    public void setBorderWidth(int borderWidth){
        this.borderWidth = borderWidth;
    }
    
    public int getBorderWidht(){
        return borderWidth;
    }
    
    public void setBorderHeight(int borderHeight){
        this.borderHeight = borderHeight;     
    }
    
    public int getBorderHeight(){
        return borderHeight;
    }
    
}
