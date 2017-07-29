/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkproject.UserInterfaceModule;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Ashenafi
 */
public class ApplicationWindow extends Stage{

    private static ApplicationWindow instance;

    private ApplicationWindow() {

    }

    public static synchronized ApplicationWindow getApplicationWindowInstance() {
        if (instance == null) {
            System.out.println("the stage instance is null");
            instance = new ApplicationWindow();

            
        }

        return instance;
    }

    public Stage setStageProperty() {
        instance.getIcons().add(new Image(getClass().getResourceAsStream("/mkproject/Image/Mesekel.jpg")));
        instance.setTitle("የአዳማ ማዕከል አባላት መመዝገቢያ ቋት"); //Amharic spelling translation: yeabalat mereja quat
        Scene scene = BiultScene.getSceneInstance().getSceneProperty();
        //scene.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
        instance.setScene(scene);
    
        instance.show();

        return instance;
    }
    
//    public static void main(String args[]){
//        launch(args);
//    }
}
