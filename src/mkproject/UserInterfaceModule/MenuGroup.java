/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkproject.UserInterfaceModule;

import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Ashenafi
 */
public class MenuGroup extends ToggleGroup{
    
    private static MenuGroup containerInstance;
    
    private MenuGroup(){
        
    }
    
    public static MenuGroup getContainerInstance(){
        if(containerInstance == null){
            containerInstance = new MenuGroup();
        }
        return containerInstance;
    }
    
}
