/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkproject.UserInterfaceModule;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mkproject.resources.ResourceLoader;

/**
 *
 * @author Ashenafi
 */
public class ApplicationStarter extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
       ResourceLoader.loadFonts();
        
        //main border pane
        BorderPane mainBorderP = mkproject.UserInterfaceModule.Border.getBorderPaneInstance().setBorderProperty();
        primaryStage = ApplicationWindow.getApplicationWindowInstance().setStageProperty();
    }
    
    public static void main(String args[]){
        launch(args);
    }
    
}
