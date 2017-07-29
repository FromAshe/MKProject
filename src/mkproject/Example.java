/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkproject;

import java.util.Optional;
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author YOHY
 */
public class Example extends Application {

    public void start(Stage stage) {
        BorderPane border = new BorderPane();
        Scene scene = new Scene(border, 400, 500);
        stage.setScene(scene);
        stage.show();
        Button but = new Button("Click");
        but.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent eve) {
                TextInputDialog alert = new TextInputDialog("");
                alert.setTitle("Confirmation");
                alert.setHeaderText("Lokk");
                alert.setContentText("Select");

                Optional<String> res = alert.showAndWait();
                if(res.isPresent())
                {
                    System.out.println("Your ID Number is = "+res.get());
                     Alert alert1 = new Alert(AlertType.CONFIRMATION);
                                    alert1.setHeaderText(null);
                                    alert1.setContentText("Successfully Updated");
                                    alert1.setTitle("Fill ID");
                                    alert1.showAndWait();
                }
               
                 else 
                {
                    alert.close();
                }

            }
        });
        border.setCenter(but);

    }
    public static void main(String args[])
    {
        launch(args);
    }
}
