/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkproject.UserInterfaceModule;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Ashenafi
 */
public class BiultScene extends Scene{
    
    private static BiultScene sceneInstance=null;
    static BorderPane mainBorderP = mkproject.UserInterfaceModule.Border.getBorderPaneInstance().setBorderProperty();
    
    public BiultScene(Parent root, double width, double height) {
        super(root, width, height);
    }
  
   public static BiultScene getSceneInstance(){
       if(sceneInstance == null){
           sceneInstance = new BiultScene(mainBorderP, 1200,750);     
       }
       return sceneInstance;
   }

   public Scene getSceneProperty() {
       sceneInstance.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
       
       return sceneInstance;
   }   
}
