/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkproject;



import java.sql.Connection;

import java.sql.ResultSet;

 import javafx.application.Application;

import javafx.beans.property.SimpleStringProperty;

 import javafx.beans.value.ObservableValue;

 import javafx.collections.FXCollections;

 import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

 import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

 import javafx.scene.control.TableColumn;

 import javafx.scene.control.TableColumn.CellDataFeatures;

import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

 import javafx.stage.Stage;

 import javafx.util.Callback;


 public class AgeligilotTableD extends Application {

       
   private ObservableList<ObservableList> data;

        private TableView tableview;
        TableColumn col;
        ComboBox combo;

      public static void main(String[] args) {
                launch(args);
            }
     public void buildData() {
         
               }
    @Override
    public  void start(Stage stage)
     {
        


                 tableview = new TableView();
                 tableview.setId("table");
                combo = new ComboBox();
                combo.setEditable(true);
                combo.getItems().add("Eth");
                 
                
                 DatabaseClass.openConnection();
                   data = FXCollections.observableArrayList();
                   
                   try {
                      
                        String SQL = "SELECT * FROM  AccountTablee"; 
                    //String sql=   "SELECT IDNO,FirstName,FatherName,GFatherName,PhoneNumber from ATable2 WHERE Sex='እንስት' AND AgeligilotKifil = 'አባላት ጉዳይ ክፍል' AND Year  = '2007'";
                       ResultSet rs = DatabaseClass.selectTable(SQL);
             for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                //We are using non property style for making dynamic table 


                               final int j = i;
                              
                                 col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                                   col.setId("table"); 
                                 col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {

                                         public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                                                return new SimpleStringProperty(param.getValue().get(j).toString());
                                             }

                                 }); 
                    col.setId("table");             
                 tableview.getColumns().addAll(col);
                               //  System.out.println("Column [" + i + "] ");
                             }
           while (rs.next()) {
                              ObservableList<String> row = FXCollections.observableArrayList();
                                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                


                                        row.add(rs.getString(i));
                                     }
                               //  System.out.println("Row [1] added " + row);
                                 data.add(row);
         tableview.setItems(data);
          // combo.setValue(data);
                       }} catch (Exception e) {
                           e.printStackTrace();
                           System.out.println("Error on Building Data");
                       }
                 BorderPane border = new BorderPane();
         Scene scene = new Scene(border,1000,600);
         
        
         
         tableview.setMaxSize(900,700);
      
           border.setCenter(tableview);
         scene.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());        


                 stage.setScene(scene);
                stage.show();
               }

 }
