/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkproject.UserInterfaceModule;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;


/**
 *
 * @author Ashenafi
 * Menu class intended to create a menu item for the application using radio buttons
 * 
 *    
 */

public class Menu extends HBox{
    private static Menu menuInstance;
    private static Hyperlink logOut;
    
    private Menu(){
        
    }
    
    //create and return an instance of Menu
    public static Menu getMenuInstance(){
        if(menuInstance == null){
            menuInstance = new Menu();
        }
        return menuInstance;
    }
    
    //create and retrun an instance of HBox which is decorated by radiobuttons as menu
    //returns a single HBox object for all callers.
    
    public HBox menuHBox(){
        HBox hBoxRadio = new HBox();
        hBoxRadio.setSpacing(50);
        hBoxRadio.setAlignment(Pos.CENTER);
        //  hBoxRadio.setId("hBox");
        hBoxRadio.setId("hBox1");
        hBoxRadio.setPadding(new Insets(10, 10, 10, 10));
        
        MemberRegisterarMenu fillRadioData = MemberRegisterarMenu.getMeberRegisterarMenu();
        RadioButton retrieveRadioData = MemberDisplayMenu.getDisplayInstanceMenu();//new RadioButton("የአባላት መረጃ ማግኛ");
        RadioButton serviceRadioData = MemberPlacementMenu.getMemeberPlacementInstance();//new RadioButton("አገልግሎት ክፍል መመደቢያ");
        RadioButton noteRadioData = CommentMenu.getCommentMenuInstance();//new RadioButton("ማስታወሻ ለመመዝገብ");

        
        hBoxRadio.getChildren().addAll(fillRadioData, serviceRadioData, retrieveRadioData, noteRadioData, LogOutLink.getLogOutLinkInstance());
        return hBoxRadio;
    }
    
    public static Hyperlink getLogOUtHyperlink(){
        
        
        return logOut;
    }
    
}
