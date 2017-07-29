/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkproject.UserInterfaceModule;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Ashenafi
 */
public class GridPaneModule extends GridPane{
    
    public static GridPane getGridPane(){
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        
        return gridPane;
    }
    
}
