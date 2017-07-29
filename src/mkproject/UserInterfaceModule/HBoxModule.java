/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkproject.UserInterfaceModule;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

/**
 *
 * @author Ashenafi
 */
public class HBoxModule extends HBox{
    
    public static HBox getHBox(){
        
        HBox hbox = new HBox();;
        hbox.setSpacing(50);
        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        hbox.setPadding(new Insets(10, 50, 50, 50));
        return hbox;
    }
}
