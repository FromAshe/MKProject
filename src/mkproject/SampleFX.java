//package mkproject;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.application.Application;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Insets;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TableCell;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableColumn.CellEditEvent;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.layout.VBox;
//import javafx.scene.text.Font;
//import javafx.stage.Stage;
//import javafx.util.Callback;
//import org.h2.jdbcx.JdbcConnectionPool;
//
///**
// *
// * @author Graham Smith
// */
//public class SampleFX extends Application {
//
//    // private TableView table = new TableView();
//    ObservableList<Person> data;
//    TableView<Person> table = new TableView<>();
//    Connection con;
//    PreparedStatement pst;
//    JdbcConnectionPool cp;
//    ResultSet rs;
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage stage) {
//        Scene scene = new Scene(new Group());
//        stage.setTitle("Table View Sample");
//        stage.setWidth(650);
//        stage.setHeight(500);
//        scene.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
//        final Label label = new Label("Address Book");
//        label.setFont(new Font("Arial", 20));
//
//        //Set up the columns
//        TableColumn firstNameCol = new TableColumn("First Name");
//        firstNameCol.setMinWidth(100);
//        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
////        firstNameCol.setCellFactory(cellFactory);
//        TableColumn lastNameCol = new TableColumn("Last Name");
//        lastNameCol.setMinWidth(100);
//        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
//        // lastNameCol.setCellFactory(cellFactory);
////        lastNameCol.setEditable( false );
//
//        TableColumn primaryEmailColG = new TableColumn("Grand Name");
//        primaryEmailColG.setMinWidth(100);
//        primaryEmailColG.setCellValueFactory(new PropertyValueFactory<>("grandName"));
//        // primaryEmailColG.setCellFactory(cellFactory);
//        //Make this column un-editable        
//
//        TableColumn secondaryEmailColB = new TableColumn("BirthDate");
//        secondaryEmailColB.setMinWidth(100);
//        secondaryEmailColB.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
//        // secondaryEmailColB.setCellFactory(cellFactory);
//
//        TableColumn firstNameColW = new TableColumn("Woreda");
//        firstNameColW.setMinWidth(100);
//        firstNameColW.setCellValueFactory(new PropertyValueFactory<>("wereda"));
//        // firstNameColW.setCellFactory(cellFactory);
//        TableColumn lastNameColKt = new TableColumn("Ketema");
//        lastNameColKt.setMinWidth(100);
//        lastNameColKt.setCellValueFactory(new PropertyValueFactory<>("ketema"));
//        // lastNameColKt.setCellFactory(cellFactory);
////        lastNameCol.setEditable( false );
//
//        TableColumn primaryEmailColKb = new TableColumn("Kebele");
//        primaryEmailColKb.setMinWidth(100);
//        primaryEmailColKb.setCellValueFactory(new PropertyValueFactory<>("kebele"));
//        // primaryEmailColKb.setCellFactory(cellFactory);
//        //Make this column un-editable        
//
//        TableColumn secondaryEmailColId = new TableColumn("ID Number");
//        secondaryEmailColId.setMinWidth(100);
//        secondaryEmailColId.setCellValueFactory(new PropertyValueFactory<>("idNumber"));
////
//        table.getColumns().addAll(secondaryEmailColId, firstNameCol, lastNameCol, primaryEmailColG, secondaryEmailColB, firstNameColW, lastNameColKt, primaryEmailColKb);
//
//        table.setId("table");
//
//        Button browse = new Button("Retrieve");
//        final VBox vbox = new VBox();
//        vbox.setSpacing(5);
//        vbox.getChildren().addAll(label, table, browse);
//        vbox.setPadding(new Insets(10, 0, 0, 10));
//        ((Group) scene.getRoot()).getChildren().addAll(vbox);
//        data = FXCollections.observableArrayList();
//        browse.setOnAction(e -> {
//
//            try {
//                Class.forName("org.h2.Driver");
//                try {
//                    try {
//                        cp = JdbcConnectionPool.create("jdbc:h2:src/DbFolder/Vocabulary", "admin", "12345");
//                    } catch (Exception y) {
//                    }
//                    con = cp.getConnection();
//
//                    String sql = "SELECT * FROM NameBirthB";
//                    pst = con.prepareStatement(sql);
//                    rs = pst.executeQuery();
//                    while (rs.next()) {
//
//                        data.addAll(new Person(
//                                rs.getString("መለያቁጥር"),
//                                rs.getString("የመጀመሪያስም"),
//                                rs.getString("የአባትስም"),
//                                rs.getString("የአያትስም"),
//                                rs.getString("የትውልድጊዜ"),
//                                rs.getString("ወረዳ"),
//                                rs.getString("ከተማ"),
//                                rs.getString("ቀበሌ")
//                        ));
//                        table.setItems(data);
//                    }
//
//                    pst.close();
//                    rs.close();
//                } catch (SQLException sqlException) {
//                }
//            } catch (Exception ex) {
//                System.err.println(ex);
//            }
//
//        });
//
//        stage.setScene(scene);
//        stage.show();
//    }
//}
