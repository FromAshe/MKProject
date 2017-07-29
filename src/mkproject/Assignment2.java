/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkproject;

/**
 *
 * @author Ashenafi
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ashenafi
 */

import mkproject.UserInterfaceModule.Border;
import mkproject.UserInterfaceModule.ApplicationWindow;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Assignment2 extends Application{
    public static void main(String args[]){
        launch(args);
    }
    Stage stage;
    Button button1,button2;
    private Stage primaryStage;
     BorderPane borderPane;
    @Override
     public void start(Stage st){
         //primaryStage = st;
         
         //
        borderPane=  Border.getBorderPaneInstance().setBorderProperty();
        primaryStage=ApplicationWindow.getApplicationWindowInstance().setStageProperty();
         //primaryStage.setTitle("Main Window");
         
         button1 = new Button("Hourly Employee");
         button2 = new Button("Salaried Employee");
         button2.setOnAction(salar);
         button1.setOnAction(hre);
         VBox vBox = new VBox();
         vBox.getChildren().addAll(button1,button2);
         vBox.setPadding(new Insets(40,40,40,40));
         
         
         button1.setMaxWidth(120);
         button2.setMaxWidth(120);
         borderPane.setCenter(vBox);
         
         System.out.println("Border Pane width: " + borderPane.getWidth() + "and Border Pane height: " + borderPane.getHeight());
  
         primaryStage.show();
         
        
     }  
//     public Stage window(Stage st){
//         stage = new Stage();
//         //stage = st;
//         stage.setTitle("Main Window");
//
//       return stage;
//    }
      class Salaried implements EventHandler<ActionEvent>{
             @Override
             public void handle(ActionEvent ev){
                new Salar(). salaried();
                //primaryStage.close();
                 
             }
         }
      
      public void playBack(){
          primaryStage.show();
      }
      
      Salaried salar = new Salaried();
      
      class HourlyEmployee implements EventHandler<ActionEvent>{
          @Override
          public void handle(ActionEvent evv){
               borderPane.getChildren().clear();
              new HourlyEmp().hourlyEmployee();
              //primaryStage.show();
          }

      }
      
      HourlyEmployee hre = new HourlyEmployee();
     
}
